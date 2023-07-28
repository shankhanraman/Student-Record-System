import java.sql.ResultSet;

/*
CREATE TABLE Parents(
student_id int,
name varchar(25),
phone_no char(10) ,
relationship varchar(20),
PRIMARY KEY(student_id, name)
);
 */
public class Parent {
    long studentId;
    String name, phoneNo, relationship;
    ConnectionEstablish studentDatabase;

    Parent(ConnectionEstablish studentDatabase){
        try{this.studentDatabase = studentDatabase;}
        catch (Exception e){
            System.out.println("An Exception occurred " + e);
        }
    }

    Parent(long studentId, String name, String phoneNo, String relationship, ConnectionEstablish studentDatabase){
        this.studentId = studentId;
        this.name = name;
        this.phoneNo = phoneNo;
        this.relationship = relationship;

        try{this.studentDatabase = studentDatabase;}
        catch (Exception e){
            System.out.println("An Exception occurred " + e);
        }
    }

    public ResultSet findParents() throws Exception{
        String Query =
                "SELECT * FROM PARENTS WHERE student_id=" + this.studentId + ";";
        System.out.println(Query);

        return studentDatabase.statement.executeQuery(Query);
    }

    public ResultSet findParents(long studentId) throws Exception{
        String Query =
                "SELECT * FROM PARENTS WHERE student_id=" + studentId + ";";
        System.out.println(Query);

        return studentDatabase.statement.executeQuery(Query);
    }

    public ResultSet listAllParents() throws Exception{
        String Query =
                "SELECT * FROM Parents";

        return studentDatabase.statement.executeQuery(Query);
    }
}

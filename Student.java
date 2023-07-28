import java.sql.ResultSet;

public class Student implements BasicCRUD{
    private long id;
    private String name;
    private String rollNumber;
    private String emailId;

    ConnectionEstablish studentDatabase;

    Student(ConnectionEstablish studentDatabase) {
        this.id = -1;
        this.name = null;
        this.rollNumber = null;
        this.emailId = null;
        try {
            this.studentDatabase = studentDatabase;
        } catch (Exception e) {
            System.out.println("An Exception Occured: " + e);
        }
    }

    Student(long id, String name, String rollNumber, String emailId, ConnectionEstablish studentDatabase){
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
        this.emailId = emailId;
        try {
            this.studentDatabase = studentDatabase;
        }catch (Exception e){
            System.out.println("An Exception Occured: " + e);
        }
    }

    // getters

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getEmailId() {
        return emailId;
    }


    // setters


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    // Query Methods
    @Override
    public ResultSet findStudent() throws Exception{
        String Query =
                "SELECT * FROM STUDENT WHERE " +
                "id=" + this.id;

        System.out.println(Query);
        return studentDatabase.statement.executeQuery(Query);
    }
    @Override
    public ResultSet findStudent(long byId, String byName, String byRollNumber, String byEmailId) throws Exception{
        String Query = "SELECT * FROM STUDENT WHERE ";
        boolean conditionGiven = false;

        if(byId != -1){
            Query += " id=" + byId;
            conditionGiven = true;
        }

        if(byName != null){
            if(conditionGiven) Query += " and ";
            else conditionGiven = true;

            Query += " name like" + "'%" + byName + "%'";
        }

        if(byRollNumber != null){
            if(conditionGiven) Query += " and ";
            else conditionGiven = true;

            Query += " roll_number like" + "'%" + byRollNumber + "%'";
        }

        if(byEmailId != null){
            if(conditionGiven) Query += " and ";
            else conditionGiven = true;

            Query += " email_id like"  + "'%" + byEmailId + "%'";
        }

        Query += ";";
        System.out.println(Query);

        return studentDatabase.statement.executeQuery(Query);
    }

    @Override
    public int insertStudent() throws Exception{
        String Query =
                "INSERT INTO Student (id, name, roll_number, email_id) VALUES" +
                "(" + this.id + ", " +
                "'" + this.name + "', " +
                "'" + this.rollNumber + "', " +
                "'" + this.emailId + "');";

        System.out.println(Query);
        return studentDatabase.statement.executeUpdate(Query);
    }

    @Override
    public int insertStudent(long id, String name, String rollNumber, String emailId) throws Exception{
        String Query =
                "INSERT INTO Student (id, name, roll_number, email_id) VALUES" +
                        "(" + id + ", " +
                        "'" + name + "', " +
                        "'" + rollNumber + "', " +
                        "'" + emailId + "');";

        System.out.println(Query);

        return studentDatabase.statement.executeUpdate(Query);
    }

    @Override
    public int removeStudent() throws Exception{
        String Query =
                "DELETE FROM STUDENT" +
                " WHERE id=" + this.id;

        System.out.println(Query);
        return studentDatabase.statement.executeUpdate(Query);
    }
    @Override
    public int removeStudent(long id, String name, String rollNumber, String emailId) throws Exception{
        String Query = "DELETE FROM STUDENT WHERE ";
        boolean conditionGiven = false;
        if(id != -1){
            Query += " id=" + id;
            conditionGiven = true;
        }

        if(name != null){
            if(conditionGiven) Query += " and ";
            else conditionGiven = true;

            Query += " name like " + "'%" + name + "%'";
        }

        if(rollNumber != null){
            if(conditionGiven) Query += " and ";
            else conditionGiven = true;

            Query += " roll_number like " + "'%" + rollNumber + "%'";
        }

        if(emailId != null){
            if(conditionGiven) Query += " and ";
            else conditionGiven = true;

            Query += " email_id like "  + "'%" + emailId + "%'";
        }

        Query += ";";

        System.out.println(Query);
        return studentDatabase.statement.executeUpdate(Query);
    }

    @Override
    public int modifyStudent(long oldId, String name, String rollNumber, String emailId, long id) throws Exception{
        String Query =
                "UPDATE STUDENT" +
                " SET " +
                " id=" + id +
                ", name=" + "'" + name + "'" +
                ", roll_number=" + "'" + rollNumber + "'" +
                ", email_id=" + "'" + emailId + "'";

        Query += " WHERE id=" + oldId;

        System.out.println(Query);
        return studentDatabase.statement.executeUpdate(Query);
    }

    public ResultSet listAllStudents() throws Exception{
        String Query = "SELECT * FROM Student";
        System.out.println(Query);

        return studentDatabase.statement.executeQuery(Query);
    }
}

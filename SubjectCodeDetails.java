import java.sql.ResultSet;

/*
CREATE TABLE Subject_Code_Detail(
subject_code varchar(10),
subject_name varchar(20),
PRIMARY KEY(Subject_Code)
);
 */
public class SubjectCodeDetails {
    String subjectCode, subjectName;
    ConnectionEstablish studentDatabase;

    SubjectCodeDetails(ConnectionEstablish studentDatabase){
        this.subjectCode = null;
        this.subjectName = null;

        try{this.studentDatabase = studentDatabase;}
        catch (Exception e){
            System.out.println("An Exception occurred " + e);
        }
    }

    SubjectCodeDetails(String subjectCode, String subjectName, ConnectionEstablish studentDatabase){
        this.subjectCode = subjectCode;
        this.subjectName =subjectName;

        try{this.studentDatabase = studentDatabase;}
        catch (Exception e){
            System.out.println("An Exception occurred " + e);
        }
    }


    // getters

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    // Setters

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }


    public ResultSet findSubjectCode(String subjectCode, String subjectName) throws Exception{
        String Query = "SELECT * FROM Subject_Code_Detail WHERE ";
        boolean conditionGiven = false;

        if(subjectCode != null){
            Query += "subject_code=" + subjectCode;
            conditionGiven = true;
        }

        if(subjectName != null){
            if(conditionGiven) Query += " and ";
            Query += "subject_name" + subjectName;
        }
        Query += ";";
        System.out.println(Query);

        return studentDatabase.statement.executeQuery(Query);
    }


    public int insertSubjectCode() throws Exception{
        String Query = "INSERT INTO Subject_Code_Detail (subject_code, subject_name) VALUES" +
                "(" + "'" + this.subjectCode + "'" + ", " +
                "'" + this.subjectName + "'" + ");";

        System.out.println(Query);

        return studentDatabase.statement.executeUpdate(Query);
    }

    public int insertSubjectCode(String subjectCode, String subjectName) throws Exception{
        String Query = "INSERT INTO Subject_Code_Detail (subject_code, subject_name) VALUES" +
                "(" + "'" + subjectCode + "'" + ", " +
                "'" + subjectName + "'" + ");";

        System.out.println(Query);
        return studentDatabase.statement.executeUpdate(Query);
    }

    public int removeSubjectCode() throws Exception{
        String Query = "DELETE FROM Subject_Code_Detail WHERE subject_code like" + "'%" + this.subjectCode +  "%'" + ";";
        System.out.println(Query);
        return studentDatabase.statement.executeUpdate(Query);
    }

    public int removeSubjectCode(String subjectCode) throws Exception{
        String Query = "DELETE FROM Subject_Code_Detail WHERE subject_code like " + "'%" + subjectCode + "%'" + ";";
        System.out.println(Query);
        return studentDatabase.statement.executeUpdate(Query);
    }

    public ResultSet listAllSubjects() throws Exception{
        String Query = "SELECT * FROM Subject_Code_Detail";

        return studentDatabase.statement.executeQuery(Query);
    }
}

import java.sql.ResultSet;

public class StudentSubject {
    ConnectionEstablish studentDatabase;

    StudentSubject(ConnectionEstablish studentDatabase){
        try{
            this.studentDatabase = studentDatabase;
        }catch (Exception e){
            System.out.println("An Exception Occurred " + e);
        }
    }


    // list all students with their scores
    // particular Subject
    // particular Student Score


    public ResultSet listAllStudentsWithScores() throws Exception{
        String Query = "SELECT \n" +
                "\tStudent.id, Student.name, Student.roll_number,\n" +
                "    Subject.s_code, Subject_Code_Detail.subject_name,\n" +
                "    Subject.el_score, Subject.quiz_score, Subject.lab_work_score, Subject.Assignment_score,\n" +
                "    Subject.midsem_score, Subject.endsem_score, Subject.attendence\n" +
                "FROM\n" +
                "\tStudent\n" +
                "LEFT OUTER JOIN\n" +
                "\tSubject\n" +
                "ON\n" +
                "\tStudent.id = Subject.student_id\n" +
                "LEFT OUTER JOIN \n" +
                "\tSubject_Code_Detail\n" +
                "ON\n" +
                "\tSubject.s_code = Subject_Code_Detail.subject_code;";

        return studentDatabase.statement.executeQuery(Query);
    }

    public ResultSet listAllStudentSubjectWise(String subjectName, String subjectCode) throws Exception{
        String Query = "SELECT \n" +
                "\tStudent.id, Student.name, Student.roll_number,\n" +
                "    Subject.s_code, Subject_Code_Detail.subject_name,\n" +
                "    Subject.el_score, Subject.quiz_score, Subject.lab_work_score, Subject.Assignment_score,\n" +
                "    Subject.midsem_score, Subject.endsem_score, Subject.attendence\n" +
                "FROM\n" +
                "\tStudent\n" +
                "LEFT OUTER JOIN\n" +
                "\tSubject\n" +
                "ON\n" +
                "\tStudent.id = Subject.student_id\n" +
                "LEFT OUTER JOIN \n" +
                "\tSubject_Code_Detail\n" +
                "ON\n" +
                "\tSubject.s_code = Subject_Code_Detail.subject_code\n " +
                "WHERE\n ";

        boolean conditionGiven = false;
        if(subjectName != null){
            Query += "Subject_Code_Detail.subject_name like " + "'%" + subjectName + "%'";
            conditionGiven = true;
        }
        if(subjectCode != null){
            if(conditionGiven) Query += " OR ";
            Query += "Subject.s_code like " + "'%" + subjectCode + "%'";
        }

        Query += ";";

        return studentDatabase.statement.executeQuery(Query);
    }

    public ResultSet listAllStudentStudentWise(String studentName, long studentId) throws Exception{
        String Query = "SELECT \n" +
                "\tStudent.id, Student.name, Student.roll_number,\n" +
                "    Subject.s_code, Subject_Code_Detail.subject_name,\n" +
                "    Subject.el_score, Subject.quiz_score, Subject.lab_work_score, Subject.Assignment_score,\n" +
                "    Subject.midsem_score, Subject.endsem_score, Subject.attendence\n" +
                "FROM\n" +
                "\tStudent\n" +
                "LEFT OUTER JOIN\n" +
                "\tSubject\n" +
                "ON\n" +
                "\tStudent.id = Subject.student_id\n" +
                "LEFT OUTER JOIN \n" +
                "\tSubject_Code_Detail\n" +
                "ON\n" +
                "\tSubject.s_code = Subject_Code_Detail.subject_code\n " +
                "WHERE\n ";

        boolean conditionGiven = false;
        if(studentName != null){
            conditionGiven = true;
            Query += " Student.name like " + "'%" + studentName + "%'";
        }
        if(studentId != -1){
            if(conditionGiven) Query += " OR ";
            Query += " Student.id = " + studentId;
        }

        Query += ";";

        return studentDatabase.statement.executeQuery(Query);
    }
}

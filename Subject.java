import com.mysql.cj.Query;
import com.mysql.cj.xdevapi.SelectStatement;

import java.sql.ResultSet;

public class Subject {
    String sCode;
    int elScore, quizScore, labScore, assignmentScore, midsemScore, endsemScore, attendance;
    long studentId;
    ConnectionEstablish studentDatabase;

    Subject(long studentId, ConnectionEstablish studentDatabase){
        this.sCode = null;
        this.studentId = studentId;
        this.elScore = -1;
        this.quizScore = -1;
        this.labScore = -1;
        this.assignmentScore = -1;
        this.midsemScore = -1;
        this.endsemScore = -1;
        this.attendance = -1;

        try{this.studentDatabase = studentDatabase;}
        catch (Exception e){
            System.out.println("An Exception Occured" + e);
        }
    }

    Subject(ConnectionEstablish studentDatabase){
        try{this.studentDatabase = studentDatabase;}
        catch (Exception e){
            System.out.println("An Exception Occured" + e);
        }
    }

    Subject(String sCode, long studentId, int elScore, int quizScore, int labScore, int assignmentScore, int midsemScore, int endsemScore, int attendance, ConnectionEstablish studentDatabase){
        this.sCode = sCode;
        this.studentId = studentId;
        this.elScore = elScore;
        this.quizScore = quizScore;
        this.labScore = labScore;
        this.assignmentScore = assignmentScore;
        this.midsemScore = midsemScore;
        this.endsemScore = endsemScore;
        this.attendance = -attendance;

        try{this.studentDatabase = studentDatabase;}
        catch (Exception e){
            System.out.println("An Exception Occured" + e);
        }
    }

    // Getters

    public String getsCode() {
        return sCode;
    }

    public long getStudentId() {
        return studentId;
    }

    public int getElScore() {
        return elScore;
    }

    public int getQuizScore() {
        return quizScore;
    }

    public int getLabScore() {
        return labScore;
    }

    public int getAssignmentScore() {
        return assignmentScore;
    }

    public int getMidsemScore() {
        return midsemScore;
    }

    public int getEndsemScore() {
        return endsemScore;
    }

    public int getAttendance() {
        return attendance;
    }

    // Setters


    public void setsCode(String sCode) {
        this.sCode = sCode;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setQuizScore(int quizScore) {
        this.quizScore = quizScore;
    }

    public void setElScore(int elScore) {
        this.elScore = elScore;
    }

    public void setLabScore(int labScore) {
        this.labScore = labScore;
    }

    public void setAssignmentScore(int assignmentScore) {
        this.assignmentScore = assignmentScore;
    }

    public void setMidsemScore(int midsemScore) {
        this.midsemScore = midsemScore;
    }

    public void setEndsemScore(int endsemScore) {
        this.endsemScore = endsemScore;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public ResultSet findSubject() throws Exception{
        String Query = "SELECT * FROM SUBJECT WHERE ";
        boolean conditionGiven = false;
        if(sCode != null){
            Query += "s_code like " + "'%" + this.sCode + "%'";
            conditionGiven = true;
        }

        if(studentId != -1){
            if(conditionGiven) Query += " and ";
            Query += "student_id=" + this.studentId;
        }

        Query += ";";
        System.out.println(Query);
        return studentDatabase.statement.executeQuery(Query);
    }

    public ResultSet findSubject(String sCode, long studentId) throws Exception{
        String Query = "SELECT * FROM SUBJECT WHERE ";
        boolean conditionGiven = false;
        if(sCode != null){
            Query += "s_code like " + "'%" + sCode + "%'";
            conditionGiven = true;
        }

        if(studentId != -1){
            if(conditionGiven) Query += " and ";
            Query += "student_id=" + studentId;
        }

        Query += ";";
        System.out.println(Query);
        return studentDatabase.statement.executeQuery(Query);
    }



    public int insertSubject() throws Exception{
        String Query =
                "INSERT INTO Subject (S_code, student_id, El_Score, Quiz_Score, Lab_Work_Score, Assignment_Score, Midsem_Score, Endsem_Score, Attendence) VALUES" +
                        "(" + "'" + this.sCode + "'" + ", " +
                        this.studentId + ", " +
                        this.elScore + ", " +
                        this.quizScore + ", " +
                        this.labScore + ", " +
                        this.assignmentScore + ", " +
                        this.midsemScore + ", " +
                        this.endsemScore + ", " +
                        this.attendance + ");";

        System.out.println(Query);
        return studentDatabase.statement.executeUpdate(Query);

    }

    public int insertSubject(String sCode, long studentId, int elScore, int quizScore, int labScore, int assignmentScore, int midsemScore, int endsemScore, int attendance) throws Exception{
        String Query =
                "INSERT INTO Subject (S_code, student_id, El_Score, Quiz_Score, Lab_Work_Score, Assignment_Score, Midsem_Score, Endsem_Score, Attendence) VALUES" +
                        "(" + "'" + sCode + "'" + ", " +
                        studentId + ", " +
                        elScore + ", " +
                        quizScore + ", " +
                        labScore + ", " +
                        assignmentScore + ", " +
                        midsemScore + ", " +
                        endsemScore + ", " +
                        attendance + ");";

        System.out.println(Query);
        return studentDatabase.statement.executeUpdate(Query);
    }


    public int removeSubject() throws Exception{
        String Query =
                "DELETE FROM SUBJECT WHERE" +
                        " s_code=" + "'" + this.sCode + "'" + ", " +
                        " student_id=" + this.studentId + ";";

        System.out.println(Query);
        return studentDatabase.statement.executeUpdate(Query);
    }

    public int removeSubject(String sCode, long studentId) throws Exception{
        String Query =
                "DELETE FROM SUBJECT WHERE" +
                " s_code=" + "'" + sCode + "'" + ", " +
                " student_id=" + studentId + ";";

        System.out.println(Query);
        return studentDatabase.statement.executeUpdate(Query);
    }

    public ResultSet listAllStudentScores() throws Exception{
        String Query = "SELECT * FROM Subject;";
        System.out.println(Query);
        return studentDatabase.statement.executeQuery(Query);
    }
}

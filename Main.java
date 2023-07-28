import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void printLogo(){
        System.out.println(" \t\t\t\t  ._____________________________________________.");
        System.out.println(" \t\t\t\t  | S T U D E N T    R E C O R D    S Y S T E M |");
        System.out.println(" \t\t\t\t  |_____________________________________________|");
        System.out.println("\n\n");

    }

    public static void printStudentHeader(ResultSet rs) throws Exception{
        System.out.println(".________________________________________________________________________________.");
        System.out.println("| id \t\t | Name \t\t | Roll Number \t\t | Email Id \t\t\t\t\t |");
        System.out.println("|________________________________________________________________________________|");

        while(rs.next()){
            System.out.println(
                    rs.getInt("id") + "\t\t" +
                    rs.getString("name") + "\t\t" +
                    rs.getString("roll_number") + "\t\t" +
                    rs.getString("email_id")
            );
        }
    }

    public static void printSubjectCodeHeader(ResultSet rs) throws Exception{
        System.out.println("._____________________________________________.");
        System.out.println("| Subject Code \t\t | Subject Name \t\t |");
        System.out.println("|_____________________________________________|");

        while (rs.next()){
            System.out.println(
                    rs.getString("subject_code") + "\t\t\t\t" +
                    rs.getString("subject_name")
            );
        }
    }

    public static void printStudentParentsHeader(ResultSet rs) throws Exception{
        System.out.println(".________________________________________________________________________________________.");
        System.out.println("| Student Id \t\t | Name \t\t | Phone N0 \t\t | Relationship \t\t\t\t |");
        System.out.println("|________________________________________________________________________________________|");

        while(rs.next()){
            System.out.println(
                    rs.getLong("student_id") + "\t\t\t\t" +
                    rs.getString("name") + "\t\t\t\t" +
                    rs.getString("phone_no") + "\t\t\t\t" +
                    rs.getString("relationship")
            );
        }
    }

    public static void printSubjectHeader(ResultSet rs) throws Exception{
        System.out.println(".____________________________________________________________________________________________________________________________________________________________________________________________________.");
        System.out.println("| Subject Code | Student Id \t\t | EL Score | Quiz Score | Lab Score | Assignment Score | " +
                "Midsem Score | Endsem Score | Attendance |");
        System.out.println("|____________________________________________________________________________________________________________________________________________________________________________________________________|");


        while(rs.next()){
//            System.out.println("here");
            System.out.println(
                    rs.getString("s_code") + "\t\t" +
                    rs.getLong("student_id") + "\t\t\t\t" +
                    rs.getInt("el_score") + "\t\t\t" +
                    rs.getInt("quiz_score") + "\t\t\t" +
                    rs.getInt("lab_work_score") + "\t\t\t" +
                    rs.getInt("assignment_score") + "\t\t\t\t\t" +
                    rs.getInt("midsem_score") + "\t\t\t\t" +
                    rs.getInt("endsem_score") + "\t\t\t\t" +
                    rs.getInt("attendence")
            );
//            System.out.println("buzz");
        }
    }


    public static void printStudentSubjectScoresHeader(ResultSet rs) throws Exception{
        System.out.println(".____________________________________________________________________________________________________________________________________________________________________________________________________.");
        System.out.println("| Id \t\t | Name \t\t | Roll_Number \t\t | Subject Code \t\t | Subject Name \t\t | EL Score | Quiz Score | Lab Score | Assignment Score |" +
                "Midsem Score | Endsem Score | Attendance |");
        System.out.println("|____________________________________________________________________________________________________________________________________________________________________________________________________|");

        while(rs.next()){
            System.out.println(
                    rs.getLong("id") + "\t\t " +
                    rs.getString("name") + "\t\t\t " +
                    rs.getString("roll_number") + "\t\t\t\t " +
                    rs.getString("s_code") + "\t\t\t" +
                    rs.getString("subject_name") + "\t\t\t\t\t6" +
                    rs.getInt("el_score") + "\t\t\t" +
                    rs.getInt("quiz_score") + "\t\t\t" +
                    rs.getInt("lab_work_score") + "\t\t\t" +
                    rs.getInt("assignment_score") + "\t\t\t\t\t" +
                    rs.getInt("midsem_score") + "\t\t\t\t" +
                    rs.getInt("endsem_score") + "\t\t\t\t" +
                    rs.getInt("attendence")
            );
        }
    }

    public static void main(String[] args) throws Exception{
        ConnectionEstablish myStudentDatabase = new ConnectionEstablish();

        Student student;
        Parent parent, parent1;
        Subject subject;
        SubjectCodeDetails scd;
        ResultSet rs;
        int numberOfRecords;
        int choice;

        try{
            Scanner input = new Scanner(System.in);

            while(true){
                printLogo();
                System.out.println("1. Student Information");
                System.out.println("2. Student Subject Information");
                System.out.println("3. Subject Information");
                System.out.println("4. Student Parents information");
                System.out.println("5. Student Subject Joined Information");
                System.out.println("6. Exit");
                System.out.print("\n Enter Your Choice: ");
                choice = input.nextInt();


                switch(choice) {
                    case 1:
                        System.out.println("\n\nSTUDENT INFORMATION");
                        System.out.println("1. List all Students");
                        System.out.println("2. Find Student(s)");
                        System.out.println("3. Insert Student");
                        System.out.println("4. Remove Student");
                        System.out.println("5. Modify Student");
                        System.out.println("6. Leave");
                        System.out.print("Enter Your Choice: ");
                        choice = input.nextInt();
                        input.nextLine();

                        System.out.println();

                        long id = -1;
                        String name = null, rollNumber = null, emailId = null;

                        switch (choice) {
                            case 1:
                                rs = new Student(myStudentDatabase).listAllStudents();

                                printStudentHeader(rs);

                                break;

                            case 2:
                                System.out.println("1. By Id");
                                System.out.println("2. By Name");
                                System.out.println("3. By Roll Number");
                                System.out.println("4. By Email Id");
                                System.out.print("Enter You Choice(if multiple choice, enter the desired choice(eg 123): ");
                                String choice2 = input.nextLine();


                                for (char c : choice2.toCharArray()) {
                                    if (c == '1') {
                                        System.out.print("Enter the id: ");
                                        id = input.nextLong();
                                        input.nextLine();
                                    } else if (c == '2') {
                                        System.out.print("Enter the Name: ");
                                        name = input.nextLine();
                                    } else if (c == '3') {
                                        System.out.print("Enter the Roll Number: ");
                                        rollNumber = input.nextLine();
                                    } else if (c == '4') {
                                        System.out.println("Enter the EmailId");
                                        emailId = input.nextLine();
                                    }
                                }

                                rs = new Student(myStudentDatabase).findStudent(id, name, rollNumber, emailId);

                                printStudentHeader(rs);
                                break;

                            case 3:
                                System.out.println("Enter the credentials");
                                System.out.print("ID: ");
                                id = input.nextLong();
                                input.nextLine();
                                System.out.print("Name: ");
                                name = input.nextLine();
                                System.out.print("Roll Number: ");
                                rollNumber = input.nextLine();
                                System.out.print("Email Id: ");
                                emailId = input.nextLine();


                                student = new Student(id, name, rollNumber, emailId, myStudentDatabase);
                                System.out.println(student.insertStudent() + " added");
                                break;

                            case 4:
                                System.out.println("1. By Id");
                                System.out.println("2. By Name");
                                System.out.println("3. By Roll Number");
                                System.out.println("4. By Email Id");
                                System.out.print("Enter You Choice(if multiple choice, enter the desired choice(eg 123): ");
                                choice2 = input.nextLine();


                                for (char c : choice2.toCharArray()) {
                                    if (c == '1') {
                                        System.out.print("Enter the id: ");
                                        id = input.nextLong();
                                        input.nextLine();
                                    } else if (c == '2') {
                                        System.out.print("Enter the Name: ");
                                        name = input.nextLine();
                                    } else if (c == '3') {
                                        System.out.print("Enter the Roll Number: ");
                                        rollNumber = input.nextLine();
                                    } else if (c == '4') {
                                        System.out.println("Enter the EmailId");
                                        emailId = input.nextLine();
                                    }
                                }

                                System.out.println(new Student(myStudentDatabase).removeStudent(id, name, rollNumber, emailId) + " removed");
                                break;

                            case 5:
                                student = new Student(myStudentDatabase);

                                System.out.print("Enter Student ID: ");
                                long currentId = input.nextLong();
                                input.nextLine();

                                student.setId(currentId);
                                rs = student.findStudent();
                                printStudentHeader(rs);

                                System.out.println("\n Enter New Credentials");
                                System.out.print("ID: ");
                                id = input.nextLong();
                                input.nextLine();
                                System.out.print("Name: ");
                                name = input.nextLine();
                                System.out.print("Roll Number: ");
                                rollNumber = input.nextLine();
                                System.out.print("Email Id: ");
                                emailId = input.nextLine();

                                System.out.println(student.modifyStudent(currentId, name, rollNumber, emailId, id) + " modified");
                                break;

                            case 6:
                                System.out.println("Going Back to Previous Menu");
                                break;

                            default:
                                System.out.println("INVALID INPUT!");
                                break;
                        }
                        break;

                    case 2:
                        System.out.println("\n\n STUDENT SUBJECT INFORMATION");
                        System.out.println("1. List Students with their Scores");
                        System.out.println("2. Insert Subject Scores");
                        System.out.println("3. Remove Student Scores");
                        System.out.println("4. Find Subject");
                        System.out.println("5. Leave");
                        System.out.print("Enter Your Choice: ");
                        choice = input.nextInt();
                        input.nextLine();

                        switch (choice) {
                            case 1:
                                printSubjectHeader(new Subject(myStudentDatabase).listAllStudentScores());
                                break;

                            case 2:
                                System.out.println("Enter the Credentials");
                                System.out.print("Enter Subject Code: ");
                                String sCode = input.nextLine();

                                System.out.print("Enter the Student Id: ");
                                long studentId = input.nextLong();
                                input.nextLine();
                                subject = new Subject(studentId, myStudentDatabase);
                                subject.setsCode(sCode);

                                System.out.print("Enter EL Score: ");
                                int elScore = input.nextInt();
                                input.nextLine();
                                subject.setElScore(elScore);
                                System.out.print("Enter Quiz Score: ");
                                int quizScore = input.nextInt();
                                input.nextLine();
                                subject.setQuizScore(quizScore);
                                System.out.print("Enter Lab Work Score: ");
                                int labScore = input.nextInt();
                                input.nextLine();
                                subject.setLabScore(labScore);
                                System.out.print("Enter Assignment Score: ");
                                int assignmentScore = input.nextInt();
                                input.nextLine();
                                subject.setAssignmentScore(assignmentScore);
                                System.out.print("Enter Midsem Score: ");
                                int midsemScore = input.nextInt();
                                input.nextLine();
                                subject.setMidsemScore(midsemScore);
                                System.out.print("Enter the Endsem Score: ");
                                int endsemScore = input.nextInt();
                                input.nextLine();
                                subject.setEndsemScore(endsemScore);
                                System.out.print("Enter Attendance: ");
                                int attendance = input.nextInt();
                                input.nextLine();
                                subject.setAttendance(attendance);

                                System.out.println(subject.insertSubject() + " added");
                                break;

                            case 3:
                                System.out.print("Enter the Student Id: ");
                                id = input.nextLong();
                                input.nextLine();

                                System.out.print("Enter the Subject Code: ");
                                sCode = input.nextLine();

                                subject = new Subject(id, myStudentDatabase);
                                System.out.println(subject.removeSubject(sCode, id) + " removed");

                                break;

                            case 4:
                                System.out.print("Enter the Student Id: ");
                                id = input.nextLong();
                                input.nextLine();

                                System.out.print("Enter the Subject Code: ");
                                sCode = input.nextLine();

                                subject = new Subject(id, myStudentDatabase);

                                printSubjectHeader(subject.findSubject(sCode, id));
                                break;

                            case 5:
                                System.out.println("Going Back to the Previous Menu");
                                break;

                            default:
                                System.out.println("INVALID INPUT");
                                break;
                        }
                        break;

                    case 3:
                        System.out.println("\n\n SUBJECT INFORMATION");
                        System.out.println("1. Find Subject");
                        System.out.println("2. Insert Subject");
                        System.out.println("3. Remove Subject");
                        System.out.println("4. List all Subjects");
                        System.out.println("5. Leave");
                        choice = input.nextInt();
                        input.nextLine();


                        switch (choice) {
                            case 1:
                                System.out.print("Enter Subject Code: ");
                                String sCode = input.nextLine();
                                printSubjectCodeHeader(new SubjectCodeDetails(myStudentDatabase).findSubjectCode(sCode, null));
                                break;

                            case 2:
                                System.out.print("Enter Subject Code: ");
                                sCode = input.nextLine();
                                System.out.print("Enter Subject Name: ");
                                name = input.nextLine();

                                System.out.println(new SubjectCodeDetails(myStudentDatabase).insertSubjectCode(sCode, name) + " added");
                                break;

                            case 3:
                                System.out.print("Enter Subject Code: ");
                                sCode = input.nextLine();
                                System.out.println(new SubjectCodeDetails(myStudentDatabase).removeSubjectCode(sCode) + " removed");
                                break;

                            case 4:
                                printSubjectCodeHeader(new SubjectCodeDetails(myStudentDatabase).listAllSubjects());
                                break;

                            case 5:
                                System.out.println("Going Back to the Previous Menu");
                                break;

                            default:
                                System.out.println("INVALID INPUT");
                                break;
                        }
                        break;

                    case 4:
                        System.out.println("\n\n STUDENT PARENTS INFORMATION");
                        System.out.println("1. List all Parents");
                        System.out.println("2. Find Parents");
                        System.out.println("3. Leave");
                        System.out.print("Enter Your Choice: ");
                        choice = input.nextInt();

                        switch (choice) {
                            case 1:
                                printStudentParentsHeader(new Parent(myStudentDatabase).listAllParents());
                                break;

                            case 2:
                                System.out.print("Enter Student Id: ");
                                id = input.nextLong();
                                input.nextLine();

                                printStudentParentsHeader(new Parent(myStudentDatabase).findParents(id));
                                break;


                            case 3:
                                System.out.println("Going Back to the Previous Menu");
                                break;

                            default:
                                System.out.println("INVALID INPUT");
                                break;
                        }
                        break;

                    case 5:
                        System.out.println("\n\nSTUDENT SUBJECT JOINED INFORMATION");
                        System.out.println("1. List All Students with their Scores");
                        System.out.println("2. List All Students Scores for a Particular Subject");
                        System.out.println("3. List All Scores for a Particular Student");
                        System.out.println("4. Leave");
                        System.out.print("Enter You Choice: ");
                        choice = input.nextInt();
                        input.nextLine();

                        switch (choice){
                            case 1:
                                printStudentSubjectScoresHeader(new StudentSubject(myStudentDatabase).listAllStudentsWithScores());
                                break;

                            case 2:
                                String subjectName = null, subjectCode = null;
                                System.out.println("1. By Name");
                                System.out.println("2. By Code");
                                System.out.print("Enter Your Choice(For both enter 12): ");
                                String choice2 = input.nextLine();

                                for(char c: choice2.toCharArray()){
                                    if(c == '1'){
                                        System.out.print("Enter Subject Name: ");
                                        subjectName = input.nextLine();
                                    }
                                    if(c == '2'){
                                        System.out.print("Enter Subject Code: ");
                                        subjectCode = input.nextLine();
                                    }
                                }
                                printStudentSubjectScoresHeader((new StudentSubject(myStudentDatabase).listAllStudentSubjectWise(subjectName, subjectCode)));
                                break;

                            case 3:
                                String studentName = null;
                                long studentId = -1;
                                System.out.println("1. By Name");
                                System.out.println("2. By Id");
                                System.out.print("Enter Your Choice(For both enter 12): ");
                                choice2 = input.nextLine();

                                for(char c: choice2.toCharArray()){
                                    if(c == '1'){
                                        System.out.print("Enter Student Name: ");
                                        studentName = input.nextLine();
                                    }
                                    if(c == '2'){
                                        System.out.print("Enter Student Id: ");
                                        studentId = input.nextLong();
                                        input.nextLine();
                                    }
                                }

                                printStudentSubjectScoresHeader(new StudentSubject(myStudentDatabase).listAllStudentStudentWise(studentName, studentId));
                                break;

                            case 4:
                                System.out.println("Going Back to the Previous Menu");
                                break;

                            default:
                                System.out.println("INVALID INPUT");
                                break;
                        }
                        break;

                    case 6:
                        System.out.println("Thank You");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("INVALID INPUT!");
                        System.exit(0);
                        break;
                    }
            }

        }
        catch (Exception e){}

    }
}

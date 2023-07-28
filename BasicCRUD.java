import java.sql.ResultSet;

public interface BasicCRUD {
    ResultSet findStudent() throws Exception;
    ResultSet findStudent(long byId, String byName, String byRollNumber, String byEmailId) throws Exception;

    int insertStudent() throws Exception;
    int insertStudent(long id, String name, String rollNumber, String emailId) throws Exception;

    int removeStudent() throws Exception;
    int removeStudent(long id, String name, String rollNumber, String emailId) throws Exception;

    int modifyStudent(long oldId, String name, String rollNumber, String emailId, long id) throws Exception;
}

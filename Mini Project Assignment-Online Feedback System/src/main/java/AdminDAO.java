import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

	// Update these connection details to match your database configuration
    private final String jdbcURL = "jdbc:mysql://localhost:3306/feedback_db";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Lesp@123";


    public AdminDAO() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Utility method to get a DB connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // Insert a new employee record
    public void insertQuestion(Questions emp) {
        String sql = "INSERT INTO questions (id, question_text) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
           
        	ps.setInt(1, emp.getId());
        	ps.setString(2, emp.getQuestion_text());           
                       
           
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update an existing employee record
    public void updateQuestion(Questions emp) {
        String sql = "UPDATE questions SET  question_text=?, WHERE id=?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
        	
        	ps.setString(2, emp.getQuestion_text());   
        	ps.setInt(1, emp.getId());
           
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete an employee record by id
    public void deleteQuestion(int id) {
        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve a single employee by id
    public Questions getQuestionId(int id) {
        Questions emp = null;
        String sql = "SELECT * FROM questions WHERE id=?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                emp = new Questions();
                emp.setId(rs.getInt("id"));
                emp.setQuestion_text(rs.getString("question_text"));
                emp.setSubject(rs.getString("subject"));
                emp.setMax_marks(rs.getInt("max_marks"));
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    // Retrieve all employee records
    public List<Questions> getAllQuestions() {
        List<Questions> list = new ArrayList<>();
        String sql = "SELECT * FROM questions";
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Questions emp = new Questions();
                
                emp.setId(rs.getInt("id"));
                emp.setQuestion_text(rs.getString("question_text"));
                emp.setSubject(rs.getString("subject"));
                emp.setMax_marks(rs.getInt("max_marks"));
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

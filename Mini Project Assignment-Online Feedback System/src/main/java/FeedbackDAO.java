import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackDAO {
	
	// Update these connection details to match your database configuration
    private final String URL = "jdbc:mysql://localhost:3306/feedback_db";
    private final String Username = "root";
    private final String Password = "Lesp@123";

    public FeedbackDAO() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }        
    }
    
    //To save data in database
    public boolean saveData(String id,String name, String email, String password) {
    	boolean status = false;
    	String query = "INSERT INTO USERS(id,name,email,password) VALUES(?,?,?,?)";
    	
    	try (Connection conn = DriverManager.getConnection(URL, Username, Password);
                PreparedStatement ps = conn.prepareStatement(query)){
    		
    		ps.setString(1, id);
    		ps.setString(2, name);
    		ps.setString(3, email);
    		ps.setString(4, password);
    		
    		
    		int result = ps.executeUpdate();
    		if(result > 0) {
    			status = true;
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return status;
    }
    
    //To check database and userInput
    
    public boolean checkData(String email,String password) {
    	boolean status =false;
    	
    	 String query = "SELECT * FROM users WHERE email = ? AND password = ?";

         try (Connection conn = DriverManager.getConnection(URL, Username, Password);
              PreparedStatement pstmt = conn.prepareStatement(query)) {

             // Set parameters
             pstmt.setString(1, email);
             pstmt.setString(2, password);

             ResultSet rs = pstmt.executeQuery();

             if (rs.next()) {
                 System.out.println("Login Successful! Welcome, " + rs.getString("name"));
                 status = true;
                 
             } else {
                 System.out.println("Invalid email or password.");
                 
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return status;
    }
    
    
    //Check THe Admin Login in database
    
    public boolean AdminChecked(String email, String password) {
    	
    	String query = "SELECT * FROM users WHERE email = ? AND password = ?";
    	boolean status =false;   	

        try (Connection conn = DriverManager.getConnection(URL, Username, Password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Set parameters
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful! Welcome, " + rs.getString("name"));
                status = true;
                
            } else {
                System.out.println("Invalid email or password.");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;}
    }
    	
    
    
    
    



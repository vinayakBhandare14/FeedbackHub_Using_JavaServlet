import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UserRegisterServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		 response.setContentType("text/html");
	       PrintWriter out = response.getWriter();
	       
	       
	       //Retrieve from data
	       String id = request.getParameter("id");
	       String name = request.getParameter("name");
	       String email = request.getParameter("email");
	       String password = request.getParameter("password");
	       
	       
	       //Save data database     
	       FeedbackDAO feedbackDAO = new FeedbackDAO();
	       boolean isSaved = feedbackDAO.saveData(id,name,email,password);
	       
	       
	       // HTML response
	        out.println("<html><head><title>Registration Status</title>");
	        out.println("<style>");
	        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center; padding: 50px; }");
	        out.println(".container { background: #fff; padding: 20px; border-radius: 10px; display: inline-block; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
	        out.println("h2 { color: #28a745; }");
	        out.println("</style>");
	        out.println("</head><body>");
	        out.println("<div class='container'>");
	        if (isSaved) {
	            out.println("<h2>Registration Successful</h2>");
	        } else {
	            out.println("<h2>Registration Failed</h2>");
	        }
	        out.println("</div>");
	        out.println("</body></html>");
		
	}
	
}


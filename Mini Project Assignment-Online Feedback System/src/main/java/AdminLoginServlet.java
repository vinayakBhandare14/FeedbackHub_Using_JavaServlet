import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	AdminDAO adminDAO = new AdminDAO();
	
	public static void QuestionForm(PrintWriter out) {

		

		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.println("<title>Admin Panel - CRUD Application</title>");
		out.println("<style>");
		out.println("body { font-family: Arial, sans-serif; margin: 20px; padding: 0; background-color: #f4f4f4; }");
		out.println(
				".container { max-width: 800px; margin: 0 auto; background: white; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
		out.println("h2 { text-align: center; }");
		out.println(".form-group { margin-bottom: 15px; }");
		out.println("label { display: block; font-weight: bold; }");
		out.println("input, button { width: 100%; padding: 10px; margin-top: 5px; }");
		out.println("button { background: blue; color: white; border: none; cursor: pointer; }");
		out.println("button:hover { background: darkblue; }");
		out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
		out.println("th, td { padding: 10px; border: 1px solid #ddd; text-align: left; }");
		out.println("th { background: #333; color: white; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");

		out.println("<div class='container'>");
		out.println("<h2>Admin Panel - Manage Users</h2>");

		// Form for adding/updating users
		out.println("<form action='AdminLoginServlet' method='post'>");
		out.println("<div class='form-group'>");
		out.println("<label for='id'>Question ID:</label>");
		out.println("<input type='text' name='id' >");
		out.println("</div>");
		out.println("<div class='form-group'>");
		out.println("<label for='name'>Question Text:</label>");
		out.println("<input type='text' name='question_text' required>");
		out.println("</div>");
		out.println("<div class='form-group'>");
		out.println("</div>");
		out.println("<div class='form-group'>");
		
		//Add
		out.println("<input type='hidden' name='action' value='add'>");
		out.println("<button type='submit'>Add Question</button>");
		
		
		// Update 
		out.println("<input type='hidden' name='action' value='update'>");
		out.println("<button type='submit'>Update question</button>");
		out.println("</div>");
		out.println("</form>");

		// Table for displaying Questions
		out.println("<h3>User List</h3>");
		out.println("<table>");
		out.println("<tr><th>ID</th><th>Question</th><th>Actions</th></tr>");

		
		out.println("<tr>");
		out.println("<td>1</td>");
		out.println("<td>John Doe</td>");	
		out.println("<td>");
		
		//Edit
		out.println("<form action='adminLogin' method='post' style='display:inline;'>");
		out.println("<input type='hidden' name='id' value='1'>");
		out.println("<button type='submit' name='action' value='edit'>Edit</button>");
		out.println("</form>");
		
		//Delete
		out.println("<form action='UserServlet' method='post' style='display:inline;'>");
		out.println("<input type='hidden' name='id' value='1'>");
		out.println("<button type='submit' name='action' value='delete' style='background:red;'>Delete</button>");
		out.println("</form>");
		out.println("</td>");
		out.println("</tr>");

		out.println("</table>");
		out.println("</div>");

		out.println("</body>");
		out.println("</html>");

		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		
		// Determine if it is a registration or update
		String action = request.getParameter("action");
		if ("update".equals(action)) {
			// Update an existing employee
			Questions emp = new Questions();
			emp.setId(Integer.parseInt(request.getParameter("id")));
			emp.setQuestion_text(request.getParameter("question_text"));
			
			

			adminDAO.updateQuestion(emp);
			response.sendRedirect("AdminLoginServlet");
		} else if("add".equals(action)){
			// Registration of a new employee
			Questions emp = new Questions();
			//emp.setId(Integer.parseInt(request.getParameter("id")));
			emp.setQuestion_text(request.getParameter("question_text"));
		

			adminDAO.insertQuestion(emp);
			response.sendRedirect("AdminLoginServalet");
		} else if ("edit".equals(action)) {
			
			Questions emp = new Questions();
			emp.setId(Integer.parseInt(request.getParameter("id")));
			emp.setQuestion_text(request.getParameter("question_text"));
			
			
			adminDAO.getQuestionId(Integer.parseInt(request.getParameter("id")));
			response.sendRedirect("AdminLoginServalet");
			
		} else if ("delete".equals(action)) {
			
			Questions emp = new Questions();
			emp.setId(Integer.parseInt(request.getParameter("id")));
			emp.setQuestion_text(request.getParameter("question_text"));
			
			
			adminDAO.deleteQuestion(Integer.parseInt(request.getParameter("id")));
			response.sendRedirect("AdminLoginServalet");
		}
		
		
	}

}

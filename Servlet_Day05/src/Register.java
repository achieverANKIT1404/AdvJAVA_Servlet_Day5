

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reg")
public class Register extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>achieverANKIT | Profile</title>");
		out.print("<style>");
		
		out.print("body{ background-image: url(Backg2.png); background-attachment: fixed;  background-size: 100%;  font-family:calibri;}");
  
        out.print(".data{background-color:palegoldenrod; width:20pc; padding:5px; border-radius:6px; margin-top:13pc;}");
  
		
		out.print("</style>");
		out.print("</head>");
		out.print("<body>");
		
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("upass");
		
		out.print("<center>");
		out.print("<div class = 'data'>");
		out.print("<h2 style = 'color:green;'>Message</h2>");
		out.print("<hr>");

		try{
			
			String  url = "jdbc:mysql://localhost:3306/myserv", uname = "root", passwrd = "abc123"; 
			
			ServletContext context = getServletContext();
			String cname = context.getInitParameter("className");
			
			Class.forName(cname);
			
			Connection con = DriverManager.getConnection(url,uname,passwrd);
			
			PreparedStatement ps = con.prepareStatement("insert into servtbs values(?,?,?,?)");
			
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, password);
			
			int i = ps.executeUpdate();
			
			if(i>0){
				
				out.print("<p style = 'font-size:20px; '>You are registered succesfully...</p>");
			}
			out.print("</div>");
			out.print("</center>");
		}catch (Exception e) {
			
			System.out.println(e);
		}
		out.print("</body>");
		out.print("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

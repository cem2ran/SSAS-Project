package dk.itu.ssas.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Invite
 */
@WebServlet("/Invite")
public class Invite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Invite() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			Connection con = DB.getConnection();
			int image_id = DBUtils.getIntParameter(request, "image_id");
			String username = request.getParameter("other");
			PreparedStatement st = con.prepareStatement("INSERT INTO perms (image_id, user_id) SELECT ? , users.id FROM users WHERE users.username = '?'");
			st.setInt(1, image_id);
			st.setString(2, username);
			st.executeUpdate();
					
			response.sendRedirect("main.jsp");
		}
		catch (SQLException e) 
		{
			throw new ServletException("SQL malfunction.", e);
		}catch(NumberFormatException e){}
	}
}

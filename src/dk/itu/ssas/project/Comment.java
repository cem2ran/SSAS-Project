package dk.itu.ssas.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static dk.itu.ssas.project.DBUtils.*;

/**
 * Servlet implementation class Comment
 */
@WebServlet("/Comment")
public class Comment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection con = DB.getConnection();
			int image_id = getIntParameter(request, "image_id");
			int user_id = getIntParameter(request,"user_id");
			String comment = request.getParameter("comment");
			PreparedStatement st = con
					.prepareStatement("INSERT INTO comments (image_id, user_id, comment) VALUES (?, ?, ?)");
			st.setInt(1, image_id);
			st.setInt(2, user_id);
			st.setString(3, comment);
			st.execute();
			response.sendRedirect("main.jsp");
		} catch(NumberFormatException e){
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

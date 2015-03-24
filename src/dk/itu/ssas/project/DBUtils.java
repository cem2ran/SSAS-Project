package dk.itu.ssas.project;

import javax.servlet.http.HttpServletRequest;

public class DBUtils {
	
	public static int getIntParameter(HttpServletRequest req, String param) throws NumberFormatException{
		return Integer.parseInt(req.getParameter(param));
	}
}

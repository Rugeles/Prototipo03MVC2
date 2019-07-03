import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
	    name = "ControladorMain",
	    urlPatterns = {"/main"}
	)
public class ControladorMain extends HttpServlet {
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException, ServletException {

		    response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
		    RequestDispatcher jsp=request.getRequestDispatcher("/WEB-INF/VistaMain.jsp");
			jsp.forward(request, response);

		  }

}

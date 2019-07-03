import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
	    name = "ControladorPais",
	    urlPatterns = {"/pais"}
	)
public class ControladorPais extends HttpServlet {
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException, ServletException {

		    response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
		    Pais pais;
		    Datos datos;
		    datos=new Datos();
		    pais=datos.recuperarPais();

		    request.setAttribute("pais", pais);
		    RequestDispatcher jsp=request.getRequestDispatcher("/WEB-INF/VistaPresentarPais.jsp");
			jsp.forward(request, response);

		  }
}

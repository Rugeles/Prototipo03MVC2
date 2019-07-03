import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
	    name = "ControladorRegistro",
	    urlPatterns = {"/registro"}
	)
public class ControladorRegistro extends HttpServlet {
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException, ServletException {

		    response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
		    RequestDispatcher jsp=request.getRequestDispatcher("/WEB-INF/VistaCapturarOpcion.jsp");
			jsp.forward(request, response);

		  }

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if ("Registrar circunscripcion".equalsIgnoreCase(request.getParameter("accion"))) {
		    response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
			RequestDispatcher vista=request.getRequestDispatcher("/WEB-INF/VistaCapturarCircunscripcion.jsp");
			vista.forward(request, response);
			}		
		if ("Consultar circunscripcion".equalsIgnoreCase(request.getParameter("accion"))) {
		    response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
			RequestDispatcher vista=request.getRequestDispatcher("/WEB-INF/VistaCapturarNombreBusqueda.jsp");
			vista.forward(request, response);
		}		
		if ("Enviar".equalsIgnoreCase(request.getParameter("accion"))) {
		    Circunscripcion circunscripcion;
		    Datos datos;
		    circunscripcion=new Circunscripcion();
		    datos=new Datos();
		    circunscripcion.setNombre(request.getParameter("nombre"));
		    circunscripcion.setPotencialSufragantes(Long.parseLong(request.getParameter("potencialSufragantes")));
		    circunscripcion.setTotalSufragantes(Long.parseLong(request.getParameter("totalSufragantes")));
		    datos.grabarCircunscripcion(circunscripcion);

		    request.setAttribute("circunscripcion", circunscripcion);
			RequestDispatcher vista=request.getRequestDispatcher("/WEB-INF/VistaPresentarCircunscripcion.jsp");
			vista.forward(request, response);
		}
		if ("Consultar".equalsIgnoreCase(request.getParameter("accion"))) {
		    Circunscripcion circunscripcion;
		    Datos datos;
		    datos=new Datos();
		    circunscripcion=datos.recuperarCircunscripcion(request.getParameter("nombre"));

		    request.setAttribute("circunscripcion", circunscripcion);
			RequestDispatcher vista=request.getRequestDispatcher("/WEB-INF/VistaPresentarCircunscripcion.jsp");
			vista.forward(request, response);
		}
		if ("Cancelar".equalsIgnoreCase(request.getParameter("accion"))) {
		    response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
			RequestDispatcher vista=request.getRequestDispatcher("/WEB-INF/VistaCapturarOpcion.jsp");
			vista.forward(request, response);
		}		
		if ("Terminar".equalsIgnoreCase(request.getParameter("accion"))) {
		    response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
			RequestDispatcher vista=request.getRequestDispatcher("index.html");
			vista.forward(request, response);
		}		
		
	}

}

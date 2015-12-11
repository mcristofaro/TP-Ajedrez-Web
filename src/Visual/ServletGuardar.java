package Visual;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import paquetePiezas.Ficha;
import Utilidades.Partidas;

/**
 * Servlet implementation class ServletGuardar
 */
@WebServlet("/ServletGuardar")
public class ServletGuardar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGuardar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Partidas part=new Partidas();
		part.guardarPartida((Ficha[][])request.getSession().getAttribute("Tablero"), (String[])request.getSession().getAttribute("Jugadores"));
		response.sendRedirect("PartidaGuardada.jdp");
		
	}

}

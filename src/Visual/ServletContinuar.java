package Visual;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utilidades.Partidas;

/**
 * Servlet implementation class ServletContinuar
 */
@WebServlet("/ServletContinuar")
public class ServletContinuar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContinuar() {
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
		Partidas parti=new Partidas();
		request.getSession().setAttribute("Jugadores", parti.getJugadores());
		request.getSession().setAttribute("Tablero", parti.getTablaContinuar((String[])request.getSession().getAttribute("Jugadores")));
		boolean turn=true;
		request.getSession().setAttribute("Turno", turn);
		response.sendRedirect("Tablero.jsp");
		
	}

}

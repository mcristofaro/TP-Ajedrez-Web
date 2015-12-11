package Visual;
import Utilidades.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletEligeJugadores
 */
@WebServlet("/ServletEligeJugadores")
public class ServletEligeJugadores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEligeJugadores() {
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
		String dni1=request.getParameter("jugador1");
		String dni2=request.getParameter("jugador2");
		Jugadores juga=new Jugadores();
		
		System.out.println(juga.getJugador(dni1));
		System.out.println(juga.getJugador(dni2));
		
		String[] jugadore=new String[2];
		jugadore[0]=juga.getJugador(dni1);
		jugadore[0]=juga.getJugador(dni2);
		request.getSession().setAttribute("Jugadores", jugadore);
				
		Tableros tab=new Tableros();
		request.getSession().setAttribute("Tablero", tab.getTableroInicial());
		
		boolean turn=true;
		request.getSession().setAttribute("Turno", turn);
		
		response.sendRedirect("Tablero.jsp");
		
	}

}

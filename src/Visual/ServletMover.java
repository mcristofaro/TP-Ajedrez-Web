package Visual;
import Utilidades.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import paquetePiezas.Ficha;

/**
 * Servlet implementation class ServletMover
 */
@WebServlet("/ServletMover")
public class ServletMover extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMover() {
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
		
		boolean fin;
		int fa=Integer.parseInt(request.getParameter("filaAnt"));
		String ca=(String)request.getParameter("colAnt");
		int fd=Integer.parseInt(request.getParameter("filaDesp"));
		String cd=(String)request.getParameter("colDesp");
		Movimiento m=new Movimiento();
		if(m.puedeMover(fa, ca, fd, cd,(Ficha[][])request.getSession().getAttribute("Tablero"),(boolean)request.getSession().getAttribute("Turno")))
		{
			fin=m.finJuego(fd,cd,(Ficha[][])request.getSession().getAttribute("Tablero"));
			request.getSession().setAttribute("Tablero",m.actualizarTablero(fa, ca, fa, cd,(Ficha[][])request.getSession().getAttribute("Tablero")));
			if (fin)
			{
				response.sendRedirect("FinJuego.jsp");
			}
			if((boolean)request.getSession().getAttribute("Turno"))
			{
				request.getSession().setAttribute("Turno",false);
			}
			else
			{
				request.getSession().setAttribute("Turno",true);
			}
		}
	}

}

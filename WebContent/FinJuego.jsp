<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Felicitaciones </h2>

<%=
if((boolean)request.getSession().getAttribute("Turno"))
	{
		out.println("<h2>");
		String[] jugador=(String[])request.getSession().getAttribute("Turno");
		out.println(jugador[0]);
		out.println("</h2>");
	}
	else
	{
		out.println("<h2>");
		out.println(jugador[1]);
		out.println("</h2>");
	}

%>
<h2>ha ganado el juego. </h2>
</body>
</html>
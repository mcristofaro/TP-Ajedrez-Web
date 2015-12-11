package Utilidades;

import java.sql.ResultSet;
import java.sql.SQLException;


import ConexionDB.MyDataAcces;

public class Jugadores {
	
	public String getJugador(String documento)
    {
    	String jugador,nom,ape;
    	nom=ape="";
		MyDataAcces conexion = new MyDataAcces();
        ResultSet resultado1;
        
        
        resultado1 = conexion.getQuery("select * from jugadores");
       
        try {
          while(resultado1.next()){
        	  
        	  if (documento.equalsIgnoreCase(resultado1.getString("DNI")))
        	  {
        		  nom=resultado1.getString("nombre");
            	  ape=resultado1.getString("apellido");
            	  
        	  }
        	  
          	}
        }catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        
        jugador=nom+" "+ape;
        
        return jugador;            
    }
	
	
	
	
	

}

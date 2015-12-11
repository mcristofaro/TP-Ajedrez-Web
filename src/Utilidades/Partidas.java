package Utilidades;

import java.sql.ResultSet;
import java.sql.SQLException;

import paquetePiezas.Alfil;
import paquetePiezas.Caballo;
import paquetePiezas.Ficha;
import paquetePiezas.Peon;
import paquetePiezas.Reina;
import paquetePiezas.Rey;
import paquetePiezas.Torre;
import ConexionDB.MyDataAcces;

public class Partidas {
	 public void guardarPartida(Ficha[][] tab, String[] jugadores)
	    {
	    	int posi;
	    	String consulta,posiTablero;
	    	String[] posicionesBlanco=new String[16];
	    	String[] posicionesNegro=new String[16];
	    	
	    	for(int i=1;i<9;i++)
	    	{
	    		for(int j=1;j<9;j++)
	    		{

	    			if(tab[i][j]!=null){
	    			if(tab[i][j].getColor().equalsIgnoreCase("B"))
	    			{
	    				posi=posicion(tab[i][j].getClass().toString().substring(20), posicionesBlanco);
	    				posiTablero=Integer.toString(i)+Integer.toString(j);
	    				posicionesBlanco[posi]=posiTablero;
	    				
	    			}
	    			else
	    			{
	    				posi=posicion(tab[i][j].getClass().toString().substring(20), posicionesNegro);
	    				posiTablero=Integer.toString(i)+Integer.toString(j);
	    				posicionesNegro[posi]=posiTablero;
	    			}
	    			}
	    		}
	    	}
	    	
	    	MyDataAcces conexion = new MyDataAcces();
	    	
	    	conexion.setQuery("truncate posiciones");
	    	conexion.setQuery("truncate partidas");
	    	
	    	consulta="insert into partidas values('1','"+jugadores[0]+"','"+jugadores[1]+"')";
	    	conexion.setQuery(consulta);
	    	
	    	consulta="insert into posiciones values('1','"+jugadores[0]+"','"+posicionesBlanco[0]+"','"+posicionesBlanco[1]+"','"+posicionesBlanco[2]+"','"+posicionesBlanco[3]+"','"+posicionesBlanco[4]+"','"+posicionesBlanco[5]+"','"+posicionesBlanco[6]+"','"+posicionesBlanco[7]+"','"+posicionesBlanco[8]+"','"+posicionesBlanco[9]+"','"+posicionesBlanco[10]+"','"+posicionesBlanco[11]+"','"+posicionesBlanco[12]+"','"+posicionesBlanco[13]+"','"+posicionesBlanco[14]+"','"+posicionesBlanco[15]+"')";
	    	conexion.setQuery(consulta);
	    	
	    	consulta="insert into posiciones values('1','"+jugadores[1]+"','"+posicionesNegro[0]+"','"+posicionesNegro[1]+"','"+posicionesNegro[2]+"','"+posicionesNegro[3]+"','"+posicionesNegro[4]+"','"+posicionesNegro[5]+"','"+posicionesNegro[6]+"','"+posicionesNegro[7]+"','"+posicionesNegro[8]+"','"+posicionesNegro[9]+"','"+posicionesNegro[10]+"','"+posicionesNegro[11]+"','"+posicionesNegro[12]+"','"+posicionesNegro[13]+"','"+posicionesNegro[14]+"','"+posicionesNegro[15]+"')";
	    	conexion.setQuery(consulta);
	    }
	    
	    public int posicion(String clase,String[] posiciones)
	    {
	    	int pos=0;
	    	switch (clase) {
			case "Torre":
				if (posiciones[0]==null){pos=0;}
				else{pos=1;}
				break;
			case "Caballo":
				if (posiciones[2]==null){pos=2;}
				else{pos=3;}
				break;
			case "Alfil":
				if (posiciones[4]==null){pos=4;}
				else{pos=5;}
				break;
			case "Reina":
				pos=6;
				break;
			case "Rey":
				pos=7;
				break;
			case "Peon":
				if (posiciones[8]==null){pos=8;}
				else
				{
					if (posiciones[9]==null){pos=9;}
					else
					{
						if (posiciones[10]==null){pos=10;}
						else
						{
							if (posiciones[11]==null){pos=11;}
							else
							{
								if (posiciones[12]==null){pos=12;}
								else
								{
									if (posiciones[13]==null){pos=13;}
									else
									{
										if (posiciones[14]==null){pos=14;}
										else
										{
											pos=15;
										}
										}
									}
									
								}
							}
						}
					}
				break;
	    	}
	    	return pos;	
	    	
	    }
	    
	    public Ficha[][] getTablaContinuar(String[] jugadores)
		{
			String id;
			id="1";
			
			MyDataAcces conexion = new MyDataAcces();
	        ResultSet resultado1;
	        Ficha[][] tablaContinuar=new Ficha[9][9];
	        resultado1 = conexion.getQuery("select * from posiciones");
	        
			
			
			 try {
		          while(resultado1.next()){
		        	  if((id.equalsIgnoreCase(resultado1.getString("ID_Partida")))&&(jugadores[0].equalsIgnoreCase(resultado1.getString("jugador"))))
		        	  {
		        		  	  if (resultado1.getString("torre1")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("torre1").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("torre1").charAt(1)))]=new Torre("B");}
			        		  if (resultado1.getString("torre2")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("torre2").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("torre2").charAt(1)))]=new Torre("B");}
			        		  if (resultado1.getString("caballo1")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("caballo1").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("caballo1").charAt(1)))]=new Caballo("B");}
			        		  if (resultado1.getString("caballo2")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("caballo2").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("caballo2").charAt(1)))]=new Caballo("B");}
			        		  if (resultado1.getString("alfil1")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("alfil1").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("alfil1").charAt(1)))]=new Alfil("B");}
			        		  if (resultado1.getString("alfil2")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("alfil2").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("alfil2").charAt(1)))]=new Alfil("B");}
			        		  if (resultado1.getString("rey")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("rey").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("rey").charAt(1)))]=new Rey("B");}
			        		  if (resultado1.getString("reina")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("reina").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("reina").charAt(1)))]=new Reina("B");}
			        		  if (resultado1.getString("peon1")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon1").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon1").charAt(1)))]=new Peon("B");}
			        		  if (resultado1.getString("peon2")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon2").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon2").charAt(1)))]=new Peon("B");}
			        		  if (resultado1.getString("peon3")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon3").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon3").charAt(1)))]=new Peon("B");}
			        		  if (resultado1.getString("peon4")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon4").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon4").charAt(1)))]=new Peon("B");}
			        		  if (resultado1.getString("peon5")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon5").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon5").charAt(1)))]=new Peon("B");}
			        		  if (resultado1.getString("peon6")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon6").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon6").charAt(1)))]=new Peon("B");}
			        		  if (resultado1.getString("peon7")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon7").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon7").charAt(1)))]=new Peon("B");}
			        		  if (resultado1.getString("peon8")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon8").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon8").charAt(1)))]=new Peon("B");}
			        		  
		        		  
		        	  }
		        	  else
		        	  {
		        		  if((id.equalsIgnoreCase(resultado1.getString("ID_Partida")))&&(jugadores[1].equalsIgnoreCase(resultado1.getString("jugador"))))
		        		  {
		        			  
		        			  if (resultado1.getString("torre1")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("torre1").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("torre1").charAt(1)))]=new Torre("N");}
				        		  if (resultado1.getString("torre2")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("torre2").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("torre2").charAt(1)))]=new Torre("N");}
				        		  if (resultado1.getString("caballo1")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("caballo1").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("caballo1").charAt(1)))]=new Caballo("N");}
				        		  if (resultado1.getString("caballo2")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("caballo2").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("caballo2").charAt(1)))]=new Caballo("N");}
				        		  if (resultado1.getString("alfil1")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("alfil1").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("alfil1").charAt(1)))]=new Alfil("N");}
				        		  if (resultado1.getString("alfil2")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("alfil2").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("alfil2").charAt(1)))]=new Alfil("N");}
				        		  if (resultado1.getString("rey")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("rey").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("rey").charAt(1)))]=new Rey("N");}
				        		  if (resultado1.getString("reina")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("reina").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("reina").charAt(1)))]=new Reina("N");}
				        		  if (resultado1.getString("peon1")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon1").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon1").charAt(1)))]=new Peon("N");}
				        		  if (resultado1.getString("peon2")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon2").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon2").charAt(1)))]=new Peon("N");}
				        		  if (resultado1.getString("peon3")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon3").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon3").charAt(1)))]=new Peon("N");}
				        		  if (resultado1.getString("peon4")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon4").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon4").charAt(1)))]=new Peon("N");}
				        		  if (resultado1.getString("peon5")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon5").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon5").charAt(1)))]=new Peon("N");}
				        		  if (resultado1.getString("peon6")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon6").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon6").charAt(1)))]=new Peon("N");}
				        		  if (resultado1.getString("peon7")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon7").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon7").charAt(1)))]=new Peon("N");}
				        		  if (resultado1.getString("peon8")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon8").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon8").charAt(1)))]=new Peon("N");}
				        			  
			        	  }
		        			  
		        	  }
		        	  
		        	  
		            	  
		        	  	}
		        	
		        	}catch (SQLException e) {
		          // TODO Auto-generated catch block
		        		e.printStackTrace();
		        	}
			 for(int i=1;i<9;i++)
		    	{
		    		for(int j=1;j<9;j++)
		    		{if(tablaContinuar[i][j]!=null){
		    			System.out.println(tablaContinuar[i][j].getApodo());}
		    		}
		    	}
			 return tablaContinuar;
		}
	    
	    public String[] getJugadores()
		{
			String[] jugadores=new String[2];
			jugadores[0]="";
			jugadores[1]="";
			MyDataAcces conexion = new MyDataAcces();
	        ResultSet resultado1;
	        
	        resultado1 = conexion.getQuery("select * from partidas");
	       
	        try {
	          while(resultado1.next()){
	        	          	  
	        	  jugadores[0]=resultado1.getString("Jugador1");
	        	  jugadores[1]=resultado1.getString("Jugador2");
	            	  
	        	  	}
	        }catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	          }
	           
	          
	           return jugadores;   
	           
	           
	  	}

}

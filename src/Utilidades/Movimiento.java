package Utilidades;
import paquetePiezas.*;
public class Movimiento {
	
	public boolean puedeMover(int a, String aux1, int c, String aux2,Ficha[][] tab, boolean jugador)
	{
		boolean puedeono, puedeono2, puedeono3,mov;
		puedeono=puedeono2=puedeono3=false;
    	int b, d;
    	
    	
    	if( ((a>0)&&(a<9))  &&  ((c>0)&&(c<9)) &&    ((aux1.equalsIgnoreCase("a"))||(aux1.equalsIgnoreCase("b"))||(aux1.equalsIgnoreCase("c"))||(aux1.equalsIgnoreCase("d"))||(aux1.equalsIgnoreCase("e"))||(aux1.equalsIgnoreCase("f"))||(aux1.equalsIgnoreCase("g"))||(aux1.equalsIgnoreCase("h")))   &&  ((aux2.equalsIgnoreCase("a"))||(aux2.equalsIgnoreCase("b"))||(aux2.equalsIgnoreCase("c"))||(aux2.equalsIgnoreCase("d"))||(aux2.equalsIgnoreCase("e"))||(aux2.equalsIgnoreCase("f"))||(aux2.equalsIgnoreCase("g"))||(aux2.equalsIgnoreCase("h")))  )
    	{
    	
    	switch (aux1) {
    	 
        case "a":b=1;break;
        case "b":b=2;break;
        case "c":b=3;break;
        case "d":b=4;break;
        case "e":b=5;break;
        case "f":b=6;break;
        case "g":b=7;break;
        case "h":b=8;break;
        default: break;
 
 }
    	switch (aux2) {
   	 
        case "a":d=1;break;
        case "b":d=2;break;
        case "c":d=3;break;
        case "d":d=4;break;
        case "e":d=5;break;
        case "f":d=6;break;
        case "g":d=7;break;
        case "h":d=8;break;
        default: break;
 
 }
    
    	    	b=0;d=0;
    	if (jugador)
    		{if (tab[a][b].getColor()=="B")
    			{puedeono3=true;}}
    	else{if (tab[a][b].getColor()=="N")
		{puedeono3=true;}}
    	
    	    	
    	if (tab[c][d]==null){puedeono2=true;}
    	else {
    		if (tab[c][d].getColor()==tab[a][b].getColor()){puedeono2=false;}
    		else {puedeono2=true;}
    	}
    	
    	puedeono= tab[a][b].mover(a, b, c, d);

	}
    	if ((puedeono)&&(puedeono2)&&(puedeono3))
    	{
    		mov=true;
    	}
    	else
    	{
    		mov=false;
    	}
	return mov;
	}
	
	public Ficha[][] actualizarTablero(int a, String aux1, int c, String aux2,Ficha[][] tab)
	{
		int b,d;
		
		
		switch (aux1) {
   	 
        case "a":b=1;break;
        case "b":b=2;break;
        case "c":b=3;break;
        case "d":b=4;break;
        case "e":b=5;break;
        case "f":b=6;break;
        case "g":b=7;break;
        case "h":b=8;break;
        default: break;
 
 }
    	switch (aux2) {
   	 
        case "a":d=1;break;
        case "b":d=2;break;
        case "c":d=3;break;
        case "d":d=4;break;
        case "e":d=5;break;
        case "f":d=6;break;
        case "g":d=7;break;
        case "h":d=8;break;
        default: break;
 
 }
    	b=0;d=0;
		tab[c][d]=tab[a][b];
		tab[a][b]=null;
		return tab;
	}
	
	public boolean finJuego(int c,String aux, Ficha[][] tablero)
	{
		int d;
		switch (aux) {
	   	 
		case "a":d=1;break;
        case "b":d=2;break;
        case "c":d=3;break;
        case "d":d=4;break;
        case "e":d=5;break;
        case "f":d=6;break;
        case "g":d=7;break;
        case "h":d=8;break;
        default: break;
        
 
		}
		d=0;
		if(tablero[c][d].getClass().toString().substring(20).equals("Rey"))
		 {
			  return true;
		 }
		else
		{
			return false;
		}
		
	}
}

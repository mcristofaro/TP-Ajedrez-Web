package Utilidades;

import paquetePiezas.Alfil;
import paquetePiezas.Caballo;
import paquetePiezas.Ficha;
import paquetePiezas.Peon;
import paquetePiezas.Reina;
import paquetePiezas.Rey;
import paquetePiezas.Torre;

public class Tableros {

	public Ficha[][] getTableroInicial()
	{
		Ficha[][] tableroInicial=new Ficha[9][9];
		tableroInicial[1][1]=new Torre();
		tableroInicial[1][2]=new Caballo();
		tableroInicial[1][3]=new Alfil();
		tableroInicial[1][4]=new Reina();
		tableroInicial[1][5]=new Rey();
		tableroInicial[1][6]=new Alfil();
		tableroInicial[1][7]=new Caballo();
		tableroInicial[1][8]=new Torre();
		tableroInicial[2][1]=new Peon();
		tableroInicial[2][2]=new Peon();
		tableroInicial[2][3]=new Peon();
		tableroInicial[2][4]=new Peon();
		tableroInicial[2][5]=new Peon();
		tableroInicial[2][6]=new Peon();
		tableroInicial[2][7]=new Peon();
		tableroInicial[2][8]=new Peon();
		
		tableroInicial[8][1]=new Torre();
		tableroInicial[8][2]=new Caballo();
		tableroInicial[8][3]=new Alfil();
		tableroInicial[8][4]=new Rey();
		tableroInicial[8][5]=new Reina();
		tableroInicial[8][6]=new Alfil();
		tableroInicial[8][7]=new Caballo();
		tableroInicial[8][8]=new Torre();
		tableroInicial[7][1]=new Peon();
		tableroInicial[7][2]=new Peon();
		tableroInicial[7][3]=new Peon();
		tableroInicial[7][4]=new Peon();
		tableroInicial[7][5]=new Peon();
		tableroInicial[7][6]=new Peon();
		tableroInicial[7][7]=new Peon();
		tableroInicial[7][8]=new Peon();
		
		for(int i=1;i<9;i++)
    	{
    		for(int j=1;j<9;j++)
    		{
    			if( (tableroInicial[i][j]!=null) && ( (i==1) | (i==2) ) ) {
    				tableroInicial[i][j].setColor("N");}
    			if( (tableroInicial[i][j]!=null) && ( (i==7) | (i==8) ) ) {
    				tableroInicial[i][j].setColor("B");}
    		}
    	}
		
		return tableroInicial;
	}
}

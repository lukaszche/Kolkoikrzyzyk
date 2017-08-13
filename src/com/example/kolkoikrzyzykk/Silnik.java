package com.example.kolkoikrzyzykk;

import android.content.Context;
import android.util.Log;

public class Silnik {

	private Context context;
	private final static int GRID_NUMBER =16;
	private float gridSize;
	
	private Gracze graczeGrid[][];
	
	protected enum Gracze{
		None, Player1, Player2
	};
	
	private Gracze currentPlayer=Gracze.None;
	
	public Silnik(Context context){
		this.context=context;
		graczeGrid = new Gracze[GRID_NUMBER][GRID_NUMBER];
		startGra(null);
		new StartDialog(this,context);
	}
	
	public void startGra(Gracze gracz){
		for (int y=0;y<GRID_NUMBER;y++){
			for(int x=0;x<GRID_NUMBER;x++){
				graczeGrid[x][y]=Gracze.None;
			}
		}
		
		currentPlayer = gracz;
	}

	public void zmienGracza(){
		if(currentPlayer == Gracze.Player1){
			currentPlayer=Gracze.Player2;
		}else{
			currentPlayer=Gracze.Player1;
		}
	}
	
	public Gracze getPlayerAt (int x, int y){
		return graczeGrid[x][y];
	}
	
	public int getGridNumber(){
		return GRID_NUMBER;
	}
	public float getGridSize() {
		return gridSize;
	}

	public void setGridSize(float gridSize) {
		this.gridSize = gridSize;
	}

	public Gracze getCurrentPlayer() {
		return currentPlayer;
	}

	public void addMark(int x, int y) {
		if(getPlayerAt(x, y)==Gracze.None){
			graczeGrid[x][y]=getCurrentPlayer();
			zmienGracza();
		}
		Gracze wygrany =wygrana();
		if(wygrany !=Gracze.None){
		new EndDialog(this, context, wygrany);
		}
	}
	
	public Gracze wygrana(){
		for(int y=0; y<GRID_NUMBER;y++){
			for(int x=0;x<GRID_NUMBER;x++){
				if(getPlayerAt(x, y)!=Gracze.None){
					Gracze p =getPlayerAt(x, y);
					
					int zX = -1;
					while(zX<2){
						int zY=-1;
						while(zY<2){
							if(zX!=0 || zY!=0){
								int i=1;
								while (i<6 && x-i>0 && x+i<GRID_NUMBER && y-i>0 && y+i<GRID_NUMBER){
									if(getPlayerAt(x+i*zX, y+i*zY)==p){
										i++;
									}else{
										break;
									}
								}
								if (i==5){
									return p;
								}
							}
							zY++;
						}
						zX++;
					}
				}
			}
		}
		
		return Gracze.None;
	}
	
}

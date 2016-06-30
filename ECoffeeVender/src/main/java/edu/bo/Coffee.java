package edu.bo;

public class Coffee {
	private int coffeePowder;
	private int sugar;
	private int creamer;
	
	public Coffee(int cp,int sg,int cm){
		coffeePowder=cp;
		sugar=sg;
		creamer=cm;
	}
	public int getCoffeePowder() {
		return coffeePowder;
	}
	public void setCoffeePowder(int coffeePowder) {
		this.coffeePowder = coffeePowder;
	}
	public int getSugar() {
		return sugar;
	}
	public void setSugar(int sugar) {
		this.sugar = sugar;
	}
	public int getCreamer() {
		return creamer;
	}
	public void setCreamer(int creamer) {
		this.creamer = creamer;
	}

}

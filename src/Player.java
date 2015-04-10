/**
* Model Class that holds all of the methods that are needed for an object to function as
* a card
**/

public abstract class Player{
	
	protected Cards cards;
	protected PlayerResult result;

	public enum PlayerResult{
		PLAY(0), BUST(1), WIN(2); 
		private int val; 

		PlayerResult(int i){ val = i; }
		public int getValue(){ return val; }	
	} 

	public Player(){
		cards = new Cards(); 
		result = PlayerResult.PLAY;
	}

	public void printCards() {
		cards.printCards(); //prints all of the cards
	}

	public void setPlayerResult(PlayerResult result){
		this.result = result;
	}
	
	public int getTotal(){
		return cards.getTotal();
	}
	public PlayerResult getResultPlayer(){
		return result;
	}
	
	public void addCard(int card){
		cards.addCard(card);
		if(cards.getNumberOfCards() == 2 && cards.getTotal() == 21){
			result = PlayerResult.WIN;
		}
		else if(cards.getTotal() > 21){
			result = PlayerResult.BUST;
		}
		else if(cards.getTotal() == 21){
			result = PlayerResult.WIN;
		}
	}
}

class Dealer extends Player{
	
	public boolean isHit() { 
		return (cards.getTotal() < 17); 
	}
}

class Human extends Player{ }


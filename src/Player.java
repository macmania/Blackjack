/**
* Model Class that holds all of the methods that are needed for an object to function as
* a card
**/

public abstract class Player{
	
	private Cards cards;
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
	
	
	
	public void addCard(int card, boolean printFlag){
		cards.addCard(card, printFlag);
		if(cards.getNumberOfCards() == 2 && cards.getTotal() == 21){
			result = PlayerResult.WIN;
		}
		else if(cards.getTotal() > 21){
			result = PlayerResult.BUST;
		}
		else if(cards.getTotal() == 21){
			result = PlayerResult.WIN;
		}
		else{
			result = PlayerResult.PLAY;
		}
	}
	
	public void setAcesValue(int aceValue){
		cards.setAces(aceValue);
	}
	
	public void clearCards(){
		cards.clearCards();
	}
}

class Dealer extends Player{

	public boolean isHit() { 
		return (getTotal() < 17); 
	}
}

class Human extends Player{ }


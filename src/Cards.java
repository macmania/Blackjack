import java.util.ArrayList;

/**
* Model Class that holds all of the methods that are needed for an object to function as
* a card
**/

public class Cards{
    private ArrayList<Integer> cards;
    private int sum;

	public enum Officer{
		KING(0), QUEEN(12), JACK(11), ACES(1), NORMALCARD(-1);

		private int val; 
		Officer(int i){ this.val = i; }
		
		public static Officer getOfficerFromInt(int type){
			switch(type){
		    		case 0: return KING;
		    		case 12: return QUEEN; 
		    		case 11: return JACK;
		    		case 1: return ACES; 
		    		default: return NORMALCARD;
			}
		}
	}
	
	public enum Type{
		HEARTS(0), TILES(1), CLOVERS(2), PIKES(3); 

		private int val; 
		Type(int i) { val = i; }
		public int getValue(){ return val; }
		
		public static Type getTypeFromInt(int type) {
		    switch(type){
		    		case 0: return HEARTS;
		    		case 1: return TILES; 
		    		case 2: return CLOVERS;
		    		case 3: return PIKES; 
		    }
			return null;
		}
	
	}

	public Cards(){
		cards = new ArrayList<Integer>(); 
	}
	
	public int getTotal(){
		return sum;
	}

	public void addCard(int c){
		cards.add(c);
		int cardValue = c % 13;
		Officer officer = Officer.getOfficerFromInt(cardValue);
		
		switch(officer){
			case KING: case QUEEN: case JACK: 
				sum += 10;
				break;
			default: 
				sum += (cardValue % 13); 
		}
		printCard(c); //prints the type of card
		System.out.println("total: " + sum); //prints the total in the next line
	}
	
	public Type getTypeCard(int c){
		return Type.getTypeFromInt(c/13);
	}
	
	public Officer getOfficerTypeCard(int c){
		return Officer.getOfficerFromInt(c%13);
	}
	
	public void printCard(int c){
		Type typeCard = getTypeCard(c);
		Officer officerCard = getOfficerTypeCard(c);
		if(officerCard != Cards.Officer.NORMALCARD)
			System.out.print(typeCard + ":" + officerCard + ", ");
		else {
			System.out.print(typeCard + ":" + (c%13) + ", ");
		}
	}

	public void printCards() {
		for(int i : cards) {
			printCard(i); 
		}
		
		System.out.print("total: " + sum); 
	}
	
	public int getNumberOfCards(){
		return this.cards.size();
	}
}

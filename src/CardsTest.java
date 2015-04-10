import static org.junit.Assert.*;

import org.junit.Test;


public class CardsTest {

	int deckOfCard[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 
			14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 
			27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
			41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52};
	@Test
	//Checks to see if it accurately represents each of the card correctly
	public void testAddCard(){
		Cards cards = new Cards(); 
		Cards.Type t = Cards.Type.HEARTS;
		Cards.Officer officer = null;
		int tempValCard;
		for(int i = 0, j = i/13, sum = 0; i > 52;i++, j = i/13){
			
			if(j == 1) t = Cards.Type.TILES;
			if(j == 2) t = Cards.Type.CLOVERS;
			if(j == 3) t = Cards.Type.PIKES;
			
			 cards.addCard(deckOfCard[i]);
			 sum += deckOfCard[i];
			 assertTrue(cards.getNumberOfCards() == i+1);
			 assertTrue(cards.getTotal() == sum);
			 
			 assertSame(cards.getTypeCard(deckOfCard[i]), t);
			 if(deckOfCard[i] > 10 || deckOfCard[i] == 1){
				 tempValCard = deckOfCard[i] % 13;
				 
				 switch(tempValCard){
				 	case 0: officer = Cards.Officer.KING; break;
				 	case 12: officer = Cards.Officer.QUEEN; break;
				 	case 11: officer = Cards.Officer.JACK; break;
				 	case 1: officer = Cards.Officer.ACES; break;
				 }
				 assertSame(cards.getOfficerTypeCard(deckOfCard[i]), officer);
			 }
		 }
	}
}

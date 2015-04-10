import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
* Main class that initiates the logic of the game
**/
public class Blackjack{
	static Player players[]; 
	static Integer deckOfCards[];
	public Blackjack(){	
		players = new Player[2]; //the 0th player is the dealer
		players[0] = new Dealer(); 
		players[1] = new Human();

		//Shuffle the deck
		deckOfCards = new Integer[52];

		for(int i=0; i < 52; i++){
			deckOfCards[i] = i + 1; 
		}

		Collections.shuffle(Arrays.asList(deckOfCards));
	}

	public static void main(String[] arg, int args){
		Scanner scan = new Scanner(System.in);
		System.out.println(); 

		int i, j=0;
		String humanPlayerInput; 
		Player.PlayerResult result; 
		Blackjack game = new Blackjack();

		
		players[1].addCard(dealCard(j)); j++; 
		players[1].addCard(dealCard(j)); j++; 
		players[0].addCard(dealCard(j)); j++; 
		players[0].addCard(dealCard(j)); j++; 		

	
		for(; j < 52; j++){
			humanPlayerInput = scan.nextLine(); 
			if(humanPlayerInput.equals("hit") && 
					players[1].getResultPlayer() != Player.PlayerResult.WIN){
				players[1].addCard(dealCard(j)); 
				j++;
			}

			if(players[0] instanceof Dealer && ((Dealer)players[0]).isHit()) {
				players[0].addCard(dealCard(j));
				j++; 
			}

			result = players[0].getResultPlayer(); 
			result = players[1].getResultPlayer(); 
			
			if( players[0].getResultPlayer() == Player.PlayerResult.BUST || //Dealer
				players[1].getResultPlayer() == Player.PlayerResult.BUST || //Player
				players[0].getResultPlayer() == Player.PlayerResult.WIN  || 
				players[1].getResultPlayer() == Player.PlayerResult.WIN) {
				break;
			}
		
			if(players[0].getResultPlayer() == Player.PlayerResult.BUST && 
						players[1].getResultPlayer() == Player.PlayerResult.BUST){
					players[0].setPlayerResult(Player.PlayerResult.WIN); 
					break;
				}
		}
		
		if(players[0].getTotal() == players[1].getTotal()){
			System.out.println("A tie"); 
		}
		
		//Need to print more information on who won. 
		
		System.out.print("Dealer's cards"); 
		players[0].printCards(); 
		
		System.out.print("Player: Human cards"); 
		players[1].printCards(); 

	}

	public static int dealCard(int i){
		return deckOfCards[i];
	}

}

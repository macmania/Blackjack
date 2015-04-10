import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
* Main class that initiates the logic of the game
**/
public class Blackjack{
	
	//Made this an array because in the future, 
	static Player human;
	static Player dealer;
	static Integer deckOfCards[];
	public Blackjack(){	
		human = new Human(); 
		dealer = new Dealer();

		//Shuffle the deck
		deckOfCards = new Integer[52];
		shuffleCards();
		
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		 
		int sessionNumber = 0, j=0;
		String humanPlayerInput, acesValue; 
		Player.PlayerResult result; 
		Blackjack game = new Blackjack();
		boolean continueSession = true, gameOver = false; 
		
		while(continueSession){
			if(j == 0 || continueSession)
			{
				System.out.println("Enter following number option for value of Aces:"
						+ "\n1:Aces=1\n2:Aces=11\n");
				while(!((acesValue = scan.nextLine()).equals("1")) && !acesValue.equals("2")){
						System.out.println("Please enter appropriate answer\n");
				}
				game.setAces(Integer.parseInt(acesValue));
				game.clearBoard();
				j = 0; 
				sessionNumber++;
			}
			System.out.println("Your cards:");
			human.addCard(dealCard(j), true); j++; 
			human.addCard(dealCard(j), true); j++; 
			System.out.println("Dealer's cards:");
			dealer.addCard(dealCard(j), false); j++; 
			dealer.addCard(dealCard(j), false); j++; 		
	
			
			
			for(; j < 52 && !dealer.getResultPlayer().equals(Player.PlayerResult.BUST)
					&& !human.getResultPlayer().equals(Player.PlayerResult.BUST) && 
					dealer.getTotal() != human.getTotal(); j++){
				System.out.println("hit or deal");
				
				while(!(humanPlayerInput = scan.nextLine()).equalsIgnoreCase("hit") && !humanPlayerInput.equals("deal")){
					System.out.println("Please type hit or deal\n");
				} 
				
				if(humanPlayerInput.equals("hit") && 
						human.getResultPlayer() != Player.PlayerResult.WIN){
					System.out.println("Your cards:");
					human.addCard(dealCard(j), true); 
					j++;
				}
	
				if(((Dealer)dealer).isHit()) {
					System.out.println("Dealer's cards:");
					dealer.addCard(dealCard(j), false);
					j++; 
				}
	
				result = dealer.getResultPlayer(); 
				result = human.getResultPlayer(); 
				
				if( dealer.getResultPlayer() == Player.PlayerResult.BUST || //Dealer
					human.getResultPlayer() == Player.PlayerResult.BUST || //Player
					dealer.getResultPlayer() == Player.PlayerResult.WIN  || 
					human.getResultPlayer() == Player.PlayerResult.WIN) {
					break;
				}
			
				if(dealer.getResultPlayer() == Player.PlayerResult.BUST && 
							human.getResultPlayer() == Player.PlayerResult.BUST){
						dealer.setPlayerResult(Player.PlayerResult.WIN); 
						break;
					}
			}
			
			
			//Need to print more information on who won. 
			System.out.println("\n\nGame over for session:" + sessionNumber);
			
			
			if(dealer.getTotal() == human.getTotal()){
				System.out.println("A tie"); 
			}
			
			else if((dealer.getResultPlayer() == Player.PlayerResult.BUST && human.getResultPlayer() == Player.PlayerResult.BUST)  
					|| dealer.getResultPlayer() == Player.PlayerResult.WIN
					|| (dealer.getResultPlayer() == Player.PlayerResult.PLAY && human.getResultPlayer() != Player.PlayerResult.WIN)
					){
				System.out.println("Dealer wins");
			}
			else if(human.getResultPlayer() == Player.PlayerResult.WIN
					|| human.getResultPlayer() == Player.PlayerResult.PLAY){
				System.out.println("You win\n");
			}
			
			
			System.out.print("Dealer's cards\n"); 
			dealer.printCards(); 
			System.out.println("\n");
			System.out.print("Player: Human cards\n"); 
			human.printCards(); 
			
			System.out.println("\nType \"continue\" to keep "
					+ "playing another blackjack game session");
			
			
			
			continueSession = "continue".equals(scan.nextLine().toLowerCase()) ? true : false;
			
		}
	}

	public static int dealCard(int i){
		return deckOfCards[i];
	}
	
	public static void setAces(int acesValue){
		dealer.setAcesValue(acesValue);
		human.setAcesValue(acesValue);
	}
	
	public static void clearBoard(){
		dealer.clearCards();
		human.clearCards();
		shuffleCards();
	}
	
	public static void shuffleCards(){
		for(int i=0; i < 52; i++){
			deckOfCards[i] = i + 1; 
		}
		Collections.shuffle(Arrays.asList(deckOfCards));
	}

}

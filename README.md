Synopsis

Implementation of blackjack game that adheres to the following rules: 
	- there are only 2 players, the dealer and player
	- if total of player or dealer's cards is over 21, then that player or dealer's cards that are 21 lost, also known as bust
	- if total of player or dealers cards is equal then they tie
	- if total of player or dealer's cards is equal to 21 then they win, given that both of them do not equal to 21
	- dealer must continue to take a card/hit if total of his cards is less than 17
	- player can choose to hit or deal

Design
	Player class is an abstract class and 2 classes - human and dealer extends from the player class. This aims to be less repetitive and more re-usable since other classes can simply inherit the player class and add additional necessary methods

	The player class contains an enum of results that represent if that player has lost or won. The rules in governing if that player has lost or won is encapsulated inside of the player class inside the method of "addCard". The player class determines almost immedietely whether the player has lost or won. 

	Cards class has its own methods that are similar in that it contains behaviors that are typical of how cards are dealt with. 

	The cards class contains 2 types of enums - Officer and CardType that are aimed to improve readibility in understanding the 4 officer of cards are dealt with - King, Jack, Queen and Ace and the type of card. These 2 enums helps in showing the user what card he/she has been dealt with

	The blackjack class contains the main method. It determines the logic of how the game operates. There are series of user input commands that determine whether the user wants to continue playing a game and whether the user wants to take a hit or deal. 

Installation
	type make and type command "java Blackjack"
	
Tests
	Import the project and run the tests on eclipse



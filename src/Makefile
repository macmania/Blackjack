JFLAGS = -g
JCC = javac

default: Blackjack.class Player.class Cards.class

Blackjack.class: Blackjack.java
	$(JCC) $(JFLAGS) Blackjack.java

Player.class: Player.java
	$(JCC) $(JFLAGS) Player.java

Cards.class: Cards.java
	$(JCC) $(JFLAGS) Cards.java

clean:
	$(RM) *.class

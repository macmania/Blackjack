import static org.junit.Assert.*;

import org.junit.Test;


public class PlayerTest {
	
	Player dealer = new Dealer(); 
	Player human = new Human(); 
	
	@Test
	public void testGetResultPlayer(){
		dealer.setPlayerResult(Player.PlayerResult.WIN);
		assertEquals(dealer.getResultPlayer(), Player.PlayerResult.WIN);
		
		human.setPlayerResult(Player.PlayerResult.BUST);
		assertEquals(human.getResultPlayer(), Player.PlayerResult.BUST);
	}
	
	@Test
	public void testGetTotal(){
		dealer.addCard(12, true); //This is a Queen
		assertTrue(dealer.getTotal() == 10);
		dealer.addCard(14, true); //This is a one 
		assertTrue(dealer.getTotal() == (10+1)); 
		
		System.out.println();
		
		human.addCard(10, true);
		assertTrue(human.getTotal() == 10);
		human.addCard(5, true);
		assertTrue(human.getTotal() == 15);
	}
	
	@Test 
	//Tests logic on who should win and lose
	public void testWinBustLogic(){
		assertTrue(((Dealer)dealer).isHit());
		dealer.addCard(10, true); dealer.addCard(10, true); 
		assertFalse(((Dealer)dealer).isHit());
		
		assertNotEquals(human.getResultPlayer(), Player.PlayerResult.WIN);
		
		human.addCard(6, true); human.addCard(10, true); human.addCard(5, true);
		assertEquals(human.getResultPlayer(), Player.PlayerResult.WIN);
		
		human.addCard(10, true);
		assertEquals(human.getResultPlayer(), Player.PlayerResult.BUST);
	}

}

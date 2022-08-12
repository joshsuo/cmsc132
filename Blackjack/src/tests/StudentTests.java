package tests;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import blackjack.Blackjack;
import blackjack.Card;


/**
 * Please put your own test cases into this file, so they can be tested
 * on the server.
*/

public class StudentTests {
	
	private static String getCardsString(Card[] array) {
		String result = "";
		for (int i=0; i<array.length; i++) {
			result += array[i] + "\n";
		}
		return result;
	}
	
	@Test
	public void test1()
	{
		Random randomGenerator = new Random(1);
		int numberOfDecks = 1;
		Blackjack blackjack = new Blackjack(randomGenerator, numberOfDecks);
		
		int[] array = null;
		
		int result = blackjack.cardsEvaluation(array, 0);
		
		assertTrue(result == 3);
		
	}
	
	@Test
	public void test2()
	{
		Random randomGenerator = new Random(1);
		int numberOfDecks = 1;
		Blackjack blackjack = new Blackjack(randomGenerator, numberOfDecks);
		
		int[] array = new int[] {10, 21};
		
		int result = blackjack.cardsEvaluation(array, array.length);
		
		assertTrue(result == Blackjack.BLACKJACK);
		
	}
	
	@Test
	public void test3()
	{
		Random randomGenerator = new Random(1);
		int numberOfDecks = 1;
		Blackjack blackjack = new Blackjack(randomGenerator, numberOfDecks);
		
		int[] array = new int[] {11, 21};
		
		
		int result = blackjack.cardsEvaluation(array, array.length);
		
		assertTrue(result == Blackjack.BLACKJACK);
		
	}
	
	@Test
	public void test4()
	{
		Random randomGenerator = new Random(2);
		int numberOfDecks = 1;
		Blackjack blackjack = new Blackjack(randomGenerator, numberOfDecks);
		
		blackjack.deal();
		
		String results = "Dealer's Hand: " + "\n";
		results += getCardsString(blackjack.getDealerCards()) + "\n";
		
		results += "Players's Hand: " + "\n";
		results += getCardsString(blackjack.getPlayerCards()) + "\n";
		
//		results += "Deck: " + "\n";
//		results += getCardsString(blackjack.getGameDeck()) + "\n";
		
		blackjack.playerHit();
		results += getCardsString(blackjack.getPlayerCards())+ "\n";
		
		blackjack.playerHit();
		results += getCardsString(blackjack.getPlayerCards()) + "\n";
		
//		blackjack.playerHit();
//		results += getCardsString(blackjack.getPlayerCards()) + "\n";
		
		blackjack.playerStand();
		results += getCardsString(blackjack.getDealerCards()) + "\n";
		
		//blackjack.cardsEvaluation(array, array.length);
		int result = blackjack.getDealerCardsEvaluation();
		
		System.out.println(results);
		System.out.println(result);
		
		//int[] array = new int[] {10, 22};
		
		//int result = blackjack.cardsEvaluation(array, array.length);
		
		//assertTrue(result == Blackjack.BUST);
		
	}
	
	
}
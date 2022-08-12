package blackjack;
import java.util.*;

public class Blackjack implements BlackjackEngine {
	
	private int numberOfDecks;
	private int account;
	private int bet;
	private Random randomGenerator;
	private int gameStatus;
	private ArrayList<Card> arrayDeck;
	private ArrayList<Card> dealerDeck;
	private ArrayList<Card> playerDeck;
	
	
	/**
	 * Constructor you must provide.  Initializes the player's account 
	 * to 200 and the initial bet to 5.  Feel free to initialize any other
	 * fields. Keep in mind that the constructor does not define the 
	 * deck(s) of cards.
	 * @param randomGenerator
	 * @param numberOfDecks
	 */
	public Blackjack(Random randomGenerator, int numberOfDecks)
	{
		this.randomGenerator = randomGenerator;
		this.numberOfDecks = numberOfDecks;
		this.account = 200;
		this.bet = 5;
		this.arrayDeck = new ArrayList<Card>();
		this.dealerDeck = new ArrayList<Card>();
		this.playerDeck = new ArrayList<Card>();
	}
	
	public int getNumberOfDecks()
	{
		return this.numberOfDecks;
	}
	
	public void createAndShuffleGameDeck()
	{
		this.createDeck();
		this.shuffleDeck();
	}
	
	private void createDeck()
	{
		this.arrayDeck.clear();
		
		for(int i = 0; i < this.numberOfDecks; i++)
		{
			for(CardSuit suit: CardSuit.values())
			{
				for(CardValue value: CardValue.values())
				{
					arrayDeck.add(new Card(value, suit));
				}
			}
		}
	}
	
	private void shuffleDeck()
	{
		Collections.shuffle(this.arrayDeck, this.randomGenerator);
	}
	
	public Card[] getGameDeck()
	{
		Card[] array = new Card[arrayDeck.size()];		
		array = (Card[]) arrayDeck.toArray(array);
		
		return array;
	}
	
	public void deal()
	{	
		this.createAndShuffleGameDeck();
		
		this.dealerDeck.clear();
		this.playerDeck.clear();
		
		
		this.playerDeck.add(arrayDeck.get(0));
		this.playerDeck.get(0).setFaceUp();
		
		this.dealerDeck.add(arrayDeck.get(1));
		this.dealerDeck.get(0).setFaceDown();
		
		this.playerDeck.add(arrayDeck.get(2));
		this.playerDeck.get(1).setFaceUp();
		
		this.dealerDeck.add(arrayDeck.get(3));
		this.dealerDeck.get(1).setFaceUp();
		
		for(int i = 0; i < 4; i++)
		{
			arrayDeck.remove(0);
		}
		
		this.gameStatus = GAME_IN_PROGRESS;
		
	}
		
	public Card[] getDealerCards()
	{
		Card[] array = new Card[dealerDeck.size()];	
		array = (Card[]) dealerDeck.toArray(array);
		
		return array;
	}

	public int[] getDealerCardsTotal()
	{	
		return this.getCardTotal(this.dealerDeck);
	}

	private int[] getCardTotal(ArrayList<Card> deck)
	{
		int total = 0;
		int countAce = 0;
		
		for(int i = 0; i < deck.size(); i++)
		{
			Card card = deck.get(i);
			
			if(card.getValue().getIntValue() ==  1)
			{
				countAce += 1;
			}
			
			total += card.getValue().getIntValue();
		}
		
		if(total > 21)
		{
			return null;
		}
		
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		values.add(total);
		
		for(int i = 0; i < countAce; i++)
		{
			total += 10;
			if(total <= 21)
				values.add(total);
		}
		
		int[] result = new int[values.size()];
		
		for(int i = 0; i < values.size(); i++)
		{
			result[i] = values.get(i);
		}
		return result;
	}
	
	public int getDealerCardsEvaluation()
	{
		return this.cardsEvaluation(this.getDealerCardsTotal(), this.dealerDeck.size());
	}
	
	public int cardsEvaluation(int[] totals, int deckSize)
	{	
		if(totals == null || totals[totals.length - 1] > 21)
			return BUST;
		
		int max = totals[totals.length - 1];
		
		if(max < 21)
		{
			return LESS_THAN_21;
		}
		else if(max == 21 && deckSize == 2)
		{
			return BLACKJACK;
		}
		else
		{
			return HAS_21;
		}
	}
	
	public Card[] getPlayerCards()
	{
		Card[] array = new Card[playerDeck.size()];	
		array = (Card[]) playerDeck.toArray(array);
		
		return array;
	}
	
	public int[] getPlayerCardsTotal()
	{
		return this.getCardTotal(playerDeck);
	}
		
	public int getPlayerCardsEvaluation()
	{
		return this.cardsEvaluation(this.getPlayerCardsTotal(), this.playerDeck.size());
	}
	
	public void playerHit()
	{
		playerDeck.add(arrayDeck.get(0));
		arrayDeck.remove(0);
		
		if(getPlayerCardsEvaluation() == BUST)
			this.gameStatus = DEALER_WON;
		else
			this.gameStatus = GAME_IN_PROGRESS;
		
	}
	
	public void playerStand()
	{
		this.dealerDeck.get(0).setFaceUp();
		
		int[] dealerTotals = this.getDealerCardsTotal();
		int dealerMax = dealerTotals[dealerTotals.length-1];
		
		
		
		while(dealerMax < 16 && !(dealerMax >= 21) && dealerMax > 0)
		{
			dealerDeck.add(arrayDeck.get(0));
			arrayDeck.remove(0);
			
			dealerTotals = this.getDealerCardsTotal();
			
			if(dealerTotals == null)
				dealerMax = 0;
			else
				dealerMax = dealerTotals[dealerTotals.length-1];
		}
		
		int[] playerTotals = this.getPlayerCardsTotal();
		int playerMax = playerTotals[playerTotals.length-1];
		
		if(dealerMax > playerMax)
		{
			this.gameStatus = DEALER_WON;
		}
		else if(dealerMax < playerMax)
		{
			this.gameStatus = PLAYER_WON;
			
			this.setAccountAmount(this.getBetAmount()*2 + this.getAccountAmount());
		}
		else
		{
			this.gameStatus = DRAW;
			
			this.setAccountAmount(this.getBetAmount() + this.getAccountAmount());
		}
		
	}
	
	public int getGameStatus()
	{
		return this.gameStatus;
	}
		
	public void setBetAmount(int amount)
	{
		this.bet = amount;
	}
	
	public int getBetAmount()
	{
		return bet;
	}
	
	public void setAccountAmount(int amount)
	{	
		this.account = amount;
	}
	
	public int getAccountAmount()
	{
		return account;
	}
	
	/* Feel Free to add any private methods you might need */
}
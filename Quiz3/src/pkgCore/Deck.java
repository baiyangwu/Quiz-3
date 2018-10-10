package pkgCore;

import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class Deck {

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() throws DeckException {

		if (cardsInDeck.size() == 0)
		{
			throw new DeckException(this);
		}
		return cardsInDeck.remove(0);

	}

	public Card Draw(eSuit eSuit) {
		for (Card c : cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return (c);
			}
		}
		return (null);
	}
	
	public int getiDeckCount()
	{
		return cardsInDeck.size();
	}

	//------------------------------------------------------Quiz 3----------------------------------------------------
	
	
	public int getRemaining(Object eNum) {
		Stream<Card> a;
		int result = 0;
		eNum = cardsInDeck.remove(eNum);
		
		if(eNum instanceof eSuit) {
			a = cardsInDeck.stream();
			result = a.filter(x -> x.geteSuit() == eNum).collect(Collectors.toList()).size();
			
		}
		if(eNum instanceof eRank) {
			a = cardsInDeck.stream();
			result = a.filter(x -> x.geteRank() == eNum).collect(Collectors.toList()).size();
		}
		
		return result;
	}
	
	
	

}
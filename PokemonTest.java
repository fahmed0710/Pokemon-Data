package proj2;

import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PokemonTest {
	CsvReader c = new CsvReader();
	Pokemon p = new Pokemon();
	
	@Test
	public void testPositive_HPLists() throws IOException {
		c.readFile("/Users/farihaahmed/Downloads/pokemon.csv");	
		HashSet<Character> list = p.getHitPointList(70, c.getCharacterSet());
		
		for(Character pokemon : list) {
			assertTrue(pokemon.getHP() <= 70 && pokemon.getHP() >= 0);
		}
	}
	
	@Test
	public void testNegative_HPLists() throws IOException {
		c.readFile("/Users/farihaahmed/Downloads/pokemon.csv");
		HashSet<Character> list = p.getHitPointList(70, c.getCharacterSet());
		
		for(Character pokemon : list) {
			assertTrue(pokemon.getHP() > 70 && pokemon.getHP() < 0);
		}
	}
	
	@Test
	public void testPositive_TotalLegendaryCount() throws IOException{
		c.readFile("/Users/farihaahmed/Downloads/pokemon.csv");
		
		assertEquals(p.getIsLegendaryCount(c.getCharacterSet()),70);
	}
	
	@Test
	public void testNegative_TotalLegendaryCount() throws IOException{
		c.readFile("/Users/farihaahmed/Downloads/pokemon.csv");
		
		assertEquals(p.getIsLegendaryCount(c.getCharacterSet()),60);
	}
	
	@Test
	public void testPositive_GetFirstCharacter() throws IOException {
		c.readFile("/Users/farihaahmed/Downloads/pokemon.csv");
		TreeSet<Character> list = p.getCharacterByFirstLetter('A', c.getCharacterSet());
		
		for(Character pokemon : list) {
			assertTrue(pokemon.getName().charAt(0) == 'A' ||
					pokemon.getName().charAt(0) == 'a');
		}
	}
	
	@Test
	public void testNegative_GetFirstCharacter() throws IOException {
		c.readFile("/Users/farihaahmed/Downloads/pokemon.csv");
		TreeSet<Character> list = p.getCharacterByFirstLetter('A', c.getCharacterSet());
		
		for(Character pokemon : list) {
			assertTrue(pokemon.getName().charAt(0) == 'B' ||
					pokemon.getName().charAt(0) == 'b');
		}
	}
	
}

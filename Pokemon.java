package proj2;

import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;

public class Pokemon{
	/*
	 * Returns a list of Pokemon characters that 
	 * have a range of HP from 0 to maxHP
	 * 
	 * @param maxHP the maximum hit points
	 * @param baseSet the list of pokemons to sort through
	 * @return a list of pokemons that have the desired range of HP
	 */
	public HashSet<Character> getHitPointList(int maxHP, HashSet<Character> baseSet){
		HashSet<Character> hpList = new HashSet<Character>();
		for(Character c : baseSet) {
			int hp = c.getHP();
			if(hp >= 0 && hp <= maxHP) 
				hpList.add(c);
		}
		return hpList;
	}
	
	/*
	 * Returns the total count of characters
	 * that are marked as legendary
	 * 
	 * @param baseSet the list of pokemons to sort through
	 * @return the total count of legendary characters
	 */
	public int getIsLegendaryCount(HashSet<Character> baseSet) {
		int legendaryCount = 0;
		for(Character c : baseSet) {
			if(c.getIsLegendery() == true)
				legendaryCount++;
		}
		return legendaryCount;
	}
	
	/*
	 * Returns a TreeSet that orders the pokemons by their name
	 * 
	 * @param firstLetter the letter to check for
	 * @param baseSet the list of pokemons to sort through
	 * @return a list of pokemons that have names that start with the desrired letter
	 */
	public TreeSet<Character> getCharacterByFirstLetter(char firstLetter, HashSet<Character> baseSet){
		TreeSet<Character> names = new TreeSet<Character>();
		for(Character c : baseSet) {
			if(c.getName().toUpperCase().charAt(0) == firstLetter ||
			   c.getName().toLowerCase().charAt(0) == firstLetter)
				names.add(c);
		}
		return names;
	}
	
	public static void main(String[] args) throws IOException{
		CsvReader c = new CsvReader();
		c.readFile("/Users/farihaahmed/Downloads/pokemon.csv");
		HashSet<Character> pokemons = c.getCharacterSet();
		Pokemon p = new Pokemon();
		for(Character poke : pokemons) {
			System.out.println(poke.getName() + ", " + poke.getHP() + ", " + poke.getIsLegendery()); 
		}
		System.out.println(p.getHitPointList(70, pokemons));
		System.out.println(p.getIsLegendaryCount(pokemons));
	}
}

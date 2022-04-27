package proj2;

public class Character implements Comparable<Character> {
	private String name;
	private int hp;
	private boolean is_legendary;
	
	/*
	 * Constructs a character
	 * 
	 * @param dataLine the information to build the character
	 */
	public Character(String dataLine) {
		String[] split = dataLine.split(",");
		name = split[split.length - 11];
		hp = Integer.valueOf(split[split.length - 13]);
		is_legendary = split[split.length-1].equals("1");
	}
	
	/*
	 * Returns the character's name
	 * 
	 * @return the character's name
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Returns the character's HP
	 * 
	 * @return the character's HP
	 */
	public int getHP() {
		return hp;
	}
	
	/*
	 * Returns if the character is legendary or not
	 * 
	 * @return the character's legendary status
	 */
	public boolean getIsLegendery() {
		return is_legendary;
	}
	
	@Override
	public int compareTo(Character o) {
		return this.name.compareTo(o.getName());
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + hp*13 + Boolean.hashCode(is_legendary);
	}
	
	@Override
	public boolean equals(Object o) {
		Character c = (Character)o;
		return this.name.equals(c.name) && this.hp == c.hp && this.is_legendary == c.is_legendary;
	}
}

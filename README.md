# Pokemon-Data

**Part 1: Source Code**

_CsvReader_

public boolean readFile(String fileName)

-Returns value is true if file was read okay, false otherwise

-Stores Character objects in a Hashset member variable in this class

-Create a new Character object for each row data line, and then for each line read, 
pass the information to the Character class method

public Hashset<Character> getCharacterSet()

-Allows the retrieval of the entire HashSet of Character objects that were created
  
-Returns a hashset of Character objects (based on the rows of data)

_Character_
  

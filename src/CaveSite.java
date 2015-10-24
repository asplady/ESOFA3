


/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main
				    

				    **/

// interface CaveSite

/*
 * All enter functions return a string to the caller. So
 * The function that calls it can handle the response. If 
 * There is nothing to report about the player's situation
 * the function needs to return a empty string.
 */
public interface CaveSite{
  String enter(Player p);
}


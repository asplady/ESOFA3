


/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main
                
**/

/**  Adventure Game  Program Code
Copyright (c) 1999-2012 James M. Bieman
The Adventure game is based on the "Colossal Cave Adventure" originally
designed by Will Crowther and implemented by Will Crowther
and Don Wood in Fortran in 1975 and 1976.

This micro-version is a variant of the original cave system and is implemented in Java
with just a few rooms and with a much more limited vocabulary.

Updated August 2010, January 2012
- Code is put into package cs314.a2 to match current CS314 coding standards.
Updated January 2012
- Renamed as the "Adventure Game"

To compile: javac cs314.a2.AdventureGame.java
To run:     java cs314.a2.AdventureGame

The main routine is AdventureGame.main
			    
			    **/

/** class Adventure: Primary method, createCave, creates the cave system.
        It eventually be replaced with a more flexible mechanism
        to support input and output from devices other than
        an ASCII terminal.

		Room descriptions are followed by a room identifier,
		to ease debugging and testing.  These would be removed
		to help confuse the user, which is our ultimate aim.

		I haven't added all of the room descriptions.  They
		will be done later.
		
		In this version all I/O is through standard I/O;
		I/O is to and from the console. 

*/

public class Adventure {

  private Room entrance;
  
  public Room createAdventure(){
    // The outside: 
      Room  outside = new Room();
      outside.setDesc(
        "Outside Room: \nBelow you is the first circle: Limbo.");
   
   // Room 1:
      Room r1 = new Room();
      r1.setDesc(
      "Circle 1: This is the room of those who are not allowed \n"
      + "into heaven for one reason or another but are not\n"
      + "sinful. As you look around you see seven castles \n"
      + "in the distance, but far too distant to approach. \n"
      + "This is Limbo."
      + "\n\nAbove you is outside, a circle two: Lust lies to the east. (r1)");

   // Connect the outside to Room 1:
      outside.setSide(5,r1);
      r1.setSide(4,outside);
      entrance = outside;

   // Room 2:
      Room r2 = new Room();
      r2.setDesc(
	"Circle 2: This is the circle of lust, those whose sexual \n"
	+ "desires govern their decisions, this is the land of adulterers.\n"
	+ "\nTo your east is Circle 3: Gluttony, west is Circle 1: Limbo. (r2)");

  // Room 3:
     Room r3 = new Room();
     r3.setDesc(
     "Circle 3: In this third circle of hell lie the gluttonous, \n"
     +"those who let their insatiable appetites twist them into\n"
     +"cold, selfish beings. Here lies Cerberus, the three headed dog.\n"
     +"He watches you, knowing you don�t belong."
     +"\n\nTo your west is Circle 2: Lust, east is Circle 4: Greed,\n"
     +"below you is Circle 5: Anger. (r3)");

  // Connect Rooms 1, 2, & 3:
     r1.setSide(2,r2);
     r2.setSide(3,r1);
     r2.setSide(2,r3);
     r3.setSide(3,r2);

  // Room 4:
     Room r4 = new Room();
     r4.setDesc(
     "Circle 4: Here lie those whose hearts are filled with greed. Souls \n"
     +"are split into two groups, the avaricious whose greed was shown\n"
     + "with their possessions, and the prodigal who covent avaricious.\n"
     +"They are watched by Pluto. \n"
     + "\n\nWest is Circle 3: Gluttony, North is Circle 7: Violence,\n"
     +"down is The River Styx. (r4)");

  // Room 5:
     Room r5 = new Room();
     r5.setDesc(
     "Circle 5: This ring covered in dark murky water, with the \n"
     + "wrathful on top of the water fighting, and the sullen, \n"
     + "who lie drowning in the water. This is the circle of Anger."
     +"\n\nEast is Circle 6: Heresy, above is Circle 3: Gluttony. (r5)");

  // Room 6:
     Room r6 = new Room();
     r6.setDesc(
     "Circle 6: In this circle live heretics, those who refuted God are \n"
     + "sent here. There are burning tombs all around. "
     +"West is Circle 5: Anger. (r6)");     

  // Room 7:
     Room r7 = new Room();
     r7.setDesc(
     "The River Styx: You are plunged into the red, murky river."
     + "\nThere doesn't seem to be anything else here."
     + "\n\nAbove is Cricle 4: Greed. (r7)");
     
     
  // Connect rooms 3, 4, 5, 6, & 7.
     r3.setSide(2,r4);
     r3.setSide(5,r5);
     r4.setSide(3,r3);
     r4.setSide(5,r7);
     r5.setSide(4,r3);
     r5.setSide(2,r6);
     r6.setSide(3,r5);
     r7.setSide(4,r4);

  // Room 8:
     Room r8 = new Room();
     r8.setDesc("Circle 7: The circle of violence, contains three sub rings for the\n"
     + "type of violence. They are guarded by the minotaur.\n"
     + "\n\nWest is Circle 8: Fraud, east is Circle 9: Treachery,\n"
     + "South is Circle 4: Greed. (r8)");


  // Room 9:
     Room r9 = new Room();
     r9.setDesc(
     "Circle 8: Geryon assists you down a large cliff, He has the head\n"
     +"of a man, paws of a lion and a scaly reptilian dragon-like body.\n"
     + "He is a representation of this circle, Fraud.\n\n"
     + "East is Circle 7: Violence. (r9)");

  // Room 10:
     Room r10 = new Room();
     r10.setDesc(
     "9: This ninth and final circle, is that of treachery. Those \n"
     +"whose fallacies were far too heinous to simply be fraudulent."
     +"\n\nWest is Circle 7: Violence, Below you is The Well of Giants Door."
     +"(r10)");
     
 // Room 11:
    Room r11 = new Room();
    r11.setDesc("Mount Purgatory: You look around at what would be a spectacular\n"
    +"view, but it's really quite hellish.\n\nAbove you is Circle 9: Treachery. (r11)");
    Treasure theTreasure = new Treasure();
    theTreasure.setDesc("A bag filled with gold bars.");
    r11.addItem(theTreasure);

 // Lets connect them:
    r4.setSide(0,r8);
    r8.setSide(1,r4);
    r8.setSide(3,r9);
    r8.setSide(2,r10);
    r9.setSide(2,r8);
    r10.setSide(3,r8);

 // Create a key and put it in r6:
    Key theKey = new Key();
    theKey.setDesc("A shiny gold key.");
    r6.addItem(theKey);

 // We add a door between r10 and r11: 
    Door theDoor = new Door(r10,r11,theKey);
    r10.setSide(5,theDoor);
    r11.setSide(4,theDoor);

 // Now return the entrance:
    entrance = outside;
    return entrance;

  }
}


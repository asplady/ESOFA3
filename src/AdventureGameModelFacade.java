
import javax.swing.*;

public class AdventureGameModelFacade {
	
	private String view = "My view";
	private String items = "My items";
	private Player player;

  AdventureGameModelFacade(Player p) { // we initialize
	  player = p;
	  view = player.look();
	  items = player.showMyThings();
  }

  // Player moves Up
  public void goUp(){
	  move(4);
  }
  
  // Player moves down
  public void goDown(){
	  move(5);
	  
    }

  // Player moves North
  public void goNorth(){
	  move(0);
    }
      
  // Player moves South
  public void goSouth(){
	  move(1);
    }

  // Player moves East
  public void goEast(){
	  move(2);
    }
      
  // Player moves West
  public void goWest(){
	  move(3);
    }

  /*
   * This is used to move the player around. All movement button operations use
   * this to move the character. This calls the player.go(n) where n is the given
   * the direction the player wants to go expressed as an int. This will also retrieve
   * the response from player.go() to print it in the view. 
   */
  private void move(int n){
	  String response = player.go(n);
	  view = player.look() +"\n" +  response;
  }
  
  // Gets the current View of the player
  public String getView(){ 
     return view;
     }

  // Gets the current items of the player
  public String getItems(){
     return items;
  }
  
  /* 
   * This handles the grab button is pressed. This will pop up a screen with your
   * options for grabbing items. If the room is empty or the player's hands are full
   * it will instead inform the player that they can not do this option at this point.
   */
  public void grab(){
	  if (player.handsFull()){
		  view = player.look() + "\nYour greedy hands are full";
	  }
	  else if((player.getLoc()).roomEmpty()){
		  view = player.look() + "\nThe room is empty.";
	  }
	  else{
		  Item[] contentsArray = (player.getLoc()).getRoomContents();
		  String[] roomContent = new String[contentsArray.length];
		  
		  int x = 0;
		  for(Item i: contentsArray){
			  roomContent[x++] = i.getDesc();
		  }
		  int response = -1;
		  response = JOptionPane.showOptionDialog(null, 
				  "What do you want to pick up?", 
				  null, JOptionPane.YES_NO_CANCEL_OPTION, 
				  JOptionPane.QUESTION_MESSAGE,null, roomContent,null);
		  if(response >-1){
		  	player.pickUp(contentsArray[response]);
		  	(player.getLoc()).removeItem(contentsArray[response]);
		  }
		  
		  view = player.look();
		  items = player.showMyThings();
		  
	  }
  }
  
  /*
   * This handles the drop button being pressed. This will pop up a screen with your
   * options for dropping an item. If the player has no items to drop it will instead
   * tell the player that they have no items.
   */
  public void drop(){
	  if (player.handsEmpty()){
		  view = player.look() + "\nUnless you cut off a hand you have nothing to drop";
	  }
	  else{
		  Item[] yourItems = player.getArrayMyThings();
		  String[] pocketContent = new String[player.numItemsCarried()]; 
		  
		  for(int i = 0; i < pocketContent.length; i++ ){
			  	pocketContent[i] = yourItems[i].getDesc();
		  }
		  int response = -1;
		  response = JOptionPane.showOptionDialog(null, 
				  "What do you want to drop?", 
				  null, JOptionPane.YES_NO_CANCEL_OPTION, 
				  JOptionPane.QUESTION_MESSAGE,null, pocketContent,null);
		  if(response >-1){
		  	player.drop(response+1);
		  	
		  }
		  
		  view = player.look();
		  items = player.showMyThings();
		  
	  }

  }
}

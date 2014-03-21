/*
 * Project: Ensign Ricky
 * Group Members: Randy Herritt, Tristan Trim, Ye Liang, Stefan Lawson, Parisa Farukh
 * Instructor: Srini Sampalli
 * Dalhousie University
 * March 2014
 *
 * Player:
 */
 
public class Player
{
   //instance variables
   private int hitPoints;
   private int currentRoom;
   private Inventory playerInventory;
   
   //no args constructor
   public Player()
   {
      hitPoints = 100;
      playerInventory = new Inventory();
      currentRoom=0;
   }
   
   //getters and setters
   public void setHitPoints(int h)
   {
      if (h > 0 && h <= 100)
         hitPoints = h;
      else
         System.out.println("Error - hitpoints have to be between 0 and 100.");   
   }   

   public int getHitPoints()
   {
      return hitPoints;
   }
   
   public Inventory getInventory()
   {
      return playerInventory;
   }

   public int getCurrentRoom()
   {
      return currentRoom;
   }

   public void setCurrentRoom(int currentRoom)
   {
      this.currentRoom=currentRoom;
   }
   
   public String displayInventory()
   {
      return "Inventory: " + playerInventory;
   }
      

}

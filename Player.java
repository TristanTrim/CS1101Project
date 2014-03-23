/*
 * Project: Ensign Ricky
 * Group Members: Randy Herritt, Tristan Trim, Ye Liang, Stefan Lawson, Parisa Farukh
 * Instructor: Srini Sampalli
 * Dalhousie University
 * March 2014
 *
 * Player:
 */

import java.util.ArrayList;

public class Player
{
   //instance variables

   private int currentRoom;
   private ArrayList<Item> inventory; //aggregation directly with Item class, no Inventory class in between
   
   //no args constructor
   public Player()
   {
      inventory = new ArrayList<Item>();
      currentRoom=0;
   }
   

   
   public ArrayList<Item> getInventory()
   {
      return inventory;
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
      return "Inventory: " + inventory;
   }
   //9 slots in inventoty     
	public void addItem(Item item)
	{
		if(inventory.size()<=9)
			inventory.add(item);
		else
			System.out.println("Inventory is full.");
	}
	//remove the first Item item from inventory
	public void removeItem(Item item)
	{
		inventory.remove(item);
	}	
	
}
/*
 * Project: Ensign Ricky
 * Group Members: Randy Herritt, Tristan Trim, Ye Liang, Stefan Lawson, Parisa Farukh
 * Instructor: Srini Sampalli
 * Dalhousie University
 * March 2014
 *
 * Inventory:
 */

import java.util.ArrayList;

public class Inventory
{
   private ArrayList<Item> items;
   
   //no arg constructor
   public Inventory()
   {
      items = new ArrayList<Item>();
   }
   
   public String toString()
   {
      String inventory = "";
      boolean isFirst = true;
      for (Item item : items)
      {
         if(isFirst){
            isFirst=false;
         }else{
            inventory +=", ";
         }
         inventory += item;
      }
      
      return inventory;
   }

   public ArrayList<Item> getItems()
   {
      return(items);
   }
   
// This is mostly for removing key items
//
// removes the first Item item from inventory.
   public void removeItem(Item item)
   {
      items.remove(item);
   }

   
}

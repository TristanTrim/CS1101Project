/*
 * Project: Ensign Ricky
 * Group Members: Randy Herritt, Tristan Trim, Ye Liang, Stefan Lawson, Parisa Farukh
 * Instructor: Srini Sampalli
 * Dalhousie University
 * March 2014
 *
 * Ship:
 */

import java.util.ArrayList;

public class Option
{

   private String Name;
   private String ActionText;
   private String FailText = "";
   private ArrayList<Item> RemovedItems = new ArrayList<Item>();
   private ArrayList<Item> AddedItems = new ArrayList<Item>();
   private int changeroom = -1;

   Option (String Name, String ActionText, int toRoom)
   {
      this.Name=Name;
      this.ActionText=ActionText;
      this.changeroom = toRoom;
   }
   Option (String Name, String ActionText)
   {
      this(Name, ActionText, -1);
   }

   public String toString() 
   {
      return(Name);
   }

   public String getDescription()
   {
      return(ActionText);
   }
   
// This will go through the options
// vars and perform apropriate actions
// in an apropriate order.
//
// Then reterns related text.
   public String decide (Player player)
   {

      //First we need to know if the user needs
      //Key items removed.
      boolean canDo=true;
      for(Item item : RemovedItems)
      {
         if(!player.getInventory().contains(item))
         {
            canDo=false;
         }
      }

      //if the user has needed items/requirements
      // we go ahead and perform the actions!
      if(canDo)
      {

        // remove items from user inventory
          for(Item item : RemovedItems)
          {
	     player.getInventory().remove(item);
          }
        // add items to user inventory
          for(Item item : AddedItems)
          {
             player.getInventory().add(0,item);
          }

        // Change users room in the ship
          if(!(changeroom==-1))
          {
             player.setCurrentRoom(changeroom);
          }

        // now, return the new infotext.
          return(ActionText);
       }else{
          return(FailText);
       }
    }


}


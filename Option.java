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

   /// Useful attributes!
   private String Name;
   private String ReplyText;
   private String FailText = "";// not sure we need this...
   private int changeRoom = -1;
   private ArrayList<Item> TakenItems = new ArrayList<Item>();
   private ArrayList<Item> GivenItems = new ArrayList<Item>();
   private int finiteGiven=-1;// this may be used or deleted at some point as well....


// constructor method only takes the name of the Option.
   Option (String Name)
   {
      this.Name=Name;
   }

// some mutators

   public void setReplyText(String ReplyText)
   {
      this.ReplyText="<html>"+ReplyText;
   }

   public void setChangeRoom(int newRoom)
   {
      this.changeRoom=newRoom;
   }


// These methods add and remove items from the arrays
// of items to be given or taken from the player upon
// them choosing the option.

   public void addGivenItem(Item givable)
   {
      if(givable!=null){
         this.GivenItems.add(givable);
      }
   }

   public void addTakenItem(Item takable)
   {
      if(takable!=null){
         this.TakenItems.add(takable);
     }
   }



   public void setFailText(String fial)
   {
      this.FailText="<html>"+fial;
   }

   public String toString() 
   {
      return(Name);
   }

   public String getDescription()
   {
      return(ReplyText);
   }
   
// This will go through the options
// vars and perform apropriate actions
// in an apropriate order.
//
// Then reterns related text.
   public String decide (Player player)
   {

      String textbuf="";

      //First we need to know if the user needs
      //Key items removed.
      boolean canDo=true;
      for(Item itemNeeded : TakenItems)
      {
         boolean itemIsNotThere = true;
         for(Item itemHad : player.getInventory())
         {
            if(itemHad.equals(itemNeeded))
            {
               itemIsNotThere = false;
            }
         }
         if(itemIsNotThere)
         {
            canDo=false;
            textbuf+="You have no "+itemNeeded+"<br>";
         }
      }

      // Players can't have more than nine items!
      // We'd better check that they don't.
      if(GivenItems.size()-TakenItems.size()>9-player.getInventory().size())
      {
         canDo=false;
         textbuf+="Your inventory is full<br>";
      }

      //if the user has needed items/requirements
      // we go ahead and perform the actions!
      if(canDo)
      {

        // remove items from user inventory
          for(Item item : TakenItems)
          {
             boolean notRemoved=true;
             for(int i=0;notRemoved;i++)
             {
                if(player.getInventory().get(i).equals(item))
                {
                   player.getInventory().remove(i);
                   notRemoved=false;
                }
             }
             textbuf+="<br>"+item.getName()+" removed from inventory.";
          }
        // add items to user inventory
          for(Item item : GivenItems)
          {
             player.getInventory().add(0,item);
             textbuf+="<br>"+item.getName()+" added to inventory.";
          }

        // Change users room in the ship
          if(!(changeRoom==-1))
          {
             player.setCurrentRoom(changeRoom);
          }


        // add the end html tag to the end of the textbuffer.
          textbuf+="</html>";

        // now, return the new infotext.
          return(ReplyText+textbuf);
       }else{
        // add the end html tag to the end of the textbuffer.
          textbuf+="</html>";
          return(FailText+textbuf);
       }
    }


}


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
   private String ActionText;
   private String FailText = "";
   private int changeroom = -1;
   private ArrayList<Item> RemovedItems = new ArrayList<Item>();
   private ArrayList<Item> AddedItems = new ArrayList<Item>();


   /// Lots of kinds of constructor methods.
   Option (String Name, String ActionText, int toRoom,
           ArrayList<Item> addit,ArrayList<Item> remit)
   {
      this.Name=Name;
      this.ActionText="<html>"+ActionText;
      this.FailText="<html>";
      this.changeroom = toRoom;
      this.AddedItems=addit;
      this.RemovedItems=remit;
   }
   Option (String Name, String ActionText)
   {
      this(Name, ActionText, -1,
      new ArrayList<Item>(),
      new ArrayList<Item>()
      );
   }
   Option (String Name, String ActionText, int changeRoom)
   {
      this(Name, ActionText, changeRoom,
      new ArrayList<Item>(),
      new ArrayList<Item>()
      );
   }
   Option (String Name, String ActionText, Item addone, Item subone, String fial)
   {
      this(Name, ActionText, -1,
      new ArrayList<Item>(),
      new ArrayList<Item>()
      );
      if(addone!=null){
         this.AddedItems.add(addone);
      }
      if(subone!=null){
         this.RemovedItems.add(subone);
     }
     this.setFailText(fial);
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
      return(ActionText);
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
      for(Item itemNeeded : RemovedItems)
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
         }
      }

      // Players cant have more than nine items!
      // We'd better check that they don't.
      if(AddedItems.size()>9-player.getInventory().size())
      {
         canDo=false;
         textbuf+="Your inventory is full";
      }

      //if the user has needed items/requirements
      // we go ahead and perform the actions!
      if(canDo)
      {

        // remove items from user inventory
          for(Item item : RemovedItems)
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
          for(Item item : AddedItems)
          {
             player.getInventory().add(0,item);
             textbuf+="<br>"+item.getName()+" added to inventory.";
          }

        // Change users room in the ship
          if(!(changeroom==-1))
          {
             player.setCurrentRoom(changeroom);
          }


        // add the end html tag to the end of the textbuffer.
          textbuf+="</html>";

        // now, return the new infotext.
          return(ActionText+textbuf);
       }else{
        // add the end html tag to the end of the textbuffer.
          textbuf+="</html>";
          return(FailText+textbuf);
       }
    }


}


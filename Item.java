/*
 * Project: Ensign Ricky
 * Group Members: Randy Herritt, Tristan Trim, Ye Liang, Stefan Lawson, Parisa Farukh
 * Instructor: Srini Sampalli
 * Dalhousie University
 * March 2014
 *
 * Ship:
 */

public class Item
{
   private String Name;

   Item(String Name){
      this.Name=Name;
   }

   public String getName(){
      return(Name);
   }

   public String toString(){
      return(Name);
   }

  //Please update this method if
  // you edit this class!
  //
  // It checks if items are the same
  // Item! (used in the Option class
  // to check for key items)
  public boolean equals(Item other) {
     return(Name.equals(other.getName()));
  }

}


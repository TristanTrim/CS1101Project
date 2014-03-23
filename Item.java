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
   private String name;
   private String description;//add description

   public Item(String name)
   {
      this.name=name;
   }

   public String getName()
   {
      return name;
   }

	public String getDescription() 
   {
		return description;
	}

	public void setDescription(String description) 
   {
		this.description = description;
	}
   
	public String toString() 
   {
		return name + ":" + description;
	}

  //Please update this method if
  // you edit this class!
  //
  // It checks if items are the same
  // Item! (used in the Option class
  // to check for key items)
  public boolean equals(Item other) {
     return(name.equals(other.getName()));
  }

}


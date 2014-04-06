/*
 * Project: Ensign Ricky
 * Group Members: Randy Herritt, Tristan Trim, Ye Liang, Stefan Lawson, Parisa Farukh
 * Instructor: Srini Sampalli
 * Dalhousie University
 * March 2014
 *
 * Room:
 */

public class Room
{
   //instance variables
   String description;
   Option option1;
   Option option2;
   Option option3;
   Option option4;
   Option option5;
   
   //no arg constructor
   public Room()
   {
   }
   
   //setters and getters
   public void setDescription(String d)
   {
      description = d;
   }
   
   public String getDescription()
   {   
      return description;
   }   
   
   // gets and sets for the options.
   // here be a blight of boredom. Do not read if you value interest.
   public void setOption1(Option s)
   {
      option1 = s;
   }
   public Option getOption1()
   {
      return option1;
   }   
   
   public void setOption2(Option s)
   {
      option2 = s;
   }
   public Option getOption2()
   {
      return option2;
   }
   
   public void setOption3(Option s)
   {
      option3 = s;
   }
   public Option getOption3()
   {
      return option3;
   }
   
   public void setOption4(Option s)
   {
      option4 = s;
   }
   public Option getOption4()
   {
      return option4;
   }
   
   public void setOption5(Option s)
   {
      option5 = s;
   }
   public Option getOption5()
   {
      return option5;
   }



}

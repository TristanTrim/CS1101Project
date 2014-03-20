/*
 * Project: Ensign Ricky
 * Group Members: Randy Herritt, Tristan Trim, Ye Liang, Stefan Lawson, Parisa Farukh
 * Instructor: Srini Sampalli
 * Dalhousie University
 * March 2014
 *
 * Ship:
 */

public class Ship
{
   //instance variables
   private Room[] rooms;
   private int currentRoom;
   
   //no arg constructor
   public Ship()
   {
      rooms = new Room[9];
      createRooms();
   }
   
   //create rooms
   public void createRooms()
   {
      //rooms
      Room bridge = new Room();
      Room captainReadyRoom = new Room();
      Room hallway = new Room();
      Room holoDeck = new Room();
      Room tenForward = new Room();
      Room engineRoom = new Room();
      Room transporterRoom = new Room();
      Room warRoom =  new Room();
      Room crewCabins = new Room();
      
      rooms[0] = bridge;
      rooms[1] = captainReadyRoom;
      rooms[2] = hallway;
      rooms[3] = holoDeck;
      rooms[4] = tenForward;
      rooms[5] = engineRoom;
      rooms[6] = transporterRoom;
      rooms[7] = warRoom;
      rooms[8] = crewCabins;
      
      //room descriptions
      //bridge
      String d = "";
      d = "<html>You are on the bridge. It's lonely here for an ensign. Spock<br>" +
          "is staring hard at his panel shaking head. The Captain is<br>" +
          "sitting in his chair staring at the view screen. He seems<br>" +
          "seems tense and distracted.</html>";
      bridge.setDescription(d);
      bridge.setOption1(new Option("North", "ya go north"));
      bridge.setOption2(new Option("East", "ya go east"));
      bridge.setOption3(new Option("Talk to Spock", "\"Please control your emotions Ricky\""));
      bridge.setOption4(new Option("Talk to Kirk", "Hmm, You, could go and get tea?"));
      bridge.setOption5(new Option("Look at viewscreen", "Looks spacy. Nice resolution"));
      
   }
   
   //get currentLocation
   public Room getCurrentRoom()
   {
      return rooms[currentRoom];
   }   
   
   public void setRoomIndex(int i)
   {
      currentRoom = i;
   }
}

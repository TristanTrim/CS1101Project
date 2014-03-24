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
      String d_bridge = "";
      String d_hallway = "";
      String d_readyRoom = "";
      
      d_bridge = "You are on the bridge of the USS Enterprise. People are <br>" +
          "walking around quickly, chattering to each other in hushed, <br>" +
          "nervous tones. Spock is looking into a device that looks a little<br>" +
          "bit like a toaster oven. You’re supposed to know what its really <br>" +
          "called, because its part of your training and you’re pretty sure <br>" +
          "that its not actually a toaster. But, you’re just an Ensign after<br>" +
          "all, and you’re sure no one really cares if you know what it’s <br>" +
          "called. You’re also not entirely sure if Vulcans can look nervous<br>" +
          "or not, but he seems to be showing definite signs of concern. The<br>" +
          "Captain is here. He is sitting in his chair, looking distracted.";
      d_hallway = "";
      d_readyRoom = "You are in the Captain’s Ready Room.  You’re pretty<br>" +
           "sure you’re not suppose to be in here. You can’t get over how<br>" +
           "immaculate the room is. There doesn’t seem to be single thing out <br>" +
           "of place. You see a desk, and a picture of a green alien woman drinking<br>" +
           "a Romulan ale.";     
      
      //bridge
      bridge.setDescription(d_bridge);
      bridge.setOption1(new Option("North", "ya go north", 2));
      bridge.setOption2(new Option("East", "ya go east"));
      bridge.setOption3(new Option("Talk to Spock", "\"Please control your emotions Ricky\""));
      bridge.setOption4(new Option("Talk to Kirk", "Hmm, You, could go and get tea?"));
      bridge.setOption5(new Option("Look at viewscreen", "Looks spacy. Nice resolution"));
   
      //hallway
      d = "<html>You are in the hallway. It's lonely here for an ensign. <br>" +
          "The hallway is empty</html>";
      hallway.setDescription(d_hallway);
      hallway.setOption1(new Option("North", "ya go north"));
      hallway.setOption2(new Option("East", "ya go east.<br> The bridge is pretty bright compared with the hallway.", 0));
      hallway.setOption3(new Option("Wait", "You wait. It's kinda booring."));
      hallway.setOption4(new Option("Do a handstand", "That wouldn't be very professional"));
      hallway.setOption5(new Option("Pick mushroom", "Odd that there would be mushrooms<br>growing in a hallway.", new Item("Mushroom")));
      
      //ready room
      captainReadyRoom.setOption1(new Option("West", d_bridge, 0));
      captainReadyRoom.setOption2(new Option("West", d_bridge, 0));
      captainReadyRoom.setOption3(new Option("West", d_bridge, 0));
      captainReadyRoom.setOption4(new Option("West", d_bridge, 0));
      captainReadyRoom.setOption5(new Option("West", d_bridge, 0));
   }


   //get currentLocation
   public Room getRoomOf(Player player)
   {
      return rooms[player.getCurrentRoom()];
   }   
   
   public void setRoomIndex(int i)
   {
      currentRoom = i;
   }
}

/*
 * Project: Ensign Ricky
 * Group Members: Randy Herritt, Tristan Trim, Ye Liang, Stefan Lawson, Parisa Farukh
 * Instructor: Srini Sampalli
 * Dalhousie University
 * March 2014
 *
 * Ship: This method is used to process text and options depending on which room
 * in the ship the Player is in.
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
      String d_warRoom = "";
      
      d_bridge = "You are on the bridge of the USS Enterprise. People are <br>" +
          "walking around quickly, chattering to each other in hushed, <br>" +
          "nervous tones. Spock is looking into a device that looks a little<br>" +
          "bit like a toaster oven. You're supposed to know what its really <br>" +
          "called, because its part of your training and you are pretty sure <br>" +
          "that its not actually a toaster. But, you're just an Ensign after<br>" +
          "all, and you're sure no one really cares if you know what it is <br>" +
          "called. You are also not entirely sure if Vulcans can look nervous<br>" +
          "or not, but he seems to be showing definite signs of concern. The<br>" +
          "Captain is here. He is sitting in his chair, looking distracted.";
      d_hallway = "You are in a hallway.  You're still learning your way around<br>" +
            "but you think this place looks familiar - in that, it looks like<br>" +
            "every other hallway on the Enterprise. Sulu is here, shirtless, and<br>" +
            "carrying a sword. But, other than that, things seem quite ordinary.";
      d_readyRoom = "You are in the Captain's Ready Room.  You are pretty<br>" +
           "sure you're not suppose to be in here. You can't get over how<br>" +
           "immaculate the room is. There doesn't seem to be single thing out<br>" +
           "of place. You see a desk, and a picture of a green alien woman<br>" +
           "drinking a Romulan ale.";
      d_warRoom = "You are in the war room. You know for a fact that you're <br>" +
            "not supposed to be in here. Why do you keep doing this to<br>" +
            "yourself. Are you trying to get reprimanded or something. I mean<br>" +
            "who just wanders into the war room of a USS ship without proper<br>" +
            "clearance. Good thing that everyone is so preoccupied with the<br>" +
            "emminent death of everyone and everything on board to not notice<br>" +
            "you walking around like you own the place... seriously. Anyway,<br>" +
            "you are in the war room. It is quite spectacular. You should <br>" +
            "see it. I'm not going to tell you about it though, because I<br>" +
            "I think you should know better, and if I do, I don't think you'll<br>" +
            "ever learn.";       
      
      //option text
      String bridgeOption3 = "";
      String bridgeOption4 = "";
      String bridgeOption5 = "";
      String readyRoomOption3 = "";
      String readyRoomOption4 = "";
      String readyRoomOption5a = "";
      String readyRoomOption5b = "";
       
      //bridge
      bridgeOption3 = "\"What - oh, Mr. Ricky. Excuse me, but this is not the <br>" +
         "time to discuss your training. As you can see, I'm really <br>" +
         "quite busy. Or do you not know that Klingons are about to attack<br>" +
         "the ship. Oh, bother, you probably don't even know what this is<br>" +
         "called, do you?\" Spock looks back into the device you <br> " +
         "are regretting not paying more attention to in class.";
       bridgeOption4 = "Kirk looks at you for a moment and then at your hands. <br>" +
         "\"You're... not... carrying my... tea.\" he says.  He looks <br>" +
         "back to the floor, seeming to lose interest in you.";
       
      bridge.setDescription(d_bridge);
      bridge.setOption1(new Option("North", d_hallway, 2));
      bridge.setOption2(new Option("East", d_readyRoom, 1));
      bridge.setOption3(new Option("Talk to Spock", bridgeOption3));
      bridge.setOption4(new Option("Talk to Kirk", bridgeOption4));
      bridge.setOption5(new Option("Look at viewscreen", "Looks spacy. Nice resolution"));
   
      //hallway
      hallway.setDescription(d_hallway);
      hallway.setOption1(new Option("North", "ya go north"));
      hallway.setOption2(new Option("South", d_bridge, 0));
      hallway.setOption3(new Option("Wait", "You wait. It's kinda booring."));
      hallway.setOption4(new Option("Do a handstand", "That wouldn't be very professional"));
      hallway.setOption5(new Option("Pick mushroom", "These aren't mushrooms at all!<br>They are glass cups!", new Item("Glass"), null, ""));
      
      //ready room
      readyRoomOption3 = "She seems quite lovely. There's some writing on the picture <br>" +
         "in purple lipstick in a language that you don't understand.";
      readyRoomOption4 = "You feel important, if not a little worried you might get<br>" +
         "caught. Although, you feel like you should be more concerned<br>" +
         "about the imminent attack of the Klingons.";

      captainReadyRoom.setOption1(new Option("West", d_bridge, 0));
      captainReadyRoom.setOption2(new Option("East", d_warRoom, 7));
      captainReadyRoom.setOption3(new Option("Look at picture", readyRoomOption3));
      captainReadyRoom.setOption4(new Option("Sit at desk", readyRoomOption4));
      captainReadyRoom.setOption5(new Option("Ponder being the Captain", "You seem to wasting a lot of time..."));
   
      //war room
      warRoom.setOption1(new Option("West", d_readyRoom, 1));
      warRoom.setOption2(new Option("West", d_readyRoom, 1));
      warRoom.setOption3(new Option("West", d_readyRoom, 1));
      warRoom.setOption4(new Option("West", d_readyRoom, 1));
      warRoom.setOption5(new Option("West", d_readyRoom, 1));
   
   }


   public Room getReadyRoom()
   {
      return rooms[1];
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

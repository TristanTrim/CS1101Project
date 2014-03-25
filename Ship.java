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
      String d_readyRoom = "";
      String d_hallway = "";
      String d_holoDeck = "";
      String d_tenForward = "";
      String d_engineRoom = "";
      String d_transporterRoom = "";
      String d_warRoom = "";
      String d_crewCabins = "";
      
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
      d_readyRoom = "You are in the Captain's Ready Room.  You are pretty<br>" +
           "sure you're not suppose to be in here. You can't get over how<br>" +
           "immaculate the room is. There doesn't seem to be single thing out<br>" +
           "of place. You see a desk, and a picture of a green alien woman<br>" +
           "drinking a Romulan ale.";
      d_hallway = "You are in a hallway.  You're still learning your way around<br>" +
            "but you think this place looks familiar - in that, it looks like<br>" +
            "every other hallway on the Enterprise. Sulu is here, shirtless, and<br>" +
            "carrying a sword. But, other than that, things seem quite ordinary.";
      d_holoDeck = "You are in the holodeck. It is currently set to the re-creation<br>" +
            "of a early 21st century university computer science class. There are <br>" +
            "a fine selection of young men and woman currently learning about<br>" + 
            "pointers. Not that you're entirely sure what that really is.";
      d_tenForward = "You are in Ten Forward. Bones is sitting at a table drinking<br>" +
            "a dark, what you can only imagine as being a strong drink. The <br>" +
            "glass seems well used. He is mumbling to himself. The rest of <br>" +
            "the bar patrons seem to ignore you. You don't really have a lot <br>" +
            "of friends onboard, do you?";
      d_engineRoom = "You are in the engine room. There is a very large, complicated<br>" +
            "engine here (vague enough). Also, there is a small panel box <br>" +
            "that does not seem to be working.";
      d_transporterRoom = "You are in the transporter room. There is a panel here <br>" +
            "with a green button that you're absolutely sure you're not supposed<br>" +
            "to touch. I mean, really - to think, an Ensign just haphazardly<br>" +
            "touching a button on a transporter panel. They don't even <br>" +
            "bother to have someone manning the station, as it is absolutely<br>" +
            "inconcievable to think that someone would be so nutty to activate<br>" +
            "the transporter without permission. I mean, come on - you're not<br>" +
            "going to do that are you?";          
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
      d_crewCabins = "You are in a section of the ship containing some of the<br>" +
            "crew's cabins.";            
      
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
      bridge.setOption1(new Option("North", d_hallway, 2));
      bridge.setOption2(new Option("East", d_readyRoom, 1));
      bridge.setOption3(new Option("Talk to Spock", bridgeOption3));
      bridge.setOption4(new Option("Talk to Kirk", bridgeOption4));
      bridge.setOption5(new Option("Look at viewscreen", "Looks spacy. Nice resolution"));
   
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

      //hallway
      hallway.setOption1(new Option("North", d_holoDeck, 3));
      hallway.setOption2(new Option("South", d_bridge, 0));
      hallway.setOption3(new Option("East", d_crewCabins, 8));
      hallway.setOption4(new Option("Do a handstand", "That wouldn't be very professional"));
      hallway.setOption5(new Option("Pick mushroom", "These aren't mushrooms at all!<br>They are glass cups!", new Item("Glass"), null, ""));
      
      //holodeck
      holoDeck.setOption1(new Option("East", d_tenForward, 4));
      holoDeck.setOption2(new Option("South", d_hallway, 2));
      holoDeck.setOption3(new Option("South", d_hallway, 2));
      holoDeck.setOption4(new Option("South", d_hallway, 2));
      holoDeck.setOption5(new Option("South", d_hallway, 2));
      
      //ten forward
      tenForward.setOption1(new Option("West", d_holoDeck, 3));
      tenForward.setOption2(new Option("East", d_engineRoom, 5));
      tenForward.setOption3(new Option("South", d_crewCabins, 8));
      tenForward.setOption4(new Option("South", d_crewCabins, 8));
      tenForward.setOption5(new Option("South", d_crewCabins, 8));
      
      //engine room
      engineRoom.setOption1(new Option("West", d_tenForward, 4));
      engineRoom.setOption2(new Option("South", d_transporterRoom, 6));
      engineRoom.setOption3(new Option("South", d_transporterRoom, 6));
      engineRoom.setOption4(new Option("South", d_transporterRoom, 6));
      engineRoom.setOption5(new Option("South", d_transporterRoom, 6));
      
      //transporter room
      transporterRoom.setOption1(new Option("North", d_engineRoom, 5));
      transporterRoom.setOption2(new Option("West", d_crewCabins, 8));
      transporterRoom.setOption3(new Option("South", d_warRoom, 7));
      transporterRoom.setOption4(new Option("South", d_warRoom, 7));
      transporterRoom.setOption5(new Option("South", d_warRoom, 7));
      
      //war room
      warRoom.setOption1(new Option("North", d_transporterRoom, 6));
      warRoom.setOption2(new Option("West", d_readyRoom, 1));
      warRoom.setOption3(new Option("West", d_readyRoom, 1));
      warRoom.setOption4(new Option("West", d_readyRoom, 1));
      warRoom.setOption5(new Option("West", d_readyRoom, 1));
      
     //crew's cabins
     crewCabins.setOption1(new Option("North", d_tenForward, 4));
     crewCabins.setOption2(new Option("West", d_hallway, 2));
     crewCabins.setOption3(new Option("East", d_transporterRoom, 6));
     crewCabins.setOption4(new Option("East", d_transporterRoom, 6));
     crewCabins.setOption5(new Option("East", d_transporterRoom, 6));
   
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

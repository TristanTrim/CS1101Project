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
            "crew's cabins. People come and go... you see a personal items<br>" +
            "like picture frames and slippers. In one room, you can see a<br>" +
            "glass case. In it is a small, furry little creature that you<br>" +
            "recognize as being a tribble. It is sickingly cute.";            
      
      //option text
      String bridgeOption3 = "";
      String bridgeOption4 = "";
      String bridgeOption5 = "";
      String readyRoomOption3 = "";
      String readyRoomOption4 = "";
      String readyRoomOption5a = "";
      String readyRoomOption5b = "";
       
      // buffer Option
      Option opbuf;

      //bridge
      opbuf = new Option("North");
      opbuf.setReplyText(d_hallway);
      opbuf.setChangeRoom(2);
      bridge.setOption1(opbuf);
      
      opbuf = new Option("East");
      opbuf.setReplyText(d_readyRoom);
      opbuf.setChangeRoom(1);
      bridge.setOption2(opbuf);

      opbuf = new Option("Talk to Spock");
      bridgeOption3 = "\"What - oh, Mr. Ricky. Excuse me, but this is not the <br>" +
         "time to discuss your training. As you can see, I'm really <br>" +
         "quite busy. Or do you not know that Klingons are about to attack<br>" +
         "the ship. Oh, bother, you probably don't even know what this is<br>" +
         "called, do you?\" Spock looks back into the device you <br> " +
         "are regretting not paying more attention to in class.";
      opbuf.setReplyText(bridgeOption3);
      bridge.setOption3(opbuf);

      opbuf = new Option("Talk to Kirk");
       bridgeOption4 = "Kirk looks at you for a moment and then at your hands. <br>" +
         "\"You're... not... carrying my... tea.\" he says.  He looks <br>" +
         "back to the floor, seeming to lose interest in you.";     
      opbuf.setReplyText(bridgeOption4);
      bridge.setOption4(opbuf);

      opbuf = new Option("Look at viewscreen");
      opbuf.setReplyText("Looks spacy. Nice resolution");
      bridge.setOption5(opbuf);


      //ready room
      readyRoomOption3 = "She seems quite lovely. There's some writing on the picture <br>" +
         "in purple lipstick in a language that you don't understand.";
      readyRoomOption4 = "You feel important, if not a little worried you might get<br>" +
         "caught. Although, you feel like you should be more concerned<br>" +
         "about the imminent attack of the Klingons.";

      opbuf = new Option("West");
      opbuf.setReplyText(d_bridge);
      opbuf.setChangeRoom(0);
      captainReadyRoom.setOption1(opbuf);

      opbuf = new Option("East");
      opbuf.setReplyText(d_warRoom);
      opbuf.setChangeRoom(7);
      captainReadyRoom.setOption2(opbuf);

      opbuf = new Option("Look at picture");
      opbuf.setReplyText(readyRoomOption3);
      captainReadyRoom.setOption3(opbuf);

      opbuf = new Option("Sit at desk");
      opbuf.setReplyText(readyRoomOption4);
      captainReadyRoom.setOption4(opbuf);

      opbuf = new Option("Ponder being the Captain");
      opbuf.setReplyText("You seem to wasting a lot of time...");
      captainReadyRoom.setOption5(opbuf);


      //hallway
      opbuf = new Option("North");
      opbuf.setReplyText(d_holoDeck);
      opbuf.setChangeRoom(3);
      hallway.setOption1(opbuf);

      opbuf = new Option("South");
      opbuf.setReplyText(d_bridge);
      opbuf.setChangeRoom(0);
      hallway.setOption2(opbuf);

      opbuf = new Option("East");
      opbuf.setReplyText(d_crewCabins);
      opbuf.setChangeRoom(8);
      hallway.setOption3(opbuf);

      opbuf = new Option("Do a handstand");
      opbuf.setReplyText( "That wouldn't be very professional");
      hallway.setOption4(opbuf);

      opbuf = new Option("Pick mushroom");
      opbuf.setReplyText( "These aren't mushrooms at all!<br>They are glass cups!");
      opbuf.addGivenItem(new Item("Glass"));
      hallway.setOption5(opbuf);

      
      //holodeck
      opbuf = new Option("East");
      opbuf.setReplyText(d_tenForward);
      opbuf.setChangeRoom(4);
      holoDeck.setOption1(opbuf);

      opbuf = new Option("South");
      opbuf.setReplyText(d_hallway);
      opbuf.setChangeRoom(2);
      holoDeck.setOption2(opbuf);
      holoDeck.setOption3(opbuf);
      holoDeck.setOption4(opbuf);
      holoDeck.setOption5(opbuf);

      
      //ten forward
      opbuf = new Option("West");
      opbuf.setReplyText(d_holoDeck);
      opbuf.setChangeRoom(3);
      tenForward.setOption1(opbuf);

      opbuf = new Option("East");
      opbuf.setReplyText(d_engineRoom);
      opbuf.setChangeRoom(5);
      tenForward.setOption2(opbuf);

      opbuf = new Option("South");
      opbuf.setReplyText(d_crewCabins);
      opbuf.setChangeRoom(8);
      tenForward.setOption3(opbuf);
      tenForward.setOption4(opbuf);
      tenForward.setOption5(opbuf);

      //engine room
      opbuf = new Option("West");
      opbuf.setReplyText(d_tenForward);
      opbuf.setChangeRoom(4);
      engineRoom.setOption1(opbuf);

      opbuf = new Option("South");
      opbuf.setReplyText(d_transporterRoom);
      opbuf.setChangeRoom(6);
      engineRoom.setOption2(opbuf);
      engineRoom.setOption3(opbuf);
      engineRoom.setOption4(opbuf);
      engineRoom.setOption5(opbuf);

      
      //transporter room
      opbuf = new Option("North");
      opbuf.setReplyText(d_engineRoom);
      opbuf.setChangeRoom(5);
      transporterRoom.setOption1(opbuf);

      opbuf = new Option("West");
      opbuf.setReplyText(d_crewCabins);
      opbuf.setChangeRoom(8);
      transporterRoom.setOption2(opbuf);

      opbuf = new Option("South");
      opbuf.setReplyText(d_warRoom);
      opbuf.setChangeRoom(7);
      transporterRoom.setOption3(opbuf);
      transporterRoom.setOption4(opbuf);
      transporterRoom.setOption5(opbuf);

      //war room
      opbuf = new Option("North");
      opbuf.setReplyText(d_transporterRoom);
      opbuf.setChangeRoom(6);
      warRoom.setOption1(opbuf);

      opbuf = new Option("West");
      opbuf.setReplyText(d_readyRoom);
      opbuf.setChangeRoom(1);
      warRoom.setOption2(opbuf);
      warRoom.setOption3(opbuf);
      warRoom.setOption4(opbuf);
      warRoom.setOption5(opbuf);

      
     //crew's cabins
      opbuf = new Option("North");
      opbuf.setReplyText(d_tenForward);
      opbuf.setChangeRoom(4);
      crewCabins.setOption1(opbuf);

      opbuf = new Option("West");
      opbuf.setReplyText(d_hallway);
      opbuf.setChangeRoom(2);
      crewCabins.setOption2(opbuf);

      opbuf = new Option("East");
      opbuf.setReplyText(d_transporterRoom);
      opbuf.setChangeRoom(6);
      crewCabins.setOption3(opbuf);
      crewCabins.setOption4(opbuf);
      crewCabins.setOption5(opbuf);

   
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

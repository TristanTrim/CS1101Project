/*
 * Project: Ensign Ricky
 * Group Members: Randy Herritt, Tristan Trim, Ye Liang, Stefan Lawson, Parisa Farukh
 * Instructor: Srini Sampalli
 * Dalhousie University
 * March 2014
 *
 * TextAdventure: This class init all game objects and handles and game logic
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextAdventure extends JFrame implements ActionListener
{
   //instance variables
   private boolean gameRunning;
   private int currentRoom;
   
   private JPanel panel;
   private JPanel panel_RoomText;
   private JPanel panel_Map;
   private JPanel panel_Options;
   private JPanel panel_Items;
   private JPanel panel_Inventory;
   private JPanel panel_MapDisplay;

   private JLabel panel_RoomText_Label;   
   private JLabel label_Items;
   private JLabel label_Map;
   
   private JButton button1;
   private JButton button2;
   private JButton button3;
   private JButton button4;
   private JButton button5;
   private JButton[] inventory;//create buttons to display inventory
   private JButton[] map;//create buttons to display map and current room
   
   private Player thePlayer;
   private Ship theShip;
   
   
   //no args constructor
   public TextAdventure()
   {
      //Create GUI
      
      //create JPanels
      panel = new JPanel(new GridLayout(2,2,5,5));
      
      panel_RoomText = new JPanel();
      panel_Map = new JPanel();
      panel_Map.setLayout(new BorderLayout());
      panel_Options = new JPanel(new GridLayout(5,1));
      panel_Items = new JPanel();
      panel_Items.setLayout(new BorderLayout());
      
      panel_MapDisplay=new JPanel(new GridLayout(3,3,1,1));
      label_Map=new JLabel("Map",JLabel.CENTER); 
      panel_Map.add(label_Map,BorderLayout.NORTH);      
      panel_Map.add(panel_MapDisplay,BorderLayout.CENTER);
      
      panel_Inventory= new JPanel(new GridLayout(3,3,5,5));
      
      
      label_Items = new JLabel("Inventory",JLabel.CENTER);
      panel_Items.add(label_Items,BorderLayout.NORTH);
      panel_Items.add(panel_Inventory,BorderLayout.CENTER);
      
      //colour
      panel.setBackground(Color.pink);
      panel_RoomText.setBackground(Color.pink);
      panel_Map.setBackground(Color.pink);
      panel_Options.setBackground(Color.pink);
      panel_Items.setBackground(Color.pink);
      panel_Inventory.setBackground(Color.pink);
            
      //add the panels
      add(panel);
      panel.add(panel_RoomText);
      panel.add(panel_Map);
      panel.add(panel_Options);
      panel.add(panel_Items);
      
            
      //create and add the options buttons
      button1 = new JButton();
      button2 = new JButton();
      button3 = new JButton();
      button4 = new JButton();
      button5 = new JButton();
      panel_Options.add(button1);
      panel_Options.add(button2);
      panel_Options.add(button3);
      panel_Options.add(button4);
      panel_Options.add(button5);
           
      //create inventory buttons
      inventory= new JButton[9];
      for (int i=0;i<9;i++)
      {
         inventory[i] = new JButton();
         inventory[i].setEnabled(false);
         //inventory[i].setText(thePlayer.getInventory().get(i).getName());
         panel_Inventory.add(inventory[i]);
      }
      
      //create map buttons
      map= new JButton[9];
      for (int i=0;i<9;i++)
      {
         map[i] = new JButton();
         map[i].setEnabled(false);
         map[i].setBackground(Color.YELLOW);
         map[i].setFont(new Font("sansserif",Font.BOLD,13));
         map[i].setForeground(new Color(255,150,0));
      }      
      panel_MapDisplay.add(map[3]);
      panel_MapDisplay.add(map[4]);
      panel_MapDisplay.add(map[5]);
      panel_MapDisplay.add(map[2]);
      panel_MapDisplay.add(map[8]);
      panel_MapDisplay.add(map[6]);
      panel_MapDisplay.add(map[0]);
      panel_MapDisplay.add(map[1]);
      panel_MapDisplay.add(map[7]);
      resetMap();
      map[0].setText("<html>Bridge<br/>You are here.");
      map[0].setBackground(new Color(0,0,0));
     
      
      //create Player
      thePlayer = new Player();
      
      //create Ship
      theShip = new Ship();
      panel_RoomText_Label = new JLabel(theShip.getRoomOf(thePlayer).getDescription(), SwingConstants.CENTER);
      panel_RoomText.add(panel_RoomText_Label);
      
       //create a JFrame
      setTitle("Ensign Ricky");
      setSize(900,600); //width, height
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);

      //update the description - can be changed to display whatever to start the game
      String introText = "<html>You are on the bridge of the USS Enterprise. People are <br>" +
          "walking around quickly, chattering to each other in hushed, <br>" +
          "nervous tones. Spock is looking into a device that looks a little<br>" +
          "bit like a toaster oven. You're supposed to know what its really <br>" +
          "called, because its part of your training and you're pretty sure <br>" +
          "that its not actually a toaster. But, you're just an Ensign after<br>" +
          "all, and you're sure no one really cares if you know what it is <br>" +
          "called. You're also not entirely sure if Vulcans can look nervous<br>" +
          "or not, but he seems to be showing definite signs of concern. The<br>" +
          "Captain is here. He is sitting in his chair, looking distracted.</html>";
      panel_RoomText_Label.setText(introText);
      
   }
   
   public void start()
   {


   // Initialization

      button1.setText(theShip.getRoomOf(thePlayer).getOption1().toString());
      button1.addActionListener(this);
      button2.setText(theShip.getRoomOf(thePlayer).getOption2().toString());
      button2.addActionListener(this);
      button3.setText(theShip.getRoomOf(thePlayer).getOption3().toString());
      button3.addActionListener(this);
      button4.setText(theShip.getRoomOf(thePlayer).getOption4().toString());
      button4.addActionListener(this);
      button5.setText(theShip.getRoomOf(thePlayer).getOption5().toString());
      button5.addActionListener(this);
   
  
   // Continuously updated
      gameRunning = true;

      // some useful global game things.

      boolean BonesInTenFor=true;
      boolean BoxFixed=false;
 
      while (gameRunning)
      {
         
         System.out.print("");//I get a really weird error if I don't put this here...

         // check if the user is in the ready room, and if they have the Glass
         // if they do, change option 5 to putting the glass on the table.
         if (theShip.getReadyRoom()==(theShip.getRoomOf(thePlayer)))
         {
            boolean hasGlass = false;
            for(Item item : thePlayer.getInventory())
            {
               if(item.equals(new Item("Dirty Glass")))
               {
                  hasGlass=true;
               }
            }
            if (hasGlass)
            {
               String readyRoomOption5a = "You place the dirty glass on the desk. Immediately a<br>" +
                    "small cleaning robot bursts through a panel you hadn't noticed in<br>" +
                    "the wall and comes hurtling itself across the room. It picks<br>" +
                    "up the glass and barrels its way towards another panel on the<br>" +
                    "other side of the room. It bumps into a collectable copy of the<br>" +
                    "Hitchhikers Guide to the Galaxy and topples over.  It gets up, <br>" +
                    "shakes its robotic head and then disappears into the hole in the<br>" +
                    "wall. You notice a small screw lying on the floor where it fell.<br>" +
                    "You pick it up, and wonder what you can do with it";
       
               Option opbuf = new Option("Put Glass on desk");
               opbuf.setReplyText(readyRoomOption5a);
               opbuf.addGivenItem(new Item("Screw"));
               opbuf.addTakenItem(new Item("Dirty Glass"));
               theShip.getRoomOf(thePlayer).setOption5(opbuf);
            }else{
               Option opbuf = new Option("Ponder being the Captain");
               opbuf.setReplyText("You seem to wasting a lot of time...");
               theShip.getRoomOf(thePlayer).setOption5(opbuf);
            }
         }

         System.out.print("");//I get a really weird error if I don't put this here...

         if (theShip.getTenForward()==(theShip.getRoomOf(thePlayer)))
         {
            boolean hasTribble = false;
            for(Item item : thePlayer.getInventory())
            {
               if(item.equals(new Item("Tribble")))
               {
                  hasTribble=true;
               }
            }
            if (hasTribble)
            {
       
               Option opbuf = new Option("Give Bones Tribble");
               opbuf.setReplyText("\"This will work perfectly for my expariment!\""
				+"<br>Bones rushes off in such a hurry he leaves his"
				+"<br>glass behind. Looks noticably dirty.");
               opbuf.addGivenItem(new Item("Dirty Glass"));
               opbuf.addTakenItem(new Item("Tribble"));
               BonesInTenFor=false;
               theShip.getRoomOf(thePlayer).setOption4(opbuf);
            }else if(!BonesInTenFor){
               Option opbuf = new Option("Ponder being the Captain");
               opbuf.setReplyText("You seem to wasting a lot of time...");
               theShip.getRoomOf(thePlayer).setOption4(opbuf);
            }
         }

         System.out.print("");//I get a really weird error if I don't put this here...

         if (theShip.getEngineRoom()==(theShip.getRoomOf(thePlayer)))
         {
            boolean hasScrew = false;
            for(Item item : thePlayer.getInventory())
            {
               if(item.equals(new Item("Screw")))
               {
                  hasScrew=true;
               }
            }
            if (hasScrew)
            {
       
               Option opbuf = new Option("Fix box");
               opbuf.setReplyText("Hacky, but working.");
               opbuf.addGivenItem(new Item("Sense of accomplishment"));
               opbuf.addTakenItem(new Item("Screw"));
               BoxFixed=true;
               theShip.getRoomOf(thePlayer).setOption4(opbuf);
            }else if(BoxFixed){
               Option opbuf = new Option("Admire your work");
               opbuf.setReplyText("Ehhh... I hope someone fixes that properly.");
               theShip.getRoomOf(thePlayer).setOption4(opbuf);
            }

         }

         System.out.print("");//I get a really weird error if I don't put this here...

         if (theShip.getTransporterRoom()==(theShip.getRoomOf(thePlayer)))
         {
            if (BoxFixed)
            {
       
               Option opbuf = new Option("Push the button");
               opbuf.setReplyText("Huh? I think it beamed some Tea up.");
               opbuf.addGivenItem(new Item("Cup of Tea"));
               theShip.getRoomOf(thePlayer).setOption4(opbuf);
            }

         }

         System.out.print("");//I get a really weird error if I don't put this here...

         if (theShip.getBridge()==(theShip.getRoomOf(thePlayer)))
         {
            if (BoxFixed)
            {
               String text =("The captain takes a sip of the tea. His eyes<br>"
			+"light up. He shouts a string of command that <br>"
			+"you don't particularly follow, and soon everyone<br>"
			+"on the bridge is cheering! You suppose this means<br>"
			+"that klingons will not be killing everyone on board.<br>"
			+"<br>This also means that you have won the game!!!"
			);
       
               Option opbuf = new Option("Give captain Tea");
               opbuf.setReplyText(text);
               opbuf.addTakenItem(new Item("Cup of Tea"));
               theShip.getRoomOf(thePlayer).setOption4(opbuf);
            }
         }


      //end of while loop!
      }


         
      // although neat, we might never use a switch case thing.
         switch (currentRoom) {
         case 0:
            
         break;
      default:
         break;   
      }
      
      
      
   }
   
   public void actionPerformed(ActionEvent e) 
   {

	if(e.getSource()==button1){
        	updateText(theShip.getRoomOf(thePlayer).getOption1().decide(thePlayer));
	}else if(e.getSource()==button2){
        	updateText(theShip.getRoomOf(thePlayer).getOption2().decide(thePlayer));
	}else if(e.getSource()==button3){
        	updateText(theShip.getRoomOf(thePlayer).getOption3().decide(thePlayer));
	}else if(e.getSource()==button4){
        	updateText(theShip.getRoomOf(thePlayer).getOption4().decide(thePlayer));
	}else if(e.getSource()==button5){
        	updateText(theShip.getRoomOf(thePlayer).getOption5().decide(thePlayer));
	} 

        updateOptions();
        updateInventory();
        updateMap();


   }     

   // we don't need to be updating the buttons constantly.
   // This updates the options menu
   public void updateOptions()
   {
      //update the options
      button1.setText(theShip.getRoomOf(thePlayer).getOption1().toString());
      button2.setText(theShip.getRoomOf(thePlayer).getOption2().toString());
      button3.setText(theShip.getRoomOf(thePlayer).getOption3().toString());
      button4.setText(theShip.getRoomOf(thePlayer).getOption4().toString());
      button5.setText(theShip.getRoomOf(thePlayer).getOption5().toString());
   }

   // much like  the update options mehtod,
   // this updates the inventory menu
   public void updateInventory()
   {
      int itemsIndex = thePlayer.getInventory().size();
      //update items
      int i =0;
      for (i=0;i<itemsIndex;i++)
      {
         inventory[i].setText(thePlayer.getInventory().get(i).getName()); }
      for (i++;i<9;i++)
      {
         inventory[i].setText("");
      }
   }
   
   public void updateMap()
   {
      String y="You are here";
      boolean updated = false;
      for (int i=0;i<9&&!updated;i++)
      {
         if(thePlayer.getCurrentRoom()==i)
         {
            resetMap();
            map[i].setText("<html>"+map[i].getText()+"<br/>"
               +"<font color=ff0000>"+y+"</font></html>");
            map[i].setBackground(Color.BLACK);
            updated=true;
         }
      }
         
         
   }
   
   public void resetMap()
   {
      map[0].setText("Bridge");
      map[1].setText("Ready Room");  
      map[2].setText("Hallway");
      map[3].setText("Holo Deck");
      map[4].setText("Ten Forward");
      map[5].setText("Engine Room");
      map[6].setText("TransporterRoom");
      map[7].setText("War Room");
      map[8].setText("Crew Cabins");
      for(JButton butt: map){
         butt.setBackground(Color.YELLOW);
      }
   }

   // I think it would be good to be able to update the
   //info text with a general method.
   public void updateText(String newText)
   {
      panel_RoomText_Label.setText(newText);
   }


}

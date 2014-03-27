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
   private JLabel panel_RoomText_Label;
   private JPanel panel_GameIcon;
   private JPanel panel_Options;
   private JPanel panel_Items;
   private JPanel panel_Inventory;
   private JLabel label_Items;
   
   private JButton button1;
   private JButton button2;
   private JButton button3;
   private JButton button4;
   private JButton button5;
   private JButton[] inventory;//create buttons to display inventory
   
   private Player thePlayer;
   private Ship theShip;
   
   
   //no args constructor
   public TextAdventure()
   {
      //Create GUI
      
      //create JPanels
      panel = new JPanel(new GridLayout(2,2,5,5));
      panel_RoomText = new JPanel();
      panel_GameIcon = new JPanel();
      panel_Options = new JPanel(new GridLayout(5,1));
      panel_Items = new JPanel();
      panel_Items.setLayout(new BorderLayout());
      
      panel_Inventory= new JPanel(new GridLayout(3,3,5,5)); 
      label_Items = new JLabel("Inventory");
      panel_Items.add(label_Items,BorderLayout.NORTH);
      panel_Items.add(panel_Inventory,BorderLayout.CENTER);
      
      //colour
      panel.setBackground(Color.pink);
      panel_RoomText.setBackground(Color.pink);
      panel_GameIcon.setBackground(Color.pink);
      panel_Options.setBackground(Color.pink);
      panel_Items.setBackground(Color.pink);
      panel_Inventory.setBackground(Color.pink);
            
      //add the panels
      add(panel);
      panel.add(panel_RoomText);
      panel.add(panel_GameIcon);
      panel.add(panel_Options);
      panel.add(panel_Items);
      
      //add Game icon
      ImageIcon gameIcon = new ImageIcon("ensignRickyIcon.png");
      JButton gIcon = new JButton();
      gIcon.setBorder(BorderFactory.createEmptyBorder());
      gIcon.setIcon(gameIcon);
      panel_GameIcon.add(gIcon);
            
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
 
      while (gameRunning)
      {
         
	
         // check if the user is in the ready room, and if they have the Glass
         // if they do, change option 5 to putting the glass on the table.
         System.out.print("");//I get a really weird error if I don't put this here...
         if (theShip.getReadyRoom()==(theShip.getRoomOf(thePlayer)))
         {
            boolean hasGlass = false;
            for(Item item : thePlayer.getInventory())
            {
               if(item.equals(new Item("Glass")))
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
               opbuf.addTakenItem(new Item("Glass"));
               theShip.getRoomOf(thePlayer).setOption5(opbuf);
            }else{
               Option opbuf = new Option("Ponder being the Captain");
               opbuf.setReplyText("You seem to wasting a lot of time...");
               theShip.getRoomOf(thePlayer).setOption5(opbuf);
            }
         }


         
      // although neat, we might never use a switch case thing.
         switch (currentRoom) {
         case 0:
            
         break;
      default:
         break;   
      }
      
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

   // I think it would be good to be able to update the
   //info text with a general method.
   public void updateText(String newText)
   {
      panel_RoomText_Label.setText(newText);
   }


}

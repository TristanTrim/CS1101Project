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
   private JLabel panel_Items_Label;
   
   private JButton button1;
   private JButton button2;
   private JButton button3;
   private JButton button4;
   private JButton button5;
   
   private Player thePlayer;
   private Ship theShip;
   
   //no args constructor
   public TextAdventure()
   {
      //Create GUI
      
      //create JPanels
      panel = new JPanel(new GridLayout(2,2));
      panel_RoomText = new JPanel();
      panel_GameIcon = new JPanel();
      panel_Options = new JPanel(new GridLayout(5,1));
      panel_Items = new JPanel();
      panel_Items_Label = new JLabel();
      panel_Items.add(panel_Items_Label);
      setBackground(Color.pink);
      
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
           
      //create Player
      thePlayer = new Player();
      
      //create Ship
      theShip = new Ship();
      panel_RoomText_Label = new JLabel(theShip.getCurrentRoom().getDescription(), SwingConstants.CENTER);
      panel_RoomText.add(panel_RoomText_Label);
      
       //create a JFrame
      setTitle("Ensign Ricky");
      setSize(900,600); //width, height
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);

      
   }
   
   public void start()
   {
      gameRunning = true;
      
      while (gameRunning)
      {
         //update the description
         panel_RoomText_Label.setText(theShip.getCurrentRoom().getDescription());
         
         //update the options
         button1.setText(theShip.getCurrentRoom().getOption1());
         button2.setText(theShip.getCurrentRoom().getOption2());
         button3.setText(theShip.getCurrentRoom().getOption3());
         button4.setText(theShip.getCurrentRoom().getOption4());
         button5.setText(theShip.getCurrentRoom().getOption5());

         //update items
         panel_Items_Label.setText(thePlayer.displayInventory());
         
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
   }     

}
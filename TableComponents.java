//Sinan Karabocuoglu & Mert Duman
//25 December 2017
//Table Components
import javax.swing.JComponent;
import java.awt.*;
import javax.swing.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class TableComponents extends JFrame
{
  Image img, img1, img2, img3, img4, img5;//images of the seats and table
  ImageIcon icon, icon1, icon2, icon3, icon4;//image icons for the images
  JButton player1, player2, player3, dealer, wallet1, wallet2,wallet3;//buttons for the players and dealer
  Deck deck1 = new Deck();//deck
  Table myTable;//table class
  int firstMoney1 = 1000;
  int firstMoney2 = 1000;
  int firstMoney3 = 1000;
  PlayerListener listener = new PlayerListener();//player1
  PlayerListener listener1 = new PlayerListener();//player2
  PlayerListener listener2 = new PlayerListener();//player3
  DealerListener listener3 = new DealerListener();//dealer
  JPanel panel = new JPanel(new GridLayout(2,3));//panel for players
  JPanel panel1 = new JPanel(new GridLayout(1,1));//panel for table
  JPanel panel2 = new JPanel(new GridLayout(1,1));//panel for dealer
  JPanel panel3 = new JPanel(new GridLayout(1,3));//panel for wallets
  public TableComponents()
  {
    deck1.shuffle();//shuffles the deck
   //******* table *********
    myTable = new Table();
    //**** loop for removing the cards that has been distributed in the first hand ****
    for(int i = 0;i<myTable.firstHand.size();i++)
    {
      for(int j = 0; j<deck1.deck.size();j++)
      {
        if(myTable.firstHand.get(i).toString().equals(deck1.deck.get(j).toString()))
        {
          deck1.deck.remove(j);
        }
      } 
    }
    //**********************************************************
   //**********************
   //******* player1 *******
   try {
        img2 = ImageIO.read(new File("seat1.png"));//gets the image of the seat
    } catch (IOException e) {//throws IO exception
    } 
    icon1 = new ImageIcon(img2);//creates an icon of the seat
    player1 = new JButton(icon1);//puts it to the button
    wallet1 = new JButton("Wallet: "+firstMoney1);
    listener.addDeck(deck1);//add the deck to the first player
    player1.addActionListener(listener);//adds the actionlistener
    listener.player.score =+myTable.card1.getValue()+myTable.card2.getValue();//gets the initial score value of the player1
    if(myTable.card1.getValue() ==11 || myTable.card2.getValue()==11)//checks if there is any aces
    {
     listener.found = true; 
    }
    //**********************
    //******* player2 *******
    try {
        img3 = ImageIO.read(new File("seat3.png"));//gets the image of the seat
    } catch (IOException e) {//throws IO exception
    }
    icon2 = new ImageIcon(img3);//creates an icon of the seat
    player2 = new JButton(icon2);//puts it to the button
    wallet2 = new JButton("Wallet: "+firstMoney2);
    listener1.addDeck(deck1);//add the deck to the second player
    player2.addActionListener(listener1);//adds the actionlistener
    listener1.player.score =+myTable.card3.getValue()+myTable.card4.getValue();//gets the initial score value of the player2
    if(myTable.card3.getValue() ==11 || myTable.card4.getValue()==11)//checks if there is any aces
    {
     listener1.found = true; 
    }
    //**********************
    //******* player3 *******
    try {
        img4 = ImageIO.read(new File("seat2.png"));//gets the image of the seat
    } catch (IOException e) {//throws IO exception
    }
    icon3 = new ImageIcon(img4);//creates an icon of the seat
    player3 = new JButton(icon3);//puts it to the button
    wallet3 = new JButton("Wallet: "+firstMoney3);
    listener2.addDeck(deck1);//add the deck to the third player
    player3.addActionListener(listener2);//adds the actionlistener
    listener2.player.score =+myTable.card5.getValue()+myTable.card6.getValue();//gets the initial score value of the player3
    if(myTable.card5.getValue() ==11 || myTable.card6.getValue()==11)//checks if there is any aces
    {
     listener2.found = true; 
    }
    //**********************
    //******* dealer *******
    try {
        img5 = ImageIO.read(new File("dealer.png"));//gets the image of the seat
    } catch (IOException e) {//throws IO exception
    }
    icon4 = new ImageIcon(img5);//creates an icon of the seat
    dealer = new JButton(icon4);//puts it to the button
    listener3.addDeck(deck1);//add the deck to the dealer 
    dealer.addActionListener(listener3);//adds the actionlistener
    listener3.player.score =+myTable.card7.getValue()+myTable.card8.getValue();//gets the initial score value of the dealer
    if(myTable.card7.getValue() ==11 || myTable.card8.getValue()==11)//checks if there is any aces
    {
     listener3.found = true; 
    }
    //**********************
    //*********** adds the buttons**********
    panel2.add(dealer);//add the button to the panel
    panel1.add(myTable);//add the button to the panel
    panel.add(player1);//add the button to the panel
    panel.add(player2);//add the button to the panel
    panel.add(player3);//add the button to the panel
    panel.add(wallet1);
    panel.add(wallet2);
    panel.add(wallet3);
    this.add(panel2,BorderLayout.NORTH);//add the panel to the frame
    this.add(panel1,BorderLayout.CENTER);//add the panel to the frame
    this.add(panel,BorderLayout.SOUTH);//add the panel to the frame
    player1.setEnabled(true);//the game starts with player1
    player2.setEnabled(false);
    player3.setEnabled(false);
    dealer.setEnabled(false);
  
  }
  
  }
//Sinan Karabocuoglu & Mert Duman
//26 December 2017
//DealerListener
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

public class DealerListener implements ActionListener
{
  JFrame frame = new JFrame();//frame that will display the blackjack game for one player
  JButton hit = new JButton("Hit");// hit button for getting a card
  JButton button;//button for deciding the player
  Deck deck;//a deck
  Hand hand = new Hand();//the hand of the dealer
  ArrayList <Integer> scores = new ArrayList<Integer>();//scores of other players
  Graphics g;
  Player player = new Player(0);//dealer as a player
  boolean found = false;//boolean for checking if player ever draw an ace
  boolean found2 = false;//boolean for ending the game
  int totalScore = 0;//the score for the player after each round played
  public void actionPerformed(ActionEvent event)
  {
    g = frame.getGraphics();//set graphics for the frame
    frame.add(hand);//adds the hand to the frame
    button = (JButton) event.getSource();//gets the source of the button
    HitListener give = new HitListener();//the action of the hit button
    hit.addActionListener(give);//adds the action listener to Hit button
    JPanel panel = new JPanel(new GridLayout(1,2));//creates a panel
    panel.add(hit);//adds the button to panel
    frame.add(panel, BorderLayout.SOUTH);//adds the panel to the end of the frame
    frame.setTitle("Dealer");//sets title
    frame.setSize(250,250);//sets the size
    frame.setLocation(400,250);//sets position
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);//set nonresizable
    frame.setVisible(true);//sets visible
  }
  public void addDeck(Deck deck1)//adds the same deck to all players
  {
    deck = deck1;
  }
  public boolean endGame()//declares the end of the game
  {
    return found2;
  }
  class HitListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
     if(player.getScore()>=17)//if the score exceeds 17
     {
     frame.setVisible(false);//closes the frame
     button.setText(button.getText()+": "+Integer.toString(player.getScore()));
     button.setEnabled(false);//disables the player
     found2 = true;//the boolean for ending the game
     }
     
     else{//if the score below 21
     Card card = deck.drawCard();//draws the card
     System.out.println(card.toString());
     if(card.getRank()==0)//if the card is an ace than the boolean turns to true
     {
       found = true;
     }
     hand.getText(card.toString());//gets the name of the card
     player.hitMe(card);//increases the score
     frame.repaint();//repaints the frame
     if(player.getScore()>=21&&found)//if the score exceeds 21 and there is an ace, the value of ace is reduced to 1
     {
      player.score = player.score-10; 
      found = false;
     }
     else if(player.getScore()>21)//if the user exceeds 21
     {
      JOptionPane.showMessageDialog(null,"Dealer bust!","BLACKJACK Go!",JOptionPane.PLAIN_MESSAGE);//shows the player bloowed up
      frame.setVisible(false);//closes the frame
      button.setText(button.getText()+": "+Integer.toString(player.getScore()));
      button.setEnabled(false);//disables the player
      found2 = true;//the boolean for ending the game
     }
     else if(player.getScore()==21)//if player reached 21
     {
      JOptionPane.showMessageDialog(null,"It is a BLACKJACK!","BLACKJACK Go!",JOptionPane.PLAIN_MESSAGE);//shows the player blackjacked
      frame.setVisible(false);//closes the frame
      button.setText(button.getText()+": "+Integer.toString(player.getScore()));
      button.setEnabled(false);//disables the player
      found2 = true;//the boolean for ending the game
     }
    }
    }
  }
}
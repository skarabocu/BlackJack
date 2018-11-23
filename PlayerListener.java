//Sinan Karabocuoglu & Mert Duman
//25 December 2017
//PlayerListener
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayerListener implements ActionListener
{
  JFrame frame = new JFrame();//frame that will display the blackjack game for one player
  JButton hit = new JButton("Hit");// hit button for getting a card
  JButton stand = new JButton("Stand On");//stand on button for ending the turn
  JButton button;//button for deciding the player
  Deck deck;//a deck
  Hand hand = new Hand();//hand of the player
  Graphics g;
  Player player = new Player(0);//player itself
  boolean found = false;//boolean for checking if player ever draw an ace
  boolean found2 = false;//boolean for ending the turn
  int totalScore = 0;//the score for the player after each round played
  public void actionPerformed(ActionEvent event)
  {
    g = frame.getGraphics();//set graphics for the frame
    frame.add(hand);//adds the hand to the frame
    button = (JButton) event.getSource();//gets the source of the button
    StandListener stop = new StandListener();//creates the action listener of stand on
    HitListener give = new HitListener();//the action of the hit button
    stand.addActionListener(stop);//adds the aciton listener to Stand On button
    hit.addActionListener(give);//adds the action listener to Hit button
    JPanel panel = new JPanel(new GridLayout(1,2));//creates a panel
    panel.add(stand);//adds the button to panel
    panel.add(hit);//adds the button to panel
    frame.add(panel, BorderLayout.SOUTH);//adds the panel to the end of the frame
    frame.setTitle("Player");//sets title
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
  public boolean endTurn()
  {
    return found2;
  }
  class StandListener implements ActionListener//action listener for Stand On button
  {
    public void actionPerformed(ActionEvent e)
    {
     frame.setVisible(false);//closes the frame
     button.setText(button.getText()+": "+Integer.toString(player.getScore()));
     button.setEnabled(false);//disables the player
     found2 = true;
    }
  }
  
  class HitListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
     if(player.getScore()>=21)//if the score exceeds 21
     {
     if(found)
     {
       player.score = player.score-10; 
      found = false;
     }
     else{
     frame.setVisible(false);//closes the frame
     button.setText(button.getText()+": "+Integer.toString(player.getScore()));
     button.setEnabled(false);//disables the player
     found2 = true;
     }
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
      JOptionPane.showMessageDialog(null,"You bust!","BLACKJACK Go!",JOptionPane.PLAIN_MESSAGE);//shows the player bloowed up
      frame.setVisible(false);//closes the frame
      button.setText(button.getText()+": "+Integer.toString(player.getScore()));
      button.setEnabled(false);//disables the player
      found2 = true;
     }
     else if(player.getScore()==21)//if player reached 21
     {
      JOptionPane.showMessageDialog(null,"It is a BLACKJACK!","BLACKJACK Go!",JOptionPane.PLAIN_MESSAGE);//shows the player blackjacked
      frame.setVisible(false);//closes the frame
      button.setText(button.getText()+": "+Integer.toString(player.getScore()));
      button.setEnabled(false);//disables the player
      found2 = true;
     }
    }
    }
    
  }
}
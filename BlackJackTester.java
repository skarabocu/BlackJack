//Sinan Karabocuoglu & Mert Duman
//25 December 2017
//BlackJack Tester
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.*;
import java.util.*;
import javax.imageio.ImageIO; 
import java.io.File; 
import java.io.IOException;
public class BlackJackTester
{
  public static void main(String [] args)
  {
    String[] buttons = { "Start","End" };// two buttons: one for countuning and one for
    int answer = JOptionPane.showOptionDialog(null,"Welcome to the BLACKJACK Go!","BLACKJACK Go!",JOptionPane.PLAIN_MESSAGE,1,null, buttons, buttons[0]);//welcoming message
    //*********Gets the user names and assign scores***********
    JPanel names = new JPanel(new GridLayout(3,2));
    JLabel label1 = new JLabel("Player 1");
    JLabel label2 = new JLabel("Player 2");
    JLabel label3 = new JLabel("Player 3");
    JTextField name1 = new JTextField();
    JTextField name2 = new JTextField();
    JTextField name3 = new JTextField();
    names.add(label1);
    names.add(name1);
    names.add(label2);
    names.add(name2);
    names.add(label3);
    names.add(name3);
    JOptionPane.showMessageDialog(null,names,"Please enter the names of the players:",JOptionPane.PLAIN_MESSAGE);
    String player1 = name1.getText();
    String player2 = name2.getText();
    String player3 = name3.getText();
    int player1Score = 0;
    int player2Score = 0;
    int player3Score = 0;
    int dealerScore = 0;
    int currentMoney1 = 1000;
    int currentMoney2 = 1000;
    int currentMoney3 = 1000;
    //****************************************
    if(answer == 0)//if the user wants to continue
    {
      while(true)
      {
    //*********Gets the bets of the players***********
    JPanel bets = new JPanel(new GridLayout(3,2));
    JLabel bet1 = new JLabel(player1+":");
    JLabel bet2 = new JLabel(player2+":");
    JLabel bet3 = new JLabel(player3+":");
    JTextField money1 = new JTextField();
    JTextField money2 = new JTextField();
    JTextField money3 = new JTextField();
    bets.add(bet1);
    bets.add(money1);
    bets.add(bet2);
    bets.add(money2);
    bets.add(bet3);
    bets.add(money3);
    JOptionPane.showMessageDialog(null,bets,"Please enter the Bets:",JOptionPane.PLAIN_MESSAGE);
    int player1Bet = Integer.parseInt(money1.getText());
    int player2Bet = Integer.parseInt(money2.getText());
    int player3Bet = Integer.parseInt(money3.getText());
    int totalBet = player1Bet+player2Bet+player3Bet;
    //****************************************
    TableComponents myFrame = new TableComponents();//creates the frame
    //***********sets new wallets money**********
    myFrame.wallet1.setText("Wallet: "+currentMoney1);
    myFrame.wallet2.setText("Wallet: "+currentMoney2);
    myFrame.wallet3.setText("Wallet: "+currentMoney3);
    //*******************************************
    //************set the texts of the buttons as the player name and bet value********
    myFrame.player1.setText(player1+"\nBet: "+player1Bet);
    myFrame.player2.setText(player2+"\nBet: "+player2Bet);
    myFrame.player3.setText(player3+"\nBet: "+player3Bet);
    //********************************************
    myFrame.dealer.setText("Dealer");
    boolean found = true;
    myFrame.setTitle("BlackJack");//sets the title
    myFrame.setSize(600,680);//sets the size
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setLocationRelativeTo(null);//sets the position
    myFrame.setResizable(false);//sets nonresizable
    myFrame.setVisible(true);//sets the frame visible 
    //************loops for changing the round of players*******
      while(true)//ending the round of player1 and starts the round of player2
    {
     boolean found2 = myFrame.listener.endTurn();//constantly checks if the dealer ended its round
     System.out.println("");//an action for turning the loop
     if(found2)
     {
       myFrame.player2.setEnabled(true);
       break;
     }
    }
    while(true)//ending the round of player2 and starts the round of player3
    {
     boolean found3 = myFrame.listener1.endTurn();//constantly checks if the dealer ended its round
     System.out.println("");//an action for turning the loop
     if(found3)
     {
       myFrame.player3.setEnabled(true);
       break;
     }
    }
    while(true)//ending the round of player3 and starts the round of dealer
    {
     boolean found4 = myFrame.listener2.endTurn();//constantly checks if the dealer ended its round
     System.out.println("");//an action for turning the loop
     if(found4)
     {
       myFrame.dealer.setEnabled(true);
       try{
       myFrame.myTable.img8 = ImageIO.read(new File("Cards/"+myFrame.myTable.card8.toString()+".png"));//opens the first card of the dealer
       } catch (IOException e) {//throws IO exception
       }
       myFrame.repaint();
       break;
     }
    }
    //**************************************************************
    //******the loop that will check wheter the game end or not*****
    while(true)
    {
     boolean found2 = myFrame.listener3.endGame();//constantly checks if the dealer ended its round
     System.out.println("");//an action for turning the loop
     if(found2)//if dealer finished his turn, then the game is finished
     {
       break;
     }
    }
    //***************************************************************     
    //******decides who wins the game********************************
    ArrayList<Integer> scores = new ArrayList<Integer>();//arraylist for the scores
    String winner = "";//the name of the winner
    int score1 =myFrame.listener.player.getScore();//gets the first score
    if(score1<=21)//checks if it is valid
    {scores.add(score1);}//adds to the list
    else{currentMoney1= currentMoney1 - player1Bet;}//decreases the money of player 1
    int score2 = myFrame.listener1.player.getScore();//gets the second score
    if(score2<=21)//checks if it is valid
    {scores.add(score2);}//adds to the list
    else{currentMoney2= currentMoney2 - player2Bet;}//decreases the money of player 2
    int score3 = myFrame.listener2.player.getScore();//gets the third score
    if(score3 <=21)//checks if it is valid
    {scores.add(score3);}//adds to the list
    else{currentMoney3= currentMoney3 - player3Bet;}//decreases the money of player 3
    int score4 = myFrame.listener3.player.getScore();//gets the fourth score
    if(score4<=21)//checks if it is valid
    {scores.add(score4);}//adds to the list
    if(scores.size()==0)//if everbody blowed up
    {
     JOptionPane.showMessageDialog(null,"Unfortunately nobody won.","BLACKJACK Go!",JOptionPane.PLAIN_MESSAGE);//shows the name of the winner 
    }
    else{//if at least one player didn't blow up 
    Collections.sort(scores);//sort the list
    //finds the winner
    if(scores.get(scores.size()-1) == score1)
    {winner = winner + " and "+ player1;
    player1Score++;
    currentMoney1 = currentMoney1 + (player1Bet*3)/2;}
    else{
      if(scores.contains(score1))
      {currentMoney1 = currentMoney1 - player1Bet;}}//decreases the money of player 1
    if(scores.get(scores.size()-1) == score2)
    {winner = winner + " and "+ player2;
    player2Score++;
    currentMoney2 = currentMoney2 + (player2Bet*3)/2;}
    else{if(scores.contains(score2))
      {currentMoney2 = currentMoney2 - player2Bet;}}//decreases the money of player 2
    if(scores.get(scores.size()-1) == score3)
    {winner = winner + " and "+ player3;
    player3Score++;
    currentMoney3 = currentMoney3 + (player3Bet*3)/2;}
    else{if(scores.contains(score3))
      {currentMoney3 = currentMoney3 - player3Bet;}}//decreases the money of player 3
    if(scores.get(scores.size()-1) == score4)
    {winner = winner+ " and "+"Dealer";
    dealerScore++;}
    JOptionPane.showMessageDialog(null,"Congratulations to "+winner.substring(5,winner.length())+"!","BLACKJACK Go!",JOptionPane.PLAIN_MESSAGE);//shows the name of the winner
    }
    //*********prepares the scoreboard************
    JPanel scoreBoard = new JPanel(new GridLayout(4,1));//scoreboard
    JLabel scoreLine1 = new JLabel(player1+": "+player1Score);
    JLabel scoreLine2 = new JLabel(player2+": "+player2Score);
    JLabel scoreLine3 = new JLabel(player3+": "+player3Score);
    JLabel scoreLine4 = new JLabel("Dealer: "+dealerScore);
    scoreBoard.add(scoreLine1);
    scoreBoard.add(scoreLine2);
    scoreBoard.add(scoreLine3);
    scoreBoard.add(scoreLine4);
    JOptionPane.showMessageDialog(null,scoreBoard,"BLACKJACK Go!",JOptionPane.PLAIN_MESSAGE);//shows the scoreboard
    //********************************************
    //*************************************************************** 
    int answer2 = JOptionPane.showOptionDialog(null,"Do you want to start a new round or and the game here?","BLACKJACK Go!",JOptionPane.PLAIN_MESSAGE,1,null, buttons, buttons[0]);//asks for another round
    if(answer2 == 1)
    {
      System.exit(0);//exits the program
    }
    else
    {
     myFrame.setVisible(false); //runs for another round
    }
    }
    }
  }
}
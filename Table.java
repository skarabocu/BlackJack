//Sinan Karabocuoglu 
//26 December 2017
//Table 
import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO; 
import java.io.File; 
import java.io.IOException;
import java.util.*;

public class Table extends JComponent
{
  //attitudes
  Deck deck = new Deck();//the deck
  Image img, img1,img2,img3,img4,img5,img6,img7,img8;//images of the first cards
  Card card1,card2,card3,card4,card5,card6,card7,card8;//first cards
  ArrayList <Card> firstHand = new ArrayList<Card>();//list of the first cards
  //cosntructer
  public Table()
  {
    deck.shuffle();//shuffles the deck
    //****** randomly distribute two cards to each player and the dealer
    card1 = deck.drawCard();
    firstHand.add(card1);//adds the card to the arraylist
    card2 = deck.drawCard();
    firstHand.add(card2);//adds the card to the arraylist
    card3 = deck.drawCard();
    firstHand.add(card3);//adds the card to the arraylist
    card4 = deck.drawCard();
    firstHand.add(card4);//adds the card to the arraylist
    card5 = deck.drawCard();
    firstHand.add(card5);//adds the card to the arraylist
    card6 = deck.drawCard();
    firstHand.add(card6);//adds the card to the arraylist
    card7 = deck.drawCard();
    firstHand.add(card7);//adds the card to the arraylist
    card8 = deck.drawCard();
    firstHand.add(card8);//adds the card to the arraylist
    //****************************
    //****** puts the table to the middle and assign images to cards********
    try {
        img = ImageIO.read(new File("green.jpeg"));
        img1 = ImageIO.read(new File("Cards/"+card1.toString()+".png"));
        img2 = ImageIO.read(new File("Cards/"+card2.toString()+".png"));
        img3 = ImageIO.read(new File("Cards/"+card3.toString()+".png"));
        img4 = ImageIO.read(new File("Cards/"+card4.toString()+".png"));
        img5 = ImageIO.read(new File("Cards/"+card5.toString()+".png"));
        img6 = ImageIO.read(new File("Cards/"+card6.toString()+".png"));
        img7 = ImageIO.read(new File("Cards/"+card7.toString()+".png"));
        img8 = ImageIO.read(new File("Cards/backface.jpg"));
    } catch (IOException e) {//throws IO exception
    }
  }
  public void paintComponent(Graphics g)
  {
    Graphics2D g2 = (Graphics2D) g;
    
    g2.drawImage(img,0,0,this);
    //**************************
    //*****puts the cards on the table*******
    g2.drawImage(img1,30,250,this);
    g2.drawImage(img2,70,250,this);
    g2.drawImage(img3,250,250,this);
    g2.drawImage(img4,290,250,this);
    g2.drawImage(img5,470,250,this);
    g2.drawImage(img6,510,250,this);
    g2.drawImage(img8,250,20,this);
    g2.drawImage(img7,290,20,this);
    //***************************************
    
  }
}


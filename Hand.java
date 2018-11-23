//Sinan Karabocuoglu 
//25 December 2017 
//Hand 
import java.awt.*; 
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO; 
import java.io.File; 
import java.io.IOException;  
public class Hand extends JComponent 
{   
  int xpos;//initial x coordinate of card for display   
  int ypos;//initial y coordinate of card for display     
  Image img , img2;   
  ArrayList <String> cards = new ArrayList<String>();
  public void paintComponent(Graphics g)   
  {    
   xpos = 30;     
   ypos = 30;     
   Graphics2D g2 = (Graphics2D) g;//creates the paint brush as g2
   try {       
       img2 = ImageIO.read(new File("green1.jpeg"));
     } catch (IOException e) {//throws IO exception   
    } 
     g2.drawImage(img2,0,0,this);//draws the background
   for(int i = 0;i< cards.size();i++) //loop for drawing all the cards that had been drawn    
   {    
     try {       
       img = ImageIO.read(new File("Cards/"+cards.get(i)+".png"));//gets the image of the card
     } catch (IOException e) {//throws IO exception   
    } 
     g2.drawImage(img,xpos,ypos,this); //draws the image 
     xpos =+70;  //xpos is increased
   }   
  }     
  public void getText(String text)   
  {     
    cards.add(text);//adds the card to the hand  
  } } 
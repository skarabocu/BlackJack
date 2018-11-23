//Sinan Karabocuoglu
//25 December 2017
//Player

public class Player
{
  //attitudes
  int score;
  int money;
  //cosntructer
  public Player(int sum)
  {
    score = sum;
    money = 1000;
  }
  
  public void hitMe(Card card)//method for increasing the score
  {
   score = score + card.getValue(); 
  }
  public int getScore()//method for getting the score
  {
    return score;
  }
  public int getMoney()
  {
    return money;
  }
}
  
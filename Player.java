import java.util.ArrayList;

class Player {
  private int numEggs;
  private ArrayList<Egg> basket;

  Player() {
    basket = new ArrayList<Egg>();
    numEggs = basket.size();
  }
  
  int getNumEggs() { return numEggs; }
  ArrayList<Egg> getBasket() { return basket; }

  void foundEgg(Egg egg) {
    basket.add(egg);
    numEggs = basket.size();
  }

  void printBasket() {
    for (Egg egg : basket) {
      egg.printEgg();
    }
  }
}
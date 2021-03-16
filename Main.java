import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Main {
  private static ArrayList<Player> players = new ArrayList<Player>();

  private static void hunt() {
    Random random = new Random();
    for (Player player : players) {
      int numEggs = random.nextInt(11);
      for (int i = 0; i < numEggs; i++)
      player.foundEgg(new Egg());
    }
  }

  private static void recap() {
    for (int i = 0; i < players.size(); i ++) {
      System.out.printf("Player %d found %d eggs%n", i , players.get(i).getNumEggs());
      players.get(i).printBasket();
      System.out.println();
    }
    System.out.println();
  }

  private static void stats() {
    int idxMost = 0;
    int mostEggs = players.get(idxMost).getNumEggs();
    int playersSize = players.size();
    if (playersSize > 1) {
      for (int i = 1; i < playersSize; i ++) {
        int numEggs = players.get(i).getNumEggs();
        if (numEggs > mostEggs) {
          idxMost = i;
          mostEggs = numEggs;
        }
      }
    }
    System.out.printf("Player %d found the most eggs, with %d eggs!%n%n%n", idxMost, mostEggs);

    int totalEggs = 0;
    int colorCount[] = { 0, 0, 0, 0};
    for (Player player : players) {
      for (Egg egg : player.getBasket()) {
        totalEggs++;
        if(egg.getColor() == Color.blue)
        colorCount[0]++;
        if(egg.getColor() == Color.pink)
        colorCount[1]++;
        if(egg.getColor() == Color.yellow)
        colorCount[2]++;
        if(egg.getColor() == Color.green)
        colorCount[3]++;
      }
    }
    System.out.printf("Total eggs found %d%n", totalEggs);
    System.out.printf("Blue eggs: %d%n", colorCount[0]);
    System.out.printf("Pink eggs: %d%n", colorCount[1]);
    System.out.printf("Yellow eggs: %d%n", colorCount[2]);
    System.out.printf("Green eggs: %d%n", colorCount[3]);
  }

  public static void main(String[] args) {
    //Get Number of players
    Scanner scanner = new Scanner(System.in);
    int numPlayers;
    System.out.print("How many players are in this Easter egg hunt? ");
    do {
      System.out.print("Enter a positive whole number: ");
      while (!scanner.hasNextInt()) {
        System.out.print("Enter a positive whole number: ");
        scanner.next();
      }
      numPlayers = scanner.nextInt();
    } while (numPlayers <= 0);
    scanner.close();

    //Create Roster of Players
    for (int i = 0; i < numPlayers; i++)
    players.add(new Player());
    System.out.printf("We have added %d players to this hunt. Let's find some eggs !%n%n", players.size());

    hunt();
    recap();
    stats();

  }
}
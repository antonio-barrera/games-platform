import data.IPlayerCRUD;
import data.PlayerCRUD;
import game.Game;
import game.hangman.Hangman;
import game.tictactoe.TicTacToe;
import player.Human;
import player.IA;
import player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GamesPlatform {
    private final Scanner sn;
    private Game game;
    private Player player1;
    private Player player2;
    private final IPlayerCRUD players;
    private final int NUMBER_OF_PLAYERS = 10;

    public GamesPlatform() {
        sn = new Scanner(System.in);
        players = new PlayerCRUD(NUMBER_OF_PLAYERS);
        players.create(new IA("Bot1"));
        players.create(new IA("Bot2"));
    }

    public void run() {
        boolean exit = false;
        int option;
        System.out.println("\nWelcome to the game platform!");
        while (!exit) {
            displayGameMenu();
            try {
                System.out.println("Choose an option: ");
                option = sn.nextInt();
                sn.nextLine();
                switch (option) {
                    case 1: playersManagement(); break;
                    case 2: showPlayersStatistics(); break;
                    case 3: listPlayers(); executeGame("TICTACTOE"); break;
                    case 4: listPlayers(); executeGame("HANGMAN"); break;
                    case 5: exit = true; break;
                    default: System.out.println("Must be a number between 1 and 5"); break;
                }
            } catch (InputMismatchException e) {
                System.out.println("You have to enter a number.");
                sn.next();
            }
        }
        System.out.println("***************************\n");
        System.out.println("Thanks for playing!");
    }

    private void playersManagement() {
        boolean exit = false;
        int option;
        while (!exit) {
            displayPlayersMenu();
            try {
                System.out.println("Choose an option: ");
                option = sn.nextInt();
                sn.nextLine();
                switch (option) {
                    case 1: createPlayer(); break;
                    case 2: listPlayers(); selectPlayer(); break;
                    case 3: listPlayers(); modifyPlayer(); break;
                    case 4: listPlayers(); deletePlayer(); break;
                    case 5: listPlayers(); break;
                    case 6: exit = true; break;
                    default: System.out.println("Must be a number between 1 and 6"); break;
                }
                System.out.println("------------------");
            } catch (InputMismatchException e) {
                System.out.println("You have to enter a number.");
                sn.next();
            }
        }
    }

    private void displayGameMenu() {
        System.out.println("\n***************************");
        System.out.println("1. Manage Players");
        System.out.println("2. Players Statistics");
        System.out.println("3. Play TicTacToe");
        System.out.println("4. Play Hangman");
        System.out.println("5. Exit");
    }

    private void displayPlayersMenu() {
        System.out.println("\n------------------");
        System.out.println("1. Create Player");
        System.out.println("2. Select Player");
        System.out.println("3. Modify Player");
        System.out.println("4. Delete Player");
        System.out.println("5. List Players");
        System.out.println("6. Exit");
    }

    private void executeGame(String gameName) {
        player1 = selectPlayer();
        player2 = selectPlayer();
        if (gameName.equals("TICTACTOE")) game = new TicTacToe(player1, player2);
        else if (gameName.equals("HANGMAN")) game = new Hangman(player1, player2);
        else return;
        game.playRound();
        game.printResult();
    }

    private void createPlayer() {
        Player player = null;
        System.out.println("Enter the new player's name: ");
        String name = sn.nextLine();
        System.out.println("Enter the of player you want to create <1>Human <2>IA: ");
        int type = sn.nextInt();
        if (type == 1) player = new Human(name);
        else if (type == 2) player = new IA(name);
        player = players.create(player);
        if (player != null) System.out.println("Created: " + player.getName());
        else System.out.println("The players list is full.");
    }

    private Player selectPlayer() {
        Player player;
        System.out.println("Enter the player's id: ");
        int id = sn.nextInt();
        sn.nextLine();
        player = players.select(id);
        if (player == null) System.out.println("Player not found!");
        else System.out.println("Selected: " + player.getName());
        return player;
    }

    private void modifyPlayer() {
        Player player = selectPlayer();
        if (player == null) return;
        System.out.println("Enter the new name: ");
        String oldName = player.getName();
        String newName = sn.nextLine();
        player.setName(newName);
        player = players.update(player);
        System.out.println("Modified: Old = " + oldName + " - New = " + player.getName());
    }

    private void deletePlayer() {
        Player player = selectPlayer();
        if (player == null) return;
        players.delete(player);
    }

    private void listPlayers() {
        System.out.println("\n+++++++++++++++++");
        System.out.println("List of players: ");
        Player[] listOfPlayers = players.selectAll();
        for (int i = 0; i < listOfPlayers.length; i++)
            if (listOfPlayers[i] != null)
                System.out.println(listOfPlayers[i].getId() + ". " + listOfPlayers[i].getName());
        System.out.println("+++++++++++++++++\n");
    }

    private void showPlayersStatistics() {
        Player[] sortedPlayers = sortPlayers(players.selectAll());
        System.out.println("\n+++++++++++++++++++++");
        System.out.println("Players' Statistics: ");
        for (int i = 0; i < sortedPlayers.length; i++)
            if (sortedPlayers[i] != null)
                System.out.println((i + 1) + ". " + sortedPlayers[i]);
        System.out.println("+++++++++++++++++++++\n");
    }

    public static Player[] sortPlayers(Player[] players) {
        int i, j;
        Player aux;
        Player[] sortedPlayers = players;
        for (i = 0; i < sortedPlayers.length - 1; i++) {
            for (j = 0; j < sortedPlayers.length - i - 1; j++) {
                if (sortedPlayers[j + 1].getWinnings() > sortedPlayers[j].getWinnings()) {
                    aux = sortedPlayers[j + 1];
                    sortedPlayers[j + 1] = sortedPlayers[j];
                    sortedPlayers[j] = aux;
                }
            }
        }
        return sortedPlayers;
    }

}

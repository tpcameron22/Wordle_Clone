import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static int continu = 0;
    static boolean winner = false;
    String SYMBOL_BLANK = " ";
   //static int guess_count = 0;
   String[][] board_array = new String[6][5];

   //Random correct guess
   //static String correct_guess = " ";

    static ArrayList<String> word_library = new ArrayList<String>(
            Arrays.asList("geeks", "creek", "apple", "elect", "abuse", "which", "there", "their", "about", "would", "these", "other", "words", "could", "write", "first", "water", "after", "where", "right", "think", "three", "years", "place", "sound", "great", "again", "still", "every", "small", "found", "those", "never", "under", "might", "while", "house", "world", "below", "asked", "going", "large", "until", "along", "shall", "being", "often", "quite", "class", "bring", "round", "horse", "shows","piece", "stand", "birds", "start", "river", "tried", "least", "field", "whose", "girls", "leave", "added", "color", "third", "hours", "moved", "plant", "doing", "names", "forms", "heavy", "ideas"));

    static Random r = new Random();
    static int random_item = r.nextInt(word_library.size());
   static String correct_guess = word_library.get(random_item);

    public String toString(String[][] board){
        String FString = "";
        FString += "   WORDLE  " + "\n ";
        for(int i = 0; i < board.length ; i++) {
            FString += "\n" + "----+---+---+---+----" + "\n";
            FString += "| ";
            for (int j = 0; j < 5; j++) {
                FString += board[i][j];
                FString += " | ";
            }
        }
        return FString;
    }

        public static void main(String[] args) {
            //make board
            Game first_game;
            first_game = new Game();

            //guess counter
            int count = 0;
            Scanner scan = new Scanner(System.in);
            System.out.println("Welcome to the wordle clone made by Thomas Cameron 6/7/22 ");
            //System.out.println("how many guesses would you like?");
            //int gc = scan.nextInt();
            //guess_count = gc - 1;

            String[][] Board = first_game.Make_Board();
            System.out.println(first_game.toString(Board));


    while(count < 6 && continu == 0) {
        int number = count + 1;
// ask for input of word
        while(true) {
            System.out.println("enter guess " + number);
            String guess = scan.nextLine();
        if(guess.length() == 5) { //and it is contained in word list

            Board = first_game.Fill_Board(guess, count);
            if(guess.equals(first_game.correct_guess)){
                continu = 1;
                winner = true;
            }
            break;
        }
        else System.out.println("Invalid Guess");

        }

        String print_board = first_game.toString(Board);
        System.out.println(print_board);
        System.out.println(first_game.keyboard);
        count++;

    }
            if (winner == true){
                System.out.println("You guessed the correct word " + correct_guess + " in "+ count + " guesses!");
            }
            else System.out.println("you lost, the correct word was " + correct_guess);

        }
    }

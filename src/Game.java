import java.util.ArrayList;
import java.util.Arrays;

public class Game extends Main{
        public Game(){
        }
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    ArrayList<String> keyboard = new ArrayList<>(
            Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p","q", "r","s","t","u","v","w","x","y","z")
    );
    public String[][] Make_Board() {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    board_array[i][j] = SYMBOL_BLANK;
                }
            }
            return board_array;
        }
        public String[][] Fill_Board(String word, int count) {
            //add words to board
            int correct = 0;
            for (int i = 0; i < 5; i++) {
                String letter = Character.toString(word.charAt(i));
                if(keyboard.contains(letter)) {
                    keyboard.remove(letter);
                }
                String correct_guess_letter = Character.toString(correct_guess.charAt(i));
                if (letter.equals(correct_guess_letter)){
                    letter = ANSI_GREEN + letter + ANSI_RESET;
                }

                else if (correct_guess.contains(letter)){
                    letter = ANSI_YELLOW + letter + ANSI_RESET;
                }
                board_array[count][i] = letter;
            }
            return board_array;
        }



}

package arraysandhashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {


    public static boolean isValidSudokuBitwise(char[][] board) {

        // These will work as 'sets' to keep track of whether or not we've seen an element.
        int[] cols = new int[board.length];
        int[] rows = new int[board.length];
        int[] grids = new int[board.length];



        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char theChar = board[i][j];

                if (theChar == '.') continue;
                int gs = (i / 3) * 3 + (j / 3);

                int el = theChar - '0';
                int mask = 0x1 << el;


                // I messed up here at first by comparing the masked output with '1' rather than checking to see
                if ((rows[i] & mask) > 0 || (cols[j] & mask) > 0 || (grids[gs] & mask) > 0 ) {
                    return false;
                }

                // Set the bit that is n elements to the left + 1 to having been seen.
                rows[i] |= mask;
                cols[j] |= mask;
                grids[gs] |= mask;

            }
        }

        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new Set[board.length];
        Set<Character>[] cols = new Set[board.length];
        Set<Character>[] grids = new Set[board.length];

        for (int i = 0; i < board.length; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            grids[i] = new HashSet<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char theChar = board[i][j];

                if (theChar == '.') continue;
                int gs = (i / 3) * 3 + (j / 3); // Flatten the 2d array

                if (rows[i].contains(theChar) || cols[j].contains(theChar) || grids[gs].contains(theChar)) {
                    return false;
                }

                rows[i].add(theChar);
                cols[j].add(theChar);
                grids[gs].add(theChar);

            }
        }

        return true;
    }


    public static void main(String[] args) {
       char[][] board =  {
        {'1','2','.','.','3','.','.','.','.'},
        {'4','.','.','5','.','.','.','.','.'},
        {'.','9','8','.','.','.','.','.','3'},
        {'5','.','.','.','6','.','.','.','4'},
        {'.','.','.','8','.','3','.','.','5'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','.','.','.','.','.','2','.','.'},
        {'.','.','.','4','1','9','.','.','8'},
        {'.','.','.','.','8','.','.','7','9'} };


       System.out.println(isValidSudokuBitwise(board));
    }
}

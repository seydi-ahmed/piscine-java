import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // Initialize sets for rows, columns, and sub-boxes
        Set<String> seen = new HashSet<>();
        
        // Iterate through each cell in the 9x9 board
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];
                
                if (num != '.') {
                    // Create unique keys for rows, columns, and sub-boxes
                    String rowKey = "row" + row + num;
                    String colKey = "col" + col + num;
                    String boxKey = "box" + (row / 3) + (col / 3) + num;
                    
                    // Check if the current number has been seen before
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false; // Duplicate found
                    }
                }
            }
        }
        
        return true; // All checks passed
    }
}

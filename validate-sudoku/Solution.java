
import java.util.HashSet;

//Time complexity: It is O(n^2) since we need to itterate over all rows and all columns of the sudoku,
//where n is the number of rows and given it is a square.
//Space complexity: It is O(n) since we for the row and col check, we need a HashSet of size 9 or "n" if we
//want to make the game bigger, and same for the square since we only track one "square game" at a time.
class Solution {
    public boolean isValidSudoku(char[][] board) {

        //Rows
        for(int row = 0; row<board.length; row++){
            HashSet<Character> rowSet = new HashSet<>();

            for(int col=0; col<board.length; col++){
                if(board[row][col] == '.'){
                    continue;
                }
                char num = board[row][col];
                if(rowSet.contains(num)){
                    return false;
                }

                rowSet.add(num);
            }
        }

        //Cols
        for(int row = 0; row<board.length; row++){
            HashSet<Character> colSet = new HashSet<>();

            for(int col=0; col<board.length; col++){
                if(board[col][row] == '.'){
                    continue;
                }
                char num = board[col][row];

                if(colSet.contains(num)){
                    return false;
                }

                colSet.add(num);
            }
        }

        //Square
        int[][] start = new int[][]{
            {0,0},
            {0,3},
            {0,6},
            {3,0},
            {3,3},
            {3,6},
            {6,0},
            {6,3},
            {6,6},
        };

        for(int i=0; i<start.length; i++){
            HashSet<Character> square = new HashSet<>();
            for(int row = start[i][0]; row< start[i][0]+3; row++){
                for(int col = start[i][1]; col<start[i][1]+3; col++){
                    if(board[row][col] == '.'){
                        continue;
                    }
                    if(square.contains(board[row][col])){
                        return false;
                    }
                    square.add(board[row][col]);
                }
            }
        }

        return true;
    }
}

// //Time complexity: It is O(n^2) since we need to itterate over all rows and all columns of the sudoku,
// //where n is the number of rows and given it is a square.
// //Space complexity: It is O(n^2) since we need a 3d array to track which numbers have already been
// //used in each sudoku box.
// //This solution can be improved...
// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         boolean[][] column = new boolean[board.length][board.length];

//         int blockSize = board.length/3;
//         boolean[][][] sudoku = new boolean[blockSize][blockSize][9];

//         for(int i=0; i < board.length; i++){
//             boolean[] row = new boolean[board.length];
//             for(int j=0; j<board.length; j++){
//                 if(board[i][j] == '.'){
//                     continue;
//                 }

//                 int iLevel = (i/blockSize);
//                 int jLevel = (j/blockSize);

//                 int num = Character.getNumericValue(board[i][j])-1;

//                 if(row[num]|| column[j][num] || sudoku[iLevel][jLevel][num]){
//                     return false;
//                 }
                
//                 row[num] = true;
//                 column[j][num] = true;
//                 sudoku[iLevel][jLevel][num] = true;
//             }
//         }
//         return true;
//     }
// }

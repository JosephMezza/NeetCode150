//Time complexity: It is O(n^2) since we need to itterate over all rows and all columns of the sudoku,
//where n is the number of rows and given it is a square.
//Space complexity: It is O(n^2) since we need a 3d array to track which numbers have already been
//used in each sudoku box.
//This solution can be improved...
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] column = new boolean[board.length][board.length];

        int blockSize = board.length/3;
        boolean[][][] sudoku = new boolean[blockSize][blockSize][9];

        for(int i=0; i < board.length; i++){
            boolean[] row = new boolean[board.length];
            for(int j=0; j<board.length; j++){
                if(board[i][j] == '.'){
                    continue;
                }

                int iLevel = (i/blockSize);
                int jLevel = (j/blockSize);

                int num = Character.getNumericValue(board[i][j])-1;

                if(row[num]|| column[j][num] || sudoku[iLevel][jLevel][num]){
                    return false;
                }
                
                row[num] = true;
                column[j][num] = true;
                sudoku[iLevel][jLevel][num] = true;
            }
        }
        return true;
    }
}

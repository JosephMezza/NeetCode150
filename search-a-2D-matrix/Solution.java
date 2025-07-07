//Cleaned up solution. Instead of checking if the number can be somewhere in the row, check the beggining and end and then else, it's in the middle.
//This also allows us to handle the case of: target = 25 , arrays: [10 20] [30 40]. In this case the targetRow will stay null and we return earlier.
//Note: Once again both loops need to run <= because we need to check the case where (start, end) and (left, right) land on the same index because we need
//to check that index against the conditions or else we're never checking it! The mid will be calculated back to that same index and it will finally be checked.
//Time complexity: O(log(m*n)) because first we binary search for the correct row log(m), then we binary search if the row has the number log(n). So, log(m) + log(n) = log(m*n).
//Space complexity: O(1) everything is done in-memory except for the integers that are needed.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length-1;
        int[] targetRow = null;

        while(start<=end){
            int mid = (start + end)/2;
            
            int[] row = matrix[mid];
            
            if(target < row[0]){
                end = mid - 1;
            }
            else if(target > row[row.length-1]){
                start = mid + 1;
            }
            else{
                targetRow = row;
                break;
            }
        }

        if(targetRow == null){
            return false;
        }

        int left = 0;
        int right = targetRow.length-1;

        while(left <= right){
            int mid = (left + right)/2;

            if(targetRow[mid] == target){
                return true;
            }
            else if(targetRow[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return false;
    }
}

//First solution. But still good! Just needs to be cleaned up a bit. Same time and space complexity.
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int top = 0;
//         int bottom = matrix.length-1;
//         int mid = -1;

//         while(top<=bottom){
//             mid = (top + bottom)/2;

//             System.out.println(mid);

//             int[] targetRow = matrix[mid];
            
//             if(target >= matrix[mid][0] && target <= matrix[mid][targetRow.length-1]){
//                 break;
//             }
//             else if(target <= matrix[mid][targetRow.length-1]){
//                 bottom = mid - 1;
//             }
//             else{
//                 top = mid + 1;
//             }
//         }

//         int left = 0;
//         int[] targetRow = matrix[mid];
//         int right = targetRow.length-1;
//         int rowMid = -1;

//         while(left <= right){
//             rowMid = (left + right)/2;

//             if(targetRow[rowMid] == target){
//                 return true;
//             }
//             else if(targetRow[rowMid] > target){
//                 right = rowMid - 1;
//             }
//             else{
//                 left = rowMid + 1;
//             }
//         }

//         return false;
//     }
// }

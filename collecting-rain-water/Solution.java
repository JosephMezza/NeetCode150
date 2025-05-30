// //First thing that came to mind. Not optimized, 
// //Time: O(n*maxHeight) Big Oof. Horrible, the array is capped at size 1000, but the height is not! So n*maxHeight could be enormous and is much worse than n^2.
// //Space: O(1)
// class Solution {
//     public int trap(int[] height) {

//         int maxHeight = 0;
//         for(int i =0; i < height.length; i++){
//             if(maxHeight < height[i])
//             {
//                 maxHeight = height[i];
//             }
//         }

//         int totalWater = 0;
//         for (int i=1; i<=maxHeight; i++)
//         {
//             int rowWater = 0;
//             boolean leftWall = false;
//             for(int j=0; j<height.length; j++)
//             {
//                 if(i <= height[j])
//                 {
//                     if(leftWall){
//                         totalWater += rowWater;
//                     }
//                     leftWall = true;
//                     rowWater = 0;
//                 }
//                 else if(leftWall){
//                     rowWater ++;
//                 }
//             }
//         }
//         return totalWater;
//     }
// }


// //Time: O(n^2) Still bad, because we need to recompute the max height for every index.
// //Space: O(1)
// class Solution {
//     public int trap(int[] height) {
//         int totalVol = 0;
//         for(int i=1; i < height.length-1; i++)
//         {
//             int left = i-1;
//             int right = i+1;

//             int leftMaxHeight = 0;
//             int rightMaxHeight = 0;
//             while(left >= 0){
//                 if(leftMaxHeight < height[left]){
//                     leftMaxHeight = height[left];
//                 }
//                 left--;
//             }

//             while(right<height.length){
//                 if(rightMaxHeight<height[right]){
//                     rightMaxHeight = height[right];
//                 }
//                 right++;
//             }

//             int volAtIndex = Math.min(leftMaxHeight, rightMaxHeight) - height[i];

//             if(volAtIndex > 0){
//                 totalVol += volAtIndex;
//             }
//         }
//         return totalVol;
//     }
// }

// //Time: O(n) Better! Make a prefix and suffix array and store the max left and right at each index.
// //Then go through the origin array one last time and use those 2 arrays to determine the max
// //water that can be held there.
// //Space: O(n) because we need a prefix and suffix array (really O(2n) -> O(n))
// class Solution {
//     public int trap(int[] height) {
//         int totalVol = 0;

//         int[] leftHeights = new int[height.length];
//         leftHeights[0] = height[0];
//         int leftMax = leftHeights[0];

//         for(int i=1; i<height.length; i++){
//             if(leftMax<height[i]){
//                 leftMax = height[i];
//             }
//             leftHeights[i] = leftMax;
//         }

//         int[] rightHeights = new int[height.length];
//         int lastIndex = height.length-1;
//         rightHeights[lastIndex] = height[lastIndex];
//         int rightMax = rightHeights[lastIndex];

//         for(int i=lastIndex-1; i>0; i--){
//             if(rightMax<height[i]){
//                 rightMax = height[i];
//             }
//             rightHeights[i] = rightMax;
//         }

//         for(int i=1; i < height.length-1; i++)
//         {
//             int leftMaxHeight = leftHeights[i];
//             int rightMaxHeight = rightHeights[i];

//             int volAtIndex = Math.min(leftMaxHeight, rightMaxHeight) - height[i];

//             if(volAtIndex > 0){
//                 totalVol += volAtIndex;
//             }
//         }
//         return totalVol;
//     }
// }

//Optimal solution!
//Time: O(n) Go through the array using 2 pointers and move the pointers based on which one is smaller. Have a while loop with condition l<r to not overlap.
// during an itteration, if we hit left for example, then we know the MAX we will be able to capture is the leftMax because it is the smallest our of the leftMax and rightMax (bottleneck)
//Space: O(1) we have 2 ints to keep track of leftMax and rightMax and 1 int for the totalVolume (doesn't really count because it's required by the output)
class Solution {
    public int trap(int[] height) {
        int totalVol = 0;

        int leftMax = height[0];
        int rightMax = height[height.length-1];

        int left = 0;
        int right = height.length-1;

        while(left<right){
            
            if(height[left] < height[right]){
                ++left;
                leftMax = Math.max(leftMax, height[left]);
                totalVol += leftMax - height[left]; //gives 0 if it was just switched, instead of checking for <0!
            }
            else{
                --right;
                
                rightMax = Math.max(rightMax, height[right]);

                totalVol += rightMax-height[right];
            }
        }

        return totalVol;
    }
}



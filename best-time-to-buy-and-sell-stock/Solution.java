//Dynamic programming
//Time complexity: O(n)
//Space complexity: O(1)
// class Solution{
//     public int maxProfit(int[] prices){
//         int maxProfit = 0;
//         int minPrice = Integer.MAX_VALUE;

//         for(int price : prices){
//             if(price < minPrice){
//                 minPrice = price;
//             }
//             else{
//                 int profit = price - minPrice;

//                 if(profit > maxProfit){
//                     maxProfit = profit;
//                 }
//             }
//         }
//         return maxProfit;
//     }
// }

//Two pointer cleaned up
//Same complexity.
//This is a sliding window because using the example, our array is [10 1 5 6 7 1] and our windows are [10 1], [1 5], [1 5 6], [1 5 6 7], [1 5 6 7 1]
class Solution{
    public int maxProfit(int[] prices){
        int maxProfit = 0;
        int i=0;
        int j = i+1;

        while(j < prices.length){
            if(prices[i] < prices[j]){
                int profit = prices[j] - prices[i];

                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }else{
                i = j;
            }
            j++; //This happens in both cases because when we anchor i to a price we increment j and when we move i to j, we need to increment j to continue the comparisons.
        }

        return maxProfit;
    }
}


//Time complexity O(n)
//Space complexity O(1)
// class Solution {
//     public int maxProfit(int[] prices) {
//         int maxProfit = 0;
//         int i=0;

//         for(int i=0; i<prices.length-1; i++){
//             if(prices[i] >= prices[i+1]){
//                 continue;
//             }
//             else{
//                 int j = i+1;
//                 while(j < prices.length && prices[i] < prices[j]){
//                     int profit = prices[j] - prices[i];

//                     if(profit > maxProfit){
//                         maxProfit = profit;
//                     }
//                     j++;
//                 }
//                 i = j-1;
//             }
//         }

//         return maxProfit;
//     }
// }

//Brute force
//Time complexity: O(n^2)
//Space complexity: O(1)
// class Solution {
//     public int maxProfit(int[] prices) {
//         int maxProfit = 0;
//         for(int i=0; i<prices.length; i++){
//             for(int j=i+1; j < prices.length; j++){
//                 int profit = prices[j]-prices[i];

//                 if(profit > maxProfit){
//                     maxProfit=profit;
//                 }
//             }
//         }
//         return maxProfit;
//     }
// }

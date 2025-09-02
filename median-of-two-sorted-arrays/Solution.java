//Time complexity: O(log(min(m,n))) where m & n are the size of each given array. It is min(m,n) because we do a binary 
//search over the smaller array.
//Space complexity: O(1). Arrays are shallow copied and we use a few ints.
//Explanation: First, we start by finding the smaller array and setting it to A.
//To find the median, we need to partition both arrays into left and right. Now, both left partitions should make up the
//left side of the total array and both left and right paritions should be equal, except if the number is odd, then we
//include an extra number on the left side. Speaking of that, if the combine array is odd, we only take the last value of
//the left partition. If it is even, we take the last of the left and the first of the right.
//In order to correctly partition both arrays, we do a binary search over A to find the correct amound of elements needed
//from this array to partition with B correctly. This happens when Aleft <= Bright and Bleft <= Aright.
//Why only binary search over A? Well, because we know the left parition = half = (total + 1)/2.
//Why (total + 1) because for even, it will have no impact on the result since we round down the 0.5 added after division, and
//for odd, it will include an extra number on the left side of the partition (Our median!)
//Continuing, we use Amin and Amax as the min and max # of elements that can be taken from A, the are NOT indices!
//We itterate while Amin <= Amax because at that point we have explored all posibilities include 0 elements taken from A (Asize=0)
//which would result in no valid answer which is impossible for this question so we return -1
//Speaking of Asize, this is where the binary search takes place, we pick the number in between Amin & Amax and filter out
//possibilities this way by updating Amin or Amax at the end of our itteration, making this itteration log(A.size).
//If we have reached the end of either side of A or B, we will set the value to -inf or +inf so when the other array compares it will
//be guaranteed to be smaller or bigger.
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;

        if(B.length < A.length){
            int[] temp = A;
            A=B;
            B=temp;
        }

        int total = A.length + B.length;
        int half = (total + 1)/2;
        int Amin = 0;
        int Amax = A.length;

        while(Amin <= Amax){
            int Asize = (Amin + Amax)/2;
            int Bsize = half - Asize;

            int Aleft = Asize-1 >= 0 ? A[Asize-1] : Integer.MIN_VALUE;
            int Aright = Asize < A.length ? A[Asize] : Integer.MAX_VALUE;
            int Bleft = Bsize - 1 >= 0 ? B[Bsize-1] : Integer.MIN_VALUE;
            int Bright = Bsize < B.length ? B[Bsize] : Integer.MAX_VALUE;

            if(Aleft <= Bright && Bleft <= Aright){
                if(total % 2 == 0){
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright))/2.0;
                }
                else{
                    return Math.max(Aleft, Bleft);
                }
            }
            else if(Aleft > Bright){
                Amax = Asize - 1;
            }
            else{
                Amin = Asize + 1;
            }
        }

        return -1;
    }
}

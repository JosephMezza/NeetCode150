//Time complexity: This is O(n) because we use 2 pointers and traverse the array only once in worst case.
//We bring the two pointers closer together. This works by taking the remainder of target-numbers[index2] and
//then looking for that value starting from index1. If numbers[index1] is already > than the rem, that
//combination is impossible so move index2 to the left decreasing the number size. We move index1 to the right and
//index2 to the left until we find the right combination. We don't need to revisit any elements because it's sorted!
//Space complexity: This is O(1) because we initialize 3 integers and that's it. It's constant.

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length-1;

        while(true){
            int rem = target-numbers[index2];

            while(numbers[index1] < rem){
                index1++;
            }

            if(numbers[index1] == rem){
                return new int[]{index1+1, index2+1};
            }

            index2--;
        }
    }
}

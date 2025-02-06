//Time complexity: This is (1) O(n^3) *  (2) O(n^3). (1) is because we need to check every
//possible triple which is n^3, where n is the size of the array. We need to multiply this
//because we need to check for unique triples, so in the worst case, we need to itterate over
//a list that could have every triple in it at size n^3. So n^3*n^3 = O(n^6).
//VERY INNEFICCIENT. Thinking of a better solution.
//Time complexity: This is O(1) since our list is required by the function and we use
//the same one to check for duplicated so no extra memory.
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> triples = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        boolean alreadyExists = false;
                        for(List<Integer> l : triples){
                            if(l.contains(nums[i]) && l.contains(nums[j]) && l.contains(nums[k])){
                                alreadyExists = true;
                                break;
                            }
                        }
                        if(alreadyExists){
                            continue;
                        }

                        triples.add(new ArrayList<Integer>(List.of(nums[i],nums[j],nums[k])));
                    }
                }
            }
        }
        return triples;
    }
}

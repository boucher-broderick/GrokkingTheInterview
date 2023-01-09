package twoPointers;

import java.util.HashMap;

class PairWithTargetSum {
    static int[] search(int[] array, int target) {
        int end = array.length-1;
        int beg = 0;
        while(beg<end){
            if(array[beg] + array[end] == target){
                return new int[] {beg, end};
            }
            else if(array[beg] + array[end] > target){
                end--;
            }
            else{
                beg++;
            }
        }
        return new int[] {-1, -1};
    }

    static int[] searchHash(int[] array, int target) {
        HashMap<Integer, Integer> nums = new HashMap<>();
        for(int i =0; i< array.length; i++){
            if (nums.containsKey(target - array[i]))
            return new int[] { nums.get(target - array[i]), i };
          else
            nums.put(array[i], i);
        }
        return new int[] {-1, -1};
    }


    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.searchHash(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.searchHash(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}


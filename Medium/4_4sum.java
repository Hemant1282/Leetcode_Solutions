// problem :-- Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

// Example 1:

// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// Example 2:

// Input: nums = [2,2,2,2,2], target = 8
// Output: [[2,2,2,2]]

//My solution

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            // Skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {

                // Skip duplicate j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                long currTarget = (long) target - nums[i] - nums[j];

                int m = j + 1;
                int n = nums.length - 1;

                while (m < n) {

                    long sum = (long) nums[m] + nums[n];

                    if (sum == currTarget) {

                        res.add(Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[m],
                            nums[n]
                        ));

                        m++;
                        n--;

                        // Skip duplicates
                        while (m < n && nums[m] == nums[m - 1]) {
                            m++;
                        }

                        while (m < n && nums[n] == nums[n + 1]) {
                            n--;
                        }

                    } 
                    else if (sum < currTarget) {
                        m++;
                    } 
                    else {
                        n--;
                    }
                }
            }
        }

        return res;
    }
}
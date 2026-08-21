// Problem :-- You are given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
// You must solve this problem without using the library's sort function.

// Example 1:

// Input: nums = [2,0,2,1,1,0]

// Output: [0,0,1,1,2,2]

// Explanation:

// The array has two 0s, two 1s, and two 2s. Sorting them in-place places all 0s first, then all 1s, then all 2s.

// Example 2:

// Input: nums = [2,0,1]

// Output: [0,1,2]

// Explanation:

// The array has one each of 0, 1, and 2, arranged in-place in the order 0, 1, 2.

//My solution
class Solution {
    public void sortColors(int[] nums) {
        int count[] = new int[3];
        for(int i = 0;i<nums.length;i++){
            count[nums[i]]++;
        }
        int k = 0;
        for(int i = 0;i<count.length;i++){
            while(count[i]>0){
                nums[k] = i;
                k++;
                count[i]--; 
            }
        }
    }
}

//Dutch National flag Algorithm
 class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while(mid <= high){
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}
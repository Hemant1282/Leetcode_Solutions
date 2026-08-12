// Problem :-- You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.

// Example :

// Example 1:


// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
// Example 2:

// Input: height = [1,1]
// Output: 1
 

//my solution
class Solution {
    public int maxArea(int[] height) {
        int first = 0;
        int last = height.length - 1;
        int max_sum = Integer.MIN_VALUE;
        while(first < last){
            int min_height = Math.min(height[first],height[last]);
            int water_contain = min_height * (last-first);
            max_sum = Math.max(water_contain,max_sum);
            if(height[first] <= height[last]){
                first++;
            }
            else{
                last--;
            }
        }
        return max_sum;
    }
}
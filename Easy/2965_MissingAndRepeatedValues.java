// Problem :-- You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.
// Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.

// Example :-- 
// Example 1:

// Input: grid = [[1,3],[2,2]]
// Output: [2,4]
// Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].
// Example 2:

// Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
// Output: [9,5]
// Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,5].

//My solution 
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int nSquared = n * n;
        
        long expectedSum = (long) nSquared * (nSquared + 1) / 2;
        long expectedSumSquares = (long) nSquared * (nSquared + 1) * (2 * nSquared + 1) / 6;
        
        long actualSum = 0, actualSumSquares = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                actualSum += grid[i][j];
                actualSumSquares += (long) grid[i][j] * grid[i][j];
            }
        }

        // a - b
        long diffSum = actualSum - expectedSum;

        // a² - b²
        long diffSumSquares = actualSumSquares - expectedSumSquares;
        
        // a + b = (a² - b²) / (a - b)
        long sumAB = diffSumSquares / diffSum;
        
        // Now we can find a and b
        int a = (int) ((sumAB + diffSum) / 2);
        int b = (int) ((sumAB - diffSum) / 2);
        
        return new int[]{a, b};
    }
}
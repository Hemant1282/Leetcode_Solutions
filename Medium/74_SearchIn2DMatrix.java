// Problem :-- You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

// Example :-- 
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true

//My solution
//TC :-- O(m+n) where m is the number of rows and n is the number of columns
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        
        while(col >= 0 && row < (matrix.length)){
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] < target){
                row++;
            }
            else{
                col--;
            }
        }
        return false;
    }
}


//Best Solution
//TC :-- O(log(m*n)) where m is the number of rows and n is the number of columns
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        // Treat the matrix as a virtually flattened sorted array
        int low = 0;
        int high = (n * m) - 1;

        while (low <= high) {

            // Calculate the middle virtual index
            int mid = low + (high - low) / 2;

            // Convert the virtual index into row and column
            int row = mid / m;
            int col = mid % m;

            // Target found
            if (matrix[row][col] == target) {
                return true;
            }

            // Current value is smaller, so search the right half
            else if (matrix[row][col] < target) {
                low = mid + 1;
            }

            // Current value is greater, so search the left half
            else {
                high = mid - 1;
            }
        }

        return false;
    }
}
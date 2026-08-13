// Problem :-- Given an m x n matrix, return all elements of the matrix in spiral order.

// Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]

// Example 2:
// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]

//My solution
import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int first_row = 0;
        int first_col = 0;
        int last_col = matrix[0].length-1;
        int last_row = matrix.length-1;
        List<Integer> list = new ArrayList<>();
        while(first_row <= last_row && first_col <= last_col){
            for(int i = first_col;i<=last_col;i++){
                list.add(matrix[first_row][i]);
            }
            for(int i = first_row+1;i<=last_row;i++){
                list.add(matrix[i][last_col]);
            }
            for(int i = last_col-1;i>=first_col;i--){
                if(first_row == last_row){
                    break;
                }
                list.add(matrix[last_row][i]);
            }
            for(int i = last_row-1;i>first_row;i--){
                if(first_col == last_col){
                    break;
                }
                list.add(matrix[i][first_col]);
            }
            first_row++;
            first_col++;
            last_row--;
            last_col--;
        }
        return list;
    }
}
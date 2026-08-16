// Problem :-- Given an integer x, return true if x is a palindrome, and false otherwise.

// Example :--
// Example 1:

// Input: x = 121
// Output: true
// Explanation: 121 reads as 121 from left to right and from right to left.
// Example 2:

// Input: x = -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
// Example 3:

// Input: x = 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

//My solution :--
class Solution {
    public boolean isPalindrome(int x) {
        int reverse = 0;
        int num = x;
        if(x<0){
            return false;
        }
        while(x>0){
            int lastdigit = x%10;
            x = x/10;
            reverse = (reverse * 10) + lastdigit;
        }
        if(reverse == num){
            return true;
        }
        else{
            return false;
        }
    }
}
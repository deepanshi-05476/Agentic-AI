/*
LeetCode #3: Longest Substring Without Repeating Characters

Approach:
Use Sliding Window and HashSet to maintain
a substring with unique characters.
*/

import java.util.*;

class Main {

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        System.out.println("Length of longest substring = "
                + lengthOfLongestSubstring(s));
    }
}

/*

Example:
Input: "abcabcbb"

Window:
"a"   -> length = 1
"ab"  -> length = 2
"abc" -> length = 3
Duplicate 'a' found -> move left pointer

Longest substring = "abc"

Output: 3

Time Complexity: O(n)
Space Complexity: O(n)
*/

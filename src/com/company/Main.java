package com.company;
public class Main {

    // #771 Jewels and Stones
    int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i=0; i<J.length(); i++) {
            char jewel = J.charAt(i);
            for (int k=0; k<S.length(); k++) {
                char stone = S.charAt(k);
                if (jewel == stone) count++;
            }
        }
        return count;
    }

    // #1 Two Sum
    int[] twoSum(int[] nums, int target) {
        int limit = nums.length;
        for (int i=0; i<limit; i++) {
            for (int k= i+1; k<limit; k++) {
                if (nums[i] + nums[k] == target) {
                    return new int[] {i,k};
                }
            }
        }
        return new int[] {0,0};
    }

    // #7 Reverse Integer
    int reverse(int x) {

        long limit = 2147483647;
        boolean isPositive = true;
        if (x < 0) {
            isPositive = false;
            x = -x;
        }
        if (x == 0) return 0;

        String origin = String.valueOf(x);
        origin = origin.trim();
        String result = "";
        for (int i = origin.length() - 1; i >= 0; i--) {
            result = result + origin.charAt(i);
        }

        long ans = 0;
        try {
            ans = Integer.parseInt(result);
        } catch (NumberFormatException e) {
            // who cares?
        }
        if ( (isPositive && ans > limit) || (!isPositive && ans > limit+1)) ans = 0;
        if (!isPositive) ans = -ans;
        return (int)ans;
    }

    // #9 Palindrome Number
    boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int oriX = x;
        int digit = 0;
        int revX = 0;
        while (x != 0) {
            digit = x % 10;
            x = x / 10;
            revX = revX * 10 + digit;
        }
        return (revX == oriX);
    }

    // #13 Roman to Integer
    int romanToInt(String s) {
        int roman = 0;
        for (int i = 0; i < s.length() ; i++) {
            switch (s.charAt(i)) {
                case 'M': roman+=1000; break;
                case 'D': roman+=500; break;
                case 'C':
                    if ((i+1 < s.length()) && (s.charAt(i+1) == 'D')) {
                        roman+=400;
                        ++i;
                        break;
                    }
                    if ((i+1 < s.length()) && (s.charAt(i+1) == 'M')) {
                        roman+=900;
                        ++i;
                        break;
                    }
                    roman+=100;
                    break;
                case 'L': roman+=50; break;
                case 'X':
                    if ((i+1 < s.length()) && (s.charAt(i+1) == 'L')) {
                        roman+=40;
                        ++i;
                        break;
                    }
                    if ((i+1 < s.length()) && (s.charAt(i+1) == 'C')) {
                        roman+=90;
                        ++i;
                        break;
                    }
                    roman+=10;
                    break;
                case 'V': roman+=5; break;
                case 'I':
                    if ((i+1 < s.length()) && (s.charAt(i+1) == 'V')) {
                        roman+=4;
                        ++i;
                        break;
                    }
                    if ((i+1 < s.length()) && (s.charAt(i+1) == 'X')) {
                        roman+=9;
                        ++i;
                        break;
                    }
                    roman+=1;
                    break;
            }
        }
        return roman;
    }

    // #938 Range Sum of BST
    // Not full, only LeetCode required part
    int RSBans=0;
    int rangeSumBST(TreeNode root, int L, int R) {
        RSBans = 0;
        BSTRec(root, L, R);
        return RSBans;
    }

    private void BSTRec(TreeNode _node, int L, int R) {
        if (_node != null) {
            if (_node.val <= R && _node.val >= L) RSBans += _node.val;
            if (_node.val > L) BSTRec(_node.left, L, R);
            if (_node.val < R) BSTRec(_node.right, L, R);
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // #14 Longest Common Prefix
    String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String lcp = strs[0];
        for (String thisStr: strs) {
            if (thisStr.length() < lcp.length()) lcp = lcp.substring(0,thisStr.length());
            for (int i = thisStr.length(); i >= 0; i--) {
                if (thisStr.startsWith(lcp)) break;
                lcp = lcp.substring(0,lcp.length()-1);
            }
        }
        return lcp;
    }

    // Test Area
    public static void main(String[] args) {
        String[] a={"acbb","a"};
        String solution = new Main().longestCommonPrefix(a);
        System.out.println(solution);
    }

}


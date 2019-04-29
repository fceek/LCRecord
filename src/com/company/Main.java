package com.company;
public class Main {

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

    public static void main(String[] args) {
        int[] a={2,7,11,15};
        int solution = new Main().romanToInt("MCMXCIV");
        System.out.println(solution);
    }
}
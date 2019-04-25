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
            //
        }
        if ( (isPositive && ans > limit) || (!isPositive && ans > limit+1)) ans = 0;
        if (!isPositive) ans = -ans;
        return (int)ans;
    }

    public static void main(String[] args) {
        int[] a={2,7,11,15};
        int solution = new Main().reverse(2147083649);
        System.out.println(solution);
    }
}
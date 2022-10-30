package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // right page equals left page + 1
        if(!isValid(pobi.get(0), pobi.get(1)) || !isValid(crong.get(0), crong.get(1)))
            return -1; // error : return -1

        // get each maximum answer between left page and right page from pobi, crong
        int pobi_max = getMax(pobi.get(0), pobi.get(1));
        int crong_max = getMax(crong.get(0), crong.get(1));

        if(pobi_max > crong_max) return 1; // pobi > crong : return 1
        return 0; // pobi < crong : return 0
    }

    // get maximum answer between left page and right page
    private static int getMax(int a, int b) {

        // max_a : maximum answer from left page
        int max_a = add_each_num(a);
        int mul_a = mul_each_num(a);
        if(mul_a > max_a) max_a = mul_a;

        // max_b : maximum answer from right page
        int max_b = add_each_num(b);
        int mul_b = mul_each_num(b);
        if(mul_b > max_b) max_b = mul_b;

        // comparison between answer from left and answer from right
        if(max_a > mul_b) return max_a;
        return max_b;
    }

    // check if input is valid( both pobi and crong )
    private static boolean isValid(int left, int right) {
        // left page number should be odd
        if(left % 2 == 0) return false;
        // right page number should be even
        if(right % 2 == 1) return false;

        // right page should be equal to left page + 1
        if(left + 1 != right) return false;

        return true;
    }

    // add each number in pageNum
    private static int add_each_num(int a) {
        int ans = 0;
        while(a != 0) {
            ans += a % 10;
            a /= 10;
        }
        return ans;
    }

    // multiply each number in pageNum
    private static int mul_each_num(int a) {
        int ans = 1;
        while(a != 0) {
            ans *= a % 10;
            a /= 10;
        }
        return ans;
    }
}
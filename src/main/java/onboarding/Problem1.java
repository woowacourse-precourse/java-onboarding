package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int leftSc, rightSc, pobiSc, crongSc;

        // pobi
        int left = pobi.get(0);
        int right = pobi.get(1);
        if(validate(left, right) == 1) {
            leftSc = divideSeat(left);
            rightSc = divideSeat(right);
            pobiSc = whichIsBigger(leftSc, rightSc);

        } else return -1;

        // crong
        left = crong.get(0);
        right = crong.get(1);
        if(validate(left, right) == 1) {
            leftSc = divideSeat(left);
            rightSc = divideSeat(right);
            crongSc = whichIsBigger(leftSc, rightSc);

        } else return -1;

        // final
        return (pobiSc > crongSc)? 1 : (pobiSc == crongSc)?0 : -1;

    }
    public static int divideSeat(int n) {
        int x,y,z;  // 각 자리수
        x = n / 100;
        y = n / 10 % 10;
        z = n % 10;

        if(x ==0) return plusProduct(y,z);
        else return plusProduct(x,y,z);
    }

    // 더하고 곱한 것 중 최대 수
    private static int plusProduct(int y, int z) {
        int ans = Integer.MIN_VALUE;
        if(Integer.compare(y+z, y*z) == 1) ans = y+z;
        else ans = y*z;

        return ans;
    }

    private static int plusProduct(int x, int y, int z) {
        int ans = Integer.MIN_VALUE;
        if(Integer.compare(x+y+z, x*y*z) == 1) ans = x+y+z;
        else ans = x*y*z;

        return ans;
    }

    private static int whichIsBigger(int x, int y) {
        int ans = Integer.MIN_VALUE;
        if(Integer.compare(x,y) == 1) ans = x;
        else ans = y;

        return ans;
    }

    private static int validate(int left, int right){
        // unlogical [case1] - 왼쪽이 홀수가 아니거나 오른쪽이 짝수가 아닌상황
        if (left %2 == 0 || right %2 != 0) return 0;
        // [case2] 왼쪽이 오른쪽보다 큰 상황
        if (left > right) return 0;
        // [case3] 왼쪽이 오른쪽보다 작지만 2보다 큰 상황
        if (left+1 < right) return 0;
        return 1;

    }

}
package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }
    static int getBig(int x) {
        int add = 0;
        int mul = 1;
        int num = 0;
        while (x > 0) {
            num = x % 10;
            x /= 10;
            add += num;
            mul *= num;
        }
        return add > mul ? add : mul;
    }
    static int getWinner(int pobiScore, int crongScore) {
        int diff = pobiScore - crongScore;
        if (diff > 0) {
            return 1;
        } else if (diff < 0) {
            return 2;
        }
        else {
            return 0;
        }
    }
    static boolean errorHandle(int left, int right) {
        if (left < 1 || left > 400 || right < 1 || right > 400 || right - left != 1) {
            return false;
        }
        return true;
    }
//    public static void main(String[] args){
//        System.out.println(getWinner(10,1));
//    }
}


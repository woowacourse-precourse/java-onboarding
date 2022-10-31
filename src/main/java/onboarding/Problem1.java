package onboarding;

import java.util.List;

class Problem1 {
    static int add(int a) {
        int result = 0;
        while(a > 0){
            result += a%10;
            a/=10;
        }
        return result;
    }
    static int multi(int a) {
        int result = 1;
        while(a > 0){
            result *= a%10;
            a/=10;
        }
        return result;
    }
    static int checkMax(int a, int b) {
        return Math.max(a, b);
    }
    //예외처리
    static boolean except(List<Integer> a) {
        if(a.get(0)%2 == 0 || a.get(1)%2 != 0) {
            return false;
        }
        if(a.get(1)-a.get(0) != 1) {
            return false;
        }
        if(a.get(0) >= 400 || a.get(0) <= 1) {
            return false;
        }
        if(a.get(1) >= 400 || a.get(1) <= 1) {
            return false;
        }
        return true;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_max1 =checkMax(add(pobi.get(0)), multi(pobi.get(0)));
        int pobi_max2 =checkMax(add(pobi.get(1)), multi(pobi.get(1)));
        int answer1 = checkMax(pobi_max1, pobi_max2);
        int crong_max1 =checkMax(add(crong.get(0)), multi(crong.get(0)));
        int crong_max2 =checkMax(add(crong.get(1)), multi(crong.get(1)));
        int answer2 = checkMax(crong_max1, crong_max2);
        if(checkMax(answer1, answer2) == answer1) {
            answer = 1;
        }
        if(checkMax(answer1, answer2) == answer2) {
            answer = 2;
        }
        if(answer1 == answer2) {
            answer = 0;
        };
        if(!except(pobi) || !except(crong)) {
            answer =-1;
        }
        return answer;
    }
}
package onboarding;

import java.util.List;

class Problem1 {
    public static int sum_n(Integer a){
        int sum = 0;
        while(a != 0){
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }

    public static int mul_n(Integer a){
        int mul = 1;
        while(a != 0){
            mul *= a % 10;
            a /= 10;
        }
        return mul;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0) return -1;
        else if(pobi.get(1) % 2 == 1 || crong.get(1) % 2 == 1) return -1;
        else if(pobi.get(0) < 1 || pobi.get(1) > 400) return -1;
        else if(pobi.get(1) - pobi.get(0) != 1) return -1;
        else if(crong.get(0) < 1 || crong.get(1) > 400) return -1;
        else if(crong.get(1) - crong.get(0) != 1) return -1;

        int po = Math.max(Math.max(sum_n(pobi.get(0)), mul_n(pobi.get(0))), Math.max(sum_n(pobi.get(1)), mul_n(pobi.get(1))));
        int cr = Math.max(Math.max(sum_n(crong.get(0)), mul_n(crong.get(0))), Math.max(sum_n(crong.get(1)), mul_n(crong.get(1))));

        if(po > cr) answer = 1;
        else if(po < cr) answer = 2;
        else answer = 0;
        return answer;

    }
}
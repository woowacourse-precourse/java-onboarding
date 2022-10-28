package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_big=0;
        int crong_big=0;
        int result;

        // 유효성 검사
        if ((pobi.get(0) != pobi.get(1)-1)||(crong.get(0) != crong.get(1)-1)) {
            answer = -1;
            return answer;
        }
        for (int i=0;i<pobi.size();i++) {
            result = calculate(pobi.get(i));
            pobi_big = (pobi_big <= result) ? result : pobi_big;
            result = calculate(crong.get(i));
            crong_big = (crong_big <= result) ? result : crong_big;
        }
        if (pobi_big > crong_big)
            answer = 1;
        else if (pobi_big < crong_big)
            answer = 2;
        else
            answer = 0;

        return answer;
    }

    public static int calculate(int list) {
        int n = list;
        int rest;
        int plus = 0;
        int time = 1;
        while (n>0) {
            rest = n%10;
            plus += rest;
            time *= rest;
            n = n/10;
        }
        return (plus <= time)?time:plus;
    }
}
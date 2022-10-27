package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    static int addDigit(List<Integer> list) {
        int result = 0;
        for(int i=0; i<2; i++) {
            int tmp = list.get(i);
            int sum = 0;
            while(tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            result = Math.max(result,sum);
        }
        return result;
    }
    static int multyDigit(List<Integer> list) {
        int result = 0;
        for(int i=0; i<2; i++) {
            int tmp = list.get(i);
            int sum = 1;
            while(tmp > 0) {
                sum *= tmp % 10;
                tmp /= 10;
            }
            result = Math.max(result,sum);
        }
        return result;
    }

    static boolean Validation(List<Integer> list) {
        if(list.get(0) + 1 != list.get(1)) return false;
        if(list.get(0) <= 0 || list.get(1) <=0) return false;
        if(list.get(0) > 400 || list.get(1) > 400) return false;
        if(list.get(0) == null || list.get(1) == null) return false;
        return true;
    }
}
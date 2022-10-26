package onboarding;

import java.util.List;

class Problem1 {

    public int inputOfException (List<Integer> pobi,List<Integer> crong) {
        int input = 0;
        if (pobi.size() == 2 && crong.size() == 2) return -1;
        if (pobi.get(0) == 0 && crong.get(0) == 0) return -1;
        if (pobi.get(1) != pobi.get(0) + 1) return  -1;
        if (crong.get(1) != crong.get(0) + 1) return  -1;
        return input;
    }

    public int sumNumber (int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }

    public int multNumber (int i) {
        int multi = 1;
        while (i > 0) {
            multi *= i % 10;
            i /= 10;
        }
        return multi;
    }

    public int leftNum (int left) {
        return Math.max(sumNumber(left),multNumber(left));
    }

    // leftNum이랑 같은 함수지만 기능 요구 사항에 맞게 구현
    public int rightNum (int right) {
        return Math.max(sumNumber(right),multNumber(right));
    }

    public int BigNum (List<Integer> list) {
        int myScore = Math.max(leftNum(list.get(0)),rightNum(list.get(1)));
        return myScore;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 p1 = new Problem1();
        int answer = Integer.MAX_VALUE;
        if (p1.inputOfException(pobi, crong) == -1) return -1;

        return answer;
    }
}
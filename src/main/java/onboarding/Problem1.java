package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;


        return answer;
    }


    public static int adder(int value) {
        if (value / 10 == 0) {
            return value;
        } else {
            return adder(value / 10) + value % 10;
        }
    }

    public static int multiplier(int value) {
        if (value / 10 == 0) {
            return value;
        } else {
            return multiplier(value / 10) * value % 10;
        }
    }

    public static int compare(int v1, int v2) {
        int largerValue = v1 >= v2 ? v1 : v2;
        return largerValue;
    }




}
package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        List<Integer> pobiRL = new ArrayList<>(pobi);
        List<Integer> crongML = new ArrayList<>(crong);
        int answer = combiner(pobiRL, crongML);

        return answer;
    }


    public static int combiner(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (checker(pobi) == -1 || checker(crong) == -1) {
            return -1;
        }

        int pobiMax = maxFinder(pobi);
        int crongMax = maxFinder(crong);

        if (pobiMax > crongMax) {
            answer =  1;
        } else if (pobiMax < crongMax) {
            answer = 2;
        } else {
            answer =  0;
        }


        return answer;
    }
    public static int adder(int value) {
        if (value / 10 == 0) {
            return value;
        } else {
            return adder(value / 10) + (value % 10);
        }
    }

    public static int multiplier(int value) {
        if (value / 10 == 0) {
            return value;
        } else {
            return multiplier(value / 10) * (value % 10);
        }
    }

    public static int compare(int v1, int v2) {
        int largerValue = v1 >= v2 ? v1 : v2;
        return largerValue;
    }

    public static int maxFinder(List<Integer> values) {
        int valueAddMax = compare(adder(values.get(0)), adder(values.get(1)));
        int valueMultMax = compare(multiplier(values.get(0)), multiplier(values.get(1)));
        int valueMax = compare(valueAddMax, valueMultMax);
        return valueMax;
    }

    public static int checker(List<Integer> intList) {
        if (intList.get(0) <= 1 || intList.get(1) >=400) {
            return -1;
        } else if (intList.get(1) - intList.get(0) != 1) {
            return -1;
        } else if ((intList.get(0) % 2 == 0) || (intList.get(1) % 2 == 1)) {
            return -1;
        } else if (intList.contains(null)) {
            return -1;
        } else {
            return 0;
        }

    }

}
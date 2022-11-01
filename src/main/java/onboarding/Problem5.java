package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

//        String result = converter(money, 0);
//        List<Integer> answer = convertToList(result);
        List<Integer> answer = Collections.emptyList();

        return answer;
    }

    public static String converter(int value, int i) {
        if (i == 8) {
            return String.valueOf(value);
        }

        int[] measurement = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        return String.valueOf(value / measurement[i]) + converter(value % measurement[i], i + 1);

    }

    public static List<Integer> convertToList(String value) {
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < value.length(); i++) {
            Integer intValue = Integer.parseInt(String.valueOf(value.charAt(i)));
            result.add(intValue);
        }
        return result;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;
        List<Integer> numList = new ArrayList<>(number);

        for (int i = 1; i <= number; i++) {
            numList.add(i);
        }

        return numCount(numList, count);
    }

    private static int numCount(List<Integer> numList, int count) {
        for (int i = 0; i < numList.size(); i++) {
            for (int j = 0; j < String.valueOf(numList.get(i)).length(); j++) {
                if (String.valueOf(numList.get(i)).charAt(j) == '3') count++;
                if (String.valueOf(numList.get(i)).charAt(j) == '6') count++;
                if (String.valueOf(numList.get(i)).charAt(j) == '9') count++;
            }
        }

        return count;
    }
}

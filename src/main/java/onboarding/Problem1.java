package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isValidValue(pobi) || !isValidValue(crong)) {
            return -1;
        }
        if (getMax(pobi) > getMax(crong)) {
            return 1;
        } else if (getMax(pobi) < getMax(crong)) {
            return 2;
        } else if (getMax(pobi) == getMax(crong)) {
            return 0;
        }
        return -1;
    }

    public static boolean isValidValue(List<Integer> pages) {
        if (pages.get(0) + 1 != pages.get(1)) {
            return false;
        }
        else if (pages.contains(1) || pages.contains(400)) {
            return false;
        }
        return true;
    }

    public static int getMax(List<Integer> array) {
        int maxValue = 0;
        int sum;
        int mul;
        for (int num : array) {
            String str = Integer.toString(num);
            String[] strArray = str.split("");
            List<String> numList = new ArrayList<>(Arrays.asList(strArray));
            sum = 0;
            mul = 1;
            for (String n : numList) {
                sum += Integer.parseInt(n);
                mul *= Integer.parseInt(n);
            }
            if (maxValue < sum) {
                maxValue = sum;
            }
            if (maxValue < mul) {
                maxValue = mul;
            }
        }
        return maxValue;
    }
}
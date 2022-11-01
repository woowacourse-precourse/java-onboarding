package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (checkException(pobi)==false || checkException(crong)==false) {
            return -1;
        }

        List<Integer> pobi_value = new ArrayList<>();
        pobi_value.add(getSum(pobi.get(0)));
        pobi_value.add(getSum(pobi.get(1)));
        pobi_value.add(getMuliple(pobi.get(0)));
        pobi_value.add(getMuliple(pobi.get(1)));

        List<Integer> crong_value = new ArrayList<>();
        crong_value.add(getSum(crong.get(0)));
        crong_value.add(getSum(crong.get(1)));
        crong_value.add(getMuliple(crong.get(0)));
        crong_value.add(getMuliple(crong.get(1)));

        int pobi_max = Collections.max(pobi_value);
        int crong_max = Collections.max(crong_value);

        return compare(pobi_max, crong_max);
    }

    private static int compare(int pobi, int crong) {
        if (pobi == crong) {
            return 0;
        } else if (pobi > crong) {
            return 1;
        } else  {
            return 2;
        }
    }
    private static boolean checkSuccessive(List<Integer> pages) {
        if (pages.get(0) + 1 != pages.get(1)) {
            return false;
        }
        return true;
    }
    private static boolean checkEven(Integer page) {
        if (page % 2 == 1){
            return false;
        }
        return true;
    }
    private static boolean checkException(List<Integer> pages){
        if (pages.get(0) < 0 || pages.get(1) > 400) {
            return false;
        }
        if (checkEven(pages.get(0))==true || checkEven(pages.get(1))==false) {
            return false;
        }
        if (checkSuccessive(pages) == false) {
            return false;
        }
        return true;
    }
    public static int getSum(Integer num) {
        String numToString = num.toString();
        int sum = 0;
        for (int i = 0; i < numToString.length(); i++) {
            sum += Integer.parseInt(String.valueOf(numToString.charAt(i)));
        }
        return sum;
    }
    private static int getMuliple(Integer num) {
        String numToString = num.toString();
        int mul = 1;
        for (int i = 0; i < numToString.length(); i++) {
            mul *= Integer.parseInt(String.valueOf(numToString.charAt(i)));
        }
        return mul;
    }
}
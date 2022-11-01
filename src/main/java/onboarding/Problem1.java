package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!(check(pobi) && check(crong))) {
            return -1;
        }

        int p = Math.max(add_or_multiply(pobi.get(0)), add_or_multiply(pobi.get(1)));
        int c = Math.max(add_or_multiply(crong.get(0)), add_or_multiply(crong.get(1)));

        int answer;

        if (p > c) {
            answer = 1;
        }
        else if (p < c) {
            answer = 2;
        }
        else {
            answer = 0;
        }

        return answer;
    }

    static boolean check(List<Integer> pages) {
        Integer left = pages.get(0);
        Integer right = pages.get(1);
        if (pages.get(0) > pages.get(1)) {
            return false;
        }
         if (pages.get(1) - pages.get(0) != 1) {
             return false;
        }
         if (left < 1 || pages.get(0) > 400 || right < 1 || pages.get(1) > 400) {
            return false;
        }
        return true;
    }
    static int add (int value) {
        int length = (int)(Math.log10(value)+1);
        int result = 0;
        String its = String.valueOf(value);
        for (int i = 0; i < length; i++){
            result += Character.getNumericValue(its.charAt(i));
        }
        return result;
    }
    static int multiply (int value) {
        int length = (int)(Math.log10(value)+1);
        int result = 1;
        String its = String.valueOf(value);
        for (int i = 0; i < length; i++){
            result *= Character.getNumericValue(its.charAt(i));
        }
        return result;
    }
    static int add_or_multiply(int value) {
        return Math.max(add(value), multiply(value));
    }
}
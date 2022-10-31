package onboarding;

import java.util.Arrays;
import java.util.List;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isException(pobi,crong)){
            return -1;
        }
        return -1;
    }

    private static boolean isException(List<Integer> pobi, List<Integer> crong){
        return (!isCorrectPage(pobi)) || (!isCorrectPage(crong));
    }

    private static boolean isCorrectPage(List<Integer>pages){ //1
        int pageGap=pages.get(1)-pages.get(0);

        if(pageGap==1) {
            return true;
        }
        return false;
    }

    private static int[] splitDigits(int number){
        return Arrays.stream(Integer.toString(number).split(""))
                .mapToInt(digit->Integer.parseInt(digit))
                .toArray();
    }
}
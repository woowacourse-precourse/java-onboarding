package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static boolean inInRange(Integer number){
        if(number >= 1 && number <= 10000)
            return true;

        return false;
    }

    public static List<Integer> makeList(Integer number){
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            numberList.add(i);
        }
        return numberList;
    }

    public static List<Integer> divideDigit(Integer number){
        List<Integer> list = new ArrayList<>();
        while(number > 0){
            list.add(number%10);
            number/=10;
        }
        return list;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = Count369(number);
        return answer;
    }

    public static boolean isInRange(Integer number){
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

    public static Integer Count369(Integer number){
        int count=0;

        if(!isInRange(number)) {
            System.out.println("error!");
            return -1;
        }

        List<Integer> list = makeList(number);
        for (int i = 0; i < list.size(); i++) {
            Integer element = list.get(i);
            List<Integer> digit = divideDigit(element);
            for (int j = 0; j < digit.size(); j++) {
                if(digit.get(j) == 3 || digit.get(j) == 6 || digit.get(j) == 9)
                    count++;
            }
        }
        return count;
    }
}

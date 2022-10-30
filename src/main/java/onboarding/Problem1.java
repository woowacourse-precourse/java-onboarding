package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static List<Integer> numList (int number){
        List<Integer> numberList = new ArrayList<>();
        while(number!=0) {
            numberList.add(number%10);
            number/=10;
        }
        return numberList;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        List<Integer> numberList=numList(234);
        System.out.println(numberList);
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}
package onboarding;

import java.util.ArrayList;
import java.util.Collections;
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

    public static int sum(List<Integer> numberlist){
        int result = 0;
        for(int num : numberlist) {
            result += num;
        }
        return result;
    }

    public static int product(List<Integer> numberlist){
        int result = 1;
        for(int num : numberlist) {
            result *= num;
        }
        return result;
    }

    public static int findMax(int left,int right){
        List<Integer> scores = new ArrayList<>();
        scores.add(sum(numList(left)));
        scores.add(product(numList(left)));
        scores.add(sum(numList(right)));
        scores.add(product(numList(right)));
        int max = Collections.max(scores);
        return max;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        List<Integer> numberList=numList(234);
        int pobiMax = findMax(pobi.get(0),pobi.get(1));
        System.out.println(pobiMax);
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}
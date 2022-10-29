package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        List<Integer> list = separateNumber(number);
        List<Integer> count = multiplyCount(countMultipleOfThree(list));
        return answer;
    }

    private static List<Integer> separateNumber(int num){
        List<Integer> list = new ArrayList<>();
        while(num > 0){
            list.add(num % 10);
            num = num /10;
        }
        return list;
    }

    private static List<Integer> countMultipleOfThree(List<Integer> separateNumberList){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i< separateNumberList.size(); i++){
            list.add(separateNumberList.get(i)/3);
        }
        return list;
    }

    private static List<Integer> multiplyCount(List<Integer> list){
        List<Integer> countList = new ArrayList<>();
        if(list.size() > 1){ //두자리 수 이상이면
            countList.add(3); // 0의 자리수
        }
        for(int i=0; i< list.size(); i++){
            int digit = (int) Math.pow(10, i);
            countList.add(list.get(i)* digit);
        }
        return countList;
    }
}

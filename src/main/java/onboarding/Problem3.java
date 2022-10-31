package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if(number < 10)
            return number / 3;
        List<Integer> list = separateNumber(number);

        //해당 자리수의 3의 배수 개수와 자리수 곱하기
        List<Integer> count = multiplyCount(countMultipleOfThree(list));
        // 한자리 수일 때 3의 배수 3개를 추가로 더하기
        answer = sumCount(count) + 3;
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

        for(int i=0; i< list.size(); i++){
            int digit = (int) Math.pow(10, i);
            countList.add(list.get(i)* digit);
        }
        return countList;
    }

    private static int sumCount(List<Integer> list){
        int result = 0;
        for(int i=0; i<list.size(); i++){
            result += list.get(i);
        }
        return result;
    }
}

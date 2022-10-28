package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(!effectivenessCheck(pobi) || !effectivenessCheck(crong)){
            return -1;
        }

        Integer pobiBigger = findLargeNumber(pobi);
        Integer crongBigger = findLargeNumber(crong);

        answer = rsultSet(pobiBigger, crongBigger);

        return answer;
    }

    public static boolean effectivenessCheck(List<Integer> numberList){
        //size check
        if(numberList.size() != 2){
            return false;
        }

        //페이지 범위 검사
        if(numberList.get(0) < 0 || numberList.get(1) > 400){
            return false;
        }

        // 홀짝검사
        if(numberList.get(0)%2 != 1 || numberList.get(1)%2 != 0){
            return false;
        }

        //왼쪽페이지보다 오른쪽페이지가 1더큰지 검사
        if(numberList.get(1) - numberList.get(0) != 1){
            return false;
        }
        return true;
    }

    public static Integer findLargeNumber(List<Integer> numberList){
        Integer largeNumber = 0;

        for(Integer number : numberList){

            List<Integer> singleNumberList = Arrays.stream(number.toString().split("")).map(p -> Integer.parseInt(p)).collect(Collectors.toList());

            int SingleNumberSum = singleNumberList.get(0);
            int SingleNumberMultiple = singleNumberList.get(0);

            for(int i=1; i < singleNumberList.size(); i++){

                SingleNumberSum += singleNumberList.get(i);
                SingleNumberMultiple *= singleNumberList.get(i);

            }

            if(SingleNumberSum > SingleNumberMultiple){
                if(largeNumber < SingleNumberSum) {
                    largeNumber = SingleNumberSum;
                }
            }else{
                if(largeNumber < SingleNumberMultiple) {
                    largeNumber = SingleNumberMultiple;
                }
            }
        }
        return largeNumber;
    }

    public static Integer rsultSet(Integer pobiResult, Integer crongResult){
        if(pobiResult > crongResult){
            return 1;
        }else if(pobiResult < crongResult){
            return 2;
        }else{
            return 0;
        }
    }

}
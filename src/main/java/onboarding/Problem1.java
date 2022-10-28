package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        //페이지 연속성에 대한 예외처리
        if(!pobi.get(1).equals(pobi.get(0)+1) || !crong.get(1).equals(crong.get(0)+1)){
            return -1;
        }
        return answer;
    }
    private static List<Integer> splitInteger(int number) {
        List<Integer> numberList = new ArrayList<Integer>();
        while(number > 0){
            numberList.add(number % 10);
            number /= 10;
        }
        return numberList;
    }
}
package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(checkException(pobi) || checkException(crong)){
            return -1;
        }


        return answer;
    }
    public static boolean checkException(List<Integer> checkList){
        Integer leftNum = checkList.get(0)+1;
        Integer rightNum = checkList.get(1);
        return checkSniffling(leftNum, rightNum);
    }
    public static boolean checkSniffling(Integer num1, Integer num2){
        return num1 % 2 != 0 || num2 % 2 != 0;
    }
}
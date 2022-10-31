package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(checkException(pobi, crong)){
            return -1;
        }
        int answer = Integer.MAX_VALUE;

        return answer;
    }

    public static int plusEachDigit(int num){
        int result = 0;
        while(num>0){
            result += num%10;
            num /= 10;
        }
        return result;
    }

    public static boolean checkException(List<Integer> pobi, List<Integer> crong){
        if(pobi.get(0)%2 != 1 || pobi.get(1)%2 == 0 || crong.get(0)%2 !=1 || crong.get(1)%2 ==0){
            return true;
        }
        if(pobi.get(1)-pobi.get(0) != 1 || crong.get(1)-crong.get(0) !=1){
            return true;
        }
        if (pobi.get(0) < 1 || pobi.get(1) > 400 || crong.get(0) < 1 || crong.get(1) > 400) {
            return true;
        }
        return false;
    }

}
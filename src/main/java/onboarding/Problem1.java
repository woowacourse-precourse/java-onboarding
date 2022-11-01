package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(checkException(pobi, crong)){
            return -1;
        }
        int answer = Integer.MAX_VALUE;

        int pobi_maxvalue = Math.max( Math.max(plusEachDigit(pobi.get(0)) ,plusEachDigit(pobi.get(1))),
                Math.max(multiEachDigit(pobi.get(0)) ,multiEachDigit(pobi.get(1))) );

        int crong_maxvalue= Math.max(Math.max(plusEachDigit(crong.get(0)) ,plusEachDigit(crong.get(1))),
                Math.max(multiEachDigit(crong.get(0)) ,multiEachDigit(crong.get(1))) );

        if(pobi_maxvalue == crong_maxvalue) answer = 0;
        else if(pobi_maxvalue > crong_maxvalue) answer =1;
        else if (pobi_maxvalue < crong_maxvalue) answer =2;

        return answer;
    }

    public static int multiEachDigit(int num){
        int result = 1;
        while(num>0){
            result *= num%10;
            num /= 10;
        }
        return result;
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
        if(pobi.get(0)%2 != 1 || pobi.get(1)%2 != 0 || crong.get(0)%2 !=1 || crong.get(1)%2 !=0){
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
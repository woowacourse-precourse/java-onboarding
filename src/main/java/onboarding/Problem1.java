package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(pobi.get(1)- pobi.get(0)!=1 || crong.get(1)-crong.get(0)!=1)
            return -1;
        int pobiLar =  sendBigger(pobi);
        int crongLar = sendBigger(crong);
        if(pobiLar>crongLar)
            answer = 1;
        else if(pobiLar<crongLar)
            answer = 2;
        else
            answer = 0;
        return answer;
    }
    static int sendBigger(List<Integer> user) {
       int result = Integer.MIN_VALUE;
       for(Integer num : user){
          int tempNum = Math.max(multiEach(num),sumEach(num));      
          if(tempNum>result)
              result = tempNum;
       }
       return result;
    }
    static int multiEach(int num) {
        int result=1;
        String changedNum = String.valueOf(num);
        for (int i = 0; i < changedNum.length(); i++) {
            result *= Character.getNumericValue(changedNum.charAt(i));
        }
        return result;
    }
    static int sumEach(int num) {
        int result=0;
        String changedNum = String.valueOf(num);
        for (int i = 0; i < changedNum.length(); i++) {
            result += Character.getNumericValue(changedNum.charAt(i));
        }
        return result;
    }
}

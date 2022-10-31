package onboarding;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        boolean isError = false;

        if(pobi.get(0)+1 != pobi.get(1) || crong.get(0)+1 != crong.get(1)) isError = true;

        int pobiMaxNum = getMaxNum(pobi);
        int crongMaxNum = getMaxNum(crong);

        if(!isError){
            if(pobiMaxNum > crongMaxNum) answer = 1;
            else if (pobiMaxNum < crongMaxNum) answer = 2;
            else if (pobiMaxNum == crongMaxNum) answer = 0;
        }else answer = -1;

        return answer;
    }

   static int getMaxNum(List<Integer> numList){
       int maxNum = 0;
       int getLeftMaxNum = getPageMaxNum(numList.get(0));
       int getRightMaxNum = getPageMaxNum(numList.get(1));
       return maxNum = Math.max(getLeftMaxNum, getRightMaxNum);
    }

    static int getPageMaxNum(int leftNum){
        int sum = 0;    //페이지 각 자리 수의 합계
        int multiple = 0; //페이지 각 자리 수의 곱
        int maxNum = 0; //페이지 가장 큰수
        while (leftNum > 0 ){
            sum += leftNum % 10;

            if(multiple == 0) multiple = leftNum % 10;
            else multiple *= leftNum % 10;
            leftNum /= 10;
        }
       return maxNum = Math.max(sum, multiple);
    }

}
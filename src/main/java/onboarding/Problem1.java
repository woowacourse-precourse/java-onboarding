package onboarding;

import java.util.ArrayList;
import java.util.List;


class Problem1 {

    public static int findMaxPageNum(Integer pageNum){
        int result;

        //배열에 각 자리 수 저장
        ArrayList<Integer> dividedPageNum = new ArrayList<>();
        int atomNum = pageNum;   //몫
        while (atomNum > 0) {
            dividedPageNum.add(atomNum % 10);
            atomNum /= 10;
        }

        //각 자리 합
        int sumResult = 0;
        for (int num : dividedPageNum) {
            sumResult += num;
        }
//        System.out.println("sumResult : " + sumResult);

        result = sumResult;

        //각 자리 곱
        int multiResult = 1;
        for (int num : dividedPageNum) {
            multiResult *= num;
        }
//        System.out.println("multiResult : "+multiResult);

        if (result < multiResult){
            result = multiResult;
        }
//        System.out.println("result : "+result);

        return result;
    }



    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        int leftNum = pobi.get(0);
        int rightNum = pobi.get(1);

        if (rightNum - leftNum != 1){
            return answer;
        }

        int pobiMaxNum = findMaxPageNum(leftNum);
        int temp = findMaxPageNum(rightNum);

        if (pobiMaxNum < temp){
            pobiMaxNum = temp;
        }



        leftNum = crong.get(0);
        rightNum = crong.get(1);
        if (rightNum - leftNum != 1){
            return answer;
        }

        int crongMaxNum = findMaxPageNum(leftNum);
        temp = findMaxPageNum(rightNum);

        if (crongMaxNum < temp){
            crongMaxNum = temp;
        }


        if (pobiMaxNum == crongMaxNum){
            answer = 0;
        } else if (pobiMaxNum > crongMaxNum) {
            answer = 1;
        } else {
            answer = 2;
        }


        return answer;
    }
}
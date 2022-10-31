package onboarding;

import java.util.*;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        answer = solutionAnswer(pobi, crong);

        return answer;
    }

    static List<Integer> FindDigitByPage(int PageNumber){ //각 자리수 구하기

        List<Integer> DigitList = new ArrayList<Integer>();

        int number = PageNumber;

        while(number!=0){
            DigitList.add(number%10);
            number = number/10;
        }

        return DigitList;
    }

    static int FindMaxValue(int num){
        int MaxValue = 0;
        int sum = 0;
        int multiple = 1;

        for(int i=0;i<FindDigitByPage(num).size();i++){
            sum += FindDigitByPage(num).get(i);
            multiple *= FindDigitByPage(num).get(i);
        }

        MaxValue = Math.max(sum, multiple);

        return MaxValue;
    }

    static int solutionAnswer (List<Integer> pobiPage, List<Integer> crongPage){

        int leftIndex = 0;
        int rightIndex = 1;

        if(pobiPage.get(leftIndex)+1 != pobiPage.get(rightIndex) || crongPage.get(leftIndex)+1 != crongPage.get(rightIndex)){
            return -1;
        }


        int pobiScore = 0;
        int crongScore = 0;

        if(FindMaxValue(pobiPage.get(leftIndex)) > FindMaxValue(pobiPage.get(rightIndex))) {
            pobiScore = FindMaxValue(pobiPage.get(leftIndex));
        }
        else {
            pobiScore = FindMaxValue(pobiPage.get(rightIndex));
        }

        if(FindMaxValue(crongPage.get(leftIndex)) > FindMaxValue(crongPage.get(rightIndex))) {
            crongScore = FindMaxValue(crongPage.get(leftIndex));
        }
        else {
            crongScore = FindMaxValue(crongPage.get(rightIndex));
        }


        if(pobiScore > crongScore){
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else {
            return 0;
        }

    }

}


package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiMaxNum = 0;
        int crongMaxNum = 0;

        // 포비의 경우의 수 체크
        for (Integer integer : pobi) {

            int addNum = 0;
            int multipleNum = 1;
            int tempAdd = integer;
            int tempMulti = integer;

            while(tempAdd > 0){
                addNum += tempAdd%10;
                tempAdd/=10;
            }

            while(tempMulti > 0){
                multipleNum *= tempMulti%10;
                tempMulti/=10;
            }

            pobiMaxNum = Math.max(addNum,multipleNum);
        }

        // 크롱의 경우의 수 체크
        for (Integer integer : crong) {

            int addNum = 0;
            int multipleNum = 1;
            int tempAdd = integer;
            int tempMulti = integer;

            while(tempAdd > 0){
                addNum += tempAdd%10;
                tempAdd/=10;
            }

            while(tempMulti > 0){
                multipleNum *= tempMulti%10;
                tempMulti/=10;
            }

            crongMaxNum = Math.max(addNum,multipleNum);
        }


        if(pobiMaxNum > crongMaxNum)
        {
            answer = 1;
        }
        else if(pobiMaxNum == crongMaxNum)
        {
            answer = 0;
        }
        else
        {
            answer = 2;
        }

        return answer;
    }
}
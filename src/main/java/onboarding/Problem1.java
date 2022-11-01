package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {


        int answer = Integer.MAX_VALUE;
        int pobiMaxNum = 0;
        int crongMaxNum = 0;


        // 만약 책을 폈을때 함께 나오는 두 페이지가 아닐 경우 예외 케이스로 -1을 반환한다.
        if ((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1))
        {
            answer = -1;
            return answer;
        }


        // 책을 시작면이나 마지막 면이 나오도록 펼치면 예외 케이스로 -1을 반환한다.
        if(pobi.get(0) == 1 || pobi.get(1) == 400 || crong.get(0) == 1 || crong.get(1) == 400)
        {
            answer = -1;
            return answer;
        }


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
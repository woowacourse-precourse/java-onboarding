package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiLeft = dividNum(pobi.get(0));
        int pobiRight = dividNum(pobi.get(1));

        int pobiNum = pobiLeft > pobiRight ? pobiLeft : pobiRight;
        int crongNum = dividNum(crong.get(0)) > dividNum(crong.get(1)) ? dividNum(crong.get(0)) : dividNum(crong.get(1));

        return pobiNum > crongNum ? 1 : 2;
    }

    public static int dividNum(Integer num){
        int sum = 0;
        int multi = 1;

        int dividOfNum = num; // 몫을 저장하는 변수
        int remain = 0;  // 나머지를 저장하는 변수

        while(dividOfNum>=10){
            remain = dividOfNum%10;
            dividOfNum = dividOfNum/10;

            sum+= remain;
            multi*= remain;
        }

        sum+=dividOfNum;
        multi*=dividOfNum;


        if(sum==multi){
            return 0;
        }

        return sum>multi ? sum: multi;
    }

}
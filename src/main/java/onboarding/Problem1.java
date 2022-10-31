package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiLeft = dividNum(pobi.get(0));
        int pobiRight = dividNum(pobi.get(1));

        int crongLeft = dividNum(crong.get(0));
        int crongRight = dividNum(crong.get(1));

        int pobiNum = 0;
        int crongNum = 0;

        if(pobiLeft ==-1 || pobiRight == -1 || crongLeft == -1 || crongRight == -1){
            return -1;
        }else {
            pobiNum = pobiLeft > pobiRight ? pobiLeft : pobiRight;
            crongNum = crongLeft > crongRight ? crongLeft : crongRight;
        }


        if(pobiNum > crongNum){
            return 1;
        } else if (crongNum > pobiNum) {
            return 2;
        }else {
            return 0;
        }
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
        if(multi == 0){
            return -1;
        }

        return sum>multi ? sum: multi;
    }

    public static void main(String[] args) {
        List<Integer> pobi = new ArrayList<>();
        pobi.add(99);
        pobi.add(102);

        List<Integer> crong = new ArrayList<>();
        crong.add(211);
        crong.add(212);

        System.out.println(solution(pobi,crong));
    }

}
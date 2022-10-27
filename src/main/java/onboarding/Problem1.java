package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        //예외처리
        if (check(pobi)==false || check(crong)==false)
            return -1;

        int maxP=calMax(pobi);
        int maxC=calMax(crong);
        if(maxP>maxC)
            return 1;
        else if (maxC>maxP)
            return 2;
        else if (maxC==maxP)
            return 0;

        return -1;
    }
    static boolean check(List<Integer> list){
        //예외1 시작 or 마지막 면이 입력으로
        //예외2 오른쪽이 짝 or 왼쪽이 홀
        //예외3 왼쪽과 오른쪽이 연이은 숫자가 아님
        return true;
    }

    static int calMax(List<Integer> list){
        ArrayList<Integer> maxlist=new ArrayList<>();
        for(int num:list){
            int sum=0;
            int mul=1;
            //합,곱 구하기
            while (num!=0){
                sum+=num%10;
                mul*=num%10;
                num/=10;
            }
            maxlist.add(Math.max(sum,mul));
        }
        return Collections.max(maxlist);
    }
}
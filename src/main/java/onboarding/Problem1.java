package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 1~400까지의 범위가 맞는가
        // 시작면이나 마지막면이 나오도록 책을 펼치지 않는가
        if(pobi.get(0)<=1 || pobi.get(1)>=400 || crong.get(0)<=1 || crong.get(1)>=400)
            return -1;
        // 양 숫자의 차이가 1인가(이때 항상 왼쪽<오른쪽)
        if((pobi.get(1)-pobi.get(0)!=1)||(crong.get(1)-crong.get(0)!=1))
            return -1;
        // 왼쪽은 홀수, 오른쪽은 짝수가 맞는가
        if(pobi.get(0)%2==0 || pobi.get(1)%2==1 || crong.get(0)%2==0 || crong.get(1)%2==1)
            return -1;
        return 0;
    }
}
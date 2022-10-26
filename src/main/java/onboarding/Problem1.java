package onboarding;

import java.util.List;

class Problem1 {

    public static int getPagePlaceSum(int page){
        int pagePlaceSum = 0;
        while(page > 0){
            pagePlaceSum = pagePlaceSum + page % 10;
            page = page / 10;
        }
        return pagePlaceSum;
    }

    public static int getPagePlaceMulti(int page){
        int pagePlaceMulti = 1;
        while(page > 0){
            pagePlaceMulti = pagePlaceMulti * (page % 10);
            page = page / 10;
        }
        return pagePlaceMulti;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}
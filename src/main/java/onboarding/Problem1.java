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

    public static int getMaxPageCalculate(int leftPage, int rightPage){
        int leftPageMax = Math.max(getPagePlaceSum(leftPage), getPagePlaceMulti(leftPage));
        int rightPageMax = Math.max(getPagePlaceSum(rightPage), getPagePlaceMulti(rightPage));
        return Math.max(leftPageMax, rightPageMax);
    }

    public static boolean isError(List<Integer> list){
        if(list.get(1) - list.get(0) != 1){
            return true;
        }
        return false;
    }

    public static int compareScore(int pobiMaxScore, int crongMaxScore){
        int answer = 0;
        if(pobiMaxScore == crongMaxScore){
            answer = 0;
        }
        if(pobiMaxScore > crongMaxScore){
            answer = 1;
        }
        if(pobiMaxScore < crongMaxScore){
            answer = 2;
        }
        return answer;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(isError(pobi) || isError(crong)){
            return -1;
        }
        int pobiMaxScore = getMaxPageCalculate(pobi.get(0), pobi.get(1));
        int crongMaxScore = getMaxPageCalculate(crong.get(0), crong.get(1));

        answer = compareScore(pobiMaxScore, crongMaxScore);

        return answer;
    }
}
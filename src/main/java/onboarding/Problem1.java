package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(!checkRange(pobi) || !checkRange(crong)){
            return -1;
        }

        if(!isLegalPage(pobi) || !isLegalPage(crong)){
            return -1;
        }

        int pobiScore = calculateScore(pobi);
        int crongScore = calculateScore(crong);

        if(pobiScore > crongScore){
            answer = 1;
        }else if(crongScore > pobiScore){
            answer = 2;
        }else if(pobiScore == crongScore){
            answer = 0;
        }else{
            return -1;
        }

        return answer;
    }

    static boolean checkRange(List<Integer> pages){
        for (Integer page : pages){
            if(page <= 1 || page >= 400){
                return false;
            }
        }
        return true;
    }

    static boolean isLegalPage(List<Integer> pages){
        if(pages.get(1) < pages.get(0)){
            return false;
        }
        if(pages.get(1) - pages.get(0) != 1){
            return false;
        }
        return true;
    }

    static int calculateScore(List<Integer> pages){
        int leftScore = Math.max(sumScore(pages.get(0)), mulScore(pages.get(0)));
        int rightScore = Math.max(sumScore(pages.get(1)), mulScore(pages.get(1)));

        return Math.max(leftScore, rightScore);
    }

    static int sumScore(Integer page){
        int sum = 0;
        while(page != 0){
            sum += page % 10;
            page /= 10;
        }

        return sum;
    }

    static int mulScore(Integer page){
        int mul = 1;
        while(page != 0){
            mul *= page % 10;
            page /= 10;
        }

        return mul;
    }
}
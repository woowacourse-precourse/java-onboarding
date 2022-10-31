package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!isValidPage(pobi.get(0), pobi.get(1)) || !isValidPage(crong.get(0), crong.get(1)))
            return -1;

        int pobiScore = getMaxScore(pobi.get(0), pobi.get(1));
        int crongScore = getMaxScore(crong.get(0), crong.get(1));

        if (pobiScore > crongScore){
            answer = 1;
        } else if (pobiScore == crongScore) {
            answer = 0;
        }else{
            answer = 2;
        }

        return answer;
    }
    private static int addAllNumbers(int page){
        int sum = 0;
        while (page > 0){
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    private static int multiplyAllNumbers(int page){
        int sum = 1;
        while (page > 0){
            sum *= page % 10;
            page /= 10;
        }
        return sum;
    }

    private static boolean isValidPage(int leftPage, int rightPage){
        if (isEven(leftPage) || !isEven(rightPage))
            return false;
        if (leftPage + 1 != rightPage){
            return false;
        }
        return true;
    }

    private static boolean isEven(int page){
        return page % 2 == 0;
    }

    private static int getMaxScore(int leftPage, int rightPage){
        int leftMax = Integer.max(addAllNumbers(leftPage), multiplyAllNumbers(leftPage));
        int rightMax = Integer.max(addAllNumbers(rightPage), multiplyAllNumbers(rightPage));
        int maxScore = Integer.max(leftMax, rightMax);

        return maxScore;
    }
}
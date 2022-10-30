package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            if(!checkPage(pobi))
                return -1;
            if(!checkPage(crong))
                return -1;

            int scoreOfPobi = getMaxScore(pobi.get(0), pobi.get(1));
            int scoreOfCrong = getMaxScore(crong.get(0), crong.get(1));

            if(scoreOfPobi > scoreOfCrong)  //pobi win
                return 1;
            else if (scoreOfPobi < scoreOfCrong) // crong win
                return 2;
            else
                return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    private static boolean checkPage(List<Integer> pageList) {
        if(pageList.get(0) + 1 == pageList.get(1))
            return true;
        else
            return false;
    }

    private static int getMaxScore(int leftPage, int rightPage) {
        int leftScore = Math.max(sum(leftPage), multiple(leftPage));
        int rightScore = Math.max(sum(rightPage), multiple(rightPage));
        return Math.max(leftScore, rightScore);
    }

    private static int sum(Integer num) {
        int ans = 0;
        while(num > 0) {
            ans += (num%10);
            num /= 10;
        }
        return ans;
    }

    private static int multiple(Integer num) {
        int ans = 1;
        while(num > 0) {
            ans *= (num%10);
            num /= 10;
        }
        return ans;
    }
}
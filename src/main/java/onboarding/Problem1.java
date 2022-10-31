package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        List<Integer> pobiScores = new ArrayList<>();
        List<Integer> crongScores = new ArrayList<>();
        if(isProblem(pobi) || isProblem(crong)) answer = -1;
        if(answer != -1){
            int pobiMax, crongMax;
            for(int i = 0; i < 2; ++i){
                int pobiScore1 = sumEachDigit(pobi.get(i));
                int pobiScore2 = multiplyEachDigit(pobi.get(i));
                pobiScores.add(pobiScore1);
                pobiScores.add(pobiScore2);
                int crongScore1 = sumEachDigit(crong.get(i));
                int crongScore2 = multiplyEachDigit(crong.get(i));
                crongScores.add(crongScore1);
                crongScores.add(crongScore2);
            }
            pobiMax = Math.max(pobiScores.get(0), pobiScores.get(1));
            crongMax = Math.max(crongScores.get(0), crongScores.get(1));
            if(pobiMax > crongMax) answer = 1;
            else if(crongMax > pobiMax) answer = 2;
            else if(pobiMax == crongMax) answer = 0;
        }
        return answer;
    }

    public static boolean isProblem(List<Integer> list){
        int leftPage = list.get(0);
        int rightPage = list.get(1);
        if(rightPage - leftPage != 1) return true;
        if(leftPage % 2 == 0 || rightPage % 2 == 1) return true;
        if(leftPage < 1 || rightPage < 1) return true;
        if(leftPage > 400 || rightPage > 400) return true;
        return false;
    }

    public static int sumEachDigit(int num){
        int sum = 0;
        while(num > 0){
            sum = sum + (num % 10);
            num = num / 10;
        }
        return sum;
    }

    public static int multiplyEachDigit(int num){
        int result = 1;
        while(num > 0){
            result = result * (num % 10);
            num = num / 10;
        }
        return result;
    }
}
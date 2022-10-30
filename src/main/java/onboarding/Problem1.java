package onboarding;

import java.util.List;


class Problem1 {

    static int getScore(int page){
        int tmp = page;
        int valueOfPlus = 0;  // 각 자리의 수를 모두 더한 값
        while(tmp != 0){
            valueOfPlus += tmp % 10;
            tmp /= 10;
        }

        tmp = page;
        int valueOfMul = 1; // 각 자리의 수를 모두 곱한 값
        while(tmp != 0){
            valueOfMul *= tmp % 10;
            tmp /= 10;
        }

        int score = Math.max(valueOfPlus, valueOfMul);
        return score;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        boolean exception = false;

        int scoreOfPobi = 0;
        for(int pageNum: pobi){
            int score = getScore(pageNum);
            scoreOfPobi = Math.max(score, scoreOfPobi);
        }

        int scoreOfCrong = 0;
        for(int pageNum: crong){
            int score = getScore(pageNum);
            scoreOfCrong = Math.max(score, scoreOfCrong);
        }

        System.out.println("scoreOfPobi = " + scoreOfPobi);
        System.out.println("scoreOfCrong = " + scoreOfCrong);

        if(scoreOfPobi > scoreOfCrong) answer = 1;
        else if(scoreOfPobi < scoreOfCrong) answer = 2;
        else if(scoreOfPobi == scoreOfCrong) answer = 0;

        if(pobi.get(0) + 1 != pobi.get(1)) exception = true;
        if(crong.get(0) + 1 != crong.get(1)) exception = true;
        if(exception) answer = -1;

        return answer;
    }
}
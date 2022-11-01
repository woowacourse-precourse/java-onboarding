package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiLeftNum = pobi.get(0);
        int pobiRightNum = pobi.get(1);
        int crongLeftNum = crong.get(0);
        int crongRightNum = crong.get(1);
        if(isException(pobiLeftNum,pobiRightNum) || isException(crongLeftNum,crongRightNum)){
            answer = -1;
        } else {
            int pobiFinalScore = getMaxScore(pobiLeftNum,pobiRightNum);
            int crongFinalScore = getMaxScore(crongLeftNum,crongRightNum);
            if(pobiFinalScore == crongFinalScore) {
                answer = 0;
            } else if(pobiFinalScore > crongFinalScore) {
                answer = 1;
            } else {
                answer = 2;
            }
        }
        return answer;
    }
    static boolean isException(int LeftNum, int RightNum){
        if(LeftNum+1 == RightNum) {
            return false;
        } else {
            return true;
        }
    }
    static int getScoreBySum(int Num){
        String stringNum = String.valueOf(Num);
        int NumSum = 0;
        for(int i = 0 ; i < stringNum.length() ; i++){
            int curNum = stringNum.charAt(i) - '0';
            NumSum += curNum;
        }
        return NumSum;
    }
    static int getScoreByMul(int Num){
        String stringNum = String.valueOf(Num);
        int NumMul = 1;
        for(int i = 0 ; i < stringNum.length() ; i++){
            int curNum = stringNum.charAt(i) - '0';
            NumMul *= curNum;
        }
        return NumMul;
    }
    static int getMaxScore(int LeftNum, int RightNum){
        List<Integer> scoreList = new ArrayList<>();
        scoreList.add(getScoreBySum(LeftNum));
        scoreList.add(getScoreByMul(LeftNum));
        scoreList.add(getScoreBySum(RightNum));
        scoreList.add(getScoreByMul(RightNum));
        Collections.sort(scoreList);
        return scoreList.get(scoreList.size()-1);
    }
}
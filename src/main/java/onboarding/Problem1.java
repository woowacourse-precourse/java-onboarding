package onboarding;

import java.util.Arrays;
import java.util.List;

/*
========================================Problem1 기능 목록========================================
- 왼쪽 페이지가 홀수인지 판별하는 기능
- 오른쪽 페이지가 짝수인지 판별하는 기능
- 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수가 아닌 예외사항을 처리하는 기능
- 페이지의 각 자리 수를 더하는 기능
- 페이지의 각 자리 수를 곱하는 기능
- 두 개의 점수 중 가장 큰 점수를 정하는 기능
- 포비와 크롱의 점수를 비교해서 누가 이겼는지 알아내는 기능
- 페이지가 서로 연속된 수의 형태를 가지는지 예외사항을 확인하는 기능
 */

class Problem1 {

    public boolean isOdd(List<Integer> param){
        if((param.get(0) & 1) != 0)
            return true;
        else
            return false;
    }

    public boolean isEven(List<Integer> param){
        if((param.get(1) & 1) == 0)
            return true;
        else
            return false;
    }

    public boolean checkPage(List<Integer> page){
        if(isOdd(page) && isEven(page))
            return true;
        else
            return false;
    }

    public int addNumberOfDigit(int digits){
        int sum = 0;
        String s = Integer.toString(digits);

        for(int i = 0;i < s.length();i++){
            sum += Integer.parseInt(s.substring(i, i+1));
        }
        return sum;
    }

    public int multipleNumberOfDigit(int digits){
        int mul = 1, temp;
        String s = Integer.toString(digits);

        for(int i = 0;i < s.length();i++){
            temp = Integer.parseInt(s.substring(i, i+1));
            if(i == 0)
                mul = temp;
            else
                mul *= temp;
        }
        return mul;
    }

    public int getHighScore(List<Integer> param){
        int addLeftScore, addRightScore, mulLeftScore, mulRightScore, leftPage, rightPage, leftHighScore, rightHighScore;
        leftPage = param.get(0);
        rightPage = param.get(1);

        addLeftScore = addNumberOfDigit(leftPage);
        addRightScore = addNumberOfDigit(rightPage);

        mulLeftScore = multipleNumberOfDigit(leftPage);
        mulRightScore = multipleNumberOfDigit(rightPage);

        if(addLeftScore >= mulLeftScore)
            leftHighScore = addLeftScore;
        else
            leftHighScore = mulLeftScore;

        if(addRightScore >= mulRightScore)
            rightHighScore = addRightScore;
        else
            rightHighScore = mulRightScore;

        return (leftHighScore >= rightHighScore) ? leftHighScore : rightHighScore;
    }

    public String getWinner(List<Integer> pobi, List<Integer> crong){
        int pobiHighScore, crongHighScore;

        pobiHighScore = getHighScore(pobi);
        crongHighScore = getHighScore(crong);

        if(pobiHighScore > crongHighScore)
            return "pobi";
        else if(pobiHighScore < crongHighScore)
            return "crong";
        else
            return "draw";
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }
}
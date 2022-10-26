package onboarding.problem1;

import java.util.List;

public class BookGame {

    private List<Integer> player1;
    private List<Integer> player2;

    public BookGame(List<Integer> player1, List<Integer> player2){
        setPlayerBookPage(player1, player2);
    }

    public void setPlayerBookPage(List<Integer> player1, List<Integer> player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    private int makeScore(List<Integer> playerPages){
        int leftScore = makeSinglePageScore(playerPages.get(0));
        int rightScore = makeSinglePageScore(playerPages.get(1));
        return max(leftScore, rightScore);
    }

    private int makeSinglePageScore(int pageNum){
        int sumScore = sumEachDigit(pageNum);
        int mulScore = multiplyEachDigit(pageNum);
        return max(sumScore, mulScore);
    }

    private int sumEachDigit(int num){
        int sum = 0;
        while(num != 0){
            sum += num%10;
            num = num/10;
        }
        return sum;
    }

    private int multiplyEachDigit(int num){
        int mul = 1;
        while(num != 0){
            mul *= num%10;
            num = num/10;
        }
        return mul;
    }

    private int max(int num1, int num2){
        if(num1 > num2){
            return num1;
        }
        return num2;
    }

    private void validatePageOddEven(List<Integer> playerPages) throws IllegalArgumentException{
        if(playerPages.get(0)%2 != 1){
            throw new IllegalArgumentException("왼쪽페이지는 홀수여야합니다.");
        }
        if(playerPages.get(1)%2 != 0){
            throw new IllegalArgumentException("오른쪽페이지는 짝수여야합니다.");
        }
    }

    private void validatePageContinuous(List<Integer> playerPages) throws IllegalArgumentException{
        if(playerPages.get(0)+1 != playerPages.get(1)){
            throw new IllegalArgumentException("연속된 페이지가 아닙니다.");
        }
    }

}

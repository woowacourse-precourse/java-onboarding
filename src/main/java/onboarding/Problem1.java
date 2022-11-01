package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Exception{
    public final int CORRECT_LENGTH = 2;
    public final int LEFT_PAGE = 0;
    public final int RIGHT_PAGE = 1;
    public final int DIFFERENCE_BETWEEN_PAGES=1;
    public final int START_PAGE = 1;
    public final int FINAL_PAGE = 400;

    public boolean isWrongLength(List<Integer> bookPages){
        return bookPages.size() != CORRECT_LENGTH;
    }
    public boolean isWrongPosition(List<Integer> bookPages){
        return (bookPages.get(LEFT_PAGE) % 2!=1)||(bookPages.get(RIGHT_PAGE)%2!=0);
    }
    public boolean isWrongPage(List<Integer> bookPages){
        return ((bookPages.get(RIGHT_PAGE)-bookPages.get(LEFT_PAGE))!=DIFFERENCE_BETWEEN_PAGES);
    }
    public boolean isFirstOrLastPage(List<Integer> bookPages){
        final int INITIALIZER=0;
        boolean isTrue = false;

        for(int i=INITIALIZER; i<CORRECT_LENGTH;i++){
            int page = bookPages.get(i);
            isTrue |= (page==FINAL_PAGE||page==START_PAGE);
        }
        return isTrue;
    }
    public boolean errorCheck(List<Integer> bookPages1, List<Integer> bookPages2){
        boolean wrongLength = (isWrongLength(bookPages1)||isWrongLength(bookPages2));
        boolean wrongPosition = (isWrongPosition(bookPages1)||isWrongPosition(bookPages2));
        boolean wrongPageDifference = (isWrongPage(bookPages1)||isWrongPage(bookPages2));
        boolean firstOrLast = (isFirstOrLastPage(bookPages1)||isFirstOrLastPage(bookPages2));
        return (wrongLength||wrongPosition||wrongPageDifference||firstOrLast);
    }
}
class Operation {

    int[] divideEachDigit(int page) {
        int[] digitNum;
        digitNum = Stream.of(String.valueOf(page).split("")).mapToInt(Integer::parseInt).toArray();
        return digitNum;
    }
    public int sumEachDigit(int[] digitArray) {
        int digitSum = 0;
        for (int digit : digitArray) {
            digitSum += digit;
        }
        return digitSum;
    }
    public int multiplyEachDigit(int[] digitArray){
        int digitMul=1;
        for(int digit : digitArray) {
            digitMul*=digit;
        }
        return digitMul;
    }
    public int findMaxValue(int sum, int mul){
        return Math.max(sum, mul);
    }
    public int findWinner(int scoreOfPlayer1, int scoreOfPlayer2){
        if(scoreOfPlayer1>scoreOfPlayer2){
            return 1;
        }
        else if(scoreOfPlayer1<scoreOfPlayer2){
            return 2;
        }
        else{
            return 0;
        }
    }
    public int calculatePlayerScore(List<Integer> bookPages){
        int maxScore=0;

        for(int bookPage:bookPages){
            int[] pageDigitArray;
            pageDigitArray = divideEachDigit(bookPage);
            int sumDigit = sumEachDigit(pageDigitArray);
            int mulDigit = multiplyEachDigit(pageDigitArray);
            int score = findMaxValue(sumDigit, mulDigit);

            if(maxScore<score){
                maxScore=score;
            }
        }
        return maxScore;
    }
}
class Problem1 {

    static final int NUMBER_OF_PLAYER=2;
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        Exception e = new Exception();
        Operation operator = new Operation();

        if(e.errorCheck(pobi, crong)){
            return -1;
        }

        List<List<Integer>> players = List.of(pobi, crong);
        int[] playerScore = new int[NUMBER_OF_PLAYER];

        for(int turn=0;turn<NUMBER_OF_PLAYER;turn++){
            playerScore[turn] = operator.calculatePlayerScore(players.get(turn));
        }

        answer = operator.findWinner(playerScore[0], playerScore[1]);
        return answer;
    }
}
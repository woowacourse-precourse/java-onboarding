package onboarding;

import java.util.List;

class Problem1 {
    //예외 사항 처리
    public static boolean isValidPageNum(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        final int FIRST_PAGE = 1;
        final int LAST_PAGE = 400;
        if(leftPage == FIRST_PAGE || rightPage == LAST_PAGE) { //1. 첫 페이지, 마지막 페이지이면 예외처리
            return false;
        }
        if(leftPage + 1 != rightPage) { //2. 연속된 페이지가 아니면 예외처리
            return false;
        }
        return true;
    }

    //자릿수 합 구하기
    public static int digitAdd(int number) {
        int result = 0;

        while(number/10 != 0) {
            result += number%10;
            number/=10;
        }
        result += number;
        return result;
    }

    //자릿수 곱 구하기
    public static int digitMultiply(int number) {
        int result = 1;

        while(number/10 != 0) {
            result *= number%10;
            number/=10;
        }
        result *= number;
        return result;
    }

    //최대값 찾기
    public static int findMax(int[] numArray) {
        int max = numArray[0];
        for(int i = 1; i < numArray.length; i++) {
            if(max < numArray[i]) {
                max = numArray[i];
            }
        }
        return max;
    }

    //자릿수 합, 곱 구해서 최대값 찾기
    public static int findMaxNum(List<Integer> player) {
        int[] numArray = new int[4];

        numArray[0] = digitAdd(player.get(0));
        numArray[1] = digitMultiply(player.get(0));
        numArray[2] = digitAdd(player.get(1));
        numArray[3] = digitMultiply(player.get(1));

        return findMax(numArray);
    }

    //승자 결정
    public static int determineWinner(int player1, int player2) {
        final int TIE = 0;
        final int PLAYER1_WIN = 1;
        final int PLAYER2_WIN = 2;

        if(player1 == player2) { //무승부
            return TIE;
        }
        if (player1 > player2) { //포비 승
            return PLAYER1_WIN;
        }
        return PLAYER2_WIN; //크롱 승
    }

    //솔루션 메소드
    public static int solution(List<Integer> player1, List<Integer> player2) {
        int answer = Integer.MAX_VALUE;
        int maxNumOfPlayer1;
        int maxNumOfPlayer2;
        final int EXCEPTION = -1;

        if(!isValidPageNum(player1) || !isValidPageNum(player2)) { //예외 사항 처리
            return EXCEPTION;
        }

        maxNumOfPlayer1 = findMaxNum(player1); //포비 최대값 찾기
        maxNumOfPlayer2 = findMaxNum(player2); //크롱 최대값 찾기

        answer = determineWinner(maxNumOfPlayer1, maxNumOfPlayer2); //승자 결정

        return answer;
    }
}
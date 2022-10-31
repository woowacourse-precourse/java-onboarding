package onboarding;

import java.util.List;

public class Problem1 {

    // 최대 세자리 수를 받아 각 자리수를 곱하여 그 값을 return하는 함수 : 구현 완료
    private static int getScoreMultiply(int pageNumber) {
        int hundred = pageNumber / 100;
        int ten = (pageNumber % 100) / 10;
        int one = pageNumber % 10;

        if(hundred == 0 && ten == 0) { // 1. 한자리 수라면
            return one;
        } else if (hundred == 0) { // 2. 두자리 수라면
            return ten * one;
        } else { // 3. 세자리 수라면
            return hundred * ten * one;
        }
    }

    // 최대 세자리 수를 받아 각 자릿수를 더하여 그 값을 return하는 함수 : 구현 완료
    private static int getScorePlus(int pageNumber) {
        int hunderd = pageNumber / 100;
        int ten = (pageNumber % 100) / 10;
        int one = pageNumber % 10;

        return hunderd + ten + one;
    }

    // 왼쪽 페이지와 오른쪽 페이지의 합과 곱을 4가지 경우로 나누어서, 가장 큰 값을 return한다.
    private static int getScore(int leftPage, int rightPage) {
        int max = 0;

        int leftPageScorePlus = getScorePlus(leftPage);
        int rightPageScorePlus = getScorePlus(rightPage);

        // 1. 왼쪽 페이지 곱한 수 = getScoreMultiply(leftPage);
        int leftPageScoreMultiply = getScoreMultiply(leftPage);

        // 2. 오른쪽 페이지 곱한 수 = getScoreMultiply(rightPage);
        int rightPageScoreMultiply = getScoreMultiply(rightPage);

        // 3. 가장 큰 값을 찾는다.
        max = Math.max(leftPageScorePlus, rightPageScorePlus);
        max = Math.max(max, leftPageScoreMultiply);
        max = Math.max(max, rightPageScoreMultiply);

        return max;
    }

    // if-else문을 통해 결과값을 return하는 메서드
    private static int getresult(int scoreOfPobi, int scoreOfCrong) {
        if(scoreOfPobi > scoreOfCrong) {
            return 1;
        } else if (scoreOfPobi < scoreOfCrong) {
            return 2;
        } else if (scoreOfPobi == scoreOfCrong) {
            return 0;
        } else {
            return -1;
        }
    }

    // solution 메서드는 결과값을 승패의 결과값에 따라 1, 2, 0, -1을 return한다.
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int result = 111; // -1, 0, 1, 2가 아닌 값으로 초기화 했음.
        boolean isRightValue = true;

        int leftPageOfPobi = pobi.get(0);
        int rightPageOfPobi = pobi.get(1);

        int leftPageOfCrong = crong.get(0);
        int rightPageOfCrong = crong.get(1);

        isRightValue = checkValue(leftPageOfPobi, rightPageOfPobi, leftPageOfCrong, rightPageOfCrong);
        if(isRightValue == false) {
            return -1;
        }

        int scoreOfPobi = getScore(leftPageOfPobi, rightPageOfPobi);
        int scoreOfCrong = getScore(leftPageOfCrong, rightPageOfCrong);

        result = getresult(scoreOfPobi, scoreOfCrong);

        // 테스트 출력
//        System.out.println("scoreOfPobi = " + scoreOfPobi);
//        System.out.println("scoreOfCrong = " + scoreOfCrong);
        return result;
    }

    private static boolean checkValue(int leftPageOfPobi, int rightPageOfPobi, int leftPageOfCrong, int rightPageOfCrong) {
        if(leftPageOfPobi + 1 != rightPageOfPobi || leftPageOfCrong +1 != rightPageOfCrong) { // 1. 왼쪽 페이지와 오른쪽 페이지가 짝이 아닌 경우 -> 비정상
            return false;
        } else if (leftPageOfPobi == 1 || leftPageOfCrong == 1 || rightPageOfPobi == 400 || rightPageOfCrong == 400) { // 2. 첫 페이지거나 마지막 페이지인 경우 -> 비정상
            return false;
        } else { // 3. 그 외의 경우 -> 정상
            return true;
        }
    }

    public static void main(String[] args) {
        List<Integer> pobi = List.of(100, 101);
        List<Integer> crong = List.of(123, 124);
        System.out.println("result : " + solution(pobi, crong));
    }
}
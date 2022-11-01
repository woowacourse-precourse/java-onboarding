package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    /**
     * 페이지 최대 자리수 final 상수
     */
    static final int LEN_NUMBER_OF_DIGITS = 3;

    /**
     * solution 메소드.
     * 예외처리 후 게임 진행.
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!verifyGame(pobi) || !verifyGame(crong)) {
            return -1;
        } else {
            return playGame(pobi, crong);
        }
    }

    /**
     * 게임 진행 메소드.
     * 페이지를 점수로 변환 후 결과 도출.
     */
    private static int playGame(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = calcScore(pobi);
        int crongScore = calcScore(crong);

        return resultGame(pobiScore, crongScore);
    }

    /**
     * 게임 결과 메소드.
     * 점수 확인 후 승자 도출.
     */
    private static int resultGame(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else {
            return 0;
        }
    }

    /**
     * 예외 처리 메소드.
     * 세부 검증 처리 후 boolean 리턴.
     */
    private static boolean verifyGame(List<Integer> list) {
        int leftPage = list.get(0);
        int rightPage = list.get(1);
        
        if (!verifyPageBoundary(leftPage, rightPage) || !verifyEdgePage(leftPage, rightPage) || !verifyContinuePage(leftPage, rightPage) || !verifyOddEven(leftPage, rightPage)) {
            return false;
        }
        return true;
    }

    /**
     * 짝수 홀수 페이지 검증 메소드.
     */
    private static boolean verifyOddEven(int leftPage, int rightPage) {
        if (leftPage % 2 != 1 || rightPage % 2 != 0) {
            return false;
        }
        return true;
    }

    /**
     * 연속된 페이지 검증 메소드.
     */
    private static boolean verifyContinuePage(int leftPage, int rightPage) {
        if (rightPage - leftPage != 1) {
            return false;
        }
        return true;
    }

    /**
     * 처음과 끝 페이지 검증 메소드.
     */
    private static boolean verifyEdgePage(int leftPage, int rightPage) {
        if (leftPage == 1 || rightPage == 400) {
            return false;
        }
        return true;
    }

    /**
     * 페이지 범위 검증 메소드.
     */
    private static boolean verifyPageBoundary(int leftPage, int rightPage) {
        if (leftPage < 1 || leftPage > 400 || rightPage < 1 || rightPage > 400) {
            return false;
        }
        return true;
    }

    /**
     * 페이지 자리수 곱셈 메소드.
     */
    private static int operMulti(int[] arr) {
        int result = 1;
        boolean numberStart = false;
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] == 0 && !numberStart) {
                continue;
            }else if (arr[i] != 0 && !numberStart) {
                numberStart = true;
            }
            result *= arr[i];
        }
        return result;
    }

    /**
     * 페이지 자리수 덧셈 메소드.
     */
    private static int operPlus(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result += num;
        }
        return result;
    }

    /**
     * 페이지 자리수 덧셈 곱셈 비교 메소드.
     */
    private static int compareScore(int[] arr) {
        return Math.max(operMulti(arr), operPlus(arr));
    }

    /**
     * 정수값을 자리수 별로 배열에 저장 메소드.
     */
    private static int[] intToArr(int page) {
        int[] arr = new int[LEN_NUMBER_OF_DIGITS];
        for (int i =0; i < arr.length; i++) {
            arr[i] = (page % (int) Math.pow(10, i + 1)) / (int) Math.pow(10, i);
        }
        return arr;
    }

    /**
     * 플레이어 페이지 점수 계산 메소드.
     */
    private static int calcScore(List<Integer> pages) {
        int score = Integer.MIN_VALUE;
        for (Integer page : pages) {
            score = Math.max(score, compareScore(intToArr(page)));
        }
        return score;
    }
}
package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    static final int LEN_NUMBER_OF_DIGITS = 3;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!verifyGame(pobi) || !verifyGame(crong)) {
            return -1;
        } else {
            return playGame(pobi, crong);
        }
    }

    private static int playGame(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = calcScore(pobi);
        int crongScore = calcScore(crong);

        return resultGame(pobiScore, crongScore);
    }

    private static int resultGame(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else {
            return 0;
        }
    }

    private static boolean verifyGame(List<Integer> list) {
        int leftPage = list.get(0);
        int rightPage = list.get(1);
        
        if (!verifyPageBoundary(leftPage, rightPage) || !verifyEdgePage(leftPage, rightPage) || !verifyContinuePage(leftPage, rightPage) || !verifyOddEven(leftPage, rightPage)) {
            return false;
        }
        return true;
    }

    private static boolean verifyOddEven(int leftPage, int rightPage) {
        if (leftPage % 2 != 1 || rightPage % 2 != 0) {
            return false;
        }
        return true;
    }

    private static boolean verifyContinuePage(int leftPage, int rightPage) {
        if (rightPage - leftPage != 1) {
            return false;
        }
        return true;
    }

    private static boolean verifyEdgePage(int leftPage, int rightPage) {
        if (leftPage == 1 || rightPage == 400) {
            return false;
        }
        return true;
    }

    private static boolean verifyPageBoundary(int leftPage, int rightPage) {
        if (leftPage < 1 || leftPage > 400 || rightPage < 1 || rightPage > 400) {
            return false;
        }
        return true;
    }

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

    private static int operPlus(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result += num;
        }
        return result;
    }

    private static int compareScore(int[] arr) {
        return Math.max(operMulti(arr), operPlus(arr));
    }

    private static int[] intToArr(int page) {
        int[] arr = new int[LEN_NUMBER_OF_DIGITS];
        for (int i =0; i < arr.length; i++) {
            arr[i] = (page % (int) Math.pow(10, i + 1)) / (int) Math.pow(10, i);
        }
        return arr;
    }

    private static int calcScore(List<Integer> pages) {
        int score = Integer.MIN_VALUE;
        for (Integer page : pages) {
            score = Math.max(score, compareScore(intToArr(page)));
        }
        return score;
    }
}
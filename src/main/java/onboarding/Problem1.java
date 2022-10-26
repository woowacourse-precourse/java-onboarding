package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isValid(pobi)) {
            return -1;
        }
        if (!isValid(crong)){
            return -1;
        }
        return getWinner(getPoint(pobi), getPoint(crong));
    }

    private static boolean isValid(List<Integer> pages) {
        if (pages.get(0) % 2 != 1 && pages.get(1) % 2 != 0) {
            return false;
        }
        if (pages.get(1) - pages.get(0) != 1) {
            return false;
        }
        return true;
    }

    private static int getWinner(int result, int result2) {
        if (result == result2) {
            return 0;
        } else if (result > result2) {
            return 1;
        } else {
            return 2;
        }
    }

    private static int getPoint(List<Integer> player) {
        int leftPage = player.get(0);
        int rightPage = player.get(1);
        return getMax(leftPage, rightPage);
    }

    private static int getMax(int leftPage, int rightPage) {
        return Math.max(getMax(leftPage), getMax(rightPage));
    }

    private static int getMax(int page) {
        int[] arrNum = toArr(page);

        return Math.max(getAddAll(arrNum), getMultiplyAll(arrNum));
    }

    private static int[] toArr(int page) {
        int[] arrNum = Stream.of(String.valueOf(page).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        return arrNum;
    }

    private static int getMultiplyAll(int[] arrNum) {
        int multiplyAll = 1;
        for (int i = 0; i < arrNum.length; i++) {
            multiplyAll *= arrNum[i];
        }
        return multiplyAll;
    }

    private static int getAddAll(int[] arrNum) {
        int addAll = 0;
        for (int i = 0; i < arrNum.length; i++) {
            addAll += arrNum[i];
        }
        return addAll;
    }
}
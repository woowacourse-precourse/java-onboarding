package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isValid(pobi) || !isValid(crong)) {
            return -1;
        }

        return getWinner(getPoint(pobi), getPoint(crong));
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
        return getMaxPage(player.get(0), player.get(1));
    }

    private static int getMaxPage(int leftPage, int rightPage) {
        return Math.max(getMax(leftPage), getMax(rightPage));
    }

    private static int getMax(int page) {
        return Math.max(getAddAll(toArr(page)), getMultiplyAll(toArr(page)));
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

    private static boolean isValid(List<Integer> pages) {
        //짝수 또는 홀수가 아닐때
        if (pages.get(0) % 2 != 1 && pages.get(1) % 2 != 0) {
            return false;
        }
        //서로 이어진 페이지가 아닐때
        if (pages.get(1) - pages.get(0) != 1) {
            return false;
        }
        //시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
        if (pages.get(0) >= 399 || pages.get(1) >= 400) {
            return false;
        }
        if (pages.get(0) <= 1 || pages.get(1) <= 2) {
            return false;
        }
        return true;
    }
}

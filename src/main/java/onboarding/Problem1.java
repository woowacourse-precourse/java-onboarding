package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobiPageList, List<Integer> crongPageList) {
        Integer pobiMaxNum = getMaxNumByPageList(pobiPageList);
        int crongMaxNum = getMaxNumByPageList(crongPageList);

        if (pobiMaxNum == -1 || crongMaxNum == -1) {
            return -1;
        }

        return pobiMaxNum.compareTo(crongMaxNum);
    }

    private static int getMaxNumByPageList(List<Integer> pageList) {
        int leftPage = pageList.get(0);
        int rightPage = pageList.get(1);

        if ((rightPage == leftPage + 1) && isRightPageNum(leftPage) && isRightPageNum(rightPage)) {
            return Math.max(getMaxNumByPage(leftPage), getMaxNumByPage(rightPage));
        } else {
            return -1;
        }
    }

    private static boolean isRightPageNum(int page) {
        return 1 <= page && page <= 400;
    }

    private static int getMaxNumByPage(int page) {
        String pageStr = String.valueOf(page);
        int maxPlusNum = 0;
        int maxMultiplyNum = 1;
        for (int i = 0; i < pageStr.length(); i++) {
            int tempNum = pageStr.charAt(i) - '0';

            maxPlusNum += tempNum;
            maxMultiplyNum *= tempNum;
        }

        return Math.max(maxPlusNum, maxMultiplyNum);
    }
}

package onboarding;

import java.util.List;

class Problem1 {
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION = -1;
    private static final int PAGE_LENGTH = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int sumPageNum(int pageNum) {
        int sum = 0;
        String pageNumStr = String.valueOf(pageNum);
        for (int i = 0; i < pageNumStr.length(); i++) {
            sum += pageNumStr.charAt(i) - '0';
        }
        return sum;
    }

    public static int multiplyPageNum(int pageNum) {
        int sum = 1;
        String pageNumStr = String.valueOf(pageNum);
        for (int i = 0; i < pageNumStr.length(); i++) {
            sum *= pageNumStr.charAt(i) - '0';
        }
        return sum;
    }

    public static int getMax(List<Integer> pages) {
        return 0;
    }

    public static int getWhoWin(int pobiNum, int crongNum) {
        if(pobiNum > crongNum) {
            return POBI_WIN;
        }
        if(pobiNum < crongNum) {
            return CRONG_WIN;
        }
        return DRAW;
    }

    public static boolean isValid(List<Integer> pobi, List<Integer> crong) {
        for (int i = 0; i < PAGE_LENGTH; i++) {
            int tmpPobiPageNum = pobi.get(i);
            int tmpCrongPageNum = crong.get(i);
            if(tmpPobiPageNum < 1 || tmpPobiPageNum > 400 || tmpCrongPageNum < 1 || tmpCrongPageNum > 400) {
                return false;
            }
        }

        if(pobi.get(0) == 1 || crong.get(0) == 1 || pobi.get(1) == 400 || crong.get(1) == 400) {
            return false;
        }

        int pobiPageGap = Math.abs(pobi.get(1) - pobi.get(0));
        int crongPageGap = Math.abs(crong.get(1) - crong.get(0));

        if(pobiPageGap != 1 || crongPageGap != 1) {
            return false;
        }
        return true;
    }
}


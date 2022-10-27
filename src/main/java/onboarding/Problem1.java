package onboarding;

import java.util.List;

class Problem1 {
    private final int POBI_WIN = 1;
    private final int CRONG_WIN = 2;
    private final int DRAW = 0;
    private final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public int sumPageNum(int pageNum) {
        int sum = 0;
        String pageNumStr = String.valueOf(pageNum);
        for (int i = 0; i < pageNumStr.length(); i++) {
            sum += pageNumStr.charAt(i) - '0';
        }
        return sum;
    }

    public int multiplyPageNum(int pageNum) {
        int sum = 1;
        String pageNumStr = String.valueOf(pageNum);
        for (int i = 0; i < pageNumStr.length(); i++) {
            sum *= pageNumStr.charAt(i) - '0';
        }
        return sum;
    }

    public int getWhoWin(int pobiNum, int crongNum) {
        if(pobiNum > crongNum) {
            return POBI_WIN;
        }
        if(pobiNum < crongNum) {
            return CRONG_WIN;
        }
        return DRAW;
    }

    public boolean isValid(List<Integer> pobi, List<Integer> crong) {

        return true;
    }
}


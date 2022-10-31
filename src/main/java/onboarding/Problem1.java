package onboarding;

import model.Reader;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 페이지 형식에 맞지 않을 경우 예외처리
        if (!isPageFormat(pobi) || !isPageFormat(crong)) {
            return -1;
        }
        Reader readerPobi = new Reader(pobi);
        Reader readerCrong = new Reader(crong);
        return pageGame(readerPobi.getMaxValue(), readerCrong.getMaxValue());
    }

    // 포비와 크롱의 페이지 게임 승자 유무 반환 메소드
    static int pageGame(int pobiMaxValue, int crongMaxValue) {
        if (pobiMaxValue > crongMaxValue) {
            return 1;
        } else if (pobiMaxValue < crongMaxValue) {
            return 2;
        } else {
            return 0;
        }
    }

    //페이지 형식이 맞는지 체크하는 메소드
    static boolean isPageFormat(List<Integer> page) {
        return page.get(0) + 1 == page.get(1);
    }
}
package onboarding;

/*
* 기능구현
* 1. 상수 설정
* 2. 제시된 책의 수 확인
* 3. 각 수를 더하거나, 곱하는 메소드 정의
* 4. 큰 수 반환
* */

import java.util.List;

class Problem1 {

    static final int POBI_WON = 1;
    static final int CRONG_WIN = 2;
    static final int DRAW = 0;
    static final int EXCEPTION = -1;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        if (checkArr(pobi) && checkArr(crong)) {
            int pobiMax = getBigNum(pobi);
            int crongMax = getBigNum(crong);

            if (pobiMax > crongMax) {
                return POBI_WON;
            } else if (crongMax > pobiMax) {
                return CRONG_WIN;
            } else {
                return DRAW;
            }
        } else {
            return EXCEPTION;
        }
    }

    public static int getBigNum(List<Integer> p) {
        int leftPage = p.get(0);
        int rightPage = p.get(1);
        return Math.max(mathMax(leftPage), mathMax(rightPage));
    }

    public static int mathMax(int pageNum) {
        String[] pageArr = String.valueOf(pageNum).split("");
        int add = 0;
        int multi = 1;
        for (String s : pageArr) {
            add += Integer.parseInt(s);
            multi *= Integer.parseInt(s);
        }
        return Math.max(add, multi);
    }

    public static boolean checkArr(List<Integer> arr) {
        for (Integer a : arr) {
            if (a < 1 || a > 400 || a == 1 || a == 399) {
                return false;
            }
        }
        return arr.get(1) - arr.get(0) == 1;
    }
}


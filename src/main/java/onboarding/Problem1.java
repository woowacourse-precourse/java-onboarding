/*
기능 목록
1. 예외처리 함수
2. 페이지 더하기 함수
3. 페이지 곱하기 함수
4. 값을 비교하여 더 큰 값을 return하는 함수
5. 크릉이와 포비 중 누가 이겼는지 return
*/
package onboarding;

import java.util.List;

class Problem1 {
    static final int POBI = 1;
    static final int CRONG = 2;
    static final int TIE = 0;
    static final int EXCEPTION = -1;
    static final int NOPROBLEM = 1;
    static final int LEFTPAGE = 0;
    static final int RIGHTPAGE = 1;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (gamerExceptionCheck(pobi) == EXCEPTION) {
            return EXCEPTION;
        }
        if (gamerExceptionCheck(crong) == EXCEPTION) {
            return EXCEPTION;
        }
        int pobiScore = listPageGetMax(pobi);
        int crongScore = listPageGetMax(crong);

        if (pobiScore < crongScore) {
            return CRONG;
        } else if (pobiScore > crongScore) {
            return POBI;
        } else {
            return TIE;
        }
    }

    public static int gamerExceptionCheck(List<Integer> gamer) {
        int leftPage = getPageLeftOrRight(gamer, LEFTPAGE);
        int rightPage = getPageLeftOrRight(gamer, RIGHTPAGE);
        try {
            if (leftPage <= 1 || leftPage >= 400) {
                throwException();
            }
            if (rightPage <= 1 || rightPage >= 400) {
                throwException();
            }
            if (leftPage % 2 == 0) {
                throwException();
            }
            if (rightPage - 1 != leftPage) {
                throwException();
            }
        }
        catch(Exception e) {
            return EXCEPTION;
        }
        return NOPROBLEM;
    }

    public static void throwException() throws Exception {
        throw new Exception();
    }

    public static int getPageLeftOrRight(List<Integer> gamer, int way) {
        return gamer.get(way);
    }

    public static int listPageGetMax(List<Integer> gamer) {
        int leftPageMax = pageGetMax(getPageLeftOrRight(gamer, LEFTPAGE));
        int rightPageMax = pageGetMax(getPageLeftOrRight(gamer, RIGHTPAGE));

        return compare(leftPageMax, rightPageMax);
    }

    public static int pageGetMax(int page){
        String stringPage = String.valueOf(page);
        int plusPage = plusPageDigit(stringPage);
        int multiPage = multiPageDigit(stringPage);

        return compare(plusPage, multiPage);
    }

    public static int plusPageDigit(String stringPage) {
        return stringPage.chars()
                .mapToObj(i -> (char)i)
                .mapToInt(Character::getNumericValue).sum();
    }

    public static int multiPageDigit(String stringPage) {
        return stringPage.chars()
                .mapToObj(i -> (char)i).mapToInt(Character::getNumericValue)
                .reduce(1, (a, b) -> a * b);
    }

    public static int compare(int score1, int score2) {
        return Math.max(score1, score2);
    }
}
package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    private static final int MIN_BOOK_PAGE = 1;
    private static final int MAX_BOOK_PAGE = 400;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int INVALID = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore = 0;
        int crongScore = 0;

        if (checkAllValidation(pobi, crong)) {
            pobiScore = getMaxScorePages(pobi);
            crongScore = getMaxScorePages(crong);

            answer = getProblemAnswer(pobiScore, crongScore);
        } else {
            answer = INVALID;
        }

        return answer;
    }

    private static boolean checkAllValidation(List<Integer> userA, List<Integer> userB) {
        return validation(userA) && validation(userB);
    }

    private static boolean validation(List<Integer> inputPage) {
        Integer leftPage = null;
        Integer rightPage = null;

        // 길이가 2인지 확인한다.
        if (inputPage.size() != 2) {
            return false;
        }

        // 정수라면 변수에 값을 설정해준다.
        try {
            leftPage = inputPage.get(0);
            rightPage = inputPage.get(1);
        } catch (Exception e) {
            return false;
        }

        // 왼쪽 페이지는 홀수이다.
        if (leftPage % 2 != 1) {
            return false;
        }

        // 오른쪽 페이지는 짝수이다.
        if (rightPage % 2 != 0) {
            return false;
        }

        // 연속된 숫자여야한다.
        if (rightPage - leftPage != 1) {
            return false;
        }

        // 시작 면이나 마지막 면이 나오지 않도록 해야 한다.
        // 왼쪽 페이지는 1페이지 ~ 400페이지가 나와야 한다.
        if (!(MIN_BOOK_PAGE <= leftPage && leftPage <= MAX_BOOK_PAGE)) {
            return false;
        }

        // 오른쪽 페이지는 1페이지 ~ 400페이지가 나와야 한다.
        if (!(MIN_BOOK_PAGE <= rightPage && rightPage <= MAX_BOOK_PAGE)) {
            return false;
        }

        return true;
    };

    private static Integer getMaxScorePages(List<Integer> playerPage) {
        Integer leftPage = playerPage.get(0);
        Integer rightPage = playerPage.get(1);

        Integer leftPageMaxScore = getMaxScoreCalculate(leftPage);
        Integer rightPageMaxScore = getMaxScoreCalculate(rightPage);

        Integer result = Math.max(leftPageMaxScore, rightPageMaxScore);

        return result;
    }

    private static Integer getMaxScoreCalculate(Integer page) {
        Integer additionScore = getAdditionScore(page);
        Integer multiplicationScore = getMultiplicationScore(page);

        Integer result = Math.max(additionScore, multiplicationScore);

        return result;
    }

    private static Integer getAdditionScore(Integer page) {
        List<Integer> pageList = integer2List(page);

        Integer result = pageList.stream().reduce(0, Integer::sum);

        return result;
    }

    private static Integer getMultiplicationScore(Integer page) {
        List<Integer> pageList = integer2List(page);

        Integer result = pageList.stream().reduce(1, (a, b) -> a * b);

        return result;
    }

    private static List<Integer> integer2List(Integer page) {
        String pageString = page.toString();
        List<Integer> pageList = new ArrayList<>();

        for(int i = 0; i < pageString.length(); i++) {
            pageList.add(pageString.charAt(i) - '0');
        }

        return pageList;
    }

    private static int getProblemAnswer(Integer userA, Integer userB) {
        int result = -1;

        if (userA > userB) {
            result = POBI_WIN;
        } else if (userA < userB) {
            result = CRONG_WIN;
        } else if (userA.equals(userB)) {
            result = DRAW;
        }

        return result;
    }
}
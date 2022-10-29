package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int fail = -1;

        if(checkPageContinuous(pobi, crong) == false) {
            return fail;
        }

        List<Integer> pobiLeftPage = seperatePageNumber(pobi.get(0));
        List<Integer> pobiRightPage = seperatePageNumber(pobi.get(1));
        List<Integer> crongLeftPage = seperatePageNumber(crong.get(0));
        List<Integer> crongRightPage = seperatePageNumber(crong.get(1));

        List<Integer> result1 = beforeScore(sumPageNumber(pobiLeftPage), multiflyPageNumber(pobiLeftPage));
        List<Integer> result2 = beforeScore(sumPageNumber(pobiRightPage), multiflyPageNumber(pobiRightPage));
        List<Integer> result3 = beforeScore(sumPageNumber(crongLeftPage), multiflyPageNumber(crongLeftPage));
        List<Integer> result4 = beforeScore(sumPageNumber(crongRightPage), multiflyPageNumber(crongRightPage));

        int result11 = maxPageNumber(result1);
        int result22 = maxPageNumber(result2);
        int result33 = maxPageNumber(result3);
        int result44 = maxPageNumber(result4);

        int pobiScore = score(result11, result22);
        int crongScore = score(result33, result44);

        int answer = result(pobiScore, crongScore);

        return answer;
    }

    //페이지의 자릿수 더한값과 곱한값을 담은 List를 리턴
    public static List<Integer> beforeScore(int page1, int page2) {
        List<Integer> beforeScore = new ArrayList<>();

        beforeScore.add(0, page1);
        beforeScore.add(1, page2);

        return beforeScore;
    }
    //페이지 숫자 쪼개는 메소드
    public static List<Integer> seperatePageNumber (int pageNumber) {
        List <Integer> pageNumberArray = new ArrayList();
        for (int i = 0; pageNumber > 0; i ++) {
            pageNumberArray.add(pageNumber % 10);
            pageNumber /= 10;
        }
        return pageNumberArray;
    }

    // 페이지 자릿수를 더해주는 메소드
    public static int sumPageNumber (List<Integer> pageNumberArray) {
        int pageSum = 0;
        for (int i = 0; pageNumberArray.size() > i; i++) {
            pageSum += pageNumberArray.get(i);
        }
        return pageSum;
    }

    //페이지 자릿수를 곱해주는 메소드
    public static int multiflyPageNumber (List<Integer> pageNumberArray) {
        int pageMultifly = 1;
        for(int i = 0; pageNumberArray.size() > i; i++) {
            pageMultifly *= pageNumberArray.get(i);
        }
        return pageMultifly;
    }

    // 자릿수 곱한거와 더한것중 가장 큰 수를 추출
    public static int maxPageNumber (List<Integer> beforeScore) {
        if ((beforeScore.get(0) > beforeScore.get(1))) {
            return beforeScore.get(0);

        } else if ((beforeScore.get(1) > beforeScore.get(0))) {
            return beforeScore.get(1);
        }

        return beforeScore.get(0);
    }

    //최종 각자의 점수 추출
    public static int score (int leftPage, int rightPage) {
        if (leftPage > rightPage) {
            return leftPage;

        } else if(rightPage > leftPage) {
            return rightPage;
        }

        return leftPage;
    }

    // 각자의 점수 비교후 결과값 리턴
    public static int result (int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;

        } else if (pobiScore < crongScore) {
            return 2;

        } else if (pobiScore == crongScore) {
            return 0;
        }

        return pobiScore;
    }

    //페이지가 연속되어있지 않는경우 확인
    public static boolean checkPageContinuous (List<Integer> pobiPage, List<Integer> crongPage) {
        boolean failCheck = false;
        boolean successCheck = true;

        if(pobiPage.get(0)+1 != pobiPage.get(1)) {
            return failCheck;
        }
        if(crongPage.get(0)+1 != crongPage.get(1)) {
            return failCheck;
        }

        return successCheck;
    }
}
package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(checkPageContinuous(pobi, crong) == false) {
            int checkFail = -1;
            return checkFail;
        }

        //각 페이지 자릿수 쪼개기
        List<Integer> pobiLeftPage = seperatePageNumber(pobi.get(0));
        List<Integer> pobiRightPage = seperatePageNumber(pobi.get(1));
        List<Integer> crongLeftPage = seperatePageNumber(crong.get(0));
        List<Integer> crongRightPage = seperatePageNumber(crong.get(1));

        // 자릿수 더한값과 자릿수 곱한값중 큰 값 추출
        int pobiLeftPageMax = Math.max(sumPageNumber(pobiLeftPage), multiflyPageNumber(pobiLeftPage));
        int pobiRightPageMax = Math.max(sumPageNumber(pobiRightPage), multiflyPageNumber(pobiRightPage));
        int crongLeftPageMax = Math.max(sumPageNumber(crongLeftPage), multiflyPageNumber(crongLeftPage));
        int crongRightPageMax = Math.max(sumPageNumber(crongRightPage), multiflyPageNumber(crongRightPage));

        //각자의 점수 추출
        int pobiScore = Math.max(pobiLeftPageMax, pobiRightPageMax);
        int crongScore = Math.max(crongLeftPageMax, crongRightPageMax);

        //누가 이겼는지 결과
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
        while(pageNumber > 0) {
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
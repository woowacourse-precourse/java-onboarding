package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
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
}
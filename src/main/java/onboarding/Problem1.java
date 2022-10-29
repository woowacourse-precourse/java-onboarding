package onboarding;

import java.util.*;

class Problem1 {
    static List <Integer> pageNumberArray = new ArrayList();
    static int pageSum = 0;
    static int pageMultifly = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    //페이지 숫자 쪼개는 메소드
    public static List<Integer> seperatePageNumber (int pageNumber) {
        for (int i = 0; pageNumber > 0; i ++) {
            pageNumberArray.add(pageNumber % 10);
            pageNumber /= 10;
        }
        return pageNumberArray;
    }

    // 페이지 자릿수를 더해주는 메소드
    public static int sumPageNumber (List<Integer> pageNumberArray) {
        for (int i = 0; pageNumberArray.size() > i; i++) {
            pageSum += pageNumberArray.get(i);
        }
        return pageSum;
    }

    //페이지 자릿수를 곱해주는 메소드
    public static int multiflyPageNumber (List<Integer> pageNumberArray) {
        for(int i = 0; pageNumberArray.size() > i; i++) {
            pageMultifly *= pageNumberArray.get(i);
        }
        return pageMultifly;
    }

    // 가장 큰 수를 추출
    public static int maxPageNumber (int sumNum, int multiflyNum) {
        int maxNumber = sumNum - multiflyNum;

        int seperateNumber = maxNumber > 0 ? 1 : 0;

        switch (seperateNumber) {
            case 1:
                return sumNum;
            case 0:
                return multiflyNum;
        }
        return maxNumber;
    }
}
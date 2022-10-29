package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    //페이지의 자릿수 더한값과 곱한값을 담은 List를 리턴
    public static List<Integer> test(List<Integer> page) {
        List<Integer> testList = new ArrayList<>();

        testList.add(0, multiflyPageNumber(page));
        testList.add(1, sumPageNumber(page));

        return testList;
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
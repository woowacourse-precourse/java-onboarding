package onboarding;

import java.util.*;

class Problem1 {
    static List <Integer> pageNumberArray = new ArrayList();

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
}
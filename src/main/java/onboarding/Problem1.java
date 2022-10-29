package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 1. 예외사항(두 페이지가 연속되지 않은 경우) -1 반환
        // 2. pobi의 점수 도출
        // 3. crong의 점수 도출
        // 4. pobi와 crong의 점수 비교
        // 5. 결과 값 반환
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            return -1;
        }

        int[] score = new int[4];
        score[0] = convertNumberPlus(pobi.get(0));
        score[1] = convertNumberMultiple(pobi.get(0));
        score[2] = convertNumberPlus(pobi.get(1));
        score[3] = convertNumberMultiple(pobi.get(1));

        Arrays.sort(score);

        int pobiScore = score[3];

        score[0] = convertNumberPlus(crong.get(0));
        score[1] = convertNumberMultiple(crong.get(0));
        score[2] = convertNumberPlus(crong.get(1));
        score[3] = convertNumberMultiple(crong.get(1));

        Arrays.sort(score);

        int crongScore = score[3];

        int answer = Integer.MAX_VALUE;
        return answer;
    }
    static int convertNumberPlus(int num) {
        String page = Integer.toString(num);
        int pagePlus = 0;
        for (int i = 0; i < page.length(); i++) {
            pagePlus += Integer.parseInt(String.valueOf(page.charAt(i)));
        }
        return pagePlus;
    }

    static int convertNumberMultiple(int num) {
        String page = Integer.toString(num);
        int pageMultiple = 1;
        for (int i = 0; i < page.length(); i++) {
            pageMultiple *= Integer.parseInt(String.valueOf(page.charAt(i)));
        }
        return pageMultiple;
    }
}
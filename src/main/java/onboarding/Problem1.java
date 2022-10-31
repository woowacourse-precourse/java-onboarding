package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //주어지는 책 페이지 검사하는 기능
        if (isCorrectBookPages(pobi, crong) == -1) {
            answer = -1;
            return answer;
        }


        return answer;
    }

    public static int isCorrectBookPages(List<Integer> pobi, List<Integer> crong) {
        //1.주어지는 책 페이지 검사하는 기능

        //1-1. 범위가 1~400인지
        for (int i = 0; i < 2; i++) {
            if (pobi.get(i) > 400 || pobi.get(i) < 1) {
                return -1;
            }
            if (crong.get(i) > 400 || crong.get(i) < 1) {
                return -1;
            }
        }
        //1-2. 오른쪽페이지가 왼쪽페이지보다 크거나 같은지
        if (pobi.get(0) >= pobi.get(1)) {
            return -1;
        }
        if (crong.get(0) >= crong.get(1)) {
            return -1;
        }
        //1-3. 오른쪽페이지와 왼쪽페이지의 차이가 1이 아닌지
        if (!(pobi.get(1) - pobi.get(0) == 1)) {
            return -1;
        }
        if (!(crong.get(1) - crong.get(0) == 1)) {
            return -1;
        }

        return 0;
    }



}
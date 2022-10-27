package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
//      시작면이나 마지막 면이 나오면 예외사항
        if (pobi.get(0) == 1 || pobi.get(0) == 399 || crong.get(0) == 1 || crong.get(0) == 399) {
            answer = -1;
        } else {
            if ((pobi.get(0) + 1 == pobi.get(1)) && (crong.get(0) + 1 == crong.get(1))) {
                someone(pobi);
                someone(crong);
//      5.점수를 비교해 가장 높은사람을 정하는 메서드
                if (someone(pobi) > someone(crong)) {
                    answer = 1;
                } else if (someone(pobi) < someone(crong)) {
                    answer = 2;
                } else {
                    answer = 0;
                }
            } else {
                answer = -1;
            }
        }
//      페이지 수가 맞지 않으면 예외사항
        return answer;
    }

//    2. Solution에서 한 사람의 페이지 번호를 받는 메서드
    public static int someone(List<Integer> bookNum) {
//      페이지List 받아서 String으로 쪼갬
        String[] leftpage = Integer.toString(bookNum.get(0)).split("");
        String[] rightpage = Integer.toString(bookNum.get(1)).split("");

//        int bookMax = Math.max(findMax(leftpage), findMax(rightpage));

        return Math.max(findMax(leftpage), findMax(rightpage));
    }

//    3. 2번에서 페이지 한쪽을 String[]으로 받아서 더하기 곱하기 비교.
//    4. 가장 큰 수를 본인의 점수로 한다.
    public static int findMax(String[] page) {
        int plus = 0;
        int multiply = 1;
        for (String i: page) {
            plus += Integer.parseInt(i);
            multiply = Integer.parseInt(i) * multiply;
        }
//        int Fin = Math.max(plus,multiply);

        return Math.max(plus,multiply);
    }

}
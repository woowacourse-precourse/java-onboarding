package onboarding;

import java.util.List;

class Problem1 {


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
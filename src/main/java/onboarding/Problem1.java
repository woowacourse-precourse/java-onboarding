package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        // 예외처리
        boolean err_status1 = validation(pobi);
        boolean err_status2 = validation(crong);

        if (!err_status1 || !err_status2) {
//            System.out.println("답은 " + answer);
            return answer;
        }

        // pobi와 crong의 max값 계산
        List<Integer> pobi_temp = calculate(pobi); // 각 페이지의 합계와 곱을 리스트로 반환
        List<Integer> crong_temp = calculate(crong); // 각 페이지의 합계와 곱을 리스트로 반환

        int pobi_max = Collections.max(pobi_temp);
        //System.out.println(pobi_max);
        int crong_max = Collections.max(crong_temp);
        //System.out.println(crong_max);

        // max값 비/
        if (pobi_max > crong_max) {
            answer = 1;
        } else if (pobi_max < crong_max) {
            answer = 2;
        } else {
            answer = 0;
        }

//        System.out.println("답은 " + answer);

        return answer;
    }

    static private List<Integer> calculate(List<Integer> value) {
        List<Integer> result = new ArrayList<>();

        for (int page : value) {
            int sum = 0;
            int mul = 1;

            String[] array = String.valueOf(page).split("");
            for (String val : array) {
                sum += Integer.valueOf(val);
                mul *= Integer.valueOf(val);
            }
            result.add(sum);
            result.add(mul);
//            System.out.println(result);
        }
        return result;
    }
    static private boolean validation(List<Integer> list) {

        boolean result = true;
        for (int page : list) {
            if (page == 1 || page == 400) {
                return false;
            }
        }

        if (1 != (list.get(1) - list.get(0))) {
            return false;
        } else if (list.get(0) % 2 != 1) {
            return false;
        } else {
            return result;
        }
    }


}
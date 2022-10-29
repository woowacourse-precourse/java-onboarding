package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        boolean isValid;

        // 예외 사항 처리 메소드 호출
        isValid = validData(pobi, crong);

        return answer;
    }

    // 예외 사항 처리 메소드
    static boolean validData(List<Integer> pobi, List<Integer> crong) {
        boolean isValid = true;

        // 페이지 번호가 범위 내인지 검증
        for(Integer page: pobi) {
            if (page < 0 | page > 400) {
                isValid = false;
                break;
            }
        }

        for(Integer page: crong) {
            if (page < 0 | page > 400) {
                isValid = false;
                break;
            }
        }

        // 페이지 번호의 차가 1인지 (서로 마주보고 있는 페이지인지 검증)
        if (pobi.get(1) - pobi.get(0) != 1) {
            isValid = false;
        } else if (crong.get(1) - crong.get(0) != 1) {
            isValid = false;
        }

        // 두 페이지의 번호가 홀수와 짝수인지
        if ((pobi.get(0) % 2 == 0) | (pobi.get(1) % 2 != 0)) {
            isValid = false;
        } else if ((crong.get(0) % 2 == 0) | (crong.get(1) % 2 != 0)) {
            isValid = false;
        }

        return isValid;
    }
}
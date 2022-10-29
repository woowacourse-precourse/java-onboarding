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

        return isValid;
    }
}
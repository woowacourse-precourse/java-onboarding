package onboarding;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Problem1 {

    // 기능 목록 1 : 예외사항 체크 함수
    public static boolean checkError(List<Integer> pages) {
        Boolean result = false;
        // 페이지의 형식이 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 아닐 경우
        if (pages.get(0) + 1 != pages.get(1)) {
            result = true;
        }
        // 시작 면이나 마지막 면이 나오도록 책을 펼친 경우
        if (pages.get(0) <= 1 || pages.get(1) >= 400) {
            result = true;
        }
        return result;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}
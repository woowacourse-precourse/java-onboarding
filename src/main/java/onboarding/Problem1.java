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

    // 기능 목록 2 : 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수(점수)를 구하는 함수
    public static int findMax(List<Integer> pages) {
        int result = Integer.MIN_VALUE;

        for (Integer p : pages) {
            int[] p_num = Stream.of(String.valueOf(p).split("")).mapToInt(Integer::parseInt)
                .toArray();

            result = Math.max(result, IntStream.of(p_num).sum());
            result = Math.max(result, multiple(p_num));
        }
        return result;
    }

    // 기능 목록 2-1 : 페이지 번호의 각 자리수를 모두 곱하는 함수
    public static int multiple(int[] num) {
        int result = 1;
        for (Integer i : num) {
            result *= i;
        }
        return result;
    }

    // 기능 목록 3 : 두 사람의 점수를 비교해 게임의 결과를 도출하는 함수
    public static int findResult(int pobi, int crong) {
        int result = -1;
        if (pobi > crong) {
            result = 1;
        }
        if (pobi < crong) {
            result = 2;
        }
        if (pobi == crong) {
            result = 0;
        }
        return result;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int maxPobi;
        int maxCrong;

        // 예외사항 처리
        if (checkError(pobi) || checkError(crong)) {
            return -1;
        }

        // 포비와 크롱의 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수(점수)를 구하기
        maxPobi = findMax(pobi);
        maxCrong = findMax(crong);

        // 두 사람의 점수를 비교해 게임의 결과를 도출하는 함수
        answer = findResult(maxPobi, maxCrong);

        return answer;
    }
}
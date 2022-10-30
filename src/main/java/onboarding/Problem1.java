package onboarding;

import java.util.List;

class Problem1 {

    // 각 자리수를 더한 것과 곱한 것 중 큰 것을 반환하는 함수
    private static int findMax(int page) {
        int sum = 0;
        int mul = 1;

        while(page > 0) { // 자리수를 줄여가며 각 자리수를 더해주고, 곱해준다.
            sum += page % 10;
            mul *= page % 10;
            page /= 10;
        }

        return Math.max(sum, mul); // 큰 값을 반환
    }

    // 문제에 대한 예외를 체크하는 함수
    private static boolean exception(List<Integer> list) {
        if (list.size() != 2) return true; // 리스트 크기가 2인지
        if (list.get(0) < 1 || list.get(0) > 400 || list.get(1) < 1 || list.get(1) > 400) return true; // 리스트의 요소가 1~400 사이인지
        if (list.get(0) % 2 != 1 || list.get(1) % 2 != 0) return true; // 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수인지
        if (list.get(1) - list.get(0) != 1) return true; // 왼쪽, 오른쪽 페이지가 1쪽 차이가 나는지
        return false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외처리
        if (exception(pobi) || exception(crong)) return -1;

        // pobi와 crong의 최대값을 구한다.
        int pobiMax = Math.max(findMax(pobi.get(0)), findMax(pobi.get(1)));
        int crongMax = Math.max(findMax(crong.get(0)), findMax(crong.get(1)));

        // 구한 최대값 비교 - 같으면 0, pobi가 크면 1, crong이 크면 2
        if (pobiMax == crongMax) answer = 0;
        else  answer = (pobiMax > crongMax) ? 1 : 2;

        return answer;
    }
}
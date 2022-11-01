package onboarding;

import java.util.List;

class Problem1 {
    // 각 숫자 더하는 알고리즘
    public static int pageSum(int pageNumber) {
        int result = 0;

        while (pageNumber != 0) {
            result += pageNumber % 10;
            pageNumber /= 10;
        }

        return result;
    }

    // 각 숫자를 모두 곱하는 알고리즙
    public static int pageMuliply(int pageNumber) {
        int result = 1;

        while (pageNumber != 0) {
            result *= pageNumber % 10;
            pageNumber /= 10;
        }

        return result;
    }

    // 각 사람의 최댓값을 계산하는 알고리즘
    public static int findMax(List<Integer> person) {
        int result = Math.max(pageSum(person.get(0)), pageMuliply(person.get(0)));
        result = Math.max(result, pageMuliply(person.get(1)));
        result = Math.max(result, pageSum(person.get(1)));

        return result;
    }

    // 페이지 수가 1씩 증가하는지 판단.
    public static boolean isError(List<Integer> pobi, List<Integer> crong) {
        // TODO [1,2], [399,400]은 펼치지 않음

        // 왼쪽 페이지가 홀수여야 함
        if (pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1) {
            return true;
        }

        // 오른쪽 페이지가 짝수여야 함
        if (pobi.get(1) % 2 != 0 || crong.get(1) % 2 != 0) {
            return true;
        }

        // 페이지가 범위 내의 값이여야 함
        if (!(1 < pobi.get(0) && pobi.get(0) < 400)) {
            return true;
        }
        if (!(1 < pobi.get(1) && pobi.get(1) < 400)) {
            return true;
        }
        if (!(1 < crong.get(0) && crong.get(0) < 400)) {
            return true;
        }
        if (!(1 < crong.get(1) && crong.get(1) < 400)) {
            return true;
        }

        // 1씩 증가해야 함
        if (pobi.get(0) + 1 != pobi.get(1)) {
            return true;
        }
        if (crong.get(0) + 1 != crong.get(1)) {
            return true;
        }

        return false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        // 1부터 시작되는 400 페이지 책
        // 왼쪽 페이지는 홀수
        // 오른쪽 페이지는 짝수

        // 1. 책을 임의로 펼침
        // 2. 왼쪽 페이지 번호 각 숫자를 더하거나, 모두 곱해 가장 큰 수
        // 3. 오른쪽 페이지 번호 각 숫자를 더하거나, 모두 곱해 가장 큰수
        // 큰 수를 본인의 점수
        // 높은 사람이 승자

        // 입력값 처리 : 왼쪽 페이지 번호 + 1 == 오른쪽 페이지 번호
        boolean pageError = isError(pobi, crong);

        // 입력받은 데이터에 문제가 있으면 -1 출력
        if (pageError) {
            return -1;
        }

        // 각 숫자 더하는 알고리즘
        // 모두 곱하는 알고리즘
        // 둘 중 최댓값을 반환하는 알고리즘

        int pobiMax = findMax(pobi);
        int crongMax = findMax(crong);

        if (pobiMax == crongMax) {
            answer = 0;
        } else if (crongMax < pobiMax) {
            answer = 1;
        } else if (pobiMax < crongMax) {
            answer = 2;
        }


        return answer;
    }

    public static void main(String[] args) {
        List<Integer> pobi = List.of(1, 2);
        List<Integer> crong = List.of(399, 400);
        System.out.println(solution(pobi, crong));
    }
}
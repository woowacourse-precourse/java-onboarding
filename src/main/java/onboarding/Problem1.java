package onboarding;

import java.util.ArrayList;
import java.util.List;

/* 기능 요구 사항 */
// 1. 책을 임의로 펼친다.
// 2. 각 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
// 3. 위 과정에서 가장 큰 수를 본인의 점수로 한다.
// 4. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
// 5. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
// -> 필요한 기능 1. randomPage 2. calculateScore 3. compareScore


class Problem1 {

    public static boolean isOdd(int num) {
        if (num % 2 == 1) return true;
        else return false;
    }

    public static List<Integer> randomPage() {

        List<Integer> page = new ArrayList<>();
        int left, right;

        // 왼쪽 페이지는 홀수
        do {
            left = (int)(Math.random() * 400);
        } while (isOdd(left));

        // 페이지 번호가 순서대로 들어 있으므로 오른쪽 페이지 = 왼쪽 페이지 + 1
        right = left + 1;

        // 리스트에 추가
        page.add(left);
        page.add(right);

        return page;

    }

    public static int calculateScore(List<Integer> page) {

        int result, left, right;
        List<Integer> score = new ArrayList<>();

        // (i = 0 - 왼쪽 페이지 / i = 1 : 오른쪽 페이지)
        for (int i = 0; i < 2; i++) {

            List<Integer> digit = new ArrayList<>();

            // 페이지 정보 읽기
            int page_info = page.get(i);

            // 페이지 파싱
            while (page_info > 0) {
                digit.add(page_info % 10);
                page_info /= 10;
            }

            // 각 자릿수의 합과 곱 비교
            score.add(compareSumWithMulByDigit(digit));

        }

        // 좌, 우 페이지 점수 비교 (0 : 좌 / 1 : 우)
        left = score.get(0);
        right = score.get(1);
        result = left >= right ? left : right;

        return result;
    }

    /* 각 자릿수 합과 곱 비교 메소드 */
    public static int compareSumWithMulByDigit(List<Integer> digit) {

        int sum_score, mul_score;

        sum_score = 0;
        mul_score = 1;

        for (int n : digit) {
            sum_score += n;
            mul_score *= n;
        }

        return sum_score >= mul_score ? sum_score : mul_score;

    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        /* 예외 처리 */
        // 1. R - L != 1 일 경우 예외 처리
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            answer = -1;
            return answer;
        }

        // 2. 첫 페이지(1) 또는 마지막 페이지(400)일 경우 예외 처리
        if (pobi.get(0) == 1 || crong.get(0) == 1 || pobi.get(1) == 400 || crong.get(1) == 400) {
            answer = -1;
            return answer;
        }

        return answer;

    }

    public static void main(String[] args) {

        List<Integer> pobi = new ArrayList<>();
        List<Integer> crong = new ArrayList<>();

        int pobi_score, crong_score, winner;

        /* 책을 임의로 펼친다 */
        pobi = randomPage();
        crong = randomPage();

        /* 점수 계산 : 각 페이지 자릿수 합셈과 곱셈 비교 후 가장 큰 조합을 점수로 설정 */
        pobi_score = calculateScore(pobi);
        crong_score = calculateScore(crong);


    }




}
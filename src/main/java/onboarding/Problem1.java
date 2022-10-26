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

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        return answer;

    }

    public static void main(String[] args) {

        List<Integer> pobi = new ArrayList<>();
        List<Integer> crong = new ArrayList<>();

        /* 책을 임의로 펼친다 */
        pobi = randomPage();
        crong = randomPage();


    }


}
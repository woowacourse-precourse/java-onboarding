package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    static int FIRST_PAGE_IDX = 1;
    static int LAST_PAGE_IDX = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        try {
            validate(pobi);
            validate(crong);

            int pobyScore = findMaxResult(pobi);
            int crongScore = findMaxResult(crong);

            answer = makeResult(pobyScore, crongScore);
        } catch (Exception e) {
            System.out.println("(Problem1) "+e.getMessage());
            answer = -1;
        }
        return answer;
    }

    private static int makeResult(int first, int second) throws Exception {
        if (first > second) {
            return 1;
        } else if (first < second) {
            return 2;
        } else if (first == second) {
            return 0;
        } else {
            throw new Exception("로직 에러");
        }
    }

    private static int findMaxResult(List<Integer> pages) {
        int leftPageIdx = pages.get(0);
        int rightPageIdx = pages.get(1);

        return Math.max(findEachPageMaxResult(leftPageIdx), findEachPageMaxResult(rightPageIdx));
    }

    private static int findEachPageMaxResult(int num) {
        //number의 자릿수를 배열에 넣는다
        List<Integer> digits = new ArrayList<>();
        while(num > 0) {
            digits.add(num % 10);
            num /= 10;
        }

        //digits의 전체 합과 전체 곱을 계산한다
        int sum = digits.stream().mapToInt(Integer::intValue).sum();
        int multi = digits.stream().reduce((first, second) -> first * second).get();

        return Math.max(sum, multi);
    }

    private static void validate(List<Integer> pages) throws Exception {
        if (pages.size() != 2) {
            throw new Exception("두개 이상의 숫자가 올 수 없습니다");
        }
        int leftPageIdx = pages.get(0);
        int rightPageIdx = pages.get(1);
        if (leftPageIdx + 1 != rightPageIdx) {
            throw new Exception("연속된 두 숫자가 와야합니다");
        }
        if (leftPageIdx < FIRST_PAGE_IDX || rightPageIdx > LAST_PAGE_IDX) {
            throw new Exception("페이지 범위 초과");
        }
        if (leftPageIdx % 2 != 1) {
            throw new Exception("페이지는 항상 음수로 시작합니다");
        }
    }
}
package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 problem1 = new Problem1();
        int answer = 0;

        try {
            // 왼쪽 페이지가 짝수거나, 페이지가 연결되지 않으면 -1 return;
            if (pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0) {
                answer = -1;
                return answer;
            }
            if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
                answer = -1;
                return answer;
            }
            answer = problem1.compareNumber(pobi, crong);
        } catch (NullPointerException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        } finally {
            return answer;
        }
    }

    // pobi의 값과 crong의 값을 비교하여 결과를 리턴
    public int compareNumber(List<Integer> pobi, List<Integer> crong) {
        int pobiNumber = returnBigNum(pobi);
        int crongNumber = returnBigNum(crong);

        if (pobiNumber == crongNumber) {
            return 0;
        } else if (pobiNumber > crongNumber) {
            return 1;
        } else {
            return 2;
        }
    }

    // 덧셈과 곱셈 비교 후 큰 수 리턴
    public int returnBigNum(List<Integer> people) {
        // 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        int leftPage;
        int rightPage;

        leftPage = Math.max(returnMulipleNum(people.get(0)), returnPlusNum(people.get(0)));
        rightPage = Math.max(returnMulipleNum(people.get(1)), returnPlusNum(people.get(1)));

        return Math.max(leftPage, rightPage);
    }

    // 각 자릿수를 더한 후 큰 수 반환
    public int returnPlusNum(int page) {
        int result = 0;

        while (page > 0) {
            result += page % 10;
            page /= 10;
        }

        return result;
    }

    // 각 자릿수를 곱하기 큰 수 반환
    public int returnMulipleNum(int page) {
        int result = 1;

        while (page > 0) {
            result *= page % 10;
            page /= 10;
        }

        return result;
    }
}
package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 problem1 = new Problem1();

        // 왼쪽 페이지가 짝수거나, 페이지가 연결되지 않으면 -1 return;
        if (pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0) {
            return -1;
        }
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            return -1;
        }
        return problem1.compareNumber(pobi, crong);
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
        int leftPage = 0;
        int rightPage = 0;

        if (returnMulipleNum(people.get(0)) > returnPlusNum(people.get(0))) {
            leftPage = returnMulipleNum(people.get(0));
        } else {
            leftPage = returnPlusNum(people.get(0));
        }

        if (returnMulipleNum(people.get(1)) > returnPlusNum(people.get(1))) {
            rightPage = returnMulipleNum(people.get(1));
        } else {
            rightPage = returnPlusNum(people.get(1));
        }

        if (leftPage > rightPage) {
            return leftPage;
        } else {
            return rightPage;
        }
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
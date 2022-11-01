package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 잘못된 페이지 입력 예외 처리
        if (!pageValidCheck(pobi) || !pageValidCheck(crong)) {
            return -1;
        }

        // pobi 가장 큰 수 구하기
        int pobiNum = getMaxValue(pobi);
        // crong 가장 큰 수 구하기
        int crongNum = getMaxValue(crong);

        // 두 수 비교
        if(pobiNum == crongNum) {
            return 0;
        }
        answer = pobiNum > crongNum ? 1 : 2;

        return answer;
    }

    private static int getMaxValue(List<Integer> list) {
        String left = String.valueOf(list.get(0));
        String right = String.valueOf(list.get(1));

        // 왼쪽 페이지 합, 곱 구하기
        int sum = 0;
        int mul = 1;
        for (int i = 0; i < left.length(); i++) {
            int leftNum = left.charAt(i) - '0';
            sum += leftNum;
            mul *= leftNum;
        }
        int leftMax = Math.max(sum, mul);

        // 오른쪽 페이지 합, 곱 구하기
        sum = 0;
        mul = 1;
        for (int i = 0; i < right.length(); i++) {
            int rightNum = right.charAt(i) - '0';
            sum += rightNum;
            mul *= rightNum;
        }
        int rightMax = Math.max(sum, mul);

        return Math.max(leftMax, rightMax);
    }

    private static Boolean pageValidCheck(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);

        if (left % 2 == 0 || right % 2 == 1)
            return false;

        if (left == 1 || right == 400)
            return false;

        if (left + 1 != right)
            return false;

        return true;
    }
}
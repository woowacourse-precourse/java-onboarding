package onboarding;

import java.util.List;

class Problem1 {

    public static void main(String args[]) {
        int a = solution(List.of(123, 124), List.of(125, 126));
        System.out.println(a);
    }

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

        // 두 수 비교 결과 저장
        if(pobiNum == crongNum) {
            return 0;
        }
        return answer;
    }

    private static int getMaxValue(List<Integer> list) {
        String left = String.valueOf(list.get(0));
        String right = String.valueOf(list.get(1));

        int sum = 0;
        int mul = 1;
        for (int i = 0; i < left.length(); i++) {
            int leftNum = left.charAt(i) - '0';
            sum += leftNum;
            mul *= leftNum;
        }
        int leftMax = Math.max(sum, mul);

        sum = 0;
        mul = 1;
        for (int i = 0; i < right.length(); i++) {
            int rightNum = right.charAt(i) - '0';
            sum += rightNum;
            mul *= rightNum;
        }

        int rightMax = Math.max(sum, mul);

        int value = Math.max(leftMax, rightMax);

        return value;
    }

    private static Boolean pageValidCheck(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);

        if (left % 2 != 0 || right != 1)
            return false;

        if (left == 1 || right == 400)
            return false;

        if (left + 1 != right)
            return false;

        return true;
    }
}
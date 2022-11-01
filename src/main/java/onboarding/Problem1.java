package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        try {
            checkPage(pobi, crong);
            int pobi_result = calMaximum(pobi);
            int crong_result = calMaximum(crong);

            if (pobi_result > crong_result) {
                answer = 1;
            } else if (pobi_result < crong_result) {
                answer = 2;
            } else {
                answer = 0;
            }
        } catch (IllegalStateException e) {
            answer = -1;
        }
        return answer;
    }

    public static int calMaximum(List<Integer> friend) {
        int result = 0;
        for (int i = 0; i < 2; i++) {
            String numStr = Integer.toString(friend.get(i));
            int[] numList = new int[numStr.length()];
            int sum = 0;
            int mul = 1;
            for (int j = 0; j < numStr.length(); j++) {
                numList[j] = numStr.charAt(j) - '0';
                sum += numList[j];
                mul *= numList[j];
                if (result < Math.max(mul, sum)) {
                    result = Math.max(mul, sum);
                }
            }
        }
        return result;
    }

    public static void checkPage(List<Integer> pobi, List<Integer> crong) {
        if (pobi.isEmpty() || crong.isEmpty()) {
            throw new IllegalStateException("입력된 값이 존재하지 않습니다.");
        } else if (pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0) {
            throw new IllegalStateException("왼쪽 페이지 번호는 홀수여야 합니다.");
        } else if (pobi.size() != 2 || crong.size() != 2) {
            throw new IllegalStateException("페이지 번호는 좌, 우로 총 2개여야 합니다.");
        } else if (Math.abs(pobi.get(1) - pobi.get(0)) != 1 || Math.abs(crong.get(1) - crong.get(0)) != 1) {
            throw new IllegalStateException("페이지 번호는 연속되어야 합니다.");
        } else if (pobi.get(0) < 1 || pobi.get(0) > 400 || crong.get(0) < 1 || crong.get(0) > 400) {
            throw new IllegalStateException("페이지 범위는 0~400입니다.");
        }
    }

}
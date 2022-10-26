package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    static int findSumMaximumValue(List<Integer> values) {
        int sumResult = 0;
        // 입력 값이 유효한 경우, 모든 자리 합의 경우 짝수 페이지가 무조건 크다.
        String stringValue = values.get(1).toString();
        for (int i = 0; i < stringValue.length(); i++) {
            sumResult += Integer.parseInt(String.valueOf(stringValue.charAt(i)));
        }
        return sumResult;
    }
}
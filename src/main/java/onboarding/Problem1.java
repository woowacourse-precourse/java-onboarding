package onboarding;

import java.util.List;

class RestrictException extends Exception {
    String exMsg;

    public RestrictException() {
    }

    public RestrictException(String message) {
        exMsg = "RestrictException: " + message;
    }
}

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}
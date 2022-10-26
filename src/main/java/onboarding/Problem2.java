package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        // 중복이 있으면 boolean으로 true일 때, 무한 반복문, false면 반복문 멈추고 리턴하자
        boolean check = true;
        while (check) {
            check = false;
            for (int i = 0; i <answer.length()-1 ; i++) {
                if (answer.charAt(i) == answer.charAt(i + 1)) {
                    check=true;
                    answer = answer.substring(0, i) + answer.substring(i+2);
                    i = 0;
                }
            }
            answer = answer;
        }

        return answer;
    }
}

package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        if (number < 1 || number > 10000) {
            throw new IllegalStateException("숫자는 1 이상, 10,000 이하여야 합니다.");
        } else {
            int[] gameNumbers = {3, 6, 9};
            for (int i = 1; i <= number; i++) {
                String numStr = Integer.toString(i);
                int currentNum;
                for (int j = 0; j < numStr.length(); j++) {
                    currentNum = numStr.charAt(j) - '0';
                    for (int k = 0; k < 3; k++) {
                        if (currentNum == gameNumbers[k]) {
                            answer++;
                        }
                    }
                }
            }
            System.out.println("number result");
            System.out.println(number + "  " + answer);

            return answer;
        }
    }
}

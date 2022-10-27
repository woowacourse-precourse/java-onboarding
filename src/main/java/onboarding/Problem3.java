package onboarding;

import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        int[] gameNumbers = {3, 6, 9};
        for (int i = 1; i <= number; i++) {
            String numStr = Integer.toString(i);
            System.out.println(numStr + "o");
            int currentNum = 0;
            for (int j = 0; j < numStr.length(); j++) {
                currentNum = numStr.charAt(j) - '0';
                System.out.println(numStr.length());
                System.out.println(numStr.charAt(j));
                System.out.println(currentNum);
                for (int k = 0; k < 3; k++) {
                    if (currentNum == gameNumbers[k]) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}

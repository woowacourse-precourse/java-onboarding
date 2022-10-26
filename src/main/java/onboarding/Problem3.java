package onboarding;

public class Problem3 {

    public static int clapCheck(int numIn) {
        int output = 0;

        String numStr = Integer.toString(numIn);
        int curNum;
        for (int i = 0; i < numStr.length(); i++) {
            curNum = numStr.charAt(i) - '0';
            if (curNum != 0) {
                if ((curNum % 3) == 0) output++;
            }
        }
        return output;
    }

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += clapCheck(i);
        }
        return answer;
    }
}

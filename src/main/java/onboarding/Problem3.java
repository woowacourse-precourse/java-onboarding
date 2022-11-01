package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }

        return answer;
    }

    private static int countClap(int number){
        int count = 0;
        String strNumber = Integer.toString(number);
        int[] arrNumberStr = new int[strNumber.length()];

        for (int i = 0; i < strNumber.length(); i++) {
            arrNumberStr[i] = strNumber.charAt(i) - '0';
            if (arrNumberStr[i] == 3){
                count++;
            } else if (arrNumberStr[i] == 6) {
                count++;
            } else if (arrNumberStr[i] == 9) {
                count++;
            }
        }

        return count;
    }
}

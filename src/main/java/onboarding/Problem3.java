package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i < number+1; i++) {
            String strNumber = Integer.toString(i);

            if (strNumber.contains("3") || strNumber.contains("6") || strNumber.contains("9")) {
                String[] strNum = strNumber.split("");

                answer = getAnswer(answer, strNum);
            }
        }
        return answer;
    }

    private static int getAnswer(int answer, String[] strNum) {
        for (int j = 0; j < strNum.length; j++) {
            if (strNum[j].equals("3") || strNum[j].equals("6") || strNum[j].equals("9")) {
                answer += 1;
            }
        }
        return answer;
    }
}
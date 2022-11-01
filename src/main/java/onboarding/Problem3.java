package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i=1;i<=number;i++)
            answer = answer + count(i);
        return answer;
    }

    /** number에서 3, 6, 9가 들어가는 횟수를 구한다. */
    private static int count(int number) {
        String strNum = String.valueOf(number);
        int count = 0;
        for (int i=0;i<strNum.length();i++) {
            char charNum = strNum.charAt(i);
            count = ((charNum=='3') || (charNum=='6') || (charNum=='9')) ? ++count : count;
        }

        return count;
    }
}

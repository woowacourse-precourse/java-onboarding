package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <=number; i++) {
            String num = String.valueOf(i);
            int numLen = num.length();
            for(int j = 0; j < numLen; j++) {
                if(num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9')
                    answer++;
            }
        }
        return answer;
    }
}

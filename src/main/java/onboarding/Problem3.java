package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 3; i <= number; i++){
            String tmpString = Integer.toString(i);
            answer += tmpString.length() - tmpString.replaceAll("[3|6|9]","").length();
        }

        return answer;
    }
}

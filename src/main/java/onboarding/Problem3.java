package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 0; i <= number; i++){
            String str = String.valueOf(i);
            answer += str.replaceAll("[^369]", "").length();
        }

        return answer;
    }
}

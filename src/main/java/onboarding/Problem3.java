package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (Integer i = 1; i <= number; i++){
            String iToString = i.toString();
            for (int j = 0; j < iToString.length(); j++){
                if (iToString.charAt(j) - '0' != 0 && iToString.charAt(j) % 3 == 0) answer += 1;
            }
        }

        return answer;
    }
}

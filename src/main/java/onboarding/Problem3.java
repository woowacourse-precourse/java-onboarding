package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i<(number+1); i++){
            String str = Integer.toString(i);
            for(int j = 0; j<str.length(); j++){
                if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
                    answer += 1;
                }
            }
        }

        return answer;
    }
}

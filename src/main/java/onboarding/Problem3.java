package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i < number+1; i++) {
            String temp = Integer.toString(i);
            for (int j = 0; j < temp.length(); j++){
                if (temp.charAt(j) == '3' || temp.charAt(j) == '6' || temp.charAt(j) == '9') {
                    answer++;
                }

            }
        }
        return answer;
    }
}

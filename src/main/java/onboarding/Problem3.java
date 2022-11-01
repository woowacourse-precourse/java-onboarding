package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i < number+1; i++){
            String num_str = String.valueOf(i);
            answer += num_str.length() - num_str.replace(String.valueOf("3"), "").length();
            answer += num_str.length() - num_str.replace(String.valueOf("6"), "").length();
            answer += num_str.length() - num_str.replace(String.valueOf("9"), "").length();
        }
        return answer;
    }
}

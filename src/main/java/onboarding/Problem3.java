package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=1; i<=number; i++){
            String num = Integer.toString(i);
            String[] nums = num.split("");
            for (String s : nums) {
                if (s.equals("3") || s.equals("6") || s.equals("9"))
                    answer += 1;
            }
        }
        return answer;
    }
}

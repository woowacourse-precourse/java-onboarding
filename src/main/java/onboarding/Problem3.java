package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i<=number; i++) {
            String NumToString = Integer.toString(i);
            for (String s : NumToString.split("")) {
                if (s.equals("3") || s.equals("6") || s.equals("9")) {
                    answer++;
                }
            }
        }
        return answer;
    }
}

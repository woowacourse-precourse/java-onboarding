package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        String num;

        for(int i=1; i<number+1; i++) {
            num = Integer.toString(i);
            for(char c: num.toCharArray()) {
                if (c=='3' || c=='6' || c=='9') {
                    answer ++;
                }
            }
        }

        return answer;
    }
}

package onboarding;

public class Problem3 {
    public static int solution(int number) {

        int answer = 0;
        for(int i=1; i<=number; i++) {
            answer += countClap(i);
        }
        return answer;
    }

    private static int countClap(int number) {
        String s = String.valueOf(number);
        int total = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '3' || s.charAt(i) == '6' || s.charAt(i) == '9') {
                total++;
            }
        }
        return total;
    }
}

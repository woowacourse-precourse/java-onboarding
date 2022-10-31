package onboarding;

public class Problem3 {
    public static int solution(int number) {
        String sum = "";

        for (int i=1; i<=number; i++) {
            String to_st = Integer.toString(i);
            sum += to_st;
        }

        int count = 0;
        for (int i = 0; i<sum.length(); i++) {
            if(sum.charAt(i) == '3' || sum.charAt(i) == '6' || sum.charAt(i) == '9') {
                count ++;
            }
        }

        int answer = count;
        return answer;
    }
}

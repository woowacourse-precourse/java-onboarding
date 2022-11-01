package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        String snumber = "";

        char n;
        for (int i=1; i <number+1; i++){
            snumber = Integer.toString(i);
            for (int j =0; j<snumber.length();j++){
                n = snumber.charAt(j);
                if (n == '3' || n == '6' || n == '9'){
                    answer++;
                }
            }
        }
        return answer;
    }
}

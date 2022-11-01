package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            answer += clap(i);
        }
        return answer;
    }

    private static int clap(int number){
        int clap = 0;
        String strNumber = Integer.toString(number);
        for(int i = 0; i < strNumber.length(); i++){
            if((strNumber.charAt(i) - '0') % 3 == 0 && strNumber.charAt(i) - '0' != 0){
                clap++;
            }
        }
        return clap;
    }
}

package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if(1 <= number && number < 10000){
            answer = clap(number);
        }
        return answer;
    }
    private static int clap(int number){
        int clap = 0;
        for(int i = 1; i < number + 1; i++){
            clap += count(i);
        }
        return clap;
    }
    private static int count(int num){
        int cnt = 0;
        String str = String.valueOf(num);
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c == '3' || c == '6' || c == '9'){
                cnt++;
            }
        }
        return cnt;
    }
}

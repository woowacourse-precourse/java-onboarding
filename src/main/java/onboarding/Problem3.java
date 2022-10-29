package onboarding;

public class Problem3 {
    static class Cal{
        public static int clap(int number){
            int answer = 0;
            for (int n = 1; n <= number; n++){
                String s = Integer.toString(n);
                for (int i = 0; i < s.length(); i++){
                    char c = s.charAt(i);
                    if (c == '3' || c == '6' || c == '9'){
                        answer += 1;
                    }
                }
            }
            return answer;
        }
    }
    public static int solution(int number) {
        return Cal.clap(number);
    }
}

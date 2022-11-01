package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            String num = Integer.toString(i);
            for(int j = 0; j < num.length(); j++){
                if(num.charAt(j) - '0' == 3
                        || num.charAt(j) - '0' == 6
                        || num.charAt(j) - '0' == 9){
                    answer += 1;
                }
            }
        }
        return answer;
    }
}

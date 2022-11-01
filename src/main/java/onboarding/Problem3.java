package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            String numStr = String.valueOf(i);
            int len = numStr.length();
            for(int j=0; j<len; j++){
                char numChar = numStr.charAt(j);
                if(numChar == '3' || numChar == '6' || numChar == '9'){
                    answer += 1;
                }
            }
        }
        return answer;
    }
}

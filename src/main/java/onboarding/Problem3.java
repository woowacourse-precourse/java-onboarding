package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            String NumToStr = String.valueOf(i);
            for(int j=0;j<NumToStr.length();j++){
                if(NumToStr.charAt(j) == '3' || NumToStr.charAt(j) == '6' || NumToStr.charAt(j) == '9') {
                    answer++;
                } else {
                    continue;
                }
            }
        }
        return answer;
    }
}

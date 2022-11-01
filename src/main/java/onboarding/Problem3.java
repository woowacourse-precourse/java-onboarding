package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            String numberString = Integer.toString(i);
            int length = numberString.length();
            for(int j = 0; j < length; j++){
                if(numberString.charAt(j) == '3' || numberString.charAt(j) == '6' || numberString.charAt(j) == '9'){
                    answer++;
                }
            }
        }
        return answer;
    }
}

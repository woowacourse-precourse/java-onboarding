package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 0; i < number + 1; i++){
            String numStr = String.valueOf(i);
            for(int j = 0; j < numStr.length(); j++){
                if(numStr.charAt(j) == '3'
                        || numStr.charAt(j) == '6' || numStr.charAt(j) == '9'){
                    ++answer;
                }
            }
        }

        return answer;
    }
}

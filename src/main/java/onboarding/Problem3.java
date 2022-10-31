package onboarding;

public class Problem3 {

    public boolean is369(int number) {

        return false;
    }

    public static int solution(int number) {
        int answer = 0;
        
        for(int i=1; i<=number; i++) {
            String numStr = Integer.toString(i);

            for(int j=0; j<numStr.length(); j++) {
                char digit = numStr.charAt(j);

                if(digit=='3' || digit=='6' || digit=='9') {
                    answer++;
                }
            }
        }

        return answer;
    }
}

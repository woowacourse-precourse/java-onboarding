package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=1; i<=number; i++) {
            String numberToStr = String.valueOf(i);
            for(int j=0; j<numberToStr.length(); j++) {
                if (numberToStr.charAt(j) == '3') answer += 1;
                if (numberToStr.charAt(j) == '6') answer += 1;
                if (numberToStr.charAt(j) == '9') answer += 1;
            }
        }

        return answer;
    }
}

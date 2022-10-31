package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=1; i <= number; i++){
            String numToStr = Integer.toString(i);
            answer += numToStr.length() - numToStr.replace("3","").replace("6","").replace("9","").length();
        }
        System.out.println(answer);
        return answer;
    }
}

package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1 ; i <= number ; i++){
            answer+=Integer.toString(i).replaceAll("[^3|6|9]","").length();
        }
        return answer;
    }
}

package onboarding;

public class Problem3 {
    public static final char[] array369 = {'3','6','9'};
    public static int solution(int number) {
        int answer = 0;
        for(int i = 0 ; i <= number ; i += 1) {
            char[] clone = ("" + i).toCharArray();
            answer += count369(clone);
        }
        return answer;
    }
    public static int count369(char[] arr) {
        int answer = 0;
        for(char c : arr) {
            for(char c369 : array369) {
                if(c == c369) answer += 1;
            }
        }
        return answer;
    }
}

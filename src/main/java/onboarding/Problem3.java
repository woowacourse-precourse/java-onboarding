package onboarding;

public class Problem3 {
    // 2. 1~nubmer까지 탐색하며 탐색하고 있는 숫자에 3, 6, 9가 몇 개 들어가는 지 센다.
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            String num = Integer.toString(i);
            answer += countChar(num, '3');
            answer += countChar(num, '6');
            answer += countChar(num, '9');
        }
        return answer;
    }
    // 1. 문자열에서 특정 문자 개수를 센다.
    public static int countChar(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

}

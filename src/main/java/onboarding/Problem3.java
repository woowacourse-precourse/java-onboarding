package onboarding;

public class Problem3 {

    // 3, 6, 9가 몇개 들어있는지
    static int countThreeSixNine(int num) {
        int cnt = 0;
        char[] eachDigit = String.valueOf(num).toCharArray();
        for(char digit : eachDigit) {
            if(digit == '3' || digit == '6' || digit == '9') {
                cnt += 1;
            }
        }
        return cnt;
    }

    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number;i++) {
            answer += countThreeSixNine(i);
        }
        return answer;
    }
}

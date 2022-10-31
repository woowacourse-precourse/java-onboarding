package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=1; i<=number; i++) {
            answer += countThreeSixNine(i);
        }

        return answer;
    }

    static int countThreeSixNine(int num) {
        String strNum = String.valueOf(num);

        int cnt = 0;
        for(int i=0; i<strNum.length(); i++) {
            Character charNum = strNum.charAt(i);
            if(charNum == '3' || charNum == '6' || charNum == '9' ) {
                cnt++;
            }
        }

        return cnt;
    }
}

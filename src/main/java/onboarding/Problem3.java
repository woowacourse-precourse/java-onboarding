package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++) {
            // 해당 숫자의 박수 횟수를 계산하여 결과에 더한다.
            answer += compute(i);
        }
        return answer;
    }

    // value 의 박수 횟수를 계산하여 return 한다.
    public static int compute(int value){
        int result = 0;
        for (int j = value; j > 0; j /= 10) {
            if (j % 10 == 3 || j % 10 == 6 || j % 10 == 9) result++;
        }
        return result;
    }
}

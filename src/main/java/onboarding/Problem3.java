package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++){
            answer += countThreeSixNine(i);
        }

        return answer;
    }

    static int countThreeSixNine(int n){
        int cnt = 0;
        while(n > 0){
            int firstDigit = n % 10;
            if(firstDigit == 3 || firstDigit == 6 || firstDigit == 9){
                cnt++;
            }
            n /= 10;
        }
        return cnt;
    }
}

package onboarding;

public class Problem3 {

    // 1 ~ number 까지 각 숫자의 3, 6, 9의 갯수를 카운트하여 리턴
    public static int getResult(int number) {
        int cnt = 0;

        for(int i=1; i<=number; i++) {
            int num = i;
            // 각 숫자의 3, 6, 9 갯수를 확인
            while(num > 0) {
                int temp = num % 10;
                if(temp == 3 || temp == 6 || temp == 9 ) cnt++;
                num /= 10;
            }
        }

        return cnt;
    }

    public static int solution(int number) {
        int answer = getResult(number);
        return answer;
    }
}

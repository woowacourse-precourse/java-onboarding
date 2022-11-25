package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // 1부터 number까지 반복하여 박수 횟수 누적
        for(int i=1; i<=number; i++) {
            answer += count(i);
        }

        return answer;
    }

    // 박수 횟수 세기
    public static int count(int num) {
        int cnt = 0;
        int temp = 0;

        while(num!=0) {
            temp = num%10;

            if(temp==3 || temp==6 || temp==9)
                cnt++;

            num /= 10;
        }

        return cnt;
    }
}

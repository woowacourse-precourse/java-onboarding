package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // num: 이번 차례에 해당하는 수
        // remain: 어떤 수를 10으로 나눈 나머지. 즉, 1의 자릿수
        // count: 현재까지 3, 6, 9가 나온 횟수
        int num, remain, count;

        count = 0;
        // 각 차례의 수마다 반복
        for(int i = 1; i <= number; i++) {
            num = i;

            while(num != 0) {
                remain = num % 10;
                // 1의 자릿수가 3, 6, 9라면 count +1
                if(remain == 3 || remain == 6 || remain == 9)
                    count++;
                num /= 10;
            }
        }
        answer = count;

        return answer;
    }
}

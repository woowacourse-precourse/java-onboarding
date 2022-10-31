package onboarding;

public class Problem3 {
    /* 기능구현
    1. 조건 : number는 1 이상 10,000 이하인 자연수이다.
    3 6 9의 개수만 알면 되기 때문에 %10, //10 연산을 반복하고 더이상 10으로 나누어지지 않는다면 while문을 탈출한다.
    * */

    public static int get369(int num){
        int result = 0;
        while (num != 0){
            int n = num % 10;
            if (n == 3 || n == 6 || n== 9){
                result += 1;
            }
            num /= 10;
        }
        return result;
    }
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i<= number; i++){
            answer += get369(i);
        }

        return answer;
    }
}


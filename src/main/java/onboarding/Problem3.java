package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;

        for(int i = 1 ; i <= number ; i++){ // 다른 방법 : dp를 통해서 점화식을 새운다면, 메모리의 용량을 줄일 수도 있다.

            int cnt = checkCnt369(i);

            if(cnt > 0){
                answer += cnt;
            }
        }

        return answer;
    }

    public static int checkCnt369(int num) {

        int result = 0;

        while(num > 0){

            int tmp = num % 10;

            if(tmp % 3 == 0 && tmp != 0){
                result++;
            }
            num /= 10;
        }

        return result;
    }
}

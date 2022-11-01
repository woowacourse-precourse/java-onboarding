package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = (number % 10) / 3;
        int start = 10000;
        while(start > 1){
            int n = number / start;
            if(n == 0){ start /= 10; continue; }


            //1. 3, 6, 9의 등장은 10까지는 3번 100까지는 60번 1000까지는 900번
            //10000까지는 12000번 등장한다. </br>
            //3,6,9의 등장 횟수 = (자리수 - 1) * 3 * (10^(자리수-1))
            int x = 0;
            int low_unit = start / 10;
            while(low_unit > 0){
                x += start*3/10;
                low_unit /= 10;
            }
            answer += x*n;

            // 2. 만약 제일 큰 자리수의 수가 3, 6, 9라면 0~ N % 10^자리수 만큼 박수를 치므로, (N%10^자리수) + 1 만큼 answer에 더해준다.
            int cur_unit = n / 3;
            if(n % 3 == 0) {
                answer += (number % start) + 1;
                cur_unit -= 1;
            }

            //3. 제일 윗자리수부터 하나씩 없애가면서 실행해준다.
            answer += cur_unit*start;
            number %= start;
            start /= 10;
        }
        return answer;
    }
}

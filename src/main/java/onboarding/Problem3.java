package onboarding;

public class Problem3 {
    // 1. 재귀로 풀이한다. 숫자를 1씩 증가하며 clap 함수로 박수 횟수를 계산한다.
    // 2. 특정 숫자를 10으로 나눠 자리수별로 확인한다. 3,6,9에 해당하면 cnt +1.
        // 만약 해당 숫자가 0이 될 경우(자리수를 다 확인함) 재귀에서 빠져나오면서 횟수를 return한다.
    public static int clap(int num, int cnt){
        if (num == 0)
            return cnt;
        if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9){
            cnt ++;
        }
        num /= 10;
        return clap(num, cnt);

    }
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1;  i <= number; i++){
            int current = i;
            answer = clap(current, answer);
        }

        return answer;
    }
}

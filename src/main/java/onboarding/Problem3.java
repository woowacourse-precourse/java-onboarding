package onboarding;
/*
* 1. 손뼉을 치는 횟수를 구하는 메소드 작성
* 2. 1부터 주어진 숫자까지 증가하며 결과 산출
* */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i<=number; i++){
            answer += clap(i);
        }
        return answer;
    }
    static int clap(int num){
        int cnt = 0;

        while(num > 0){
            if((num % 10) % 3 == 0 && (num % 10) / 3 >0){
                cnt++;
            }
            num /= 10;
        }
        return cnt;
    }
}

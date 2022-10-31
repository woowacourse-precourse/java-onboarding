package onboarding;

public class Problem3 {
    //num 에 3,6,9가 몇 번 들어갔는지 return 해주는 함수
    public static int cnt(int num){
        int tmp = num;
        int ret = 0;
        while(tmp != 0){
            int n = tmp % 10;
            if(n == 3 || n == 6 || n == 9) ret++;
            tmp /= 10;
        }
        return ret;
    }
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<= number; i++){
            answer += cnt(i);
        }
        return answer;
    }
}

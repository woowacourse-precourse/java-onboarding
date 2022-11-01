package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0,cnt;
        for(int i=1;i<=number;i++){
            cnt = isClap(i);
            if(cnt > 0)
                answer += cnt;
        }
        return answer;
    }
    public static int isClap(int x){
        int cnt = 0,digit;
        //자릿수가 3,6,9중 하나라면 cnt++
        for(int i=10;x * 10 >= i;i*=10){
            digit = x%i/(i/10);
            if(digit == 3 || digit == 6 || digit == 9)
                cnt++;
        }
        return cnt;
    }
}

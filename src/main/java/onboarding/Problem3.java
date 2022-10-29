package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            answer += getClapCnt(i);
        }
        return answer;
    }
    public static int getClapCnt(int num){
        int cnt=0;
        while(num > 0){
            int cur = num%10;
            if(is369(cur))
                cnt++;
            num/=10;
        }
        return cnt;
    }
    public static boolean is369(int num){
        if(num == 3 || num == 6 || num ==9){
            return true;
        }
        return false;
    }
}

package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
    public static int getClapCnt(int num){
        while(num > 0){
            int cur = num%10;
            num/=10;
        }
        return 0;
    }
    public static boolean is369(int num){
        if(num == 3 || num == 6 || num ==9){
            return true;
        }
        return false;
    }
}

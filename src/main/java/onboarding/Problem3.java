package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer=-1;
        if(checkLimit(number)) answer =count369(number);
        return answer;
    }

    /*
    문제 조건 사항 체크
     */
    private static boolean checkLimit(int num){
        //숫자 1부터 10000까지
        if(num>=1&&num<=10000) return true;
        return false;
    }
    /*
    숫자에서 3,6,9, 숫자 세기
     */
    private static int count369(int num){
        int cnt=0;
        for(int i=1;i<=num;i++){
            int temp=i;
            while(temp>0){
                if(temp%10==3||temp%10==6||temp%10==9){
                    cnt++;
                }
                temp/=10;
            }
        }
        return cnt;
    }
}

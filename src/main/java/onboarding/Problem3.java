package onboarding;

public class Problem3 {

    static int[] dp= new int[10005];

    //1~10000까지 dp 테이블을 생성하는 함수
    static void fillTable(int number){
        for(int i=1; i<=number; i++){
           int now = i;
           int cnt = 0;
           while (now>0){
               if(now%10 == 3||now%10 == 6||now%10 == 9)
                   cnt++;

               now /=10;
           }
           dp[i] = dp[i-1] +cnt;
        }
    }

    public static int solution(int number) {
        int answer = 0;

        //주어진 숫자에 손뼉을 몇번 쳐야하는지 dp 테이블에서 구하기
        fillTable(number);
        answer = dp[number];
        return answer;
    }
}

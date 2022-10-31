package onboarding;

public class Problem3 {
    static int return369(int a) {
        int result=0;
        int b = 0;
        while(a>0){
            b = a%10;
            a/=10;
            if(b == 3 || b == 6 || b == 9) {
                result++;
            }
        }
        return result;
    } // 숫자 하나에 대해 그 숫자에 369가 얼마나 포함되었는지 구함
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++) {
            answer += return369(i);
            //return369를 이용해서 1 부터 number까지 369의 수를 더해감
        }
        return answer;
    }
}

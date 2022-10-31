package onboarding;

/*제한사항 : number 1은 10000이하인 자연수
기능 목록
1. number보다 작은 모든 수를 확인한다. (2자리수 이상일 경우 그 자리수의 숫자도 확인한다)
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int i;
        for(i = 1;i<=number;i++){
            int t = i;
            while(t>0){
                if((t%10 != 0) &&((t%10)%3 == 0)) answer ++;
                t/= 10;
            }
        }
        return answer;
    }
}

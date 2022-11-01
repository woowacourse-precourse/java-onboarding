package onboarding;

public class Problem3 {

    // 기능 목록 1 : 해당 숫자의 손뼉 치는 횟수를 구하는 함수
    public static int clap(int num){
        int result = 0;
        while(num>0){
            if(num%10==3 ||num%10==6||num%10==9){
                result += 1;
            }
            num /= 10;
        }
        return result;
    }
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}

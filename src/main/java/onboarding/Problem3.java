package onboarding;

/**
 * 기능목록
 * 1. 369게임 진행
 * 2. 손뼉 확인
 * 3. 손뼉! 짝!
 * */
public class Problem3 {
    private static int crap;
    public static int solution(int number) {
        int answer = 0;

        playGame(number);
        return answer;
    }

    static void playGame(int number){
        crap=0;
        for(int i=1; i<=number; i++){
            decideCrap(i);
        }
    }

    static void decideCrap(int num){
        while(num>0){
            if(num%10==3||num%10==6||num%10==9){

            }
            num/=10;
        }
    }
}

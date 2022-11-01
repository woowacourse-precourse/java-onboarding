package onboarding;

public class Problem3 {
    //주어진 숫자에 포함된 3, 6, 9의 개수를 반환해주는 함수
    private static int count_369(int num){
        int count = 0;
        while(num >= 1){
            if (num%10 == 3 || num%10 == 6 || num%10 == 9){
                count += 1;
            }
            num /= 10;
        }
        return count;
    }

    public static int solution(int number) {
        int count = 0;

        //1부터 주어진 수 까지 369게임을 진행했을 때 손뼉을 친 횟수를 구한다.
        for(int i = 1; i<=number; i++){
            count += count_369(i);
        }

        return count;
    }
}

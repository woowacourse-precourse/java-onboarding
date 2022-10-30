package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = count(number);
        return answer;
    }

    public static int count(int num){ // 손뼉 치는 횟수를 구하는 함수
        int ret = 0;
        for(int i = 1; i <= num; i++){
            int a = i;
            while(a != 0){
                if(a % 10 == 3 || a % 10 == 6 || a % 10 == 9){
                    ret++;
                }
                a /= 10;
            }
        }
        return ret;
    }
}

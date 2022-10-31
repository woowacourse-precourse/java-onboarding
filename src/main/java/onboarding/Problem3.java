package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        // 1부터 number까지 count369의 합을 더하여 반환
        for (int i=1; i<=number; i++){
            answer += count369(i);
        }
        return answer;
    }

    // 숫자 n에 3,6,9가 몇개 들어있는지 리턴하는 함수 count369()
    private static int count369(int n){
        int sum = 0;
        while(n>0){
            if(n%10==3 || n%10==6 || n%10==9) sum++;
            n/=10;
        }
        return sum;
    }
}

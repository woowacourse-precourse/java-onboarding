package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=0; i<=number; i++){
            int a = i / 100; // 백의 자릿수
            int b = (i / 10) % 10; // 십의 자릿수
            int c = i % 10;
            if(a==3 || a==6 || a==9){
                answer++;
            }
            if(b==3 || b==6 || b==9){
                answer++;
            }
            if(c==3 || c==6 || c==9){
                answer++;
            }
        }
        return answer;
    }
}

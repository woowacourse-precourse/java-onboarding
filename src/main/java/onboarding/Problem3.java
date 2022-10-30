package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int i;
        int answer = 0;
        for(i=1;i<= number;i++){
            if(i/10 == 3 || i/10 == 6 || i/10 == 9)
                answer++;
            if(i%10 == 3|| i%10 == 6 || i%10 == 9)
                answer++;
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        int answer = solution(43);
    }
}

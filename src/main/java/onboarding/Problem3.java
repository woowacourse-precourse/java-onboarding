package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=0; i<=number; i++){
            answer += countClaps(i);
        }

        return answer;
    }

    public static int countClaps(int num){
        int count = 0;

        while(num > 0){
            int  n = num%10;
            if(n == 3 || n == 6 || n == 9) count+=1;
            num /= 10;
        }

        return count;
    }
}

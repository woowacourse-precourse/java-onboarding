package onboarding;

public class Problem3 {
    public static int check(int number){
        int count = 0;

        if(number < 1 || number > 10000){
            return -1;
        }

        for(int i = 1; i <= number; i++){
            count += solution(i);
        }
        return count;
    }

    public static int solution(int number) {
        int answer = 0;

        for (int i = 0; i <= number; i++) {
            int x = i%10;
            int y = i/10;

            if(x==3||x==6||x==9) {
                if((y==3||y==6||y==9))
                    answer += 2;
                else
                    answer += 1;
            } else if(y==3||y==6||y==9){
                answer += 1;
            }

        }
        return answer;
    }
}

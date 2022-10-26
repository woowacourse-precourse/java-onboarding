package onboarding;

public class Problem3 {

    public static int count(int number){
        int res = 0;
        while(number != 0){
            int tmp = number%10;
            if(tmp == 3 || tmp == 6 || tmp == 9)
                res++;
            number/=10;
        }
        return res;

    }


    public static int solution(int number) {
        int answer = 0;

        for(int i=1; i<=number; i++){
            answer += count(i);
        }

        return answer;
    }
}

package onboarding;

public class Problem3 {

    private static int answer;

    public static int solution(int number) {

        answer = 0;

        game(number);

        return answer;
    }

    public static void game(int number){
        for(int i=1;i<=number;i++){
            int num = i;
            while(num > 0){

                if(isHavingThreeOrSixOrTen(num))
                    answer += 1;

                num /= 10;
            }
        }
    }

    public static boolean isHavingThreeOrSixOrTen(int num){

        if(num % 10 == 3)
            return true;

        if(num % 10 == 6)
            return true;

        return num % 10 == 9;
    }
}

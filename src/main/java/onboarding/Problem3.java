package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if(!err_check(number))
            return -1;
        else
            number = game(number);
         return number;
    }

    private static boolean err_check(int number){
        //only one constraint
        if(number < 1 || number > 10000)
            return false;
        else
            return true;
    }

    private static int game(int number){
        int result = 0, n;
        //counting from 1 to given number
        for(int i=1;i<=number;i++){
            n = i;
            while(n > 0){
                if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9)
                    result++;
                n /= 10;
            }
        }
        return result;
    }
}

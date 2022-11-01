package onboarding;

public class Problem3 {
    public static int count(int number){
        int claps = 0;
        while (number > 0){
            if (number % 10 == 3 || number %10 == 6 || number %10 == 9)
                claps+= 1;
            number /= 10;
        }
        return claps;
    }

    public static int solution(int number) {
        int sum = 0;

        for(int i = 1; i <= number; i++){
            sum += count(i);
        }

        return sum;
    }
}

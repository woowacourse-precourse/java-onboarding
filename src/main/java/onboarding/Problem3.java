package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int num=1; num <= number; num++) {
            answer += calculClaps(num);
        }
        return answer;
    }

    public static int calculClaps(int number) {
        int claps=0;

        while(number!= 0) {
            int num = number % 10;
            number /= 10;

            if (num == 3 || num == 6 || num == 9) {
                claps++;
            }
        }

        return claps;
    }

}

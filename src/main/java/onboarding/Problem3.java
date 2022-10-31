package onboarding;

public class Problem3 {
    static int gameStart(int number){
        int number_of_claps = 0;
        for (int current_number=1;current_number<=number;current_number++) {
            number_of_claps += countNumberOfClaps(current_number);
        }
        return number_of_claps;
    }
    static int countNumberOfClaps(int current_number) {
        int number_of_claps_for_current_number = 0;
        while (current_number > 0){
            number_of_claps_for_current_number += is369(current_number%10);
            current_number /= 10;
        }
        return number_of_claps_for_current_number;
    }

    static int is369(int num) {
        return (num == 3 || num == 6 || num == 9) ? 1 : 0;
    }

    public static int solution(int number) {
        int answer = gameStart(number);
        return answer;
    }
}

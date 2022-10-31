package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    private static boolean check_number_range(int number) {
        if (number > 10000 || number < 1)
            return false;
        return true;
    }
    public static int num_to_clap(int number){
        List<Integer> digits = new ArrayList<Integer>();
        int clap = 0;

        int_to_digits(number, digits);
        clap = getClap(digits, clap);
        return clap;
    }

    private static void int_to_digits (int number, List<Integer> digits) {
        while (number > 0) {
            digits.add(number % 10); // 각 자리를 digits 배열에 저장
            number = number / 10;
        }
    }

    private static int getClap(List<Integer> digits, int clap) {
        for (int j = 0; j< digits.size(); j++){
            if (digits.get(j) % 3 == 0 && digits.get(j) != 0)
                clap++;
        }
        return clap;
    }


    public static int solution(int number) {
        int answer = 0;

        if (!check_number_range(number))
            return (0);
        for (int i = 1; i <= number; i++)
            answer += num_to_clap(i);
        return answer;
    }


}

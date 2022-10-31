package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }
        return answer;
    }
    public static Integer countClap(Integer number) {
        List<Integer> threeSixNine = new ArrayList<>(Arrays.asList(3, 6, 9));
        int clap= 0;
        while (number > 0) {
            //자릿수 분리
            int check = number % 10;
            number /= 10;
            //3, 6, 9 있으면 박수
            clap = increaseClap(check, clap);
        }
        return clap;
    }

    public static Integer increaseClap(Integer check, Integer clap) {
        List<Integer> threeSixNine = new ArrayList<>(Arrays.asList(3, 6, 9));
        if (threeSixNine.contains(check)) {
            clap+=1;
        }
        return clap;
    }
}

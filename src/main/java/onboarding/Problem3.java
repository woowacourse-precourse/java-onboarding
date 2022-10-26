package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += CountClap(i);
        }
        return answer;
    }
    public static Integer CountClap(Integer number) {
        List<Integer> threeSixNine = new ArrayList<>(Arrays.asList(3, 6, 9));
        int clap= 0;
        while (number > 0) {
            //자릿수 분리
            int check = number % 10;
            number /= 10;
            //3, 6, 9 있으면 박수
            if (threeSixNine.contains(check)) {
                clap+=1;
            }
        }
        return clap;
    }
}

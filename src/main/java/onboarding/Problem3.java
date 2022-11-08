package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        int[] clap = new int[number+1];
        List<Integer> entry = Arrays.asList(3,6,9);

        int quotient;
        int remainder;

        for (int i=1; i<number+1; i++){
            if (i<10){
                if (entry.contains(i)){
                    clap[i]++;
                }

            } else if (i<100) {
                quotient = i/10;
                remainder = i%10;

                if (entry.contains(quotient)) {
                    clap[i]++;
                }
                clap[i]+=clap[remainder];

            } else if (i<1000) {
                quotient = i/100;
                remainder = i%100;

                if (entry.contains(quotient)) {
                    clap[i]++;
                }
                clap[i]+=clap[remainder];

            } else if (i<10000) {
                quotient = i/1000;
                remainder = i%1000;

                if (entry.contains(quotient)) {
                    clap[i]++;
                }
                clap[i]+=clap[remainder];
            }

            answer+=clap[i];
        }

        return answer;
    }
}

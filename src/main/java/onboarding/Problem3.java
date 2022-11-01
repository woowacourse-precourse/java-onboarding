package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static List<Integer> claps = new ArrayList<>();

    public static int clap(int number){
        claps.add(0);
        if(number < 1 || number > 10000){
            return -1;
        }


        for(int i = 1; i < 10000; i++){
            int tmp = i;
            int count = 0;
            while(tmp != 0) {
                if ((tmp%10)==3 || (tmp%10)==6 || (tmp%10)==9) {
                    count++;
                }
                tmp /=10;
            }

            claps.add(claps.get(claps.size()-1) + count);
        }
        return claps.get(number);
    }
    public static int solution(int number) {

        int answer = clap(number);
        return answer;
    }
}

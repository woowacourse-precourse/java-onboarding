package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        pobi = new ArrayList<>();
        crong = new ArrayList<>();

        pobi.add(randomPage());
        pobi.add(randomPage()+1);

        crong.add(randomPage());
        crong.add(randomPage()+1);

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static Integer randomPage(){
        Random random = new Random();
        Integer randomPage  = 0;
        randomPage = 2*random.nextInt(401)+1;
        return randomPage;
    }
}
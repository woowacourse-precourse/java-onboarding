package onboarding;

import java.util.List;
import java.util.Random;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {


        int[] pobi = new int[2];
        int[] crong = new int[2];

        Random rand = new Random();

        pobi[0] = rand.nextInt(399) +1;

        while ((pobi[0] != 1) && (pobi[0] != 399)){
            pobi[0] = rand.nextInt(399) +1;
        }

        pobi[1] = pobi[0] + 1;

        int pobileftsum = 0;

        int num = pobi[0];
        while(num!=0){
            pobileftsum += num%10;
            num /= 10;
        }

        int pobirightsum = 0;

        int num = pobi[1];
        while(num!=0){
            pobirightsum += num%10;
            num /= 10;
        }

        if



        crong[0] = rand.nextInt(400) +1;
        crong[1] = crong[0] + 1;


        int answer = Integer.MAX_VALUE;
        return answer;
    }
}
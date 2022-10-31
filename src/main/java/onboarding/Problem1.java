package onboarding;

import java.util.List;
import static java.lang.Math.abs;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int maxpobi = 0;
        int maxcrong = 0;

        if (abs(pobi.get(0) - pobi.get(1)) != 1) {
            answer = -1;
        } else if (abs(crong.get(0) - crong.get(1)) != 1) {
            answer = -1;
        } else {
            maxpobi = maxNum(sum(pobi.get(0)), sum(pobi.get(1))
                    , multi(pobi.get(0)), multi(pobi.get(1)));

            maxcrong = maxNum(sum(crong.get(0)), sum(crong.get(1))
                    , multi(crong.get(0)), multi(crong.get(1)));

            if(maxpobi > maxcrong){
                answer = 1;
            } else if(maxcrong > maxpobi){
                answer = 2;
            } else if(maxcrong == maxpobi) {
                answer = 0;
            }
        }

        return answer;
    }

    public static int sum(int a) {
        int s = 0;
        while(a != 0){
            s += a%10;
            a /= 10;
        }

        return s;
    }

    public static int multi(int a) {
        int s = 1;
        while(a != 0){
            s *= a%10;
            a /= 10;
        }

        return s;
    }

    public static int maxNum(int a, int b, int c, int d) {

        int max = a;
        if (max < b)
            max = b;
        if (max < c)
            max = c;
        if (max < d)
            max = d;

        return max;
    }
}
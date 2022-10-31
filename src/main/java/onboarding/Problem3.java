package onboarding;

import java.util.List;

public class Problem3 {

    private static List<Integer> lst369(Integer n) {
        List<Integer> lst369 = List.of(3);
        for(int i=0; i<n-1; i++) {
            lst369.add(lst369.get(i)*10 + (int)Math.pow(10, i)*3);
        }
        return lst369;
    }


    public static int solution(int n) {

        if (n < 1) return 0;

        int length = (int) Math.log10(n);
        int tmp = 0, res = 0;
        int eachNum, q3EachNum;
        List<Integer> lst369 = lst369(length);


        // 0 부터 10^1 - 1까지 369 개수 합, 10^1 ~ 10^2-1까지 369 개수 합, ...

        for(int i = length; i>0; i--) {

            tmp = (int) Math.pow(10, i);
            eachNum = n/tmp;
            q3EachNum = eachNum/3;
            res += eachNum * lst369.get(i-1);

            if(q3EachNum>0) {
                for (int j=0; j < q3EachNum-1; j++){
                    res += tmp;
                }
                res += n%tmp + 1;
            }
            n %= tmp;
        }
        res += n/3;

        return res;
    }
}

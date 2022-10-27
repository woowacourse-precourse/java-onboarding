package onboarding;

import java.util.List;

class Problem1 {
    private static int sum(Integer n) {
        int ret = 0;

        while(n > 0) {
            ret += n % 10;
            n /= 10;
        }

        return ret;
    }

    private static int mul(Integer n) {
        int ret = 1;

        while(n > 0) {
            ret *= n % 10;
            n /= 10;
        }

        return ret;
    }

    private static int max(List<Integer> list) {
        int ret = 0;

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) % 2 == i)
                return -1;

            int s = sum(list.get(i)), m = mul(list.get(i));

            if(ret < s)
                ret = s;
            if(ret < m)
                ret = m;
        }

        return ret;
    }

    private static boolean gap(List<Integer> list) {
        return list.get(1) - list.get(0) != 1;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(pobi.size() != 2 || crong.size() != 2)
            return -1;
        if(gap(pobi) || gap(crong))
            return -1;

        int p = max(pobi), c = max(crong);

        if(p == -1 || c == -1)
            return -1;

        if(p < c)
            return 2;
        if(c < p)
            return 1;
        return 0;
    }
}
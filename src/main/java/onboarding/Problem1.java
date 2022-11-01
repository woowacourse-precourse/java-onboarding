package onboarding;

import java.util.List;

class Problem1 {
    public static boolean IsException(List<Integer> pobi, List<Integer> crong)
    {
        if (pobi.size() != 2 || crong.size() != 2)
            return true;
        for (Integer page : pobi)
            if (page < 1 || page > 400)
                return true;
        for (Integer page : crong)
            if (page < 1 || page > 400)
                return true;
        if ((pobi.get(0) % 2 != 1) || (crong.get(0) % 2 != 1))
            return true;
        if ((pobi.get(0) + 1 != pobi.get(1)) || (crong.get(0) + 1 != crong.get(1)))
            return true;
        return false;
    }

    public static int GetMaxValue(int val)
    {
        int sum = 0, mul = 1;
        while (val != 0)
        {
            sum += val % 10;
            mul *= val % 10;
            val /= 10;
        }
        return sum > mul ? sum : val;
    }
    public static int GetMaxValue(int page1, int page2)
    {
        int p1 = GetMaxValue(page1);
        int p2 = GetMaxValue(page2);
        return p1 > p2 ? p1 : p2;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (IsException(pobi, crong))
            return -1;
        int pobiScore = GetMaxValue(pobi.get(0), pobi.get(1));
        int crongScore = GetMaxValue(crong.get(0), crong.get(1));
    }
}
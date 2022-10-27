package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(pobi.get(0) % 2 == 0) return -1;
        if(crong.get(0) % 2 == 0) return -1;
        if(pobi.get(0) + 1 != pobi.get(1)) return -1;
        if(crong.get(0) + 1 != crong.get(1)) return -1;

        int [] left = new int [] {0,1,0,1};
        int [] right = new int [] {0,1,0,1};

        for(int i = pobi.get(0); i > 0; i = i / 10)
        {
            int cur = i % 10;
            left[0] += cur;
            left[1] *= cur;
        }

        for(int i = pobi.get(1); i > 0; i = i / 10)
        {
            int cur = i % 10;
            left[2] += cur;
            left[3] *= cur;
        }

        for(int i = crong.get(0); i > 0; i = i / 10)
        {
            int cur = i % 10;
            right[0] += cur;
            right[1] *= cur;
        }

        for(int i = crong.get(1); i > 0; i = i / 10)
        {
            int cur = i % 10;
            right[2] += cur;
            right[3] *= cur;
        }
        int left_max = left[0];
        int right_max = right[0];

        for(Integer e: left) if(e > left_max) left_max = e;
        for(Integer e: right) if(e > right_max) right_max = e;

        if(left_max > right_max) return 1;
        if(left_max < right_max) return 2;
        return 0;
    
    }
}
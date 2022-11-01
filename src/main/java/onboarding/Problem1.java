package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    static int getmaxscore(List<Integer> arr){
        //예외처리
        if(arr.size()!=2) return -1;
        if(arr.get(0) != (arr.get(1)-1)) return -1;
        if(arr.get(0)%2==0 || arr.get(0)<=0) return -1;

        List<Integer> maxarr = new ArrayList<>();
        for(int trial=0;trial<2;trial++) {
            //문자열로 변환
            String str = Integer.toString(arr.get(trial));
            int len = str.length();
            int sum = 0;
            int mult = 1;

            for (int i = 0; i < len; i++) {
                int k = Integer.parseInt(String.valueOf(str.charAt(i)));
                sum = sum + k;
                mult = mult * k;
            }
            maxarr.add(Math.max(sum, mult));
        }
        return Math.max(maxarr.get(0),maxarr.get(1));
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobimax = getmaxscore(pobi);
        int crongmax = getmaxscore(crong);

        if(pobimax==-1 || crongmax==-1) return -1;
        if(pobimax > crongmax) return 1;
        else if (pobimax < crongmax) return 2;
        else return 0;
    }
}
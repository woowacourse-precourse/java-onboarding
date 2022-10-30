package onboarding;

import java.util.List;

class Problem1 {
    public static int getAddMultiple(int page){
        int add = 0;
        int multiple = 1;
        while(page!=0) {
            int k = page % 10;
            add += k;
            multiple *= k;
            page /= 10;
        }
        if(add>multiple){
            return add;
        }
        return multiple;
    }

    public static int getGreater(int page1, int page2){
        int record1 = getAddMultiple(page1);
        int record2 = getAddMultiple(page2);
        if(record1>record2){
            return record1;
        }
        return record2;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {


        int greaterPobi = getGreater(pobi.get(0),pobi.get(1));
        int greaterCrong = getGreater(crong.get(0),crong.get(1));

        int answer = Integer.MAX_VALUE;
        if(greaterPobi>greaterCrong) {
            answer = 1;
        } else if (greaterCrong>greaterPobi) {
            answer = 2;
        }else answer = 0;
        return answer;
    }
}
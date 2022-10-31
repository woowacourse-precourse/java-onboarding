package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobi_max = 0;
        List<Integer> pobi_page = new ArrayList<>();
        pobi_page.add(pobi.get(0)/100 + (pobi.get(0)%100)/10 + pobi.get(0)%10);
        pobi_page.add(pobi.get(0)/100 * (pobi.get(0)%100)/10 * pobi.get(0)%10);
        pobi_page.add(pobi.get(1)/100 + (pobi.get(1)%100)/10 + pobi.get(1)%10);
        pobi_page.add(pobi.get(1)/100 * (pobi.get(1)%100)/10 * pobi.get(1)%10);

        int crong_max = 0;
        List<Integer> crong_page = new ArrayList<>();
        crong_page.add(crong.get(0)/100 + (crong.get(0)%100)/10 + crong.get(0)%10);
        crong_page.add(crong.get(0)/100 * (crong.get(0)%100)/10 * crong.get(0)%10);
        crong_page.add(crong.get(1)/100 + (crong.get(1)%100)/10 + crong.get(1)%10);
        crong_page.add(crong.get(1)/100 * (crong.get(1)%100)/10 * crong.get(1)%10);

        for(int i = 0; i<4; i++){
            if (pobi_max < pobi_page.get(i)){
                pobi_max = pobi_page.get(i);
            }
            if (crong_max < crong_page.get(i)){
                crong_max = crong_page.get(i);
            }
        }

        int answer = Integer.MAX_VALUE;

        if (pobi.get(0) + 1 == pobi.get(1) || crong.get(0) + 1 == crong.get(1)){
            answer = -1;
        }
        else if(pobi_max > crong_max){
            answer = 1;
        }
        else if(pobi_max < crong_max){
            answer = 2;
        }
        else {
            answer = 0;
        }
        return answer;
    }
}
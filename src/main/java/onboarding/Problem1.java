package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobi_max = 0;
        List<Integer> pobi_page = new ArrayList<>();
        int crong_max = 0;
        List<Integer> crong_page = new ArrayList<>();

        for(int i=0 ; i<2 ; i++){
            //포비
            if (pobi.get(i) / 100 == 0 && (pobi.get(i) % 100) / 10 == 0) {
                pobi_page.add(pobi.get(i) % 10);
            }
            else if (pobi.get(0) / 100 == 0 && (pobi.get(0) % 100) / 10 != 0) {
                pobi_page.add((pobi.get(i) % 100) / 10 + pobi.get(i) % 10);
                pobi_page.add(((pobi.get(i) % 100) / 10) * (pobi.get(i) % 10));
            }
            else {
                pobi_page.add(pobi.get(i)/100 + (pobi.get(i)%100)/10 + pobi.get(i)%10);
                pobi_page.add((pobi.get(i)/100) * ((pobi.get(i)%100)/10) * (pobi.get(i)%10));
            }


            //크롱
            if (crong.get(i) / 100 == 0 && (crong.get(i) % 100) / 10 == 0) {
                crong_page.add(crong.get(i) % 10);
            }
            else if (crong.get(0) / 100 == 0 && (crong.get(0) % 100) / 10 != 0) {
                crong_page.add((crong.get(i) % 100) / 10 + crong.get(i) % 10);
                crong_page.add(((crong.get(i) % 100) / 10) * (crong.get(i) % 10));
            }
            else {
                crong_page.add(crong.get(i)/100 + (crong.get(i)%100)/10 + crong.get(i)%10);
                crong_page.add((crong.get(i)/100) * ((crong.get(i)%100)/10) * (crong.get(i)%10));
            }
        }

        for(int i = 0; i<pobi_page.size(); i++) {
            if (pobi_max < pobi_page.get(i)) {
                pobi_max = pobi_page.get(i);
            }
        }

        for(int i = 0; i<crong_page.size(); i++){
            if (crong_max < crong_page.get(i)){
                crong_max = crong_page.get(i);
            }
        }

        int answer = Integer.MAX_VALUE;

        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)){
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
package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobi_odd_add=0;
        int pobi_odd_mult=1;
        int pobi_score=0;
        int crong_odd_add=0;
        int crong_odd_mult=1;
        int crong_score=0;
        int answer;
        int pobi_odd = pobi.get(0);
        int pobi_even = pobi.get(1);
        int crong_odd = crong.get(0);
        int crong_even = crong.get(1);
        if(pobi_odd>pobi_even||pobi_even-pobi_odd!=1||pobi_odd%2!=1||pobi_even%2!=0){
            return -1;
        }

        String spobi_odd = Integer.toString(pobi.get(0));
        String spobi_even = Integer.toString(pobi.get(1));
        String scrong_odd = Integer.toString(crong.get(0));
        String scrong_even = Integer.toString(crong.get(1));


        for(int i=0; i<spobi_odd.length(); i++) {
            pobi_odd_add += Integer.parseInt(spobi_odd.substring(i, i + 1));
        }
        for(int i=0; i<spobi_odd.length(); i++) {
            pobi_odd_mult *= Integer.parseInt(spobi_odd.substring(i, i + 1));
        }
        if(pobi_odd_add>pobi_odd_mult){
            pobi_score=pobi_odd_add;
        }else{
            pobi_score=pobi_odd_mult;
        }

        for(int i=0; i<scrong_odd.length(); i++) {
            crong_odd_add += Integer.parseInt(scrong_odd.substring(i, i + 1));
        }
        for(int i=0; i<scrong_odd.length(); i++) {
            crong_odd_mult *= Integer.parseInt(scrong_odd.substring(i, i + 1));
        }
        if(crong_odd_add>crong_odd_mult){
            crong_score=crong_odd_add;
        }else{
            crong_score=crong_odd_mult;
        }

        if(pobi_score>crong_score){
            answer=1;
        } else if (pobi_score<crong_score) {
            answer=2;
        } else  {
            answer=0;
        }


        return answer;
    }
}
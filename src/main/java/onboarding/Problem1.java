package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_plus =0;
        int crong_plus = 0;
        int pobi_multi = 1;
        int crong_multi = 1;
        int pobi_val = 0;
        int crong_val = 0;
        if(pobi.get(1) - pobi.get(0) != 1 | crong.get(1)-crong.get(0) != 1){
            answer = -1;
            return answer;}
        for(int i =0; i<2 ; i++){
            int pobi_len = pobi.get(i).toString().length();
            int crong_len = crong.get(i).toString().length();
            String pobi_page = pobi.get(i).toString();
            String crong_page = crong.get(i).toString();
            for(int j=0; j<pobi_len ; j++){
                int val = pobi_page.charAt(j)-'0';
                pobi_plus += val;
                pobi_multi *= val;}
            if(pobi_multi >= pobi_plus ){
                if(pobi_val <= pobi_multi){
                    pobi_val = pobi_multi;}
            }else{
                if(pobi_plus >= pobi_val){
                    pobi_val = pobi_plus;}
            }
            pobi_multi = 1;
            pobi_plus = 0;
            for(int j=0; j<crong_len ; j++){
                int val_ = crong_page.charAt(j)-'0';
                crong_plus += val_;
                crong_multi *= val_;
            }
            if(crong_multi >= crong_plus){
                if(crong_multi>= crong_val){
                    crong_val = crong_multi;}
            }else{
                if(crong_plus >= crong_val){
                    crong_val = crong_plus;}
            }
            crong_plus = 0;
            crong_multi = 1;
        }
        if(crong_val < pobi_val){
//            System.out.println(" crong win" );
            answer = 1;
        } else if (crong_val > pobi_val) {
//            System.out.println(" pobi win");
            answer = 2;
        } else{
//            System.out.println(" draw ");
            answer = 0;
        }
        return answer;
    }
}
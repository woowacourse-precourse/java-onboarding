package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //이상한 페이지 예외처리
        if(pobi.get(1)-pobi.get(0) == 1 && crong.get(1)-crong.get(0)==1){
            //처음, 마지막 페이지
            if(pobi.get(0) == 1||pobi.get(1)==400){
                answer = -1;
                return answer;
            }
            else if(crong.get(0) == 1 || crong.get(1) == 400){
                answer = -1;
                return answer;
            }

            else{
                int po_max = 0;
                int po_add = 0;
                int po_mul = 1;

                int po_l = pobi.get(0);
                int po_r = pobi.get(1);
                while(po_l != 0) {
                    po_add += po_l % 10;
                    po_mul = po_mul * (po_l % 10);
                    po_l = po_l / 10;
                }
                while(po_r != 0){
                    po_add += po_r % 10;
                    po_mul = po_mul * (po_r % 10);
                    po_r = po_r/10;
                }

                if(po_add > po_mul)
                    po_max = po_add;
                else
                    po_max = po_mul;

                int c_max = 0;
                int c_add = 0;
                int c_mul = 1;

                int c_l = crong.get(0);
                int c_r = crong.get(1);
                while(c_l != 0) {
                    c_add += c_l % 10;
                    c_mul = c_mul * (c_l % 10);
                    c_l = c_l / 10;
                }
                while(c_r != 0){
                    c_add += c_r % 10;
                    c_mul = c_mul * (c_r % 10);
                    c_r = c_r/10;
                }

                if(c_add > c_mul)
                    c_max = c_add;
                else
                    c_max = c_mul;

                if(c_max > po_max)
                    answer = 2;
                else if(c_max < po_max)
                    answer = 1;
                else
                    answer = 0;

                return answer;

            }
        }
        else{
            answer = -1;
            return answer;
        }

    }
}
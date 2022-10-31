package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 각 배열의 가장 큰 수
        int pobi_max_num = 0;
        int crong_max_num = 0;
        // 답변 출력
        int answer = Integer.MAX_VALUE;

        // 배열이 잘못 주어졌을 경우
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1){
            answer = -1;
        }else{
            // pobi 더하는 경우
            for(int i=0; i<2; i++){
                if(pobi.get(i) < 10){
                    if(pobi_max_num < pobi.get(i)){
                        pobi_max_num = pobi.get(i);
                    }
                }else if(pobi.get(i) > 9 && pobi.get(i) < 100){
                    int a = pobi.get(i) % 10 + pobi.get(i) /10%10;
                    if(pobi_max_num < a){
                        pobi_max_num = a;
                    }
                }else if(pobi.get(i) > 99){
                    int a = pobi.get(i) % 10 + pobi.get(i) /10%10 + pobi.get(i) /10/10%10;
                    if(pobi_max_num < a) {
                        pobi_max_num = a;
                    }
                }
            }
            // pobi 곱하는 경우
            for(int i=0; i<2; i++){
                if(pobi.get(i) < 10){
                    if(pobi_max_num < pobi.get(i)){
                        pobi_max_num = pobi.get(i);
                    }
                }else if(pobi.get(i) > 9 && pobi.get(i) < 100){
                    int a = (pobi.get(i) % 10) * (pobi.get(i)/10%10);
                    if(pobi_max_num < a){
                        pobi_max_num = a;
                    }
                }else if(pobi.get(i) > 99){
                    int a = (pobi.get(i) % 10) * (pobi.get(i) /10%10) * (pobi.get(i) /10/10%10);
                    if(pobi_max_num < a) {
                        pobi_max_num = a;
                    }
                }
            }

            // crong 더하는 경우
            for(int i=0; i<2; i++){
                if(crong.get(i) < 10){
                    if(crong_max_num < crong.get(i)){
                        crong_max_num = crong.get(i);
                    }
                }else if(crong.get(i) > 9 && crong.get(i) < 100){
                    int a = crong.get(i) % 10 + crong.get(i) /10%10;
                    if(crong_max_num < a){
                        crong_max_num = a;
                    }
                }else if(crong.get(i) > 99){
                    int a = crong.get(i) % 10 + crong.get(i) /10%10 + crong.get(i) /10/10%10;
                    if(crong_max_num < a) {
                        crong_max_num = a;
                    }
                }
            }
            // crong 곱하는 경우
            for(int i=0; i<2; i++){
                if(crong.get(i) < 10){
                    if(crong_max_num < crong.get(i)){
                        crong_max_num = crong.get(i);
                    }
                }else if(crong.get(i) > 9 && crong.get(i) < 100){
                    int a = (crong.get(i) % 10) * (crong.get(i) /10%10);
                    if(crong_max_num < a){
                        crong_max_num = a;
                    }
                }else if(crong.get(i) > 99){
                    int a = (crong.get(i) % 10) * (crong.get(i) /10%10) * (crong.get(i) /10/10%10);
                    if(crong_max_num < a) {
                        crong_max_num = a;
                    }
                }
            }
            if(pobi_max_num > crong_max_num){
                answer = 1;
            }else if(pobi_max_num < crong_max_num){
                answer = 2;
            }else if(pobi_max_num == crong_max_num){
                answer = 0;
            }else{
                answer = -1;
            }
        }
        return answer;
    }
}
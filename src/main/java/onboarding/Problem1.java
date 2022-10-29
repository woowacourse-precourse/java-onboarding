package onboarding;

import java.util.List;
import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외 조건
        // 1. 왼쪽 페이지: 홀수, 오른쪽 페이지: 짝수
        // 2. 왼쪽 페이지 + 1 = 오른쪽 페이지
        // 3. 페이지는 1~400까지만 가능
        for(int i = 0; i < 2; i++){
            if(pobi.get(i) < 1 && pobi.get(i) > 400 && crong.get(i) < 1 && crong.get(i) > 400){
                answer = -1;
            }
            if(i == 0){ // 왼쪽 페이지인 경우, 홀수여야 함
                if(pobi.get(i) % 2 == 0 || crong.get(i) % 2 == 0){
                    answer = -1;
                }
            }
            if(i == 1){
                if(pobi.get(i) % 2 == 1 || crong.get(i) % 2 == 1){
                    answer = -1;
                }
            }
        }

        if(pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)){
            answer = -1;
        }

        if(answer != -1){
            int pobi_max_score = 0;
            int crong_max_score = 0;

            for(int i = 0; i < 2; i++){ // 왼쪽 페이지 다음 오른쪽 페이지
                int pobi_page = pobi.get(i);
                int crong_page = crong.get(i);

                int pobi_page_sum = 0;
                int pobi_page_mul = 1;

                int crong_page_sum = 0;
                int crong_page_mul = 1;

                while(pobi_page != 0){
                    pobi_page_sum += pobi_page % 10;
                    pobi_page_mul *= pobi_page % 10;
                    pobi_page /= 10;
                }

                pobi_max_score = max(pobi_page_sum, pobi_page_mul);

                while(crong_page != 0){
                    crong_page_sum += crong_page % 10;
                    crong_page_mul *= crong_page % 10;
                    crong_page /= 10;
                }

                crong_max_score = max(crong_page_sum, crong_page_mul);

            }

            if(pobi_max_score > crong_max_score){
                answer = 1;
            }
            else if(pobi_max_score == crong_max_score){
                answer = 0;
            }
            else{
                answer = 2;
            }

        }

        return answer;
    }
}
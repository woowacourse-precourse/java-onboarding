package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // Page 범위가 올바른지 체크하기 (2~399)
        if (pobi.get(0) <= 1) return -1;
        if (crong.get(0) <= 1) return -1;
        if (pobi.get(1) >= 400) return -1;
        if (crong.get(1) >= 400) return -1;

        // 각자 펼쳐본 왼쪽 페이지, 오른쪽 페이지 최댓값 뽑기
        int pobi_max = calcMaxPageNumber(pobi);
        int crong_max = calcMaxPageNumber(crong);

        // pobi 승리시 1
        if (pobi_max > crong_max)
            answer = 1;
        // crong 승리시 2
        if (pobi_max < crong_max)
            answer = 2;
        // 무승부시 0
        if (pobi_max == crong_max)
            answer = 0;

        return answer;
    }

    public static int calcMaxPageNumber(List<Integer> pages){
        int max_num = 0;
        int tmp_max_num = 0;
        int add_result = 0;
        int mul_result = 0;
        // 자릿수를 담는 리스트 pageNums 선언하기.
        ArrayList<Integer> pageNums = new ArrayList<>();

        // 왼쪽 페이지 ( i = 0 ), 오른쪽 페이지( i = 1 )
        for ( int i = 0; i <= 1; i++ ){
            // 초기화
            pageNums.clear();
            add_result = 0;
            // 곱하기 할 때 0인 경우를 고려.
            mul_result = 1;

            // 페이지 선언
            int page = pages.get(i);
            // 자릿수 별로 0이 되기 전까지 pageNum에 원소 집어넣기.
            while(page != 0){
                int tmp = page % 10;
                pageNums.add(tmp);
                page /= 10;
            }
            // 각 자릿수별로 더하거나 곱한 결과 저장하기
            for (int j = 0; j < pageNums.size(); j++) {
                add_result += pageNums.get(j);
                mul_result *= pageNums.get(j);
            }

            /* 덧셈 결과와 곱셈 결과 비교해서 tmp_max_num에 저장하기 */
            if (mul_result >= add_result)
                tmp_max_num = mul_result;
            if (add_result > mul_result)
                tmp_max_num = add_result;


            // 만약 계산값이 최댓값보다 큰 경우 최댓값 변경하기.
            if (tmp_max_num > max_num)
                max_num = tmp_max_num;
        }

        return max_num;
    }
}

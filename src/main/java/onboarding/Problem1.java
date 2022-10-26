package onboarding;

import java.util.List;

class Problem1 {
    // 계산을 위한 메소드 선언
    public static int add_mul_page(int page,boolean flag){
        int sol = (flag)? 0:1;
        String n = Integer.toString(page);
        for(int i=0;i<n.length();i++){
            int sol1 = Integer.parseInt(n.substring(i, i + 1));
            if (flag) sol += sol1;
            else sol *= sol1;
        }
        return sol;
    }

    public static int calculate_return_biggest(int page){
        int l_page = page;
        int r_page = page+1; //왼쪽페이지 +1
        // 상식적으로 오른쪽 페이지가 왼쪽 페이지보다 더한값이 더 크다
        return Math.max(add_mul_page(r_page,true),
                Math.max(add_mul_page(r_page,false),add_mul_page(l_page,false)));
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외사항
        if((pobi.get(0)+1 != pobi.get(1)) || (crong.get(0)+1 != crong.get(1)) ||
                (pobi.size()!=2) || (crong.size()!=2)){
            return -1;
        }

        // 문제풀이
        int pobi_Max = calculate_return_biggest(pobi.get(0));
        int crong_Max = calculate_return_biggest(crong.get(0));
        int answer = Integer.MAX_VALUE;
        if (pobi_Max == crong_Max) answer = 0;
        else if (pobi_Max > crong_Max) answer = 1;
        else if (pobi_Max < crong_Max) answer = 2;
        else answer = -1;

        return answer;
    }
}
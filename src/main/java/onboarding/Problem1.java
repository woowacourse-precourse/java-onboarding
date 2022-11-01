package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        
        //1) 포비 큰 수 구하기
        int pobi_max = 0;
        int pobi_sum = 0;
        int pobi_calc = 1;
        for(int i=0; i<pobi.size(); i++){
            String num = String.valueOf(pobi.get(i));
            for(int j=0; j<num.length(); j++){
                pobi_sum += Character.getNumericValue(num.charAt(j));
                pobi_calc = pobi_calc * Character.getNumericValue(num.charAt(j));
            }
        }
        pobi_max = Math.max(pobi_sum, pobi_calc);
        
        //2) 크롱 큰 수 구하기
        int crong_max = 0;
        int crong_sum = 0;
        int crong_calc = 1;
        for(int i=0; i<crong.size(); i++){
            String num = String.valueOf(crong.get(i));
            for(int j=0; j<num.length(); j++){
                crong_sum += Character.getNumericValue(num.charAt(j));
                crong_calc = crong_calc * Character.getNumericValue(num.charAt(j));
            }
        }
        crong_max = Math.max(crong_sum, crong_calc);
        
        //3) 2,3 비교후 리턴 반환
        //3-1) 페이지 차이가 1이상이면 -1 리턴 (예외처리)
        if( pobi.get(1)-pobi.get(0)>1 || crong.get(1)-crong.get(0)>1 ) answer = -1;
        else if(pobi_max > crong_max) answer = 1;
        else if (pobi_max < crong_max) answer = 2;
        else if(pobi_max == crong_max) answer = 0;
        
        return answer;
    }
}
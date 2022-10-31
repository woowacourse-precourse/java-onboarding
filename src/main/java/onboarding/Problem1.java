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
        
        return answer;
    }
}
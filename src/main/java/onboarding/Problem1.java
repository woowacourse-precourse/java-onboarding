package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int findMax(List<Integer> list){
        String str;
        int sum = 0;
        int mul = 1;
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        for(int i : list){
            str = i + "";
            for(int j = 0; j < str.length(); j++){
                sum += Character.getNumericValue(str.charAt(j));
                mul *= Character.getNumericValue(str.charAt(j));
            }
            resultList.add(sum);
            resultList.add(mul);
            sum = 0;
            mul = 1;
        }

        int max = resultList.get(0);
        for(int i = 0; i < resultList.size(); i++){
            if(resultList.get(i) > max)
                max = resultList.get(i);
        }
        return max;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiMax;
        int crongMax;

        pobiMax = findMax(pobi);
        crongMax = findMax(crong);

        if (pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0 || pobi.get(1) % 2 != 0 || crong.get(1) % 2 != 0){
            answer = -1;
        }
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            answer = -1;
        }
        if(answer != -1) {
            if (pobiMax > crongMax)
                answer = 1;
            else if (pobiMax < crongMax)
                answer = 2;
            else
                answer = 0;
        }

        return answer;
    }
}
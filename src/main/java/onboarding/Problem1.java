package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 들어온 데이터가 유효한지 확인한다.
        if(!confirm_values(pobi, crong)){
            return -1;
        }

        int answer;
        int pobi_max = 0, crong_max = 0;

        // pobi가 만들 수 있는 최대의 값을 계산한다.
        pobi_max = computeMax(pobi);

        // crong이 만들 수 있는 최대의 값을 계산한다.
        crong_max = computeMax(crong);

        // 둘의 결과값을 비교하여 최종적인 답을 정한다.
        answer = compare_two_values(pobi_max, crong_max);

        return answer;
    }
    // 들어온 데이터가 유효한지 확인한다.
    public static boolean confirm_values(List<Integer> pobi, List<Integer> crong){
        if(pobi.get(0) < 1 || pobi.get(1) > 400 || crong.get(0) < 1 || crong.get(1) > 400){
            return false;
        }

        if(pobi.get(0) + 1 != pobi.get(1) || crong.get(0) +1 != crong.get(1)){
            return false;
        }
        return true;
    }

    // 해당 리스트에서 rule에 맞는 최대의 값을 return 한다.
    public static int computeMax(List<Integer> value) {
        int result = 0;
        for(Integer i:value) {
            result = maxValue(i, result);
        }
        return result;
    }

    // value로 만들 수 있는 최대의 값과 old_value 중 더 큰 값을 return 한다.
    public static int maxValue(int value, int old_value){
        int tmp_sum = 0, tmp_mul = 1;
        for (; value > 0; value /= 10) {
            tmp_sum += value % 10;
            tmp_mul *= value % 10;
        }

        if(tmp_sum > old_value){
            old_value = tmp_sum;
        }

        if(tmp_mul > old_value){
            old_value = tmp_mul;
        }
        return old_value;

    }

    // 둘의 결과값을 비교하여 최종적인 답을 return 한다.
    public static int compare_two_values(int pobi_max, int crong_max){
        if(pobi_max>crong_max){
            return 1;
        }
        if(pobi_max<crong_max) {
            return 2;
        }
        return 0;
    }
}

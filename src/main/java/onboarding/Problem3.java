package onboarding;

import java.util.HashMap;

public class Problem3 {
    public static int solution(int number) {
        //시간 복잡도를 위한 HashMap
        HashMap<Integer, Integer> num_count_map = new HashMap<>();
        for (int i = 1; i <= number; i++) {
            String[] each_num_arr = String.valueOf(i).split(""); //각 자리 숫자 추출
            for (int j = 0; j < each_num_arr.length; j++){
                int temp_num = Integer.parseInt(each_num_arr[j]);
                //숫자가 나온 횟수 카운트
                if (!num_count_map.containsKey(temp_num)) num_count_map.put(temp_num,1);
                else num_count_map.put(temp_num,num_count_map.get(temp_num)+1);
            }
        }
        //3이 나온 횟수, 6인 나온 횟수, 9가 나온 횟수의 합
        int answer = num_count_map.get(3) + num_count_map.get(6) + num_count_map.get(9);
        return answer;
    }
}

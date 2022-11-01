package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int max_pobi = 0, max_crong = 0;
        if ((pobi.get(0) + 1 != pobi.get(1)) || (crong.get(0) + 1 != crong.get(1))) {
            answer = -1;
            return answer;
        }
        max_pobi = getMax(pobi, max_pobi);
        max_crong = getMax(crong, max_crong);
        if (max_pobi > max_crong) answer = 1;
        else if (max_pobi < max_crong) answer = 2;
        else if (max_pobi == max_crong) answer = 0;

        return answer;
    }

    private static int getMax(List<Integer> list, int max_value) {
        for (int i = 0; i < list.size(); i++) {
            int[] temp = Stream.of(String.valueOf(list.get(i)).split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < temp.length - 1; j++) {
                if ((temp[j] + temp[j+1]) > max_value) max_value = temp[j] + temp[j+1]; // +
                if ((temp[j] * temp[j+1]) > max_value) max_value = temp[j] * temp[j+1]; // *
                if (temp.length > 2 && j == 0) {
                    if ((temp[j] + temp[j+2]) > max_value) max_value = temp[j] + temp[j+2];
                    if ((temp[j] * temp[j+2]) > max_value) max_value = temp[j] * temp[j+2];
                }
            }
        }
        return max_value;
    }
}
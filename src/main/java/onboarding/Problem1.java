package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

    }

    static int getMax(List<Integer> player) {
        int maximum_value = 0;
        List<String> playerString = List.of(Integer.toString(player.get(0)), Integer.toString(player.get(1)));
        for (int i = 0; i<2; i++) {
            int sum = 0;
            int mul = 1;
            String now_num = playerString.get(i);
            int digits = now_num.length();
            for (int j=0; j<digits; j++) {
                int n = Integer.parseInt(String.valueOf(now_num.charAt(j)));
                sum += n;
                mul *= n;
            }
            if (Math.max(sum, mul)>maximum_value) {
                maximum_value = Math.max(sum, mul);
            }
        }
        return maximum_value;
    }
}
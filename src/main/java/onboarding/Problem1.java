package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobi_value = 0;
        int crong_value = 0;
        if (pobi.get(1)-pobi.get(0) != 1 || pobi.get(0) % 2 != 1 || pobi.get(1) % 2 != 0) return -1;
        if (crong.get(1)-crong.get(0) != 1 || crong.get(0) % 2 != 1 || crong.get(1) % 2 != 0) return -1;

        for (int i = 0; i <= pobi.size()-1 ; i++) {
            String str_num = Integer.toString(pobi.get(i));
            int pobi_sum = 0;
            int pobi_multi = 1;
            int tmp_max;
            for (int k = 0; k < str_num.length(); k++) {
                pobi_sum += Character.getNumericValue(str_num.charAt(k));
                pobi_multi *= Character.getNumericValue(str_num.charAt(k));
            }
            tmp_max = Math.max(pobi_sum, pobi_multi);
            pobi_value = Math.max(tmp_max, pobi_value);
        }

        for (int j = 0; j<= crong.size()-1 ; j++) {
            String str_num = Integer.toString(crong.get(j));
            int crong_sum = 0;
            int crong_multi = 1;
            int tmp_max;
            for (int k = 0; k < str_num.length(); k++) {
                crong_sum += Character.getNumericValue(str_num.charAt(k));
                crong_multi *= Character.getNumericValue(str_num.charAt(k));
            }
            tmp_max = Math.max(crong_sum, crong_multi);
            crong_value = Math.max(tmp_max, crong_value);

        }

        if (pobi_value == crong_value) return 0;
        else if (pobi_value > crong_value) return 1;
        else return 2;
    }
}

package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        if (pobi.size() > 2 || crong.size() > 2) {
            answer = -1;
        } else {
            int pobi1 = pobi.get(0);
            int pobi2 = pobi.get(1);

            int crong1 = crong.get(0);
            int crong2 = crong.get(1);

            if (Math.abs(pobi1 - pobi2) != 1 || Math.abs(crong1 - crong2) != 1) {
                answer = -1;
            } else {
                if (Math.max(findmax(pobi1), findmax(pobi2)) > Math.max(findmax(crong1), findmax(crong2))) {
                    answer = 1;
                } else if (Math.max(findmax(pobi1), findmax(pobi2)) < Math.max(findmax(crong1), findmax(crong2))) {
                    answer = 2;
                } else {
                    answer = 0;
                }
            }
        }
        return answer;
    }

    public static int findmax(int a) {
        int result = 0;
        int plus = 0;
        int mult = 1;
        String b = Integer.toString(a);
        for (int i = 0; i < b.length(); i++) {
            plus += Integer.parseInt(b.split("")[i]);
            mult *= Integer.parseInt(b.split("")[i]);
        }
        result = Math.max(plus, mult);
        return result;
    }
}
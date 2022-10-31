package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        if ((pobi.get(0) + 1) != pobi.get(1) ||
            (pobi.get(0) % 2) != 1 ||
            (pobi.get(1) % 2 != 0) ||
            (crong.get(0) + 1) != crong.get(1) ||
            (crong.get(0) % 2) != 1 ||
            (crong.get(1) % 2) != 0) {
            answer = -1;
            return answer;
        }

        int pobi_max = 0;
        int crong_max = 0;

        for (int i=0; i<pobi.size(); i++) {
            int sum = 0;
            int mul = 1;
            String tmp1 = Integer.toString(pobi.get(i));
            String tmp2 = Integer.toString(crong.get(i));

            for(int j=0; j<tmp1.length(); j++) {
                int num = Integer.parseInt(String.valueOf(tmp1.charAt(j)));
                sum += num;
                mul *= num;
            }
            pobi_max = Math.max(pobi_max, Math.max(sum, mul));

            sum = 0;
            mul = 1;
            for(int k=0; k<tmp2.length(); k++) {
                int num = Integer.parseInt(String.valueOf(tmp2.charAt(k)));
                sum += num;
                mul *= num;
            }
            crong_max = Math.max(crong_max, Math.max(sum, mul));
        }

        if (pobi_max > crong_max)
            answer = 1;
        else if (pobi_max < crong_max)
            answer = 2;
        else
            answer = 0;

        return answer;
    }
}
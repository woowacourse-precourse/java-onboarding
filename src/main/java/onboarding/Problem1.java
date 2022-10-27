package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobi_result = 0;
        for (int i = 0; i<2; i++) {
            System.out.println(pobi.get(i));
            String pobiStr = Integer.toString(pobi.get(i));
            int[] pobi_numList = new int[pobiStr.length()];
            int pobi_sum = 0;
            int pobi_mul = 1;
            for (int j = 0; j<pobiStr.length(); j++) {
                pobi_numList[j] = pobiStr.charAt(j) - '0';
                pobi_sum += pobi_numList[j];
                pobi_mul *= pobi_numList[j];
                if (pobi_result < Math.max(pobi_mul, pobi_sum)) {
                    pobi_result = Math.max(pobi_mul, pobi_sum);
                }
            }

        }

        int crong_result = 0;
        for (int i = 0; i<2; i++) {
            System.out.println(crong.get(i));
            String crongStr = Integer.toString(crong.get(i));
            int[] crong_numList = new int[crongStr.length()];
            int crong_sum = 0;
            int crong_mul = 1;
            for (int j = 0; j<crongStr.length(); j++) {
                crong_numList[j] = crongStr.charAt(j) - '0';
                crong_sum += crong_numList[j];
                crong_mul *= crong_numList[j];
                if (crong_result < Math.max(crong_mul, crong_sum)) {
                    crong_result = Math.max(crong_mul, crong_sum);
                }
            }

        }

        if (pobi_result > crong_result) {
            answer = 1;
        } else if (pobi_result < crong_result) {
            answer = 2;
        } else if (pobi_result == crong_result) {
            answer = 0;
        } else {
            answer = -1;
        }

        System.out.println(pobi_result);
        System.out.println(crong_result);
        System.out.println(answer);
        System.out.println("pobi crong result");
        System.out.println(pobi + " " + crong + " " +  answer);
        return answer;
    }




}
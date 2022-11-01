package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;


        if(pobi.get(0) %2==1 && pobi.get(1) - pobi.get(0) ==1 && crong.get(0) %2==1 && crong.get(1) - crong.get(0) ==1 && pobi.get(0) !=1 && pobi.get(0) !=399 && crong.get(0) !=1 && crong.get(0) !=399) {
            int p_max = 0;
            for (int i = 0; i < 2; i++) {
                String[] a = Integer.toString(pobi.get(i)).split("");
                int sum = 0;
                int prod = 1;
                for (int j = 0; j < a.length; j++) {
                    sum += Integer.parseInt(a[j]);
                    prod *= Integer.parseInt(a[j]);
                }
                p_max = Math.max(sum, prod);
            }

            int c_max = 0;
            for (int i = 0; i < 2; i++) {
                String[] a = Integer.toString(crong.get(i)).split("");
                int sum = 0;
                int prod = 1;
                for (int j = 0; j < a.length; j++) {
                    sum += Integer.parseInt(a[j]);
                    prod *= Integer.parseInt(a[j]);
                }
                c_max = Math.max(sum, prod);
            }

            if(p_max>c_max) {
                answer = 1;
            }
            if(p_max<c_max) {
                answer = 2;
            }
            if(p_max==c_max) {
                answer = 0;
            }
        }

        return answer;
    }
}
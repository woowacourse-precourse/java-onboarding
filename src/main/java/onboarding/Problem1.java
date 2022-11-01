package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        if(pobi.get(0) %2==1 && pobi.get(1) - pobi.get(0) ==1 && crong.get(0) %2==1 && crong.get(1) - crong.get(0) ==1 && pobi.get(0) !=1 && pobi.get(0) !=399 && crong.get(0) !=1 && crong.get(0) !=399) {
            int pobiMax = 0;
            for (int i = 0; i < 2; i++) {
                String[] a = Integer.toString(pobi.get(i)).split("");
                int sum = 0;
                int multiple = 1;
                for (int j = 0; j < a.length; j++) {
                    sum += Integer.parseInt(a[j]);
                    multiple *= Integer.parseInt(a[j]);
                }
                pobiMax = Math.max(sum, multiple);
            }

            int crongMax = 0;
            for (int i = 0; i < 2; i++) {
                String[] a = Integer.toString(crong.get(i)).split("");
                int sum = 0;
                int multiple = 1;
                for (int j = 0; j < a.length; j++) {
                    sum += Integer.parseInt(a[j]);
                    multiple *= Integer.parseInt(a[j]);
                }
                crongMax = Math.max(sum, multiple);
            }

            if(pobiMax>crongMax) {
                answer = 1;
            }
            if(pobiMax<crongMax) {
                answer = 2;
            }
            if(pobiMax==crongMax) {
                answer = 0;
            }
        }

        return answer;
    }
}
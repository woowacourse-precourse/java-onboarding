package onboarding;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiMax = 0;
        int crongMax = 0;

        if (!(pobi.get(1)-pobi.get(0) == 1 && crong.get(1)- crong.get(0) == 1)) return -1;

        for (int i=0; i<2; i++){

            int[] array = getSplit(pobi, i);
            int a = array[0];
            int b = array[1];
            int c = array[2];

            int sum = a + b + c;
            int dup = getDup(a,b,c);

            int max = Math.max(sum, dup);
            if (pobiMax < max) pobiMax = max;
        }

        for (int k=0; k<2; k++){

            int[] array = getSplit(crong, k);
            int a = array[0];
            int b = array[1];
            int c = array[2];

            int sum = a + b + c;
            int dup = getDup(a,b,c);

            int max = Math.max(sum, dup);
            if (crongMax < max) crongMax = max;
        }

        if (pobiMax > crongMax) return 1;
        else if (crongMax > pobiMax) return 2;
        else return 0;
    }

    private static int[] getSplit(List<Integer> list, int num) {
        int a = list.get(num) / 100;
        int b = list.get(num) % 100 / 10;
        int c = list.get(num) % 100 % 10;
        return new int[]{a,b,c};
    }

    private static int getDup(int a, int b, int c){
        int dup;
        if (a == 0 && b ==0) dup = c;
        else if (a == 0) dup = b*c;
        else dup = a*b*c;
        return dup;
    }
}
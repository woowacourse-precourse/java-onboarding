package onboarding;

import java.util.List;

class Problem1 {
    public static int calc(int value) {
        int digit = 0, copy = value, plus = 0, multiply = 1;
        int[] arr;
        while (copy > 0) {
            digit++;
            copy /= 10;
        }
        arr = new int[digit];

        for (int i = 0; i < digit; i++) {
            if (value / 10 > 0) {
                arr[i] = value % 10;
                value /= 10;
            }
        }
        arr[digit - 1] = value % 10;

        for (int i = 0; i < arr.length; i++) {

            plus += arr[i];
            multiply *= arr[i];
        }
        return Math.max(plus, multiply);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pf = pobi.get(0);
        int pe = pobi.get(1);
        int cf = crong.get(0);
        int ce = crong.get(1);

        int p_result, c_result;
        if (pe - pf != 1 || ce - cf != 1) {
            return -1;
        }
        p_result = Math.max(calc(pf), calc(pe));
        c_result = Math.max(calc(cf), calc(ce));

        if (p_result > c_result) {
            return 1;
        } else if (p_result < c_result) {
            return 2;
        } else {
            return 0;
        }


    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        List<Integer> pobi = new ArrayList<>();
//        List<Integer> crong = new ArrayList<>();
//        for (int i=0;i<2;i++){
//            pobi.add(sc.nextInt());
//        }
//        //System.out.println("p: " +pobi.toString());
//        for (int i=0;i<2;i++){
//            crong.add(sc.nextInt());
//        }
//        //System.out.println("c: " +crong.toString());
//        System.out.println(solution(pobi,crong));
//    }
}
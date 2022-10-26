package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static boolean isEx(int a, int b){
        return (b-a)==1 && (a %= 2) == 1 && (b %= 2) == 0;
    }

//    public static int help(int a, int b){
//        int[] arr1 = Stream.of(String.valueOf(a).split("")).mapToInt(Integer::parseInt).toArray();
//        int[] arr2 = Stream.of(String.valueOf(b).split("")).mapToInt(Integer::parseInt).toArray();
//
//        int result_left = getResult(arr1);
//        int result_right = getResult(arr2);
//
//        return Math.max(result_left, result_right);
//    }
//
//    private static int getResult(int[] arr) {
//        int res1 = 0, res2 = 1;
//        for(int num: arr){
//            res1 += num;
//            res2 *= num;
//        }
//        return Math.max(res1, res2);
//    }
//
//    public static int solution(List<Integer> pobi, List<Integer> crong) {
//        Integer[] pobi_arr = pobi.toArray(new Integer[2]);
//        Integer[] crong_arr = crong.toArray(new Integer[2]);
//
//        Integer left_p = pobi_arr[0];
//        Integer right_p = pobi_arr[1];
//
//        Integer left_c = crong_arr[0];
//        Integer right_c = crong_arr[1];
//
//        if(!(isEx(left_p, right_p) && isEx(left_c, right_c))) return -1;
//
//        int max_pobi = help(left_p, right_p);
//        int max_crong = help(left_c, right_c);
//
//        if(max_pobi == max_crong) return 0;
//        else if(max_pobi > max_crong) return 1;
//        else return 2;
//    }
}
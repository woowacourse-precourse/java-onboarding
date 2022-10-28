package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int[] po = pobi.stream().mapToInt(Integer::intValue).toArray();
        int[] cr = crong.stream().mapToInt(Integer::intValue).toArray();

        if(equals(po[0],po[1])&&equals(cr[0],cr[1])) {

        }



        return answer;
    }
    public static boolean equals(int arr0, int arr1) {

        return (arr0+1==arr1&&arr0%2!=0&&arr1%2==0);

    }

}
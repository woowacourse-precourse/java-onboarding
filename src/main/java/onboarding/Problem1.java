package onboarding;

import java.util.List;

class Problem1 {

    /**포비와 크롱의 한판 승부
     *
     * @param pobi
     * @param crong
     * @return
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        /*포비와 크롱의 승부
          파라미터는 각각 펼친 페이지 수.
          0 = 왼쪽편의 페이지 수 , 1= 오른쪽의 페이지 수

           각각 자리수를 연산해 가장 큰 수를 구해야 한다.
           재귀함수를 사용해야 할듯하다.

          , 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0,
        */
        int pobiMaxNum=0;
        int crongMaxNum=0;

        if(!pobi.isEmpty()) pobiMaxNum = temp(pobi);
        else                crongMaxNum =temp(crong);

        System.out.println(pobiMaxNum);
        System.out.println(crongMaxNum);
        return 0;
    }

    /**포비 혹은 크롱의 리스트를 받아 매직 후 최대 값을 반환하는 메서드
     *
     * @param list
     * @return
     */
    public static int temp(List<Integer> list){
        String left = String.valueOf(list.get(0));
        String right = String.valueOf(list.get(1));
        int lMax = 1;
        int rMax = 1;

        for (int i = 0; i <left.length(); i++) {
            lMax += magic( Character.getNumericValue(left.charAt(i)),lMax);
        }

        for (int i = 0; i <right.length(); i++) {
            rMax += magic(Character.getNumericValue(right.charAt(i)),rMax);
        }
        return Math.max(lMax, rMax);
    }

    /**두 방식중 큰 수를 구하기
     *
     * @param n
     * @param i
     * @return
     */
    public static int magic(int n , int i){
        return Math.max((n + i), (n * i));
    }

    public static void main(String[] args) {
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);
        int i = solution(pobi,crong);
    }

}
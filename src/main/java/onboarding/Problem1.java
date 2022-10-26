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

          List.of(97, 98);
        */
        int pobiMaxNum=0;
        int crongMaxNum=0;

        while(pobi.isEmpty()&&crong.isEmpty()){

        }

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public int magic(int n , int i){
        return Math.max((n + i), (n * i));
    }

    public static void main(String[] args) {
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);
        int i = solution(pobi,crong);
    }

}
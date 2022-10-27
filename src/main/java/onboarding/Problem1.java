package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        int pobisNumber;
        int crongsNumber;
        try {
            pobisNumber = findMaxValue(pobi);
            crongsNumber = findMaxValue(crong);
            System.out.println("pobisNumber = " + pobisNumber);
            System.out.println("crongsNumber = " + crongsNumber);
        } catch (Exception e) {
            return -1;
        }
        return pobisNumber > crongsNumber?1:pobisNumber < crongsNumber?2:0;
    }

    public static int findMaxValue(List<Integer>list)throws Exception{
        List<Integer> left =Arrays.stream(String.valueOf(list.get(0)).split("")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> right =Arrays.stream(String.valueOf(list.get(1)).split("")).map(Integer::parseInt).collect(Collectors.toList());

//        원래라면 재귀를 쓰겟지만 문제에서 400 페이지 미만이라는 조건을 주었기 때문에 각각의 경우를 만든다.
//        재귀를 이용 할 수 있을 것 같다!!
//        int leftMax = recursive(list,"",0);
//        int rightMax = recursive(right,"",0);
//        포기 게속 하면 찾을거 같은데 더 이상 시간을 투자하게 되면 힘들듯.

        int leftMax = 1;
        int rightMax = 1;

        for (Integer i : left) leftMax = Math.max((leftMax * i), (leftMax + i));
        for (Integer i : right) rightMax = Math.max((rightMax * i), (rightMax + i));

        return Math.max(leftMax,rightMax);
    }

    public static int recursive(List<Integer> list,String simpol,int result){

        result = Integer.parseInt( simpol+list.get(0));
        list.remove(0);
        //최종 값까지 추출한 다음 list가 비었을 경우 누적된 결과값을 가져간다.
        if(list.isEmpty()) return result;

        return Math.max(recursive(list, "+",result), recursive(list, "*",result));
    }
}


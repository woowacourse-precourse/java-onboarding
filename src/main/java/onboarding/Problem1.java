package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        /* 각각 페이지가 이어지는지 확인
        * 그 전에 시작면과 마지막 면인지 확인 (1, 400)
        * 좌측이 홀수, 우측이 짝수
        * 좌측+1 == 우측인지
        * 아니면 answer = -1; return answer;
        * */

        List<List<Integer>> bookList = new ArrayList<>();
        bookList.add(pobi);
        bookList.add(crong);

        if((pobi.contains(1) || pobi.contains(400)) || ((crong.contains(1) || crong.contains(400)))){
            answer = -1;
            return answer;
        }

        if((pobi.get(1) != (pobi.get(0)+1)) || (crong.get(1) != (crong.get(0)+1))){
            answer = -1;
            return answer;
        }

        if(((pobi.get(0)%2 != 1) || (crong.get(0)%2 != 1)) || ((pobi.get(1)%2 != 0) || (crong.get(1)%2 != 0))){
            answer = -1;
            return answer;
        }

        /* 좌측 우측 모두 각각의 경우에서 가장 큰 값 구하기
        * 더한값과 곱한 값 비교 후 저장
        * */
        // 좌측과 우측 중 더 큰 값 저장

        int[] max = new int[2];
        int i=0;

        for(List<?> list : bookList){
            String bookPage1 = Integer.toString((int) list.get(0));
            String bookPage2 = Integer.toString((int) list.get(1));

            String[] page1 = bookPage1.split("");
            String[] page2 = bookPage2.split("");

            int[] left = {0, 1};
            int[] right = {0, 1};
            int[] num = new int[2];

            for(String pageNum : page1){
                left[0] += Integer.parseInt(pageNum);
                left[1] *= Integer.parseInt(pageNum);
            }

            for(String pageNum : page2){
                right[0] += Integer.parseInt(pageNum);
                right[1] *= Integer.parseInt(pageNum);
            }

            num[0] = Math.max(left[0], left[1]);
            num[1] = Math.max(right[0], right[1]);
            max[i++] = Math.max(num[0], num[1]);
        }

        // 비교
        if(max[0] > max[1])
            answer = 1;
        else if(max[0] < max[1])
            answer = 2;
        else
            answer = 0;

        return answer;
    }
}
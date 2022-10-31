package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
//성공
class Problem1 {
//
//    포비와 크롱이 펼친 페이지가 들어있는 리스트/배열 pobi와 crong이 주어질 때, 포비가 이긴다면 1,
//    크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성하라.


    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int p_left = pobi.get(0);
        int p_right = pobi.get(1);

        int c_left = crong.get(0);
        int c_right = crong.get(1);

        // 예외 처리
        if (p_left+1!=p_right || c_left+1!=c_right || p_left%2==0 || c_left%2==0 || p_right%2!=0 || c_right%2!=0 || p_right>400 || c_right>400){
            return -1;
        }

        // 각 숫자 배열 형식으로 받기
        int[] pobi1 = Stream.of(String.valueOf(p_left).split("")).mapToInt(Integer::parseInt).toArray();
        int[] pobi2 = Stream.of(String.valueOf(p_right).split("")).mapToInt(Integer::parseInt).toArray();

        int[] crong1 = Stream.of(String.valueOf(c_left).split("")).mapToInt(Integer::parseInt).toArray();
        int[] crong2 = Stream.of(String.valueOf(c_right).split("")).mapToInt(Integer::parseInt).toArray();

        // 덧셈 값 지정
        int pobi_sum1 = Arrays.stream(pobi1).sum();
        int pobi_sum2 = Arrays.stream(pobi2).sum();
        int crong_sum1 = Arrays.stream(crong1).sum();
        int crong_sum2 = Arrays.stream(crong2).sum();

        // 덧셈 중 최댓값 구하기
        int pobi_sum = Math.max(pobi_sum1,pobi_sum2);
        int crong_sum = Math.max(crong_sum1,crong_sum2);


        // 곱셈 값 지정
        int pobi_mul1=1;
        int pobi_mul2=1;

        int crong_mul1=1;
        int crong_mul2=1;

        for(int i:pobi1){
            pobi_mul1 *= i;
        }
        for(int i:pobi2){
            pobi_mul2 *= i;
        }
        for(int i:crong1){
            crong_mul1 *= i;
        }
        for(int i:crong2){
            crong_mul2 *= i;
        }

        // 곱셈 중 최댓값 구하기
        int pobi_mul = Math.max(pobi_mul1,pobi_mul2);
        int crong_mul = Math.max(crong_mul1,crong_mul2);

        int pobi_final = Math.max(pobi_sum,pobi_mul);
        int crong_final = Math.max(crong_sum,crong_mul);

        // 최종 결과 출력
        if(pobi_final>crong_final){
            return 1;
        } else if (pobi_final==crong_final) {
            return 0;

        } else {
            return 2;
        }

    }

}
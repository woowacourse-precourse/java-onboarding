package onboarding;

import java.util.List;
// 리스트의 숫자 곱을 구하는 함수
public static int multi_num(List<Integer> list) {
        multi_num = 1
        for i in range(len(list))
            multi_num = multi_num*list[i]

        return multi_num;
    }

// 왼쪽,오른쪽 리스트 합과 곱을 구한 뒤 그 중 큰수를 뽑아서 왼쪽과 오른쪽의 큰값을 최종으로 뽑아내는 함수
public static int get_sum_multi_which_big_num(List<Integer> left, List<Integer> right,) {
        if sum(List<Integer> left) > multi_num(List<Integer> left):
            big_left_num = sum(List<Integer> left)
        else:
            big_left_num = multi_num(List<Integer> left):
        if sum(List<Integer> right) > multi_num(List<Integer> right):
            big_right_num = sum(List<Integer> right)
        else:
            big_right_num = multi_num(List<Integer> right):

        if big_left_num > big_right_num
            big_num = big_left_num
        else:
            big_num = big_right_num

        return big_num;
    }


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        List<Str> pobi_left_num = pobi[0].split()  // 포비 나눈 왼쪽 숫자
        List<Str> pobi_right_num = pobi[1].split() // 포비 나눈 오른쪽 숫자
        List<Str> crong_left_num = crong[0].split() // 크롱 나눈 왼쪽 숫자
        List<Str> crong_right_num = crong[1].split() // 크롱 나눈 오른쪽 숫자

        if pobi_right_num-pobi_left_num = 1 and crong_right_num - crong_left_num = 1 // 페이지가 정상적인 경우
             // 조건대로 양쪽 수의 합 또는 곱중 큰 수 구하기
            pobi_big_num = get_sum_multi_which_big_num(pobi_left_num, pobi_right_num) 
            crong_big_num = get_sum_multi_which_big_num(crong_left_num, crong_right_num)
            
            if pobi_big_num > crong_big_num:  // 포비 윈 : 1
                int result = 1
            elif crong_big_num > pobi_big_num: // 크롱 윈 : 2
                int result = 2
            else pobi_big_num = crong_big_num: // 무승부 : 0
                int result = 0
        elif pobi_left_num < 2 or pobi_right_num > 399: // 포비 책 페이지가 첫페이지 전이거나 마지막페이지 뒤인 경우
            int result = -1
        elif crong_left_num < 2 or crong_right_num > 399: // 크롱 책 페이지가 첫페이지 전이거나 마지막페이지 뒤인 경우
            int result = -1
        else:  // 그 외 모든 예외상황
            int result = -1

        return result;
    }
}
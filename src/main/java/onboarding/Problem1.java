package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        
        // 페이지 번호. 순서대로 포비 왼쪽, 포비 오른쪽, 크롱 왼쪽, 크롱 오른쪽
        int[] page_nums = {pobi.get(0), pobi.get(1), crong.get(0), crong.get(1)};

        // 입력받은 페이지 번호에서 예외사항 발생시 바로 -1 리턴
        // 예외사항 1. 시작면이나 마지막면이 나오도록 책을 펼친 경우
        // 예외사항 2. 왼쪽 페이지와 오른쪽 페이지의 차이가 1보다 큰 경우
        // 예외사항 3. 왼쪽 페이지가 짝수거나, 오른쪽 페이지가 홀수거나
        // 예외사항 4. 왼쪽 페이지가 오른쪽 페이지보다 같거나 큰 경우
        if(pobi.get(0) >= pobi.get(1)) { return -1; }
        else if((pobi.get(1) - pobi.get(0) > 1)) { return -1; }
        else if((pobi.get(0) % 2 == 0) || (pobi.get(1) % 2 != 0)) {  return -1; }
        else if(pobi.get(0) == 1 || pobi.get(0) == 399 || pobi.get(1) == 2 || pobi.get(1) == 400) { return -1; }

        if(crong.get(0) >= crong.get(1)) { return -1; }
        else if((crong.get(1) - crong.get(0) > 1)) { return -1; }
        else if((crong.get(0) % 2 == 0) || (crong.get(1) % 2 != 0)) {  return -1; }
        else if(crong.get(0) == 1 || crong.get(0) == 399 || crong.get(1) == 2 || crong.get(1) == 400) { return -1; }


    // 예외사항 모두 통과시 게임 승자 정하기
        // 각 자리 숫자를 모두 더한 값을 저장할 배열
        int[] page_nums_sum = {0, 0, 0, 0};

        // 각 자리 숫자를 모두 곱한 값을 저장할 배열
        int[] page_nums_multi = {1, 1, 1, 1};

        // 각 자리 숫자를 모두 더하거나 모두 곱해서 배열에 저장
        for (int i = 0; i < page_nums.length; i++) {
            while (page_nums[i] > 0) {
                page_nums_sum[i] += page_nums[i] % 10;
                page_nums_multi[i] *= page_nums[i] % 10;
                page_nums[i] /= 10;
            }
        }

        // 포비와 크롱의 점수 구하기
        int pobi_num = Integer.MIN_VALUE;
        int crong_num = Integer.MIN_VALUE;

        // 포비와 크롱의 점수를 각각 구하기 위해 현재 점수를 Integer.MIN_VALUE로 초기화 후
        // 그 값을 각 자리 숫자 더한 값부터 비교 후, 각 자리 숫자 곱한 값이랑 비교하여 점수를 구한다

        // 포비 페이지 수와 관련된 값은 인덱스 0, 1에 저장되어 있다.
        for (int i = 0; i < 2; i++) {
            if(pobi_num <= page_nums_sum[i]) {
                pobi_num = page_nums_sum[i];
            }
            if(pobi_num <= page_nums_multi[i]) {
                pobi_num = page_nums_multi[i];
            }
        }

        // 크롱 페이지 수와 관련된 값은 인덱스 2, 3에 저장되어 있다.
        for (int i = 2; i < 4; i++) {
            if (crong_num <= page_nums_sum[i]) {
                crong_num = page_nums_sum[i];
            }
            if (crong_num <= page_nums_multi[i]) {
                crong_num = page_nums_multi[i];
            }
        }

        // 포비와 크롱의 점수를 비교하여 승부 결정
        if(pobi_num > crong_num) {
            answer = 1;
        } else if(pobi_num < crong_num) {
            answer = 2;
        } else {
            answer = 0;
        }


        return answer;
    }
}
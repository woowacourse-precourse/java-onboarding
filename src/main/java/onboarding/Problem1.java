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


        return answer;
    }
}
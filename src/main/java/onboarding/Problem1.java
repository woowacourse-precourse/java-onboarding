package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!validatePageNum(pobi) || !validatePageNum(crong)) return -1;
        return answer;
    }

    private static Boolean validatePageNum(List<Integer> pageList) {
        int page = pageList.get(0);
        if (page < 1 || page > 399) return false; // 페이지 범위 체크 (왼쪽 페이지 유효 범위 : 1 ~ 399)
        if (pageList.get(1) != page + 1) return false; // 왼쪽 페이지와 오른쪽 페이지의 번호 차이가 1이 아닐 경우
        if (page % 2 != 1) return false; // 짝,홀 체크
        return true;
    }

}
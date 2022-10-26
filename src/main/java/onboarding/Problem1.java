package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외의 경우 처리
        if(!validChk(pobi) || !validChk(crong)) return answer = -1;

        // 포비와 크롱의 점수 계산
        int pobiPoint = Math.max(solution(pobi.get(0)), solution(pobi.get(1)));
        int crongPoint = Math.max(solution(crong.get(0)), solution(crong.get(1)));

        return answer;
    }

    /**
     * 조건에 따라 더 큰 점수를 리턴
     * @param pageNum
     * @return Math.max(합, 곱셈)
     */
    public static int solution(int pageNum) {
        String page = String.valueOf(pageNum);
        int sum = 0, multi = 1;
        for (char c : page.toCharArray()) {
            int num = Integer.parseInt(String.valueOf(c));
            sum += num;
            multi *= num;
        }

        return Math.max(sum, multi);
    }

    /**
     * 예외처리 함수
     * @param list
     * @return {boolean}
     */
    public static boolean validChk(List<Integer> list) {
        if(list.get(1) - list.get(0) > 1 || list.contains(400) || list.contains(1)) return false;
        return true;
    }
}
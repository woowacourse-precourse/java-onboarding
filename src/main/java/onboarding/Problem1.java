package onboarding;

import java.util.List;

class Problem1 {

    /**
     * 예외사항 확인 메서드
     *
     * @param name 책을 펼치는 사람, Integer형의 List로 길이는 2
     * @return 예외 사항이 있을 시 true, 그 외엔 false를 반환
     */
    static boolean isException(List<Integer> name) {
        if ((name.get(0) < 1) || name.get(1) > 400)
            return true;
        else if ((name.get(0) == null) || (name.get(1) == null))
            return true;
        else if (name.get(0) % 2 != 1)
            return true;
        else if (name.get(1) % 2 != 0)
            return true;
        else if ((name.get(1) - name.get(0)) != 1)
            return true;
        else if ((name.get(0) == 1 || name.get(0) == 399 || name.get(1) == 2 || name.get(1) == 400)) {
            return true;
        }

        return false;
    }



    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}
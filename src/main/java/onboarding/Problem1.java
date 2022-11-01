package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (check(pobi.get(0),pobi.get(1)) || check(crong.get(0),crong.get(1))) {
            return -1;
        }
        
        int pobi_pv = bigger(plus(pobi.get(0)), plus(pobi.get(1)));
        int pobi_mv = bigger(multiple(pobi.get(1)), multiple(pobi.get(1)));
        int pobi_value = bigger(pobi_mv, pobi_pv);

        int crong_pv = bigger(plus(crong.get(0)), plus(crong.get(1)));
        int crong_mv = bigger(multiple(crong.get(0)), multiple(crong.get(1)));
        int crong_value = bigger(crong_mv, crong_pv);

        int answer = 0;

        if (pobi_value > crong_value) {
            answer = 1;
        } else if (pobi_value < crong_value) {
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }
    /** 두 값 더하기 */
    public static int plus(Integer page) {
        String s_page = Integer.toString(page);
        int value = 0;
        for (int i = 0; i < s_page.length(); i++) {
            char temp = s_page.charAt(i);
            value += (int)(temp - '0');
        }
        return value;
    }
    /** 두 값 곱하기 */
    public static int multiple(Integer page) {
        String s_page = Integer.toString(page);
        int value = 1;
        for (int i = 0;i <s_page.length();i++){
            char temp = s_page.charAt(i);
            value *= (int)(temp - '0');
        }
        return value;
    }
    /** 대소 비교(max 메서드가 안먹혀서 만든 함수) */
    public static int bigger(Integer v1, Integer v2) {
        if (v1 > v2) {
            return v1;
        } else {
            return v2;
        }
    }

    public static boolean check(Integer v1, Integer v2) {
        if (v2 < v1){
            return true;
        } else if (v2-v1 != 1) {
            return true;
        } else if (v1%2 != 1 || v2%2 == 1) {
            return true;
        } else {
            return false;
        }
    }
}
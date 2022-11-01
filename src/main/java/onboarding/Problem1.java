package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(pobi.get(1)-pobi.get(0) != 1 || crong.get(1)-crong.get(0) != 1)      // 예외처리
            return -1;

        String spl = Integer.toString(pobi.get(0));     // 포비의 왼쪽 페이지
        String spr = Integer.toString(pobi.get(1));     // 포비의 오른쪽 페이지
        String scl = Integer.toString(crong.get(0));    // 크롱의 왼쪽 페이지
        String scr = Integer.toString(crong.get(1));    // 크롱의 왼쪽 페이지

        int pla = 0, plc = 1;
        for(int i = 0; i < spl.length(); i++) {
            pla += (spl.charAt(i) - '0');           // 더하기 연산
            plc *= (spl.charAt(i) - '0');           // 곱셈 연산
        }
        int pl = pla >= plc ? pla : plc;            // 두개의 값 중에서 더 큰 값을 왼쪽 값으로 저장

        int pra = 0, prc = 1;
        for(int i = 0; i < spr.length(); i++) {
            pra += (spr.charAt(i)- '0');
            prc *= (spr.charAt(i)- '0');
        }
        int pr = pra >= prc ? pra : prc;            // 두개의 값 중에서 더 큰 값을 오른쪽 값으로 저장

        int cla = 0, clc = 1;
        for(int i = 0; i < scl.length(); i++) {
            cla += (scl.charAt(i)- '0');
            clc *= (scl.charAt(i)- '0');
        }
        int cl = cla >= clc ? cla : clc;

        int cra = 0, crc = 1;
        for(int i = 0; i < scr.length(); i++) {
            cra += (scr.charAt(i)- '0');
            crc *= (scr.charAt(i)- '0');
        }
        int cr = cra >= crc ? cra : crc;

        if (((pl >= pr) ? pl : pr) > ((cl >= cr) ? cl : cr))
            return 1;
        else if (((pl >= pr) ? pl : pr) < ((cl >= cr) ? cl : cr))
            return 2;
        else
            return 0;
    }
}
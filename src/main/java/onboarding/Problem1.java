package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(pobi.get(1)-pobi.get(0) != 1 || crong.get(1)-crong.get(0) != 1)
            return -1;

        String spl = Integer.toString(pobi.get(0));
        String spr = Integer.toString(pobi.get(1));
        String scl = Integer.toString(crong.get(0));
        String scr = Integer.toString(crong.get(1));

        int pla = 0, plc = 1;
        for(int i = 0; i < spl.length(); i++) {
            pla += (spl.charAt(i) - '0');
            plc *= (spl.charAt(i) - '0');
        }
        int pl = pla >= plc ? pla : plc;

        int pra = 0, prc = 1;
        for(int i = 0; i < spr.length(); i++) {
            pra += (spr.charAt(i)- '0');
            prc *= (spr.charAt(i)- '0');
        }
        int pr = pra >= prc ? pra : prc;

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
package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = -1;

        int a = pobi.get(0);   int b = pobi.get(1);
        int c = crong.get(0);  int d = crong.get(1);
        int x = b-1;   int y = d-1;

        if(a != x) { return answer;}
        if(c != y) { return answer;}
        if(a == 0) { return answer;}
        if(b>=400) { return answer;}
        if(c == 0) { return answer;}
        if(d>=400) { return answer;}


        int asum = 0; while(a!=0) {	asum += a%10; a /= 10; }
        int bsum = 0; while(b!=0) { bsum += b%10; b /= 10; }
        int csum = 0; while(c!=0) { csum += c%10; c /= 10; }
        int dsum = 0; while(d!=0) { dsum += d%10; d /= 10; }


        a = pobi.get(0);   b = pobi.get(1);
        c = crong.get(0);  d = crong.get(1);

        int ax = 1;
        String stra = Integer.toString(a);
        for (int j=0; j < stra.length(); j++) {
            ax *= Integer.parseInt(String.valueOf(stra.charAt(j)));
        }

        int bx = 1;
        String strb = Integer.toString(b);
        for (int j=0; j < strb.length(); j++) {
            bx *= Integer.parseInt(String.valueOf(strb.charAt(j)));
        }

        int cx = 1;
        String strc = Integer.toString(c);
        for (int j=0; j < strc.length(); j++) {
            cx *= Integer.parseInt(String.valueOf(strc.charAt(j)));
        }

        int dx = 1;
        String strd = Integer.toString(d);
        for (int j=0; j < strd.length(); j++) {
            dx *= Integer.parseInt(String.valueOf(strd.charAt(j)));
        }

        int pobimax, crongmax;

        if(b<10) {pobimax = b;}
        else {
            int amax = Math.max(asum, ax);
            int bmax = Math.max(bsum, bx);
            pobimax = Math.max(amax, bmax);
        }

        if(d<10) {crongmax = d;}
        else {
            int cmax = Math.max(csum, cx);
            int dmax = Math.max(dsum, dx);
            crongmax = Math.max(cmax, dmax);
        }

        if(pobimax > crongmax) {answer = 1;}
        else if(pobimax < crongmax) {answer =2;}
        else {answer = 0;}

        return answer;
    }
}
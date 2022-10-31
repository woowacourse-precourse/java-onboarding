package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(exs(pobi, crong)) return -1; // ex test

        int[] digitP = {-1, -1, -1};
        int[] digitC = {-1, -1, -1};
        int pmax = 0;
        int cmax = 0;

        for(int i = 0; i < 2; i++) {
            int tmp = pobi.get(i); // pobi "i" num digit chk
            for(int j = 0; tmp != 0; j++) {
                digitP[j] = tmp % 10;
                tmp /= 10;
            }
            tmp = crong.get(i); // crong "i" num digit chk
            for(int j = 0; tmp != 0; j++) {
                digitC[j] = tmp % 10;
                tmp /= 10;
            }

            int addP = 0;
            int addC = 0;
            for(int j = 0; j < 3; j++) { // add digit num
                if(digitP[j] != -1) {
                    addP += digitP[j];
                }
                if(digitC[j] != -1) {
                    addC += digitC[j];
                }
            }
            if(pmax < addP) {
                pmax = addP;
            }
            if(cmax < addC) {
                cmax = addC;
            }

            int mulP = 1;
            int mulC = 1;
            for(int j = 0; j < 3; j++) { // mul digit num
                if(digitP[j] != -1) {
                    mulP *= digitP[j];
                }
                if(digitC[j] != -1) {
                    mulC *= digitC[j];
                }
            }
            if(pmax < mulP) {
                pmax = mulP;
            }
            if(cmax < mulC) {
                cmax = mulC;
            }
        }

        if(pmax > cmax) { // pobi win
            return 1;
        }
        else if(pmax < cmax) { // crong win
            return 2;
        }
        else { // draw
            return 0;
        }
    }
    static boolean exs(List<Integer> pobi, List<Integer> crong) { // init exceptions true:ex / false:non-ex
        if(pobi.get(0) % 2 != 1 || pobi.get(1) % 2 != 0) return true; // pobi left even or right odd
        if(crong.get(0) % 2 != 1 || crong.get(1) % 2 != 0) return true; // crong left even or right odd
        if((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1)) return true; // uncountinuous page numb
        if(pobi.get(0) < 1 || pobi.get(0) > 400 || pobi.get(1) < 1 || pobi.get(1) > 400) return true; // invalid pobi page numb
        if(crong.get(0) < 1 || crong.get(0) > 400 || crong.get(1) < 1 || crong.get(1) > 400) return true; // invalid crong page numb

        return false; // ex test pass
    }
}
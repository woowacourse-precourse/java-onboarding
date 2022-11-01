package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
    	for (int i = 0; i < 2; i++) {
			if (pobi.get(i) < 0 || pobi.get(i) > 400 || crong.get(i) < 0 || crong.get(i) > 400) {
				return -1;
			} else if (pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1) {
				return -1;
			} else if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
				return -1;
			}
		}
    	
    	int pobiMax = 0;
		int crongMax = 0;
		int pobiNum = 0;
		int crongNum = 0;
		for (int i = 0; i < 2; i++) {
			int pobiCase = pobi.get(i);
			while (pobiCase > 0) {
				pobiNum += pobiCase % 10;
				pobiCase = (int) (pobiCase / 10);
			}
			if (pobiNum > pobiMax) {
				pobiMax = pobiNum;
			}
			pobiCase = pobi.get(i);
			while (pobiCase > 0) {
				pobiNum *= pobiCase % 10;
				pobiCase = (int) (pobiCase / 10);
			}
			if (pobiNum > pobiMax) {
				pobiMax = pobiNum;
			}
			int crongCase =crong.get(i);
			while (crongCase > 0) {
				crongNum += crongCase % 10;
				crongCase = (int) (crongCase / 10);
			}
			if (crongNum > crongMax) {
				crongMax = crongNum;
			}
			crongCase =crong.get(i);
			while (crongCase > 0) {
				crongNum *= crongCase % 10;
				crongCase = (int) (crongCase / 10);
			}
			if (crongNum > crongMax) {
				crongMax = crongNum;
			}
		}
		if (pobiMax > crongMax) {
			return 1;
		} else if (pobiMax == crongMax) {
			return 0;
		} else{
			return 2;
		}
    	
    }
}

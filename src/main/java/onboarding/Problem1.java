package onboarding;

import java.util.List;

class Problem1 {
	
	public int calc (int a) {
		int plus = 0;
		int mult = 1;
		
		String s = Integer.toString(a);
		for(int i=0; i < s.length(); i++) { plus += Integer.parseInt(s.substring(i, i+1)); }
		for(int i=0; i < s.length(); i++) { mult *= Integer.parseInt(s.substring(i, i+1)); }
		
		return (plus > mult)? plus : mult;
	}
	
    public static int solution(int[] pobi, int[] crong) {
        int answer = Integer.MAX_VALUE;
        if (pobi[1]-pobi[0] != 1 || crong[1]-crong[0] != 1 
				|| pobi[1]>=400 || crong[1]>=400 || pobi[0]<=1 || crong[0]<=1 ) { return -1; }
		pobi[0] = calc(pobi[0]);
		pobi[1] = calc(pobi[1]);
		crong[0] = calc(crong[0]);
		crong[1] = calc(crong[1]);
		int poResult = (pobi[0] > pobi[1])? pobi[0] : pobi[1];
		int croResult = (crong[0] > crong[1])? crong[0] : crong[1];
		int re = poResult - croResult;
		if (re == 0) { return 0; }
		else if(re > 0) { return 1; }
		else if(re < 0) { return 2; }
		else { return -1; }
    }
}
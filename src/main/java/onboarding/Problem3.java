package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
	private static List<Integer> getClapNumber() {
		List<Integer> clapper= new ArrayList<Integer>();
		clapper.add(3);
		clapper.add(6);
		clapper.add(9);
		return clapper;
	}
	private static int countClap(int x,List<Integer> clapper) {
		int clap=0;
		while(x>0) {
			int isClap=x%10;
			if(clapper.contains(isClap)) {
				clap++;
			}
			x /= 10;
		}
		return clap;
	}
    public static int solution(int number) {
        int answer = 0;
        List<Integer> clapper= getClapNumber();
        
        for(int i=1;i<=number;i++) {
			answer += countClap(i,clapper);
		}
        
        return answer;
    }
}

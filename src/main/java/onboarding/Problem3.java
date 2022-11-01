package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        
		int[] numberRange = new int[number];
		
		for (int i = 0; i < numberRange.length; i++) {
			numberRange[i] = i+1;
			
			String numberToString = numberRange[i] + "";
			String[] clap = numberToString.split("");
			
			for (int j = 0; j < clap.length; j++) {
				int number369 = Integer.parseInt(clap[j]);
				if (number369 == 3 || number369 == 6 || number369 == 9) {
					answer++;
				}
			}
		}
        
        return answer;
    }
}

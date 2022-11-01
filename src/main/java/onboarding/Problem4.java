package onboarding;

public class Problem4 {
	public class reverse {
		public static String solution(String word) {
	        String answer = "";
	        char[] arr = word.toCharArray();
			for(int i = 0; i < arr.length; i++) {
				int n = (int) arr[i];
				if(n > 64 && n < 90) {
					arr[i] = (char) (26 - (n - 65) + 64);
				}
				else if (n > 96 && n < 122){
					arr[i] = (char) (26 - (n - 97) + 96);
				}
			}
			String result = String.valueOf(arr);
			
			answer = result;
	        return answer;
	    }
}

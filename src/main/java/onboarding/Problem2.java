package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
        String answer = "answer";
        String lastStr = "";
		char temp = ' ';
		while(!lastStr.equals(cryptogram)) {
			char[] arr = cryptogram.toCharArray();
			lastStr = cryptogram;
			for(int i = 0; i < arr.length - 1; i++) {
				if(arr[i] == arr[i+1]) {
					temp = arr[i];
					arr[i] = ' ';
					arr[i+1] = ' ';
				}
				else if(arr[i] == ' ' && temp == arr[i+1]) {
					arr[i+1] = ' ';
				}
				else {}
			}
			cryptogram = String.valueOf(arr);
			cryptogram = cryptogram.replaceAll(" ", "");
		}
		
		
		answer = cryptogram;
        
        
        return answer;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        
		answer = sameWordDelete(cryptogram);

		while (answer.length() != sameWordDelete(answer).length()) {
			answer = sameWordDelete(answer);
		}
        
        return answer;
    }
    
	public String sameWordDelete(String cryptogramText) {
		String[] cryptogramArray = cryptogramText.split("");
		List<String> cryptogramList = new ArrayList<String>(Arrays.asList(cryptogramArray));
		String cryptogramCorrection = "";

		for (int i = 0; i < cryptogramArray.length - 1; i++) {
			if (cryptogramArray[i].equals(cryptogramArray[i + 1])) {
				cryptogramList.remove(i + 1);
				cryptogramList.remove(i);
				cryptogramArray = cryptogramList.toArray(new String[cryptogramArray.length - 2]);
			}
			cryptogramCorrection = String.join("", cryptogramArray);
		}
		return cryptogramCorrection;
	}
}

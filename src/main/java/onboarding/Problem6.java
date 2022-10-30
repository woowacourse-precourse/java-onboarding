package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		HashMap<String, String> tmpAnswer = new HashMap<>();
		for (int myIndex = 0; myIndex < forms.size() - 1; myIndex++) {
			String myEmail = forms.get(myIndex).get(0);
			String myNickName = forms.get(myIndex).get(1);
			if (!emailCheck(myEmail) && !nicknameCheck(myNickName)) {
				continue;
			}
			
			
			for (int targetIndex = myIndex + 1; targetIndex < forms.size(); targetIndex++) {
				String targetEmail = forms.get(targetIndex).get(0);
				String targetNickname = forms.get(targetIndex).get(1);
				if (!emailCheck(targetEmail) && !nicknameCheck(targetNickname)) {
					continue;
				}
				
				// match
				for (int i = 0; i < myNickName.length() - 1; i++) {
					String targetSequence = myNickName.substring(i, i + 2);
					boolean contains = targetNickname.contains(targetSequence);
					if (contains) {
						tmpAnswer.put(targetEmail, targetNickname);
						tmpAnswer.put(myEmail, myNickName);
						break;
					}
					// 같은 글자의 2개의 경우
					if (targetSequence.charAt(0) == targetSequence.charAt(1)) {
						i++;
					}
				}
			}
		}
		
		List<String> answer = new ArrayList<>(tmpAnswer.keySet());
		answer.sort(Comparator.naturalOrder());
		return answer;
	}
	
	private static boolean nicknameCheck(String nickname) {
		if (nickname.length() == 0 || nickname.length() > 19) {
			return false;
		}
		
		if (!nickname.matches("^[ㄱ-ㅎ ㅏ-ㅣ 가-힣]$")) {
			return false;
		}
		
		return true;
	}
	
	private static boolean emailCheck(String email) {
		
		if (email.length() < 11 || email.length() > 19) {
			return false;
		}
		
		boolean containsDelimiter = email.contains("@");
		if (!containsDelimiter) {
			return false;
		}
		
		int delimiterIndex = email.indexOf('@');
		String domain = email.substring(delimiterIndex + 1);
		if (!domain.equals("email.com")) {
			return false;
		}
		
		return true;
	}
}

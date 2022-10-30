package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		HashMap<String, String> tmpAnswer = new HashMap<>();
		for (int i = 0; i < forms.size() - 1; i++) {
			String email = forms.get(i).get(0);
			String nickName = forms.get(i).get(1);
			if (!emailCheck(email) && !nicknameCheck(nickName)) {
				continue;
			}
			
			// match
			for (int ii = 0; ii < nickName.length() - 1; ii++) {
				String targetSequence = nickName.substring(ii, ii + 2);
				
				for (int iii = i + 1; iii < forms.size(); iii++) {
					String targetEmail = forms.get(iii).get(0);
					String targetNickname = forms.get(iii).get(1);
					if (!emailCheck(targetEmail) && !nicknameCheck(targetNickname)) {
						continue;
					}
					
					boolean contains = targetNickname.contains(targetSequence);
					if (contains) {
						tmpAnswer.put(targetEmail, targetNickname);
						tmpAnswer.put(email, nickName);
						break;
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

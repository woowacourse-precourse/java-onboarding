package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("");
        if (!restrictions(forms)) {
        	answer = duplicate(forms);
        }
        return answer;
    }
    
    private static boolean restrictions(List<List<String>> forms) {
    	if (!checkingCrew(forms) || !checkingEmail(forms)) {
    		return true;
    	}
		return false;
	}

	static boolean checkingEmail(List<List<String>> forms) {
		for (int i = 0; i < forms.size(); i++) {
			String email = forms.get(i).get(0);
			if (email.length() < 11 || email.length() >= 20) {
				return false;
			}
		}
		return checkingDomain(forms);
	}

	private static boolean checkingDomain(List<List<String>> forms) {
		for (int i = 0; i < forms.size(); i++) {
			String email = forms.get(i).get(0);
			if (!email.contains("email.com")) {
				return false;
			}
		}
		return true;
	}

	static boolean checkingCrew(List<List<String>> forms) {
		if (1 > forms.size() || 10000 < forms.size()) {
			return false;
		}
		return checkingKorean(forms);
	}

	static boolean checkingKorean(List<List<String>> forms) {
		for (int i = 0; i < forms.size(); i++) {
			String[] strArray = forms.get(i).get(1).split("");
			for(int j = 0; j < strArray.length; j++) {
				if(!strArray[j].matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
					return false;
				}
			}
		}
		return true;
	}

	static List<String> duplicate(List<List<String>> forms) {
    	List<String> duplicateemails = new ArrayList<String>();
    	String nickname;
    	for (int i = 0; i < forms.size(); i++) {
    		nickname = forms.get(i).get(1);
    		for (int j = 0; j < nickname.length() - 1; j++) {
    			duplicateemails.addAll(findDuplicateNickname(forms, nickname.substring(j, j+2), i));
    		}
    	}
    	 List<String> newList = duplicateemails.stream().distinct().collect(Collectors.toList());
    	 Collections.sort(newList);
		return newList;
	}

	static List<String> findDuplicateNickname(List<List<String>> forms, String nickname, int i) {
		List<String> duolicateemails = new ArrayList<String>();
		List<String> duolicateemails2 = new ArrayList<String>();
		for(int k = i; k < forms.size(); k++) {
			if (forms.get(i).get(1).contains(nickname)) {
				duolicateemails.add(forms.get(i).get(0));
			}
			i++;
		}
		if (duolicateemails.size() == 1) {
			return duolicateemails2;
		}
		return duolicateemails;
	}
	
}

package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
	static HashMap<String, String> usedNickNamePart;
	static TreeSet<String> emailToBeSent;
	
	public static List<String> solution(List<List<String>> forms) {
		usedNickNamePart = new HashMap<>();
		emailToBeSent = new TreeSet<>();
		List<String> answer = List.of("answer");
		for (List<String> form : forms) {
			checkNickName(form);
		}
		answer = new ArrayList<>(emailToBeSent);
		return answer;
	}
	public static void checkNickName(List<String> form) {
		HashMap<String, String> myUsedNickNamePart = new HashMap<>();
		String myEmail = form.get(0);
		String myNickName = form.get(1);
		for (int i = 1; i < myNickName.length(); i++) {
			String myNickNamePart = "" + myNickName.charAt(i - 1) + myNickName.charAt(i);
			checkNickNamePart(myNickNamePart, myEmail);
			myUsedNickNamePart.put(myNickNamePart, myEmail);
		}
		usedNickNamePart.putAll(myUsedNickNamePart);
	}
	public static void checkNickNamePart(String myNickNamePart, String myEmail) {
		if (usedNickNamePart.containsKey(myNickNamePart)) {
			emailToBeSent.add(usedNickNamePart.get(myNickNamePart));
			emailToBeSent.add(myEmail);
		}
	}
}

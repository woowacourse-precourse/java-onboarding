package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
	static HashMap<String, String> usedNickNamePart = new HashMap<>();
	static TreeSet<String> emailToBeSent = new TreeSet<>();
	
	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = List.of("answer");
		for (List<String> form : forms) {
			checkNickName(form);
		}
		answer = new ArrayList<>(emailToBeSent);
		return answer;
	}
	public static void checkNickName(List<String> emailAndName) {
		HashMap<String, String> myUsedNickNamePart = new HashMap<>();
		String myEmail = emailAndName.get(0);
		String myNickName = emailAndName.get(1);
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

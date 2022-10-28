package onboarding;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Problem2 {
	public static String solution(String cryptogram) {
		String answer = "answer";

		while (checkDuplication(cryptogram)) {
			cryptogram = removeDuplication(cryptogram);
		}
		answer = cryptogram;
		return answer;

	}

	private static boolean checkDuplication(String str) {

		for (int i = 0; i < str.length() - 1; i++)
			//중복이 있을 경우
			if (str.charAt(i) == str.charAt(i + 1)) {
				return true;
			}

		// 중복이 없을 경우
		return false;
	}

	private static String removeDuplication(String str) {

		Stack<Integer> storage = new Stack<>();
		LinkedList<Character> lst = new LinkedList<>();

		for (int i = 0; i < str.length(); i++)
			lst.add(str.charAt(i));

		for (int i = 0; i < str.length() - 1; i++)
			if (str.charAt(i) == str.charAt(i + 1)) {
				storage.push(i);
				storage.push(i + 1);
				i += 1;
			}

		for (int i = storage.size(); i >= 1; i--) {
			lst.remove(storage.pop().intValue());
		}

		String temp = "";
		
		for (Character c : lst) {
			temp += c;
		}

		return temp;
	}

}

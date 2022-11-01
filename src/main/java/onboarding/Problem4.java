package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem4 {

	public static String solution(String word) {

		String compareWord = word.toUpperCase();
		String answer = "";

		String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };
		List<String> alphabetAry = Arrays.asList(alphabet);

		List<String> wordAry = Arrays.asList(word.split(""));
		List<String> compareWordAry = Arrays.asList(compareWord.split(""));
		List<Integer> index = new ArrayList<Integer>();

		for (String ch : compareWordAry) {

			if (ch == " ") {
				index.add(-1);
			} else {
				index.add(alphabetAry.indexOf(ch));
			}

		}

		Collections.reverse(alphabetAry);
		String[] alphabetRev = alphabetAry.toArray(alphabet);
		List<String> alphabetRevAry = Arrays.asList(alphabetRev);
		List<String> revWord = new ArrayList<String>();

		for(int i = 0; i < wordAry.size(); i++) {
			int indexNum = index.get(i);
			String character = wordAry.get(i);
			if (Character.isUpperCase(character.charAt(0))) {
				revWord.add(alphabetRevAry.get(indexNum));
			} else if (indexNum == -1) {
				revWord.add(" ");
			} else {
				revWord.add(alphabetRevAry.get(indexNum).toLowerCase());
			}
		}

		for(String str : revWord) {
			answer += str;
		}
		System.out.println(answer);
		return answer;
	}
}

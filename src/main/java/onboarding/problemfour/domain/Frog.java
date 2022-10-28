package onboarding.problemfour.domain;

import java.util.HashMap;


public class Frog {

	private HashMap<Character, Character> dictionary=new HashMap<>();

	public Frog() {

		for(int i=0; i<26; i++){
			dictionary.put((char)('A'+i),(char)('Z'-i));
			dictionary.put((char)('a'+i),(char)('z'-i));
		}

	}
}

package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        
        answer =  decode(cryptogram);
        
        return answer;
    }

    
    /**
     * 암호를 복호화한다.
     * @param 암호화된 단어
     * @return 복호화된 단어
     */
	private static String decode(String cryptogram) {
	
		List<Character> spellings = stringToCharacterList(cryptogram);
		
		boolean hasDuplicate = true;
		while(hasDuplicate) {
			hasDuplicate = hasDuplication(spellings);
		}
		
		return CharacterListToString(spellings);
	}
	 
    /**
     * 단어를 철자의 배열로 변경한다.
     * @param 암호화된 단어
     * @return 단어 철자의 배열
     */
	
	private static List<Character> stringToCharacterList(String cryptogram) {

		List<Character> list =  new ArrayList<Character>();
		for (Character character : cryptogram.toCharArray()) {
			list.add(character);
		}
		return list;
	}
	 
    /**
     * 단어가 중복된 철자룰 포함하고 있는지 확인한다.
     * @param 단어 철자의 배열
     * @return 포함여부
     */
	private static boolean hasDuplication(List<Character> spellings) {
		boolean duplicateIndex = false;
		for (int i = 1; i < spellings.size() ; i++) {
			duplicateIndex = checkDuplication(spellings,i)? true : duplicateIndex;
		}
		return duplicateIndex;	
	}
	
	/**
     * 배열의 특정 index가 그 이전 index와 동일한지 확인한다
     * @param 단어 철자의 배열, 확인할 index
     * @return 중복여부
     */
	private static boolean checkDuplication(List<Character> spellings, int index) {
		
		boolean duplicateIndex = false;

		Character c = spellings.get(index);
		Character exC = spellings.get(index-1);
		
		if(c==exC) {
			duplicateIndex = true;
			removeSpelling(spellings, index);
		}
		
		return duplicateIndex;
	}

	/**
     * 연속으로 중복된 철자를 제거한다.
     * @param 단어 철자의 배열, 삭제할 기준 index
     */
	private static void removeSpelling(List<Character> spellings, int index) {
		spellings.remove(index);
		spellings.remove(index-1);
	}

	/**
     * 철자의 배열을 단어로 만든다.
     * @param 단어 철자의 배열
     * @return 배열의 단어화
     */
	
	private static String CharacterListToString(List<Character> spellings) {
		char[] charArr =  new char[spellings.size()];
		
		for (int i = 0; i < spellings.size(); i++) {
			charArr[i] = spellings.get(i);
		}
		return String.copyValueOf(charArr);
	}
}

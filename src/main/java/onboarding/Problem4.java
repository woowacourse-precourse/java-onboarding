package onboarding;

// import java.util.List;
// import java.util.Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class Problem4 {

	public String solution(String word) {
		
		char[] arr = word.toCharArray();
		
		ArrayList<Character> reverseList = new ArrayList<Character>();
		
		ArrayList<Character> UPPERCASELIST = createAlphabetList('A');
		ArrayList<Character> LOWERCASELIST = createAlphabetList('a');

		ArrayList<Character> REVERSEUPPERCASELIST = (reverseNewList(UPPERCASELIST));
		ArrayList<Character> REVERSELOWERCASELIST = (reverseNewList(LOWERCASELIST));

		for (char a : arr) {

			boolean isUppercase = (int) a >= 65 && (int) a <= 90;
			boolean isLowercase = (int) a >= 97 && (int) a <= 122;

			if (isUppercase) {

				char character = replaceCharacter(a, UPPERCASELIST, REVERSEUPPERCASELIST);

				reverseList.add(character);
			}

			else if (isLowercase) {

				char character = replaceCharacter(a, LOWERCASELIST, REVERSELOWERCASELIST);

				reverseList.add(character);
			}

			else
				reverseList.add(a);
		}
		
		String answer = fromArrayListToString(reverseList);
		return answer;
	}
	
	////////////////////////
	// ㅜ 알파벳 배열을 만드는 함수
	// public static char[] createAlphabetArr(char a) {
	//
	// char[] alphabetArr = new char[26];
	//
	// for (int i = 0; i < alphabetArr.length; i++) {
	//
	// alphabetArr[i] = (char) (a + i);
	// }
	//
	// return alphabetArr;
	// }

	////////////////////////
	// ㅜ 알파벳 배열을 만드는 함수
	public ArrayList<Character> createAlphabetList(char a) {

		int LENGTH = 26;

		ArrayList<Character> alphabetList = new ArrayList<Character>(LENGTH);

		// ㅜ 0
		// System.out.println(alphabetList.size());

		for (int i = 0; i < LENGTH; i++) {

			char character = (char) (a + i);

			alphabetList.add(character);
		}

		return alphabetList;
	}

	///////////////////////////
	// ㅜ 배열을 뒤집어서 반환하는 함수
	// public static char[] reverseNewArr(char[] arr) {
	//
	// // ㅜ Type mismatch
	// // ㅜ Character 타입과 char[] 타입이 왜 다른 걸까...
	// // List<Character> reverse = Arrays.asList(arr);
	//
	// // ㅜ 배열을 리스트로 변환
	// List<char[]> list = Arrays.asList(arr);
	//
	// // ㅜ [[C@1eb44e46]
	// // System.out.println(list);
	//
	// // ㅜ 1
	// // System.out.println(list.size());
	//
	// // ㅜ 인자로 전달된 리스트의 요소 순서를 뒤집는 함수
	// // Collections.reverse(list);
	//
	// // ㅜ [[C@1eb44e46]
	// // System.out.println(list);
	//
	// char[] reverseArr = new char[26];
	//
	// for (int i = 0; i < arr.length; i++) {
	//
	// int idx = arr.length - 1 - i;
	//
	// reverseArr[i] = list.get(0)[idx];
	// }
	// // ㅜ 정방향
	// // System.out.println(list.get(0));
	// // System.out.println(arr);
	//
	// return reverseArr;
	// }

	///////////////////////////
	// ㅜ 배열을 뒤집어서 반환하는 함수
	public ArrayList<Character> reverseNewList(ArrayList<Character> alphabetList) {

		ArrayList<Character> newList = new ArrayList<Character>(alphabetList);

		Collections.reverse(newList);

		return newList;
	}

	///////////////////////////////////////
	// ㅜ 어레이리스트를 문자열로 변환해서 반환하는 함수
	public String fromArrayListToString(ArrayList<Character> list) {

		StringBuilder stringBuilder = new StringBuilder(list.size());

		for (char a : list) {

			stringBuilder.append(a);
		}
		
		return stringBuilder.toString();
	}

	/////////////////////////////////////////////////////////////////////////////
	// ㅜ 리스트에서 일치하는 알파벳 인덱스를 찾아 뒤집은 리스트에서 인덱스에 해당하는 값을 반환하는 함수
	public char replaceCharacter(char character, ArrayList<Character> alphabetList,
			ArrayList<Character> reverseAlphabetList) {

		int idx = alphabetList.indexOf(character);

		return reverseAlphabetList.get(idx);
	}
}
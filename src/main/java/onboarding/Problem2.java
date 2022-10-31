package onboarding;

import java.util.ArrayList;

public class Problem2 {
	public static String solution(String cryptogram) {
		while (true) {
			ArrayList<Integer[]> indexPair = new ArrayList<>();
			boolean changeFlag = false;
			
			// 역순
			for (int end = cryptogram.length() - 1; end > 0; end--) {
				
				// 1. 중복되는 글자가 2글자 이상인가? boolean (중복되는 글자가 없으면 continue)
				if (cryptogram.charAt(end) != cryptogram.charAt(end - 1)) {
					continue;
				}
				changeFlag = true;
				
				// 2. 중복되는 글자의 인덱스는 어디 어디인가?
				int start = findStartIndex(cryptogram, end);
				
				// 3. 한사이클에서 중복되는 글자 저장
				Integer[] pair = {start, end};
				indexPair.add(pair);
				
				// 4. 중복된 값 아래부터 시작
				end = start;
			}
			
			if (!changeFlag) {
				break;
			}
			
			for (Integer[] pair : indexPair) {
				cryptogram = substringCrytogram(cryptogram, pair[0], pair[1] + 1);
			}
			
		}
		return cryptogram;
	}
	
	private static String substringCrytogram(String cryptogram, int start, int end) {
		
		String beforeTarget = cryptogram.substring(0, start);
		String afterTarget = cryptogram.substring(end);
		String result = beforeTarget.concat(afterTarget);
		
		return result;
	}
	
	private static int findStartIndex(String cryptogram, int lastIndex) {
		int firstIndex = lastIndex - 1;
		for (int i = lastIndex - 1; i >= 0; i--) {
			if (cryptogram.charAt(i) != cryptogram.charAt(lastIndex)) {
				firstIndex = i + 1;
				break;
			}
			if (i == 0) {
				firstIndex = 0;
				break;
			}
		}
		return firstIndex;
	}
	
}
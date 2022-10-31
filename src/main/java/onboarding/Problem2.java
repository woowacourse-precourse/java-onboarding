package onboarding;

public class Problem2 {

	public static String chkOrDelStr(String str) {
		// 단어의 길이 0~1인지 확인
		if (str.length() == 0 || str.length() == 1) {
			return str;
		// 2이상은 중복이 있을수도있으므로 중복 검사
		} else {
			// 단어 중복 없을때 까지 반복  
			while (true) {
				
				boolean bool = false;
				for (int i = 0; i < str.length() - 1; i++) {
					if (str.charAt(i) == str.charAt(i + 1)) {
						// 처음부터 ~ i 전까지          // i+1 다음부터   
						str = str.substring(0, i) + str.substring(i + 2);
						bool = true;
					}
				}
				// 반복된 단어 없으면 탈출
				if (bool == false) {
					break;
				}
			}
			return str;
		}
	}

	public static String solution(String cryptogram) {
		return chkOrDelStr(cryptogram);
	}
}

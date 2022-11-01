package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		// 모두 중복될 경우 빈 문자열 return
		if (cryptogram.length() == 2 && cryptogram.charAt(0) == cryptogram.charAt(1)) {
			return "";
		}

		// char 배열로 변환 후 현재 idx i, 다음 idx k
		char[] c = cryptogram.toCharArray();

		int i = 0;
		int k = 0;

		// 현재와 이전 문자가 동일한지 비교
		for (i = 1; i < c.length; i++) {
			if (c[i - 1] != c[i]) {
				c[k++] = c[i - 1]; // 동일하지 않으면 추가
			} else {
				while (i < c.length && c[i - 1] == c[i]) { // 중복 제거
					i++;
				}
			}
		}

		c[k++] = c[i - 1]; // 마지막 문자는 따로 추가



		return "";

	}

//	public static void main(String args) {
//		String str = "zyelleyz";
//		char[] c = str.toCharArray();
//
//		int i = 0;
//		int k = 0;
//
//		for (i = 1; i < c.length; i++) {
//			if (c[i - 1] != c[i]) {
//				c[k++] = c[i - 1];
//			} else {
//				while (i < c.length && c[i - 1] == c[i]) {
//					i++;
//				}
//			}
//		}
//
//		c[k++] = c[i - 1];
//
//		String s = new String(c).substring(0, k);
//
//		if (k != c.length) {
//			System.out.println(s);
//			main(s);
//		}
//
//		System.out.println(s);
//	}


}

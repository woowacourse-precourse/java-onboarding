package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		// 모두 중복될 경우 빈 문자열 return
		if (cryptogram.length() == 2 && cryptogram.charAt(0) == cryptogram.charAt(1)) {
			return "";
		}

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

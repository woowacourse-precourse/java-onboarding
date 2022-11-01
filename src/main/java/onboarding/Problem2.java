package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		String answer = "";

//		for (int i = 0; i < cryptogram.length(); i++) {
//			if (cryptogram.indexOf(cryptogram.charAt(i)) == i) {
//				answer += cryptogram.charAt(i);
//			}
//		}

		return answer;
	}

	public static void main(String[] args) {
		String str = "browoanoommnaon";
		System.out.println(str.charAt(2));
		StringBuilder sb = new StringBuilder();
		int k = 0;
		char[] chars = str.toCharArray();

//	System.out.println(str.indexOf(str.charAt(4)));

		sb.append(str.charAt(0));

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(i - 1)) {
				sb.append(str.charAt(i));
			}
		}

		System.out.println(sb);
	}
}

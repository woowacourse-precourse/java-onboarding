package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";   // String answer ="answer"인데 임의로 변경



        return answer;
    }
}

//		for (int i = 0; i < str.length(); i ++) {
//			if(!result.contains(String.valueOf(str.charAt(i)))) {
//				result += String.valueOf(str.charAt(i));
//			}
//		}

/*
 * 문자열 [0]과 문자열 [1] 비교 하려고 했는데 안됨
 * for (int i = 0; i < str.length(); i++) {
 * for (int j = 1; j < str.length(); j++) {
 * if (!(str.charAt(i) == str.charAt(j))){
 * result += String.valueOf(str.charAt(i));
 * }
 * }
 * }
 */

/*
 * 일차원적 생각으로 연속되는 두 문자 중복되면 제
		int j = 1;
		for (int i = 0; i < str.length()-1; i++) {

			if ((str.charAt(i) == str.charAt(j))) {
				result += "";
				i++;
				i++;
				j++;
				j++;
			} else {
				result += str.charAt(i);
				j++;
			}

		}
 */


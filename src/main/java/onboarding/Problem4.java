package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        
        char [] momDic = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' ,'J', 'K', 'L', 'M', 
				'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'n', 'm', 'o',
				'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		char[] frogDic = {'Z', 'Y',	'X', 'W', 'V', 'U',	'T', 'S', 'R', 'Q',	'P', 'O', 'N',
				'M', 'L', 'K', 'J',	'I', 'H', 'G', 'F',	'E', 'D', 'C', 'B', 'A',
				'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n',
				'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};

		
		char[] chars = word.toCharArray();
		for (int i=0; i < word.length(); i++) {
			for (int j=0; j < momDic.length; j++) {
				if(chars[i] == (momDic[j])) {
					chars[i] = frogDic[j];
					break;
				}
			}
		}
		
		answer = String.valueOf(chars);
        return answer;
    }
}

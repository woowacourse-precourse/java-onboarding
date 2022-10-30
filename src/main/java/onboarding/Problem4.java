package onboarding;

public class Problem4 {
	public static String solution(String word) {
		String answer = "";

		for(int i = 0;i < word.length();i++)
		{
			char c = word.charAt(i);
			if('a' <= c && c <= 'z')
				answer += (char)('z' - (c - 'a'));
			else if('A' <= c && c <= 'Z')
				answer += (char)('Z' - (c - 'A'));
			else
				answer += c;
		}

		return answer;
	}
}

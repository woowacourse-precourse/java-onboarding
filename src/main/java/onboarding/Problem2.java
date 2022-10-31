package onboarding;

import java.util.Stack;

public class Problem2 {
	private static boolean isAllLowerCase(String cryptogram)
	{
		int i = 0;
		int len = cryptogram.length();

		while (i < len && Character.isLowerCase(cryptogram.charAt(i))) {
			i++;
		}
		return (i == len);
	}
	private static boolean isValidLength(String cryptogram)
	{
		int len = cryptogram.length();

		return (0 < len && len < 1001);
	}
	private static boolean isValidCryptogram(String cryptogram)
	{
		return (cryptogram != null && isAllLowerCase(cryptogram) && isValidLength(cryptogram));
	}
	private static int fillStack(Stack<Character> stack, String cryptogram, int index)
	{
		char newCh = cryptogram.charAt(index);
		char top;
		int len;

		if (stack.isEmpty() || stack.peek() != newCh) {
			stack.push(newCh);
			return (index + 1);
		}
		len = cryptogram.length();
		top = stack.pop();
		while (index < len && cryptogram.charAt(index) == top)
			index++;
		return (index);
	}
	private static Stack<Character> deciper(String cryptogram)
	{
		Stack<Character> stack = new Stack<>();
		int i = 1;
		int len = cryptogram.length();

		stack.push(cryptogram.charAt(0));
		while (i < len)
			i = fillStack(stack, cryptogram, i);
		return (stack);
	}
	private static String buildString(Stack<Character> stack)
	{
		StringBuilder sb = new StringBuilder();
		int size = stack.size();

		for (int i = 0; i < size; i++) {
			sb.append(stack.pop());
		}
		return (sb.reverse().toString());
	}
	public static String solution(String cryptogram) {
		if (!isValidCryptogram(cryptogram))
			throw (new RuntimeException("유효하지 않은 문자열"));
		return (buildString(deciper(cryptogram)));
	}
}

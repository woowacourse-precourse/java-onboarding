package onboarding;

import java.util.Deque;
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
	private static Stack<Character> getFilledStack(String cryptogram)
	{
		Stack<Character> stack = new Stack<>();
		char[] arr = cryptogram.toCharArray();

		for (char ch : arr)
			stack.push(ch);
		return (stack);
	}
	private static void removeDup(Stack<Character> left, Stack<Character> right)
	{
		boolean dupFlag = false;

		right.push(left.pop());
		if (!left.isEmpty() && left.peek() == right.peek())
			dupFlag = true;
		if (!dupFlag)
			return;
		while (!left.isEmpty() && left.peek() == right.peek())
			left.pop();
		right.pop();
	}
	private static void examineCryptogram(Stack<Character> left, Stack<Character> right)
	{
		while (!left.isEmpty()) {
			removeDup(left, right);
		}
	}
	private static void moveAllToLeft(Stack<Character> left, Stack<Character> right)
	{
		while (!right.isEmpty())
			left.push(right.pop());
	}
	private static Stack<Character> deciper(String cryptogram)
	{
		Stack<Character> left = getFilledStack(cryptogram);
		Stack<Character> right = new Stack<>();
		int sizeBefore = -1;

		while (left.size() != sizeBefore) {
			sizeBefore = left.size();
			examineCryptogram(left, right);
			moveAllToLeft(left, right);
		}
		return (left);
	}
	private static String buildString(Stack<Character> stack)
	{
		StringBuilder sb = new StringBuilder();

		while (!stack.isEmpty())
			sb.append(stack.pop());
		return (sb.reverse().toString());
	}
	public static String solution(String cryptogram) {
		if (!isValidCryptogram(cryptogram))
			throw (new RuntimeException("유효하지 않은 문자열"));
		return (buildString(deciper(cryptogram)));
	}
}

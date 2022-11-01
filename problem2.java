package onboarding;
import java.util.*;
import java.util.Scanner;

public class problem2 {
	public static String solution(StringBuilder cryptogram, int length) {
		StringBuilder str = cryptogram;
		
		for (int i = 0; i < length; i++) {
			if (str.length() == 0) {
				return "";
			}

			if (i+1 < str.length()) {
				if (str.charAt(i) == str.charAt(i + 1)) {
					str.deleteCharAt(i);
					str.deleteCharAt(i);
					length -= 2;
					solution(str, length);
				}
			}
		}
		return str.toString();
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		StringBuilder str = new StringBuilder(s);
		System.out.println(solution(str, s.length()));
	}
}


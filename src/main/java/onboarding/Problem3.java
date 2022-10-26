package onboarding;

public class Problem3 {

	private static final int size = 10001;
	private static final int[] countList = new int[size];
	private static final int[] checkList = {3, 6, 9};

	public static int solution(int number) {
		initialCountList();
		return countList[number];
	}

	private static void initialCountList() {
		for (int i = 1; i < size; i++) {
			int quantity = countQuantity(i);
			countList[i] = quantity + countList[i - 1];
		}
	}

	private static int countQuantity(int number) {
		int count = 0;
		while (number > 0) {
			int rest = number % 10;
			count += check369(rest);
			number /= 10;
		}

		return count;
	}

	private static int check369(int rest) {
		int count = 0;
		for (int n : checkList) {
			if (n == rest) {
				count++;
			}
		}
		return count;
	}

}

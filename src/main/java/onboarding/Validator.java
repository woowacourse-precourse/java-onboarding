package onboarding;

import java.util.List;

public class Validator {
	public static boolean isCorrectSize(List<Integer> array){
		if (array.size() == 2) {
			return true;
		}
		return false;
	}

	public static boolean isCorrectRange(List<Integer> array){
		if (array.indexOf(0) <= 1 || array.indexOf(0) >= 399){
			return false;
		}
		if (array.indexOf(1) <= 2 || array.indexOf(1) >= 400){
			return false;
		}
		return true;
	}

	public static boolean isConsecutive(List<Integer> array){
		if (array.indexOf(1) - array.indexOf(0) == 1){
			return true;
		}
		return false;
	}

	public static boolean isLeftOdd(List<Integer> array){
		if (array.indexOf(0) % 2 == 1){
			return true;
		}
		return false;
	}

	public static boolean isRightEven(List<Integer> array){
		if (array.indexOf(1) % 2 == 0){
			return true;
		}
		return false;
	}
}

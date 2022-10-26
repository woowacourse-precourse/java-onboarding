package onboarding;

import java.util.List;

class Problem1 {
    private static final int NUMBER_OF_DIGIT_DIVISION = 10;

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		return answer;
	}

	private static int digitAdd(Integer page) {
            int addValue = 0;
            while(page!=0){
                addValue += page % NUMBER_OF_DIGIT_DIVISION;
                page /= NUMBER_OF_DIGIT_DIVISION;
            }
            return addValue;
	}

    private static int digitMultiple(Integer page) {
        int multipleValue = 1;
        while(page!=0){
            multipleValue *= page % NUMBER_OF_DIGIT_DIVISION;
            page /= NUMBER_OF_DIGIT_DIVISION;
        }
        return multipleValue;
    }

}

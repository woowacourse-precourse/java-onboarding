package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        
        if (!exception(pobi) || !exception(crong)) {
        	answer = -1;
        }
        else {
        	answer = winner(pobi, crong);
        }
        
        return answer;
    }

	static boolean exception(List<Integer> person) {
		if (!checkLength2(person) || !checkingPage(person)) {
        	return false;
        }
		return true;
	}

	static int winner(List<Integer> pobi, List<Integer> crong) {
		int myScore1, myScore2, answer = Integer.MAX_VALUE;
        
        myScore1 = myScore(pobi);
        myScore2 = myScore(crong);
        
        answer = win(myScore1, myScore2);
        
        return answer;
	}

	static boolean checkLength2(List<Integer> person) {
		if (person.size() == 2) {
			return true;
		}
		return false;
	}

	static boolean checkingPage(List<Integer> person) {
    	if(person.get(0) + 1 == person.get(1)) {
    		return checkingPageNum(person);
    	}
    	return false;
	}
	static boolean checkingPageNum(List<Integer> person) {
		if (1 < person.get(0) && 400 > person.get(1)) {
			return checkingOddEvenPage(person);
		}
		return false;
	}

	static boolean checkingOddEvenPage(List<Integer> person) {
		if (person.get(0) % 2 == 1 && person.get(1) % 2 == 0) {
			return true;
		}
		return false;
	}

	static int maxNum(int page) {
		int sum = sum(page);
		int mul = mul(page);
		if (sum < mul) {
			return mul;
		}
		return sum;
	}
	static int sum(int page) {
		int sum = 0;
		int[] digits = eachDigit(page);
		for (int i = 0; i < digits.length; i++) {
			sum += digits[i];
		}
		return sum;
	}

	static int mul(int page) {
		int mul = 1;
		int[] digits = eachDigit(page);
		for (int i = 0; i < digits.length; i++) {
			mul *= digits[i];
		}
		return mul;
	}
	
	static int[] eachDigit(int page) {
		int[] digit = Stream.of(String.valueOf(page).split("")).mapToInt(Integer::parseInt).toArray();
		return digit;
	}
	
	static int myScore(List<Integer> person) {
		int maxLeftNum, maxRightNum;
		
		maxLeftNum = maxNum(person.get(0));
        maxRightNum = maxNum(person.get(1));
        
		return Math.max(maxLeftNum, maxRightNum);
	}
	
	static int win(int myScore1, int myScore2) {
		if(myScore1 > myScore2) {
			return 1;
		}
		else if (myScore1 < myScore2) {
			return 2;
		}
		else {
			return 0;
		}
	}
	
}
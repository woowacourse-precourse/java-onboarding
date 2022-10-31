package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        int pobi_max_number = 0;
        int crong_max_number = 0;

        if (!validate(pobi) || !validate(crong)) {
            return answer;
        }
        int[] pobi_calculate_array = {sumEveryPlaceValue(pobi.get(0)), sumEveryPlaceValue(pobi.get(1)), multipleEveryPlaceValue(pobi.get(0)), multipleEveryPlaceValue(pobi.get(1))};
        int[] crong_calculate_array = {sumEveryPlaceValue(crong.get(0)), sumEveryPlaceValue(crong.get(1)), multipleEveryPlaceValue(crong.get(0)), multipleEveryPlaceValue(crong.get(1))};

        pobi_max_number = getMaxNumber(pobi_calculate_array);
        crong_max_number = getMaxNumber(crong_calculate_array);

        if (pobi_max_number > crong_max_number) {
            return 1;
        }
        if (pobi_max_number == crong_max_number) {
            return 0;
        }
        if (pobi_max_number < crong_max_number) {
            return 2;
        }
        return answer;
    }

    private static boolean validate(List<Integer> pages) {
        if (pages.size() != 2) {
            return false;
        }
        if (pages.get(0) % 2 == 0) {
            return false;
        }
        if (pages.get(1) % 2 == 1) {
            return false;
        }
        if (1 != Math.abs(pages.get(0) - pages.get(1))) {
            return false;
        }
        return true;
    }

    private static int sumEveryPlaceValue(int number) {
        int sum_value = 0;
        String[] string_array = String.valueOf(number).split("");
        for (String place_value: string_array) {
            sum_value += Integer.valueOf(place_value);
        }
        return sum_value;
    }

    private static int multipleEveryPlaceValue(int number) {
        int multiple_value = 1;
        String[] string_array = String.valueOf(number).split("");
        for (String place_value: string_array) {
            multiple_value *= Integer.valueOf(place_value);
        }
        return multiple_value;
    }

    private static int getMaxNumber(int[] numbers) {
        return Arrays.stream(numbers).max().getAsInt();
    }
}
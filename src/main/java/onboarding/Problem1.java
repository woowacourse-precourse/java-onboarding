package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        try {
            Exception.validateParticipantPages(Arrays.asList(pobi, crong));

            int pobiScore = getFinalScore(pobi);
            int crongScore = getFinalScore(crong);

            answer = determinateWinner(pobiScore, crongScore);
        } catch (IllegalArgumentException e) {

        }

        return answer;
    }

    public static int getFinalScore(List<Integer> participant) {
        List<List<Integer>> seperatedDigits = separateDigits(participant);
        List<Integer> cases = new ArrayList<>();

        for (List<Integer> page : seperatedDigits) {
            cases.add(add(page));
            cases.add(multiply(page));
        }

        int max = getMax(cases);

        return max;
    }

    public static List<List<Integer>> separateDigits(List<Integer> pages) {
        List<List<Integer>> digitsNum = new ArrayList<>();

        for (int page : pages) {
            int [] onePage = Stream.of(String.valueOf(page).split("")).mapToInt(Integer::parseInt).toArray();
            List<Integer> al = Arrays.stream(onePage).boxed().collect(Collectors.toList());
            digitsNum.add(al);
        }

        return digitsNum;
    }

    public static int add(List<Integer> page) {
        return page.stream().mapToInt(Integer::intValue).sum();
    }

    public static int multiply(List<Integer> page) {
        int mul = 1;

        for (int num : page) {
            mul *= num;
        }

        return mul;
    }

    public static int getMax(List<Integer> cases) {
        int max = cases.stream().mapToInt(x -> x).max().getAsInt();
        return max;
    }

    public static int determinateWinner(int pobi, int crong) {
        if (pobi > crong) {
            return 1;
        }
        if (crong > pobi) {
            return 2;
        }
        if (crong == pobi) {
            return 0;
        }
        return -1;
    }
}

class Exception {
    static final String ERROR_MESSAGE = "페이지 번호가 잘못 입력되었습니다.";

    public static void validateParticipantPages(List<List<Integer>> participants) {
        for (List<Integer> participant : participants) {
            validateSizeTwo(participant);
            validatePageRange(participant);
            validateInOrder(participant);
        }
    }
    public static void validateSizeTwo(List<Integer> participant) {
        if (participant.size() != 2) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static void validatePageRange(List<Integer> participant) {
        for (int page : participant) {
            if (page < 2 || page > 399) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
        }
    }

    public static void validateInOrder(List<Integer> participant) {
        int left = participant.get(0);
        int right = participant.get(1);

        if (left + 1 != right) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

}
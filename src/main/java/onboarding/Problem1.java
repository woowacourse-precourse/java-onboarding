package onboarding;

import onboarding.problem1.CalculateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class Problem1 {

    public boolean checkOutOfRangeException(List<Integer> list) {
        return (list.get(0) > 1) && (list.get(1) < 400);
    }

   public boolean checkPageNumberValidityException(List<Integer> list) {
       return (list.get(0) % 2 == 1) && (list.get(1) - list.get(0) == 1);
   }

    public boolean checkException(List<Integer> list) {
        return checkOutOfRangeException(list) && checkPageNumberValidityException(list);
    }

    public List<Integer> calculateEachDigitOfPageNumberWithStrategy(List<Integer> list, CalculateStrategy calculateStrategy) {
        List<Integer> resultList = new ArrayList<>();
        for (Integer integer : list) {
            int result = calculateStrategy.calculateEachDigitOfPageNumber(integer);
            resultList.add(result);
        }
        return resultList;
    }

    public List<Integer> addEachDigitOfPageNumber(List<Integer> list) {
        return calculateEachDigitOfPageNumberWithStrategy(list,
                new CalculateStrategy() {
                    @Override
                    public int calculateEachDigitOfPageNumber(int pageNumber) {
                        int summation = 0;
                        while (pageNumber > 0) {
                            summation += pageNumber % 10;
                            pageNumber /= 10;
                        }
                        return summation;
                    }
                });
    }

    public List<Integer> multiplyEachDigitOfPageNumber(List<Integer> list) {
        int multiplication;
        List<Integer> multiplicationList = new ArrayList<>();
        for (Integer integer : list) {
            multiplication = 1;
            while (integer > 0){
                multiplication *= integer % 10;
                integer /= 10;
            }
            multiplicationList.add(multiplication);
        }
        return multiplicationList;
    }

    public List<Integer> calculateEachDigitOfPageNumber(List<Integer> list) {
        List<Integer> calculationList = addEachDigitOfPageNumber(list);
        calculationList.addAll(multiplyEachDigitOfPageNumber(list));
        return calculationList;
    }

    public int getMaxValue(List<Integer> list) {
        int maxValue = list.stream()
                .max(Integer::compare)
                .orElseThrow(NoSuchElementException::new);
        return maxValue;
    }

    public int findWinner(List<Integer> maxValueOfPlayers) {
        int pobiMaxValue = maxValueOfPlayers.get(0);
        int crongMaxValue = maxValueOfPlayers.get(1);

        if (pobiMaxValue > crongMaxValue) {
            return 1;
        } else if (pobiMaxValue < crongMaxValue) {
            return 2;
        }
        return 0;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 problem1 = new Problem1();

        if (!problem1.checkException(pobi) && problem1.checkException(crong)) {
            return -1;
        }

        List<Integer> pobiCalculationValues = problem1.calculateEachDigitOfPageNumber(pobi);
        int pobiMaxValue = problem1.getMaxValue(pobiCalculationValues);

        List<Integer> crongCalculationValues = problem1.calculateEachDigitOfPageNumber(crong);
        int crongMaxValue = problem1.getMaxValue(crongCalculationValues);

        List<Integer> maxValueOfPlayers = List.of(pobiMaxValue, crongMaxValue);

        return problem1.findWinner(maxValueOfPlayers);
    }
}
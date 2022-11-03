package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {


    public static List<Integer> solution(int money) {
        List<Integer> numberOfBills = new ArrayList<>();
        getNumberOfBills(money, numberOfBills);

        List<Integer> answer = numberOfBills;
        return answer;
    }

    public static List<Integer> getNumberOfBills(int money, List<Integer> numberOfBills) {

        numberOfBills.add(money % 10); // 일 원 동전
        int temp = money / 10;

        for(; numberOfBills.size() != 7; temp /= 10) {
            numberOfBills.addAll(calculateNumberOfBills(temp % 10));
        }
        numberOfBills.addAll(calculateNumberOfBills(temp));; // 만 원권, 오 만원권

        Collections.reverse(numberOfBills);
        return numberOfBills;
    }

    public static List<Integer> calculateNumberOfBills(int placeValue) {
        List<Integer> billNumberPortion = new ArrayList<>();
        billNumberPortion.add(placeValue % 5); // (placeValue * 1)원
        billNumberPortion.add(placeValue / 5); // (placeValue * 5)원

        return billNumberPortion;
    }

}

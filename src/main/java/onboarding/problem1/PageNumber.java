package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PageNumber  {
    private static final int MIN = 2;
    private static final int MAX = 398;
    private final List<Integer> pageDigits = new ArrayList<>();
    private final int page;
    public PageNumber(int page) {
        validatePage(page);
        getDigit(page);
        this.page = page;
    }

    private void validatePage(int page){
        validateMIN(page);
        validateMAX(page);
    }

    private static void validateMIN(int page) {
        if (page < MIN){
            throw new PageException("첫장 이후의 장을 입력해주세요.");
        }
    }
    private static void validateMAX(int page) {
        if (page > MAX){
            throw new PageException("마지막 이전의 장을 입력해주세요.");
        }
    }

    public int getPage() {
        return page;
    }

    public int getMax() {
        return Math.max(sumAll(),multiply());
    }

    private int sumAll() {
        return pageDigits.stream().reduce(Integer::sum).orElseThrow();
    }

    private int multiply() {
        return pageDigits.stream().reduce(1, (a, b) -> a * b);
    }
    private List<Integer> getDigit(Integer pageNumber) {
        int i, temp, count = 0;
        temp = pageNumber;
        while (temp > 0) {
            count++;
            temp = temp / 10;
        }
        double num = Math.pow(10, count - 1);
        i = (int) num;
        for (; i > 0; i /= 10) {
            pageDigits.add(pageNumber / i % 10);
        }
        return pageDigits;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageNumber that = (PageNumber) o;
        return Objects.equals(pageDigits, that.pageDigits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageDigits);
    }


}

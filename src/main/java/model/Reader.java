package model;

import java.util.List;

public class Reader {
    private List<Integer> pages;
    private int maxValue;

    public Reader(List<Integer> pages) {
        int leftMaxValue = getBiggerValue(pages.get(0));
        int rightMaxValue = getBiggerValue(pages.get(1));

        this.pages = pages;
        // 4번과정을 통해서 큰 수를 maxValue에 저장
        this.maxValue = Math.max(leftMaxValue, rightMaxValue);
    }

    public int getMaxValue() {
        return this.maxValue;
    }

    // 2~3번 과정 메소드
    int getBiggerValue(int page) {
        return Math.max(addEachDigit(page), multiplyEachDigit(page));
    }

    //각자리수 더하는 메소드
    int addEachDigit(int page) {
        int result = 0;
        while (page > 0) {
            result += page % 10;
            page /= 10;
        }
        return result;

    }

    //각 자리수 곱하는 메소드
    int multiplyEachDigit(int page) {
        int result = 1;
        while (page > 0) {
            result *= page % 10;
            page /= 10;
        }
        return result;
    }
}

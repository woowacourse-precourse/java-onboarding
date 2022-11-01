package model;

import java.util.List;

public class Reader {
    private int maxValue;

    public Reader(List<Integer> pages) {
        int leftMaxValue = getBiggerValue(pages.get(0));
        int rightMaxValue = getBiggerValue(pages.get(1));
        this.maxValue = Math.max(leftMaxValue, rightMaxValue);
    }

    public int getMaxValue() {
        return this.maxValue;
    }

    int getBiggerValue(int page) {
        return Math.max(addEachDigit(page), multiplyEachDigit(page));
    }

    int addEachDigit(int page) {
        int result = 0;
        while (page > 0) {
            result += page % 10;
            page /= 10;
        }
        return result;

    }

    int multiplyEachDigit(int page) {
        int result = 1;
        while (page > 0) {
            result *= page % 10;
            page /= 10;
        }
        return result;
    }
}

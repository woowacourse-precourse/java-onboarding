package onboarding.problem1;

import java.util.List;

/**
 * Checks availability
 */
public class PageChecker {

    private final int SIZE;

    /**
     * Constructor with size
     * @param size max page of book
     */
    public PageChecker(int size) {
        SIZE = size;
    }

    /**
     * Check if input values are available
     * @param pages page numbers when opening book
     * @return true if available
     */
    public boolean isAvailableInput(List<Integer> pages) {
        return isAvailableSize(pages.size()) && isAvailableValues(pages.get(0), pages.get(1));
    }

    /**
     * Check if size is available
     * @param size size of pages
     * @return true if size is 2
     */
    private boolean isAvailableSize(int size) {
        return size == 2;
    }

    /**
     * Check if values are available
     * @param left left page
     * @param right right page
     * @return return true if left and right is in range, left is odd number and left + 1 is right
     */
    private boolean isAvailableValues(int left, int right) {
        return left < SIZE && left % 2 == 1 && left + 1 == right;
    }
}

package problem1;

public class Validate {
    public static boolean pageBoundaryCheck(Integer left, Integer right) {
        return (1 <= left && left <= 400) && (1 <= right && right <= 400);
    }

    public static boolean pageValidCheck(Integer left, Integer right) {
        return ((left % 2 == 1 && right % 2 == 0) && right == left + 1);
    }
}

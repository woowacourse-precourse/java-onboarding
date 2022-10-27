package custom.problem1;


import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 *  > List<Ineger> pages를 1급 컬렉션으로 구현
 *  page 원시 객체를 Page로 랩핑
 *  목적은 일급 컬렉션인데 주어진 리스트가 입력이 2로 고정이여서 두개의 인스턴스 변수를 사용했는데
 *  엄밀하게 일급 컬렉션인지는 헷갈림
 */
public class BookPages {

    private final Page leftPage;
    private final Page rightPage;

    public BookPages(List<Integer> pages) {
        if (pages.size() != 2) {
            throw new RuntimeException("BookPage는 페이지가 2개여야 합니다");
        }
        if (pages.get(1) - pages.get(0) != 1) {
            throw new RuntimeException("좌우 페이지는 1 크기 차이만 허용합니다");
        }
        this.leftPage = new Page(pages.get(0), Status.LEFT);
        this.rightPage = new Page(pages.get(1), Status.RIGHT);
    }

    public int getMaxNumber() {
        BinaryOperator<Integer> mul = (o1, o2) -> o1 * o2;
        BinaryOperator<Integer> sum = (o1, o2) -> o1 + o2;
        return Collections.max(
            List.of(
                Calculator.calculateNumber(leftPage.getValue(), sum),
                Calculator.calculateNumber(leftPage.getValue(), mul),
                Calculator.calculateNumber(rightPage.getValue(), sum),
                Calculator.calculateNumber(rightPage.getValue(), mul)
            )
        );
    }
}


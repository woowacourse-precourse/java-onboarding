package onboarding.problem7.collection;

import onboarding.problem7.validation.VisitorsValidator;

import java.util.List;
import java.util.function.Consumer;

/**
 * 방문자의 이름 목록을 관리하는 일급 컬렉션입니다.
 * @author BackFoxx
 */
public class Visitors {
    private final List<String> visitors;

    private Visitors(List<String> visitors) {
        this.visitors = visitors;
    }

    /**
     * 주어진 이름 목록을 이용해 Visitors 객체를 만드는 메소드입니다.
     * @param visitors 방문자 이름 값이 담긴 리스트입니다.
     */
    public static Visitors of(List<String> visitors) {
        VisitorsValidator.validate(visitors);
        return new Visitors(visitors);
    }

    public void forEach(Consumer<? super String> action) {
        visitors.forEach(action);
    }
}

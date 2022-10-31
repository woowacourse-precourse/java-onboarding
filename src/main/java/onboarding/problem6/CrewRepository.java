package onboarding.problem6;

import static onboarding.problem6.consts.FormIndexConst.FORM_EMAIL_INDEX;
import static onboarding.problem6.consts.FormIndexConst.FORM_NICKNAME_INDEX;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 크루의 정보를 관리하는 일급 컬렉션
 */
public class CrewRepository {

    /**
     * 크루의 정보를 관리하는 컬렉션
     */
    private final List<Crew> crews;

    /**
     * 크루의 정보를 초기화하는 생성자
     *
     * @param forms String 타입의 크루 이메일, 닉네임 정보
     */
    public CrewRepository(List<List<String>> forms) {
        this.crews = initCrews(forms);
    }

    /**
     * String 타입의 크루 정보를 Crew 타입으로 변환하는 메소드
     *
     * @param forms 크루의 이메일, 닉네임 정보
     * @return Crew 타입의 크루 정보 List
     */
    private List<Crew> initCrews(List<List<String>> forms) {
        return forms.stream()
            .map(crew -> new Crew(crew.get(FORM_EMAIL_INDEX), crew.get(FORM_NICKNAME_INDEX)))
            .collect(Collectors.toList());
    }

    /**
     * 모든 크루의 정보를 Stream 타입으로 반환하는 메소드
     *
     * @return Stream 타입의 크루 정보
     */
    public Stream<Crew> findAllCrewStream() {
        return crews.stream();
    }
}

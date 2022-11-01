package onboarding.problem6.repository;

import onboarding.problem6.vo.Crew;

import java.util.List;

/**
 * Crew 의 상태를 관리하는 리포지토리 인터페이스입니다.
 * @author BackFoxx
 */
public interface CrewRepository {
    /**
     * Crew 객체 하나를 저장합니다.
     * @param crew 저장할 Crew 객체입니다.
     */
    void save(Crew crew);

    /**
     * UserRepository 가 갖고 있는 Crew 리스트 전체를 조회합니다.
     */
    List<Crew> findAll();

    /**
     * name 필드에 word 값이 포함된 Crew 를 전부 조회합니다.
     * @param word name 값에 포함되었는 지 확인할 문자열입니다.
     */
    List<Crew> findAllByNameContaining(String word);
}

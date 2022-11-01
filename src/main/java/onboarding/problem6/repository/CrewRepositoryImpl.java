package onboarding.problem6.repository;

import onboarding.problem6.vo.Crew;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * List<Crew> 자료구조에 저장되어 있는
 * Crew 리스트의 상태를 관리하는 리포지토리 클래스입니다.
 * @author BackFoxx
 */
public class CrewRepositoryImpl implements CrewRepository {
    private final List<Crew> crews;

    public CrewRepositoryImpl() {
        this.crews = new ArrayList<>();
    }

    public void save(Crew crew) {
        crews.add(crew);
    }

    public List<Crew> findAll() {
        return crews;
    }

    public List<Crew> findAllByNameContaining(String word) {
        return crews.stream()
                .filter(crew -> crew.getName().contains(word))
                .collect(Collectors.toList());
    }
}

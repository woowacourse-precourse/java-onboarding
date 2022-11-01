package onboarding.problem6.service;

import onboarding.problem6.repository.CrewRepository;
import onboarding.problem6.validation.CrewValidator;
import onboarding.problem6.vo.Crew;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Crew 와 관련한 비즈니스 로직을 진행하는 서비스 레이어 클래스입니다.
 * @author BackFoxx
 */
public class CrewService {
    private final CrewRepository crewRepository;

    public CrewService(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    /**
     * 주어진 배열을 Crew 로 변환해 저장하는 메소드입니다.
     * @param crews <이메일, 이름> 으로 이루어진 List 의 리스트입니다.
     */
    public void saveAllCrews(List<List<String>> crews) {
        CrewValidator.validate(crews);
        crews.forEach(form -> crewRepository.save(Crew.of(form.get(0), form.get(1))));
    }

    /**
     * 현재까지 저장된 크루들 중
     * 같은 글자가 연속으로 포함되어 유효하지 않은 이름을 가진 크루들의 이메일 리스트를 만들어 반환하는 메소드입니다.
     * @return 유효하지 않은 이름을 가진 크루들의 이메일 리스트입니다.
     */
    public List<String> findAllEmailByCrewsHavingInvalidName() {
        List<Crew> allCrews = crewRepository.findAll();
        return allCrews
                .stream().map(this::findAllInvalidEmailsFromUser)
                .flatMap(Set::stream).distinct().sorted().collect(Collectors.toList());
    }

    /**
     * 인자로 주어진 Crew 의 이름을 기준으로 하여,
     * 해당 Crew 의 이름 중 두 글자 이상이 연속으로 중복되는 크루들의 이메일 리스트를 만들어 반환하는 메소드입니다.
     * @param crew 유효성 검증의 기준이 되는 Crew 객체입니다.
     * @return 유효하지 않은 이름을 가진 크루들의 이메일 리스트입니다.
     */
    private Set<String> findAllInvalidEmailsFromUser(Crew crew) {
        TreeSet<String> result = new TreeSet<>();
        String name = crew.getName();
        for (int spellIndex = 0; spellIndex < name.length() - 1; spellIndex++) {
            String duplicatingWord = makeDuplicatingWord(name, spellIndex);
            Set<String> invalidEmails = findInvalidEmails(crew, duplicatingWord);
            result.addAll(invalidEmails);
        }
        return result;
    }

    /**
     * 인자로 넘어온 Crew 와 이름 중 일부 문자열을 기준으로 하여,
     * 해당 Crew 의 이름 중 두 글자 이상이 연속으로 중복되는 크루들의 이메일 리스트를 만들어 반환하는 메소드입니다.
     * @param crew 유효성 검증의 기준이 되는 Crew 객체입니다.
     * @param duplicatingWord 유효성 검증의 기준이 되는 이름의 일부 문자열입니다.
     * @return 유효하지 않은 이름을 가진 크루들의 이메일 리스트입니다.
     */
    private Set<String> findInvalidEmails(Crew crew, String duplicatingWord) {
        return crewRepository.findAllByNameContaining(duplicatingWord)
                .stream().filter(find -> !crew.equals(find))
                .map(find -> find.getEmail())
                .collect(Collectors.toSet());
    }

    /**
     * 유효성 검증의 기준이 되는 이름의 일부 문자열을 생성하는 문자열입니다.
     */
    private static String makeDuplicatingWord(String name, int index) {
        return name.substring(index, index + 2);
    }
}

package onboarding.problem6;

import static onboarding.problem6.consts.NicknameConst.NICKNAME_DUPLICATE_START_INDEX;
import static onboarding.problem6.consts.NicknameConst.NICKNAME_MINIMUM_LENGTH;
import static onboarding.problem6.consts.NicknameConst.PART_OF_NICKNAME_RANGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 중복된 닉네임을 가진 크루의 이메일 목록을 제공하는 클래스
 */
public class CrewDuplicateNicknameService {

    /**
     * (크루의 닉네임 중 2글자, 크루의 이메일) 방식으로 크루 정보를 관리하는 컬렉션
     */
    private final Map<String, String> partOfNicknameMap;

    /**
     * 중복된 닉네임을 가진 크루의 이메일 목록을 관리하는 컬렉션
     */
    private final Set<String> duplicateNicknameCrewSet;

    /**
     * 크루의 정보를 관리하는 일급 컬렉션
     */
    private final CrewRepository crewRepository;

    /**
     * 컬렉션을 초기화하는 생성자
     *
     * @param crewRepository 크루의 정보를 관리하는 일급 컬렉션
     */
    public CrewDuplicateNicknameService(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
        this.partOfNicknameMap = new HashMap<>();
        this.duplicateNicknameCrewSet = new HashSet<>();
    }

    /**
     * 모든 크루의 닉네임을 확인해 중복된 닉네임을 가진 크루 이메일을 구하는 메소드
     *
     * @return 중복된 닉네임을 가진 크루의 이메일
     */
    public List<String> findDuplicateCrews() {
        crewRepository.findAllCrewStream().forEach(this::processDuplicateCrewNickname);

        return sortAscCrewEmailList();
    }

    /**
     * 크루의 닉네임 길이만큼 반복하며 크루의 닉네임이 중복되었는지 확인하는 메소드
     *
     * @param crew 중복 닉네임 유무를 확인하기 위한 크루
     */
    private void processDuplicateCrewNickname(Crew crew) {
        String nickname = crew.getNickname();

        if (validateCrewNickname(nickname)) {
            return;
        }
        for (int i = NICKNAME_DUPLICATE_START_INDEX; i < nickname.length(); i++) {
            String partOfNickname = calculatePartOfNickname(nickname, i);

            validateDuplicateNickname(crew, partOfNickname);
        }
    }

    /**
     * 크루의 닉네임 중 연속적인 2글자가 중복되는지 확인하는 메소드
     *
     * @param crew           중복 닉네임 유무를 확인하기 위한 크루
     * @param partOfNickname 크루의 닉네임 중 연속적인 2글자
     */
    private void validateDuplicateNickname(Crew crew, String partOfNickname) {
        if (partOfNicknameMap.containsKey(partOfNickname)) {
            addDuplicateCrewEmail(crew, partOfNicknameMap.get(partOfNickname));
            return;
        }
        partOfNicknameMap.put(partOfNickname, crew.getEmail());
    }

    /**
     * 중복된 크루의 이메일을 저장하는 메소드
     *
     * @param duplicateCrew         중복된 닉네임을 가진 크루
     * @param duplicateCrewNickname 중복된 닉네임을 가진 크루의 이메일
     */
    private void addDuplicateCrewEmail(Crew duplicateCrew, String duplicateCrewNickname) {
        duplicateNicknameCrewSet.add(duplicateCrewNickname);
        duplicateNicknameCrewSet.add(duplicateCrew.getEmail());
    }

    /**
     * 크루의 닉네임이 중복이 될 수 있는지 확인하는 메소드
     *
     * @param nickname 크루의 닉네임
     * @return 닉네임 중복 조건을 부합하는지에 대한 여부
     */
    private boolean validateCrewNickname(String nickname) {
        return nickname.length() < NICKNAME_MINIMUM_LENGTH;
    }

    /**
     * 크루의 닉네임 중 연속적인 2글자를 구하는 메소드
     *
     * @param nickname 크루의 닉네임
     * @param index    현재 크루의 닉네임 인덱스
     * @return 크루의 닉네임 중 연속적인 2글자
     */
    private String calculatePartOfNickname(String nickname, int index) {
        return nickname.substring(index - PART_OF_NICKNAME_RANGE, index + PART_OF_NICKNAME_RANGE);
    }

    /**
     * 중복된 크루 이메일을 List로 변환하고 오름차순으로 정렬하는 메소드
     *
     * @return 오름차순으로 정렬된 중복된 크루 이메일 List
     */
    private List<String> sortAscCrewEmailList() {
        List<String> duplicateCrewEmail = new ArrayList<>(duplicateNicknameCrewSet);

        Collections.sort(duplicateCrewEmail);
        return duplicateCrewEmail;
    }
}

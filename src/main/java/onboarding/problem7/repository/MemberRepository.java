package onboarding.problem7.repository;

import onboarding.problem7.entity.Member;

import java.util.List;
import java.util.Optional;

/**
 * 한 유저를 기준으로 한 친구추천 후보 목록을 관리하는 리포지토리 인터페이스입니다.
 *
 * @author BackFoxx
 */
public interface MemberRepository {
    /**
     * Member 객체 하나를 리포지토리에 저장하는 메소드입니다.
     * 이미 저장된 Member 의 친구 여부가 변화했을 때에도 이 메소드를 호출하여 수정할 수 있습니다.
     *
     * @param member 리포지토리에 저장할 Member 객체입니다.
     */
    void save(Member member);

    /**
     * 주어진 이름에 해당하는 Member 객체를 찾아 반환하는 메소드입니다.
     * @param name 검색의 기준이 될 이름입니다.
     */
    Optional<Member> findByName(String name);

    /**
     * 사용자와 이미 친구를 맺고 있는지 여부에 따라 Member 목록을 만들어 반환하는 메소드입니다.
     *
     * @param isAlreadyFriend 검색의 기준이 되는 '이미 친구인 여부' 입니다.
     */
    List<Member> findByIsAlreadyFriend(boolean isAlreadyFriend);

    /**
     * 친구추천 점수가 0 이상이고,
     * 점수가 같은 경우 오름차순 이름으로 정렬하여
     * 최대 5까지 이름만 조회해 목록을 반환하는 메소드입니다.
     */
    List<String> findAllNameSortByScoreNot0DescNameAsc();

    /**
     * 주어진 Member 객체가 이미 친구로 저장되어 있는 지 여부를 알려주는 메소드입니다.
     *
     * @param member 검색의 기준이 되는 Member 객체입니다. 해당 객체의 이름을 이용해 조회합니다.
     */
    boolean isMemberAlreadyFriend(Member member);

    /**
     * 친구추천 후보 목록의 기준이 될 유저 이름을 반환하는 메소드입니다.
     */
    String getUser();
}

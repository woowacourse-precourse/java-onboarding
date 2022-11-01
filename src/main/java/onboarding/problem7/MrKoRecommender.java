package onboarding.problem7;

import java.util.*;

public class MrKoRecommender extends FriendRecommender{
    // 멤버 이름, 추천 점수 를 관리하기 위한 scoreMap 선언
    private Map<String, Integer> scoreMap = new HashMap<>();
    private final int COFRIEND_WEIGHT = 10;
    private final int VISITOR_WEIGHT = 1;

    // 부모 클래스의 생성자를 호출해 memberMap을 가져옴
    public MrKoRecommender(Map<String, Member> memberMap) {
        super(memberMap);
    }

    /**
     * 7.3
     * 각 멤버를 추천하는 알고리즘 객체를 이용해 친구 추천
     */
    @Override
    public List<Member> recommendFor(String userName) {

        // 등록된 멤버들의 이름을 배열로 변환
        String[] memberNames = memberMap.keySet().toArray(new String[0]);
        // 멤버들에게 할당되는 추천 점수를 위한 배열 선언
        int[] recommendScores = new int[memberMap.size()];

        // userName의 멤버에게 해당되는 다른 멤버들의 추천점수를 계산
        recommendScores = calculateScores(userName, memberNames, recommendScores);

        // 추천 점수가 존재하는 멤버들을 관리하는 scoreMap 초기화
        for (int i = 0; i < recommendScores.length; i++)
            if (recommendScores[i] > 0)
                scoreMap.put(memberNames[i], recommendScores[i]);

        // 추천 멤버가 담긴 scoreMap을 통해 추천 멤버 리스트 저장 후 반환
        memberMap.get(userName).setRecommendedFriends(getRecommendFriends(scoreMap));

        return memberMap.get(userName).getRecommendedFriends();
    }

    /**
     * 7.3.3
     * 가중치를 이용해 추천 점수 계산
     */
    public int[] calculateScores(String userName, String[] memberNames, int[] recommendScores) {
        int i = 0;
        while (i < memberMap.size()) {

            // 본인이 아니고, memberNames[i]와 친구가 아닌 경우
            if (!userName.equals(memberNames[i]) && !isFriend(userName, memberNames[i])) {
                recommendScores[i] += VISITOR_WEIGHT * countVisits(userName, memberNames[i]);

                // 두 멤버가 같은 친구를 맺고 있다면 가중치 + 10
                if (hasCoFriend(userName,memberNames[i]))
                    recommendScores[i] += COFRIEND_WEIGHT;
            }
            i++;
        }

        return recommendScores;
    }

    // memberName이 userName을 방문한 횟수를 꼐산
    public int countVisits(String userName, String memberName) {
        int visits = 0;

        Member user = memberMap.get(userName);
        Member member = memberMap.get(memberName);

        for (Member visitor : user.getVisitors())
            if (visitor.getName().equals(memberName))
                visits++;

        return visits;
    }

    /**
     * 7.3.4
     * 추천 점수 리스트를 통해 추천 친구 리스트 반환
     */
    private List<Member> getRecommendFriends(Map<String, Integer> scoreMap) {
        // scoreMap에 존재하는 멤버 이름을 리스트로 변환
        List<String> scoredMemberNames = new ArrayList<>(scoreMap.keySet());

        // 추천 리스트 정렬
        Comparator<String> comparator = setComparator();
        Collections.sort(scoredMemberNames,comparator);

        // 정렬된 멤버 형태의 리스트에서 멤버 이름 리스트로, 최대 5개의 요소만 반환
        List<Member> recommendedFriends = new ArrayList<>();
        while (recommendedFriends.size() < 5) {
            for (String memberName : scoredMemberNames)
                recommendedFriends.add(memberMap.get(memberName));

            break;
        }

        return recommendedFriends;
    }

    // [1. 추천 점수 내림차순 2. 멤버 이름 오름차순 ]정렬을 위한 변수 초기화
    public Comparator<String> setComparator() {

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String member1, String member2) {
                // 1. 추천 점수 내림차순
                if (scoreMap.get(member1) < scoreMap.get(member2)) return 1;
                else if (scoreMap.get(member1) > scoreMap.get(member2)) return -1;
                else {
                    // 2. 추천 점수가 같을 시에, 이름으로 오름차순
                    if (member1.compareTo(member2) > 0) return 1;
                    else return -1;
                }
            }
        };

        return comparator;
    }
}

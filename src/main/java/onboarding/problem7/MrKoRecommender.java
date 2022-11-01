package onboarding.problem7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MrKoRecommender extends FriendRecommender{

    private final int COFRIEND_WEIGHT = 10;
    private final int VISITOR_WEIGHT = 1;

    public MrKoRecommender(Map<String, Member> memberStore) {
        super(memberStore);
    }

    @Override
    public List<Member> recommendFor(String userName) {

        String[] memberNames = memberStore.keySet().toArray(new String[0]);
        int[] recommendScores = new int[memberStore.size()];

        recommendScores = calculateScores(userName, memberNames, recommendScores);



        return null;
    }

    /**
     * 7.3.3
     * 가중치를 이용해 추천 점수 계산
     */
    public int[] calculateScores(String userName, String[] memberNames, int[] recommendScores) {
        int i = 0;
        while (i < memberStore.size()) {

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

    public int countVisits(String userName, String memberName) {
        int visits = 0;

        Member user = memberStore.get(userName);
        Member member = memberStore.get(memberName);

        for (Member visitor : user.getVisitors())
            if (visitor.getName().equals(memberName))
                visits++;

        return visits;
    }
}

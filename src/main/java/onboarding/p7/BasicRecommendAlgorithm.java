package onboarding.p7;

import java.util.*;
import java.util.stream.Collectors;

import static onboarding.p7.RecommendScore.ALONG_WITH;
import static onboarding.p7.RecommendScore.VISIT;

public class BasicRecommendAlgorithm implements RecommendAlgorithm {
    private final int RECOMMEND_COUNT = 5;
    String user;
    List<RecommendUser> recommendUsers;

    public BasicRecommendAlgorithm(String user) {
        this.user = user;
        recommendUsers = new ArrayList<>();
    }

    @Override
    public List<String> getRecommendUser(List<List<String>> friends, List<String> visitors) {
        List<String> myFriends = getMyFriends(friends);

        List<String> alongWithMyFriends = getAlongWithMyFriends(friends, myFriends);
        plusAlongWithScore(alongWithMyFriends);

        List<String> visitorWithOutMyFriend = getVisitorWithOutMyFriends(visitors, myFriends);
        plusVisitScore(visitorWithOutMyFriend);

        return getRecommend();
    }

    public List<String> getRecommend() {
        sortByScoreDescAndName();
        List<String> recommend = new ArrayList<>();
        if (recommendUsers.size() < RECOMMEND_COUNT) {
            for (RecommendUser recommendUser : recommendUsers) {
                recommend.add(recommendUser.getName());
            }
        } else {
            for (int i = 0; i < RECOMMEND_COUNT; i++) {
                recommend.add(recommendUsers.get(i).getName());
            }
        }

        return recommend;
    }

    private List<RecommendUser> sortByScoreDescAndName() {
        return recommendUsers.stream()
                .sorted(Comparator.comparing(RecommendUser::getName, Comparator.naturalOrder())
                        .thenComparing(RecommendUser::getScore, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    public List<String> getMyFriends(List<List<String>> friends) {
        List<String> myFriends = new ArrayList<>();
        for (List<String> fr : friends) {
            if (fr.get(0).equals(user)) {
                myFriends.add(fr.get(1));
            } else if (fr.get(1).equals(user)) {
                myFriends.add(fr.get(0));
            }
        }
        return myFriends;
    }

    public List<String> getVisitorWithOutMyFriends(List<String> visitors, List<String> myFriends) {
        List<String> visitorWithOutMyFriend = new ArrayList<>();
        for (String visitor : visitors) {
            if (!myFriends.contains(visitor) && !visitor.equals(user)) {
                visitorWithOutMyFriend.add(visitor);
            }
        }
        return visitorWithOutMyFriend;
    }

    public List<String> getAlongWithMyFriends(List<List<String>> friends, List<String> myFriends) {
        List<String> alongWithMyFriends = new ArrayList<>();
        for (List<String> fr : friends) {
            if (myFriends.contains(fr.get(0)) && !myFriends.contains(fr.get(1)) && !fr.get(1).equals(user)) {
                alongWithMyFriends.add(fr.get(1));
            } else if (myFriends.contains(fr.get(1)) && !myFriends.contains(fr.get(0)) && !fr.get(0).equals(user)) {
                alongWithMyFriends.add(fr.get(0));
            }
        }

        return alongWithMyFriends;
    }

    public void plusAlongWithScore(List<String> alongWithMyFriends) {
        for (String alongWith : alongWithMyFriends) {
            RecommendUser recommendUser = getRecommendUserScore(alongWith);
            if (recommendUser == null) {
                recommendUser = new RecommendUser(alongWith);
                recommendUsers.add(recommendUser);
            }
            recommendUser.plusScore(ALONG_WITH.getScore());
        }
    }

    public void plusVisitScore(List<String> visitors) {
        for (String visitor : visitors) {
            RecommendUser recommendUser = getRecommendUserScore(visitor);
            if (recommendUser == null) {
                recommendUser = new RecommendUser(visitor);
                recommendUsers.add(recommendUser);
            }
            recommendUser.plusScore(VISIT.getScore());
        }
    }

    public RecommendUser getRecommendUserScore(String name) {
        if (recommendUsers.isEmpty()) {
            return null;
        }
        for (RecommendUser user : recommendUsers) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}

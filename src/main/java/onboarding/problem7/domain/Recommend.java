package onboarding.problem7.domain;

public class Recommend implements Comparable<Recommend> {

    private final User user;

    private final User recommendUser;

    private final int score;

    public Recommend(User user, User recommendUser, int score) {
        this.user = user;
        this.recommendUser = recommendUser;
        this.score = score;
    }

    public User getRecommendUser() {
        return recommendUser;
    }

    @Override
    public int compareTo(Recommend o) {
        // 점수는 내림차순
        if (score > o.score) {
            return -1;
        }
        if (score < o.score) {
            return 1;
        }

        // 이름은 오름차순
        return (recommendUser.getName()
                .compareTo(o.recommendUser.getName()));
    }
}

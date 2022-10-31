package onboarding;

/*
problem 7에 사용되는 클래스 입니다.
 */
class RecommendFriend {
    String name;
    int point;

    public RecommendFriend(String name, int point) {
        this.name = name;
        this.point = point;
    }

    //친구의 친구인 경우
    void addLinkedFriendPoint() {
        this.point += 10;
    }

    //친구가 타임라인에 방문한 경우
    void addVisitedFriendPoint() {
        this.point += 1;
    }

}

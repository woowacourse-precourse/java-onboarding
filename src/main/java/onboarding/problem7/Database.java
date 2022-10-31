package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    //사용자 이름 인덱스 해쉬맵
    private Map<String, User> database = new HashMap<>();
    //입력받은 방문기록
    private List<String> visitLogs;

    //방문기록으로 생성자
    public Database(List<String> visitLogs) {
        this.visitLogs = visitLogs;
    }
    //사용자 추가
    private void addUser(String name) {
        database.put(name, new User(name));
    }
    //이름으로 검색
    public User findByName(String name) {
        return database.get(name);
    }
    //로그 기준으로 회원 등록
    //친구관계 입력받아서 DB최신화
    //누군가의 친구로 추천하기위해 겹치는 친구 수 방문기록을 기준으로 점수를 갱신한다.
    //친구 추천 목록 반환함수









    public void registerUsersFromLog(List<String> logs) {
        for (var name : logs)
            if (!database.containsKey(name)) addUser(name);
    }

    public void addRelation(List<String> relation) {
        for (var name : relation)
            if (!database.containsKey(name)) addUser(name);
        User user1 = findByName(relation.get(0));
        User user2 = findByName(relation.get(1));
        user1.addFriend(user2);
        user2.addFriend(user1);
    }

    private void calculateScoreByTargetName(String name) {
        User user = findByName(name);
        for (var entry : database.entrySet()) {
            entry.getValue().resetScore();
            if (entry.getKey() == name) continue;
            User otherUser = entry.getValue();
            otherUser.calculateFriendsScore(user);
        }
        for (var log : visitLogs) {
            if (database.containsKey(log)) database.get(log).addScore();
        }
    }

    public List<User> getRecommendedUsersByName(String name) {
        User target = findByName(name);
        calculateScoreByTargetName(name);
        List<User> users = new ArrayList<>();
        for (var userEntry : database.entrySet()) {
            User user = userEntry.getValue();
            if (user == target || user.isScoreZero() || user.isFriend(target)) continue;
            users.add(user);
        }
        return users;
    }
}

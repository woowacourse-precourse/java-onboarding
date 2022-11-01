package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Problem7 {

    public static class Score {
        private String name;
        private Integer score;

        public Score(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new ArrayList<String>();
        List<String> userFriends = new ArrayList<String>();
        findUserFriends(user, friends, userFriends);
        List<String> allUser = new ArrayList<String>();


        // 모든 이용자 찾는 로직
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < friends.get(i).size(); j++) {
                if (friends.get(i).get(j) != user) {
                    allUser.add(friends.get(i).get(j));
                }
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            if (visitors.get(i) != user) {
                allUser.add(visitors.get(i));
            }
        }

        List newAllUser = allUser.stream().distinct().collect(Collectors.toList());//중복 제거

        List<Score> score = new ArrayList<Score>();

        // 본인을 제외한 이용자를 찾아 Score 객체를 리스트에 넣어줌
        for (int i = 0; i < newAllUser.size(); i++) {
            score.add(new Score(newAllUser.get(i).toString(), 0));
        }

        friendScoreConversion(user, friends, score, userFriends);
        visitorsScoreConversion(visitors, score);

        // 점수를 기준으로 내림차순, 점수가 같으면 이름순 정렬
        score.sort(Comparator.comparing(Score::getScore).reversed().thenComparing(Score::getName));

        // 점수가 0 이상인것만 넣어줌
        for (int i = 0; i < 5; i++) {
            if (score.get(i).getScore() != 0) {
                answer.add(score.get(i).getName());
            }
        }

        // user 와 친구면 빼줌
        for (int i = 0; i < userFriends.size(); i++) {
            if (answer.contains(userFriends.get(i))) {
                answer.remove(userFriends.get(i));
            }
        }

        return answer;
    }

    // 주어진 방문자에 의한 점수 변경
    private static void visitorsScoreConversion(List<String> visitors, List<Score> score) {

        plus1(visitors, score);

    }

    //사용자의 타임 라인에 방문한 횟수에 + 1점
    private static void plus1(List<String> visitors, List<Score> score) {
        for (int i = 0; i < visitors.size(); i++) {
            for (int j = 0; j < score.size(); j++) {
                if (score.get(j).getName() == visitors.get(i)) {
                    score.get(j).setScore(score.get(j).getScore() + 1);
                }
            }
        }
    }

    //주어진 친구에 의한 점수 변경
    private static void friendScoreConversion(String user, List<List<String>> friends, List<Score> score, List<String> userFriends) {

        List changeUser = new ArrayList(); //점수 변동이 있을 사람 리스트

        changeScoreUser(user, friends, userFriends, changeUser);

        plus10(score, changeUser);

    }

    // 사용자와 함께 아는 친구의 수에 + 10점을 해줌
    private static void plus10(List<Score> score, List changeUser) {
        for (int i = 0; i < changeUser.size(); i++) {
            for (int j = 0; j < score.size(); j++) {
                if (score.get(j).getName() == changeUser.get(i)) {
                    score.get(j).setScore(score.get(j).getScore() + 10);
                }
            }
        }
    }

    // 요구사항에 맞게 점수가 변경되는 사람 찾아 리스트에 넣어주는 함수
    private static void changeScoreUser(String user, List<List<String>> friends, List<String> userFriends, List changeUser) {
        for (int i = 0; i < userFriends.size(); i++) {
            for (int j = 0; j < friends.size(); j++) {

                if (friends.get(j).contains(userFriends.get(i))) {
                    for (int k = 0; k < 2; k++) {
                        if (friends.get(j).get(k) != user && friends.get(j).get(k) != userFriends.get(i)) {
                            changeUser.add(friends.get(j).get(k));
                        }

                    }
                }
            }
        }
    }

    //User 의 친구들을 찾아주는 함수
    private static void findUserFriends(String user, List<List<String>> friends, List userFriends) {
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0) == user || friends.get(i).get(1) == user) {
                for (int j = 0; j < friends.get(i).size(); j++) {
                    if (friends.get(i).get(j) != user) {
                        userFriends.add(friends.get(i).get(j));
                    }
                }
            }
        }
    }
}

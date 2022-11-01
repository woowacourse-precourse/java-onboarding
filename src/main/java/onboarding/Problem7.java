package onboarding;

/**
 *
 * [ SNS ]
 *
 *  - Map<String, User> users = 유저 이름이 key, User 객체가 value 인 Map
 *  - List<User> recommend_list = 친구 추천 리스트를 저장할 list
 *
 * ( 유저 추가 )
 *  - add_user(String username) = username 을 이름으로 한 User 객체 생성해서 users 에 넣고 객체 반환
 *  - add_all_user_by_friend_list(List<List<String>> friends) = friends 리스트를 받아서 모든 유저 등록, 친구 등록
 *  - add_friend_list(List<String> friend) = 리스트의 첫번쨰 user, 두번째 user 등록 후 서로 친구 등록
 *  - add_all_user_by_visitors(List<String> visitors, String target) = visitors 리스트를 받아서 모든 방문객을 등록
 *  - visitor_visit_target(String visitor, String target) = target 이름의 유저의 visitors 에 visitor 이름의 유저를 등록
 *
 * ( 유저 조회 )
 *  - is_user_exist(String username) = username 의 유저가 있는지 없는지 확인
 *  - find_by_name(String username) = username 의 유저를 찾아서 반환
 *
 * ( 추천 리스트 생성 )
 *  - List<String> make_recommended_friend_list_for_target(User target) = target 에게 추천할 친구리스트를 만드는 메서드
 *  - void give_connected_score(User target) = 친구의 친구들에게 점수를 부여하는 메서드
 *  - void add_score_if_connected(User target, User friend) = 친구의 친구들중 나를 제외한 친구에게만 10점을 부여한다.
 *  - void give_visitor_score(User target) = 방문자들에게 방문횟수 만큼의 점수를 부여한다.
 *  - void recommend_if_connected(User target, User user) = 친구의 친구일 경우 추천 친구 리스트에 추가한다.
 *  - void sort_descending_with_score(User target) = target 을 향한 추천 점수를 기준으로 내림차순, 같은시 알파벳 순으로 정렬한다.
 *  - List<String> show_five_recommend_user() = 추천할 5명의 친구의 이름을 담은 리스트를 반환 ( 5명보다 적을시 그만큼만 )
 *
 *
 * [ User ]
 *
 *  - String name = 이름
 *  - List<User> friends = 친구들이 저장되어 있는 List
 *  - Map<User, Integer> visitors = 방문한 User 가 key 방문횟수가 value 인 Map
 *  - Map<User, Integer> score_map = Username 이 key 추천 점수가 value 인 Map
 *
 *  ( name 관련 메서드 )
 *  - String show_name() = 이름을 반환
 *
 *  ( friends 관련 메서드 )
 *  - boolean is_friend(User user) = user 랑 친구인지 반환
 *  - void add_friend(User user) = user 를 친구로 등록
 *  - List<User> show_friends() = 모든 친구 목록을 리스트로 저장하여 반환
 *  - void set_friends(User friend) = friend 와 서로 친구로 등록
 *
 *  ( visitors 관련 메서드 )
 *  - boolean is_visitor(User user) = user 가 visitors 에 있는지 확인
 *  - void add_visitor(User user) = visitors 에 user cnrk
 *  - Set<User> show_visitors() = visitors 의 key 인 방문한 User 들이 담긴 Set을 반환
 *  - int show_visit_count(User user) = user 가 몇번 방문했는지 반환
 *
 * ( score 관련 메서드 )
 *  - boolean is_score_exist(User user) = user 를 대상으로 하는 추천 점수가 존재하는지 확인
 *  - void add_target_score(User user, int amount) = user 를 대상으로 하는 추천 점수를 amount 만큼 증가시킨다.
 *  - int show_target_score(User user) = user 를 대상으로 하는 추천 점수를 반환
 *
 */

import java.util.*;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Sns sns = new Sns();
        sns.add_all_user_by_friend_list(friends);
        sns.add_all_user_by_visitor_list(visitors, user);
        return sns.make_recommended_friend_list_for_target(user);
    }
}

class Sns {
    private Map<String, User> users = new HashMap<>();
    private List<User> recommend_list;

    //user 생성, 추가
    private User add_user(String username) {
        if (!is_user_exist(username)) {
            User user = new User(username);
            users.put(username, user);
            return user;
        }
        return find_by_name(username);
    }

    public void add_all_user_by_friend_list(List<List<String>> friends) {
        for (List<String> friend : friends) {
            add_friend_list(friend);
        }
    }

    private void add_friend_list(List<String> friend) {
        User user1 = add_user(friend.get(0));
        User user2 = add_user(friend.get(1));
        user1.set_friends(user2);
    }

    public void add_all_user_by_visitor_list(List<String> visitors, String target) {
        for (String visitor : visitors) {
            visitor_visit_target(visitor, target);
        }
    }

    private void visitor_visit_target(String visitor, String target) {
        User visit_user = add_user(visitor);
        User target_user = find_by_name(target);
        target_user.add_visitor(visit_user);
    }

    //user 조회
    private boolean is_user_exist(String username) {
        return users.containsKey(username);
    }

    private User find_by_name(String username) {
        return users.get(username);
    }

    //추천 리스트 관련 메서드
    public List<String> make_recommended_friend_list_for_target(String target_name) {
        User target = find_by_name(target_name);
        give_connected_score(target);
        give_visitor_score(target);
        recommend_list = new ArrayList<>();
        for (User user : users.values()) {
            recommend_if_connected(target, user);
        }
        sort_descending_with_score(target);
        return show_five_recommend_user();
    }

    private void give_connected_score(User target) {
        List<User> friends = target.show_friends();
        for (User friend : friends) {
            add_score_if_connected(target, friend);
        }
    }

    private void add_score_if_connected(User target, User friend) {
        for (User connected : friend.show_friends()) {
            if (connected == target) {
                continue;
            }
            connected.add_target_score(target, 10);
        }
    }

    private void give_visitor_score(User target) {
        Set<User> visitors = target.show_visitors();
        for (User visitor : visitors) {
            visitor.add_target_score(target, target.show_visit_count(visitor));
        }
    }

    private void recommend_if_connected(User target, User user) {
        if (user.show_target_score(target) > 0 && !user.is_friend(target)) {
            this.recommend_list.add(user);
        }
    }

    private void sort_descending_with_score(User target) {
        Collections.sort(this.recommend_list, (o1, o2) -> {
            if (o1.show_target_score(target) == o2.show_target_score(target)) {
                return o1.show_name().compareTo(o2.show_name());
            }
            return o2.show_target_score(target) - o1.show_target_score(target);
        });
    }

    public List<String> show_five_recommend_user() {
        List<String> recommend_name = new ArrayList<>();
        for (int amount = 0; amount < Math.min(5, this.recommend_list.size()); amount++) {
            recommend_name.add(this.recommend_list.get(amount).show_name());
        }
        return recommend_name;
    }
}

class User {
    private String name;
    private List<User> friends;
    private Map<User, Integer> visitors;
    private Map<User, Integer> score_map;

    User(String username) {
        this.name = username;
        friends = new ArrayList<>();
        visitors = new HashMap<>();
        score_map = new HashMap<>();
    }

    //username 관련 메서드
    public String show_name() {
        return name;
    }

    //friend 관련 메서드
    public boolean is_friend(User user) {
        return friends.contains(user);
    }

    public void add_friend(User user) {
        if (!is_friend(user)) {
            friends.add(user);
        }
    }

    public List<User> show_friends() {
        return new ArrayList<>(friends);
    }

    public void set_friends(User friend) {
        add_friend(friend);
        friend.add_friend(this);
    }

    //visitor 관련 메서드
    public boolean is_visitor(User user) {
        return visitors.containsKey(user);
    }

    public void add_visitor(User user) {
        int prev_score = 0;
        if (is_visitor(user)) {
            prev_score = visitors.get(user);
        }
        visitors.put(user, prev_score + 1);
    }

    public Set<User> show_visitors() {
        return visitors.keySet();
    }

    public int show_visit_count(User user) {
        return visitors.get(user);
    }

    //score 관련 메서드
    private boolean is_score_exist(User user) {
        return score_map.containsKey(user);
    }

    public void add_target_score(User user, int amount) {
        int prev_score = 0;
        if (is_score_exist(user)) {
            prev_score = score_map.get(user);
        }
        score_map.put(user, prev_score + amount);
    }

    public int show_target_score(User user) {
        if (is_score_exist(user)) {
            return score_map.get(user);
        }
        return 0;
    }
}

package onboarding;

import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;


public class Problem7 {
    public static Map<String, Integer> recommaned = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        try {
            validate_user(user);
            validate_friends(friends);
            validate_visitor(visitors);
            for (List<String> friend : friends) {
                validate_element(friend);
            }
        } catch (Exception e) {
            System.out.println("Problem7 exception : " + e.getMessage());
        }


        ArrayList<String> directs = direct_friend(user, friends);
        friends_of_friends(directs, friends);
        visted_member(visitors);


        return recommaned_five(user, directs);
    }

    static void validate_user(String user) {
        //user 길이 1 이상 30 이하 검사.
        int user_length = user.length();
        if (user_length < 1 || user_length > 30) {
            System.out.println("user는 길이가 1 이상 30 이하이어야 합니다.");
        }
        validate_name(user);
    }

    static void validate_name(String name) {
        //모든 사용자 아이디는 알파벳 소문자 검사
        boolean c = Pattern.matches("^[a-z]*$", name);
        if (!c) {
            System.out.println("모든 사용자 아이디는 알파벳 소문자 이어야 합니다.");
        }
    }

    static void validate_friends(List<List<String>> friends) {
        //friends는 길이가 1 이상 10,000 이하 검사.
        int friends_size = friends.size();
        if (friends_size < 1 || friends_size > 10000) {
            System.out.println("friends는 길이가 1 이상 10,000 이하이어야 합니다.");
        }
    }

    static void validate_element(List<String> friend) throws Exception {
        //friends의 각 원소 길이가 2인지 검사
        int friend_size = friend.size();
        if (friend_size != 2) {
            throw new Exception("friends의 각 원소는 길이가 2이어야 합니다.");
        }
        for (String person : friend) {
            validate_name(person);
        }
    }

    static void validate_visitor(List<String> visitors) {
        //visitors는 길이가 0 이상 10,000 이하
        int visitors_size = visitors.size();
        if (visitors_size < 1 || visitors_size > 10000) {
            System.out.println("visitors는 길이가 0 이상 10,000 이하이어야 합니다.");
        }
        for (String visitor : visitors) {
            validate_name(visitor);
        }
    }

    static ArrayList<String> direct_friend(String user, List<List<String>> friends) {

        ArrayList<String> directs = new ArrayList<String>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                int fnum = (friend.indexOf(user) == 1) ? 0 : 1;
                directs.add(friend.get(fnum));
            }
        }
        return directs;
    }

    static void friends_of_friends(ArrayList<String> directs, List<List<String>> friends) {
        for (List<String> member : friends) {
            for (String direct : directs) {
                if (member.contains(direct)) {
                    int mnum = member.indexOf(direct) == 1 ? 0 : 1;
                    String nummember = String.valueOf(member.get(mnum));
                    recommaned.put(nummember, recommaned.get(nummember) == null ? 10 : recommaned.get(nummember) + 10);
                }
            }
        }
    }

    static void visted_member(List<String> visitors) {
        for (String visitor : visitors) {
            recommaned.put(visitor, recommaned.get(visitor) == null ? 1 : recommaned.get(visitor) + 1);
        }
    }

    static List<String> recommaned_five(String user, ArrayList<String> directs) {

        List <String> result = new ArrayList<String>();


        int loopcount = 0;

        for (String key : recommaned.keySet()) {
            if (loopcount == 5) {
                break;
            }
            if (key.equals(user) || directs.contains(key)){
                continue;
            }
            if (result.size() == 0) {
                result.add(key);
            }else {
                for (String element : result) {
                    if (recommaned.get(key) == recommaned.get(element)){
                        if(key.compareTo(element) < 0){
                            int idx = result.indexOf(element);
                            result.add(idx,key);
                            break;
                        }
                    }
                }
                if(!result.contains(key)){
                    result.add(key);
                }
            }
        }
        return result;
    }

}
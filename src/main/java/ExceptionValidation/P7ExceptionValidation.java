package ExceptionValidation;

//- user 길이가 1~30인지 판단
//- friends id의 길이가 1~30 인지 판단
//- friends의 길이가 1~10000 인지 판단
//- friends의 원소 길이가 2인지 판단
//- visitors의 길이가 0~10000 인지 판단
//- 모든 아이디가 소문자 인지 판단
//- 위의 조건을 만족 안할때는 빈 리스트를 반환

import java.util.List;

public class P7ExceptionValidation {

    public static boolean p7ExceptionValidation(String user, List<List<String>> friends, List<String> visitors) {

        return userNameBetween1and30(user)
                && friendsLowerAlphabet(friends)
                && friendsBetween1and10000(friends)
                && elementIsTwo(friends);
    }


    private static boolean userNameBetween1and30(String user) {
        if (user.length() < 1 || user.length() > 30) {
            return false;
        }
        return true;
    }

    private static boolean friendsLowerAlphabet(List<List<String>> friends) {
        for (int i = 0; i < 2; i++) {
            for (List<String> edge : friends) {
                String current = edge.get(i);

                return current.chars()
                        .filter(Id -> 'a' <= Id && Id <= 'z')
                        .count() == current.length();
            }
        }
        return false;
    }

    private static boolean friendsBetween1and10000(List<List<String>> friends) {
        if (friends.size() < 1 || friends.size() > 10000) {
            return false;
        }
        return true;
    }

    private static boolean elementIsTwo(List<List<String>> friends) {

        for(List<String> edge : friends){
            return edge.stream().count() == 2;
        }
        return false;
    }
}


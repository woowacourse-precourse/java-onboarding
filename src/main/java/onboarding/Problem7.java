package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        //user와 친구 상태인 사용자를 제외하고, 추천 점수를 계산해야할 유저의 리스트 추출
        List<String> names = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            String name = friends.get(i).get(1);
            if (!user.equals(name)) {
                names.add(name);
                names.add(friends.get(i).get(0));
            }
            if (user.equals(name)) {
                names.removeAll(Collections.singleton(friends.get(i).get(0)));
            }
        }
        Set<String> set = new HashSet<String>(names);
        List<String> newNames =new ArrayList<String>(set);

        //사용자와 함께 아는 친구와 그 점수
        String[][] checkScore = new String[newNames.size()][2];
        for (int j = 0; j < newNames.size(); j++) {
            checkScore[j][0] = newNames.get(j);
            checkScore[j][1] = "10";
        }
        for (int m = 0; m < visitors.size(); m++) {
            for (int y = 0; y < checkScore.length; y++) {
                String pattern = checkScore[y][0];
                if (pattern.equals(visitors.get(m))) {
                    checkScore[y][1] = String.valueOf(Integer.parseInt(checkScore[y][1]) + 1);
                    System.out.println("중도 확인용 : " + Arrays.deepToString(checkScore));
                }
            }
        }
        return newNames;
    }
}
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

        //방문자 중 친구 추천 점수를 받을 수 있는 리스트 추출
        List<String> visitorsnames = new ArrayList<>(visitors);
        for (int p = 0; p < friends.size(); p++) {
            if (user.equals(friends.get(p).get(1))) {
                visitorsnames.removeAll(Collections.singleton(friends.get(p).get(0)));
            }
        }
        Set<String> setVisitors = new HashSet<String>(visitorsnames);
        List<String> newVisitorsNames = new ArrayList<String>(setVisitors);

        //방문자 중 친구 추천 점수를 받을 수 있는 인물과 그 점수
        String[][] checkScoreVisitors = new String[newVisitorsNames.size()][2];
        for (int r = 0; r < newVisitorsNames.size(); r++) {
            checkScoreVisitors[r][0] = newVisitorsNames.get(r);
            checkScoreVisitors[r][1] = "0";
        }
        for (int c = 0; c < visitors.size(); c++) {
            for (int d = 0; d < checkScoreVisitors.length; d++) {
                String pattern = checkScoreVisitors[d][0];
                if (pattern.equals(visitors.get(c))) {
                    checkScoreVisitors[d][1] = String.valueOf(Integer.parseInt(checkScoreVisitors[d][1]) + 1);
                    System.out.println("방문자 중도 확인 : " + Arrays.deepToString(checkScoreVisitors));
                }
            }
        }

        //점수가 계산된 모든 인물과 각 인물의 점수가 포함된 리스트
        List<List<String>> lastNames = new ArrayList<>();
        for (int v = 0; v < checkScore.length; v++) {
            lastNames.add(List.of(checkScore[v]));
        }
        for (int b = 0; b < checkScoreVisitors.length; b++) {
            lastNames.add(List.of(checkScoreVisitors[b]));
        }
        System.out.println("최종 점수 받은 이들 중도 확인 : " + lastNames);

        return newNames;
    }
}
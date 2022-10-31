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

        //위 리스트를 기반으로 최종적으로 인물 5명을 추려 반환시킨다
        List<String> answerList = new ArrayList<>();
        for (int z = 0; z < lastNames.size(); z++) {
            int max = 0;
            String nameOne = "";
            //점수가 제일 큰 인물을 구하고
            if (Integer.parseInt(lastNames.get(z).get(1)) > max) {
                max = Integer.parseInt(lastNames.get(z).get(1));
                nameOne = lastNames.get(z).get(0);
            }
            //점수가 동점일 경우에는 인물 이름을 사전순으로 배치한다.
            if (Integer.parseInt(lastNames.get(z).get(1)) == max) {
                if (lastNames.get(z).get(0).compareToIgnoreCase(nameOne) < 0) {
                    nameOne = lastNames.get(z).get(0);
                }
                if (lastNames.get(z).get(0).compareToIgnoreCase(nameOne) > 0) {
                    continue;
                }
            }
            //인물은 최대 5명까지 추천할 수 있다.
            if (answerList.size() == 5) {
                return answerList;
            }
            answerList.add(nameOne);
        }
        return answerList;
    }
}
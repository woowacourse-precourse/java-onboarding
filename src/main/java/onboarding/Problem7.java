package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<Recommend> recommend = new ArrayList<>();
        String[] ID = new String[2];

        friends.add(new ArrayList<String>(Arrays.asList("donut","andole")));
        friends.add(new ArrayList<String>(Arrays.asList("donut","jun")));
        friends.add(new ArrayList<String>(Arrays.asList("donut","mrko")));
        friends.add(new ArrayList<String>(Arrays.asList("shakevan","andole")));
        friends.add(new ArrayList<String>(Arrays.asList("shakevan","jun")));
        friends.add(new ArrayList<String>(Arrays.asList("shakevan","mrko")));



        visitors.add("bedi");
        visitors.add("bedi");
        visitors.add("donut");
        visitors.add("bedi");
        visitors.add("shakevan");
        List<String> userFriend = new ArrayList<>();
        for (int i=0;i<friends.size();i++) {
            for (int j=0;j<friends.get(i).size();j++) {
                if(friends.get(i).get(j) == user && j==0) {
                    userFriend.add(friends.get(i).get(j+1));
                } else if(friends.get(i).get(j) == user && j==1) {
                    userFriend.add(friends.get(i).get(j-1));
                }
            }
        }
//        donut shakevan

        for (int i=0;i<friends.size();i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < userFriend.size(); k++) {
                    if (friends.get(i).get(j) == userFriend.get(k) && j == 0 && friends.get(i).get(j+1) != user) {

                        Recommend tempRecommend = new Recommend();
                        tempRecommend.setName(friends.get(i).get(j+1));
                        tempRecommend.setPoint(10);
                        recommend.add(tempRecommend);

                    } else if (friends.get(i).get(j) == userFriend.get(k) && j == 1 && friends.get(i).get(j-1) != user) {

                        Recommend tempRecommend = new Recommend();
                        tempRecommend.setName(friends.get(i).get(j-1));
                        tempRecommend.setPoint(10);
                        recommend.add(tempRecommend);
                    }
                }
            }
        }

        for (int i=0;i<recommend.size()-1;i++) {
            for (int j=i+1;j<recommend.size();j++) {
                if (recommend.get(i).getName() == recommend.get(j).getName()) {
                    recommend.get(i).addPoint(10);
                    recommend.remove(j);
                    j--;
                }
            }
        }


        for (int i=0;i<recommend.size();i++) {
            for (int j=0;j<visitors.size();j++) {
                if (recommend.get(i).getName() == visitors.get(j)) {
                    recommend.get(i).addPoint(1);
                    visitors.remove(j);
                    break;
                }
            }
        }
        // 기존 recommend 목록이랑 겹치면 visitor랑 비교해서 recommend에 포인트올리고 visitor는 삭제

        for (int i=0;i<visitors.size()-1;i++) {
            Recommend tempRecommend = new Recommend();
            tempRecommend.setName(visitors.get(i));
            tempRecommend.setPoint(1);
            for (int j=i+1;j< visitors.size();j++) {
                if(tempRecommend.getName()==visitors.get(j)) {
                    tempRecommend.addPoint(1);
                }
            }
            recommend.add(tempRecommend);

        }

        for (int i=0;i<recommend.size()-1;i++) {
            for (int j=i+1;j<recommend.size();j++) {
                if (recommend.get(i).getName() == recommend.get(j).getName()) {
                    recommend.remove(j);
                    j--;
                }
            }
        }

        for (int i=0;i<recommend.size();i++) {
            for (int j=0;j<userFriend.size();j++) {
                if (recommend.get(i).getName() == userFriend.get(j)) {
                    recommend.remove(i);
                    i--;
                }
            }
        }

        List<Recommend> ans = new ArrayList<>();

        for (int i=0;i<recommend.size()-1;i++) { // 버블정렬
            for (int j=i+1;j< recommend.size();j++) {
                if (recommend.get(i).getPoint()<recommend.get(j).getPoint()) {
                    Recommend tempRecommend = recommend.get(i);
                    recommend.add(i, recommend.get(j));
                    recommend.remove(i+1);
                    recommend.add(j, tempRecommend);
                    recommend.remove(j+1);
                }
            }
        }

        for (int i=0;i< recommend.size();i++) {
            if (i>=5) {
                break;
            }
            answer.add(recommend.get(i).getName());
        }




        return answer;
    }
}

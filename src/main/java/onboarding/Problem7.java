package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        HashMap<String, Integer> nameAndPoint = new HashMap<>(); //이름과 그에 맞는 잠수 배열을 Hashmap으로 만들어준다.

        int numberOfVisitor = visitors.size();
        int lengthOfFriendsEachElementList = friends.get(0).size();
        int numberOfFriends = friends.size();

        for (int j = 0; j < numberOfVisitor ; j++){ //visitor들의 이름과 횟수에 따른 점수 부여 진행
            String visitorName = visitors.get(j); //visitor의 이름

            if (nameAndPoint.containsKey(visitorName)){ //이미 hashmap에 visitor의 정보가 담겨있다면, 1점을 추가로 준다.
                int presentPoint = nameAndPoint.get(visitorName);
                presentPoint += 1;
                nameAndPoint.put(visitorName,presentPoint);
                continue;
            }

            nameAndPoint.put(visitorName,1); //hashmap에 visitor 정보가 없다면 점수 1점과 함께 내용 저장
        }



        for (int i = 0; i < lengthOfFriendsEachElementList ; i++){ //Friends에 있는 사람들의 이름과 점수를 nameAndPoint라는 Hashmap에 저장해준다.
            for (int j = 0; j < numberOfFriends ; j++){
                String name = friends.get(j).get(i);

                if (nameAndPoint.containsKey(name)){ //Visitor에서 이미 추가한 사람은 제외한다.
                    continue;
                }

                nameAndPoint.put(name,0);
            }
        }



        List<String> friendsOfUser = new ArrayList<>(); //User와 친구인 사람을 담기 위한 friendsOfUser라는 배열 생성 (어짜피 중복이 안되므로 array로 만듦)

        for (int i =0 ; i < numberOfFriends ; i++) {

            int userIndex = friends.get(i).indexOf(user); //User와 친구인 사람을 찾기 위해 userIndex선언 (친구라면 0 or 1 값이 아니라면, -1이 선언)

            if (userIndex == - 1 ){ //User와 친구가 아닌 경우
                continue;
            }
            int friendIndex = 1-userIndex; //User와 친구인 사람의 Index를 찾아줌

            friendsOfUser.add(friends.get(i).get(friendIndex)); //friendsOfUser라는 배열에 User와 친구인 사람을 추가
        }

        int numberOfFriendsOfUser = friendsOfUser.size();




        for (int i = 0 ; i < numberOfFriendsOfUser ; i ++){ //친구의 친구를 찾기 위한 for문
            for (int j =0 ; j < numberOfFriends ; j++) {
                int friendsIndex = friends.get(j).indexOf(friendsOfUser.get(i));

                if (friendsIndex == - 1 ){
                    continue;
                }

                int friendOfFriendIndex = 1-friendsIndex;

                String friendNameOfFriendOfUser = friends.get(j).get(friendOfFriendIndex);

                int presentPoint = nameAndPoint.get(friendNameOfFriendOfUser);

                presentPoint += 10; //친구의 친구에게는 점수 10점씩 추가

                nameAndPoint.put(friendNameOfFriendOfUser,presentPoint);
            }
        }

        nameAndPoint.remove(user); //친구 추천을 위해, user 정보는 삭제

        List<String> keySetList = new ArrayList<>(nameAndPoint.keySet()); //nameAndPoint의 키값(아이디)만 배열화


        Collections.sort(keySetList, (o1, o2) -> (nameAndPoint.get(o2).compareTo(nameAndPoint.get(o1)))); //nameAndPoint의 키값(아이디)를 점수 순서로 배열

        for (int i =0 ; i<friendsOfUser.size() ; i ++) { //이미 친구인 사람은 제거
            keySetList.remove(friendsOfUser.get(i));
        }

        List<String> answer = keySetList;




        return answer;
    }
}

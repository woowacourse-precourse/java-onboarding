package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = FriendRecommender.recommend(new UserInformation(user,friends,visitors));
        return answer;
    }
}

class FriendRecommender {

    public static List<String> recommend(UserInformation userInformation) {

        RecommendScoreList recommendScoreList = new RecommendScoreList();

        for (String name : userInformation.friendsListOfFriends) {
            recommendScoreList.updateList(name, 10);
        }

        for (String name : userInformation.visitorList) {

            if (!userInformation.friendsList.contains(name)) {
                recommendScoreList.updateList(name, 1);
            }
        }
        return recommendScoreList.getTopFiveRankers();
    }

}


class RecommendScore {
    private final String name;
    private int score;

    RecommendScore(String name){
        this.name = name;
        score = 0;
    }

    public int addScore(int score) {
        this.score += score;
        return this.score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

class RecommendScoreList {
    private RecommendScore[] list;
    private RecommendScore[] rank;
    private int length;

    RecommendScoreList() {
        length = 0;
        list = new RecommendScore[5];
        rank = new RecommendScore[5];
    }

    public List<String> getTopFiveRankers() {

        int smallerLength = 5;
        if (length < smallerLength) {
            smallerLength = length;
        }

        String[] topFives = new String[smallerLength];

        for (int i = 0; i < smallerLength; i++) {
            topFives[i] = rank[i].getName();
        }

        return List.of(topFives);
    }

    public void updateList(String name, int score) {
        if(length == 0 || !addScore(name,score)) {
            addList(name,score);
        }
    }

    private void increaseLength () {
        RecommendScore[] tmpList = new RecommendScore[length + 5];
        RecommendScore[] tmpRank = new RecommendScore[length + 5];

        for (int i = 0; i < list.length; i++) {
            tmpList[i] = list[i];
            tmpRank[i] = rank[i];
        }

        list = tmpList;
        rank = tmpRank;

    }


    private void addList(String name, int score) {
        if (length == list.length - 1) {
            increaseLength();
        }

        list[length] = new RecommendScore(name);
        list[length].addScore(score);

        updateRank(name, score);

        length++;
    }

    private boolean addScore(String name, int score) {
        for (int i = 0; i < length; i++) {
            if(list[i].getName().equals(name)) {
                updateRank(name, list[i].addScore(score));
                return true;
            }
        }

        return false;
    }

    private void updateRank(String name, int score) {
        int ranking = 0;
        int tmpRankLength = length;

        for (int i = 0; i < tmpRankLength; i++) {
            if (rank[i].getName().equals(name)) {
                rank = delSlotInArray(rank, i);
                tmpRankLength--;
            }
        }
        for (int i = 0; i < tmpRankLength; i++) {
            if (rank[i].getScore() > score ||
                    (rank[i].getScore() == score && rank[i].getName().compareTo(name) < 0)) {
                ranking++;
            }
        }

        rank = pushSlotInArray(rank, ranking);
        rank[ranking] = new RecommendScore(name);
        rank[ranking].addScore(score);
    }

    private RecommendScore[] pushSlotInArray(RecommendScore[] array, int index) {
        RecommendScore[] out = new RecommendScore[array.length + 1];
        int counter = 0;
        int indexer = counter;
        while (counter < array.length) {
            if (counter == index) {
                indexer++;
            }
            out[indexer] = array[counter];

            indexer++;
            counter++;
        }

        return out;
    }

    private RecommendScore[] delSlotInArray(RecommendScore[] array, int index) {
        RecommendScore[] out = new RecommendScore[array.length - 1];

        int pass = 0;
        for (int i = 0; i < out.length; i++) {
            if (i == index) {
                pass = 1;
            }
            out[i] = array[i + pass];
        }
        return out;
    }

}

class UserInformation {
    public String name;
    public List<String> friendsList;
    public List<String> friendsListOfFriends;
    public List<String> visitorList;

    UserInformation(String name, List<List<String>> friendsForm, List<String> visitors) {
        this.name = name;
        friendsList = Collections.emptyList();
        friendsListOfFriends = Collections.emptyList();

        for (List<String> form : friendsForm) {
            friendsList = checkFriendNAddList(friendsList,form,this.name);
        }

        for (List<String> form : friendsForm) {
            for (String friend : friendsList) {
                friendsListOfFriends = checkFriendNAddList(friendsListOfFriends,form,friend);
            }
        }

        friendsListOfFriends = ListOrder.plzDelete(friendsListOfFriends,this.name);
        for (String friendName : friendsList) {
            friendsListOfFriends = ListOrder.plzDelete(friendsListOfFriends,friendName);
        }

        this.visitorList = visitors;
    }

    private List<String> checkFriendNAddList (List<String> listName, List<String> form, String name){
        if (form.contains(name)) {
            String friendOfName = form.get(1 - form.indexOf(name));
            return ListOrder.plzAdd(listName, friendOfName);
        }
        return listName;
    }
}

class ListOrder {

    public static List<String> plzAdd(List<String> list, String item) {

        if (list.contains(item)) {
            return list;
        }

        String listString = list.toString();
        listString = listString.substring(1,listString.length() - 1);

        if (list.size() == 0) {
            return List.of(item);
        }

        listString = listString + ", " + item;
        String[] arrString = listString.split(", ");
        return List.of(arrString);
    }

    public static List<String> plzDelete(List<String> list, String item) {

        if (!list.contains(item)) {
            return list;
        }

        String delItem = item;

        String listString = list.toString();
        listString = listString.substring(1,listString.length() - 1);

        if (list.indexOf(item) != list.size() - 1) {
            delItem = delItem + ", ";
        }

        listString = listString.replace(delItem , "");
        String[] arrString = listString.split(", ");

        return List.of(arrString);
    }
}
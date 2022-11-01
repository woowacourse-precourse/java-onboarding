package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {

    public static class Friend {

        public Friend(String name){
            this.name = name;
            this.score = 0;
        }

        public String getName(){
            return this.name;
        }

        public int getScore(){
            return this.score;
        }

        public void addScore(int score){
            this.score += score;
        }

        private String name;
        private int score;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        int fCount = 0; int dfCount = 0;
        int maxLength = 1 + friends.size() * 2 + visitors.size();

        List<String> result = new ArrayList<>();
        String[] directFriends = new String[maxLength];
        Friend[] friendArr = new Friend[maxLength];

        // direct friends
        for(int i=0; i<friends.size(); i++){
            for(int j=0; j<2; j++){
                String f = friends.get(i).get(j);
                if(f.equals(user)){
                    String ff = friends.get(i).get(1-j);
                    for(int k=0; k<directFriends.length; k++){
                        if(directFriends[k] == null){
                            directFriends[dfCount] = new String(ff);
                            dfCount++;
                            break;
                        }else if(directFriends[k].equals(ff)){
                            break;
                        }
                    }
                    break;
                }
            }
        }

        // friends
        for(int i=0; i<friends.size(); i++) {
            for (int j=0; j<2; j++) {
                String f = friends.get(i).get(j);
                if(f.equals(user)){
                    continue;
                }
                boolean isDirectFriend = false;
                for(int k=0; k<dfCount; k++){
                    String df = directFriends[k];
                    if(df.equals(f)){
                        isDirectFriend = true;
                        break;
                    }
                }
                if(isDirectFriend){
                    continue;
                }

                for(int k=0; k<friendArr.length; k++){
                    if(friendArr[k] == null){
                        friendArr[fCount] = new Friend(f);
                        fCount++;
                        break;
                    }else if(friendArr[k].getName().equals(f)){
                        break;
                    }
                }
            }
        }

        // friends - visitor
        for(int i=0; i<visitors.size(); i++){
            String visitor = visitors.get(i);

            boolean isDirectFriend = false;
            for(int k=0; k<dfCount; k++){
                String df = directFriends[k];
                if(df.equals(visitor)){
                    isDirectFriend = true;
                    break;
                }
            }
            if(isDirectFriend){
                continue;
            }

            for(int j=0; j<friendArr.length; j++){
                Friend friend = friendArr[j];
                if(friend == null){
                    friendArr[fCount] = new Friend(visitor);
                    fCount++;
                    break;
                }else if(friend.getName().equals(visitor)){
                    break;
                }
            }
        }

        for(int i=0; i<fCount; i++){
            Friend friend = friendArr[i];
            if(friend == null){
                continue;
            }
            for(int j=0; j<friends.size(); j++){
                String friend1 = friends.get(j).get(0);
                String friend2 = friends.get(j).get(1);
                if(friend1.equals(friend.getName())){
                    for(int k=0; k<dfCount; k++){
                        if(directFriends[k].equals(friend2)){
                            friendArr[i].addScore(10);
                        }
                    }
                }else if(friend2.equals(friend.getName())){
                    for(int k=0; k<dfCount; k++){
                        if(directFriends[k].equals(friend1)){
                            friendArr[i].addScore(10);
                        }
                    }
                }
            }
        }

        for(int i=0; i<fCount; i++){
            Friend friend = friendArr[i];
            for(int j=0; j<visitors.size(); j++){
                String visitor = visitors.get(j);
                if(visitor.equals(friend.getName())){
                    friendArr[i].addScore(1);
                }
            }
        }

        // sort by alphabetical order
        for(int i=1; i<fCount; i++){
            Friend current = friendArr[i];
            int j = i-1;
            while(j >= 0 && friendArr[j].getName().compareTo(current.getName()) > 0){
                friendArr[j+1] = friendArr[j];
                j -= 1;
            }
            friendArr[j+1] = current;
        }

        // sort by score
        for(int i=1; i<fCount; i++){
            Friend current = friendArr[i];
            int j = i-1;
            while(j >= 0 && friendArr[j].getScore() < current.getScore()){
                friendArr[j+1] = friendArr[j];
                j -= 1;
            }
            friendArr[j+1] = current;
        }

        for(int i=0; i<fCount; i++){
            Friend f = friendArr[i];
            if(f == null || result.size() >= 5 || f.getScore() == 0){
                break;
            }
            result.add(f.getName());
        }
        return result;




















        ///////////////////////////////////////////////


        // add result candidates
//        for(List<String> friend : friends){
//
//            if(!user.equals(friend.get(0)) && !user.equals(friend.get(1))){
//                boolean isNull = false;
//                boolean duplicate0 = false;
//                boolean duplicate1 = false;
//                for(i=0; i<friendArr.length; i++){
//                    if(friendArr[i] == null){
//                        isNull = true;
//                        break;
//                    }else if(friendArr[i].getName().equals(friend.get(0))){
//                        duplicate0 = true;
//                        break;
//                    }else if(friendArr[i].getName().equals(friend.get(1))){
//                        duplicate1 = true;
//                        break;
//                    }
//                }
//                if(isNull && !duplicate0){
//                    friendArr[count] = new Friend(friend.get(0));
//                    System.out.println("count: " + (count+1) + " / " + friend.get(0) + " is added.");
//                    count++;
//                }else if(isNull && !duplicate1){
//                    friendArr[count] = new Friend(friend.get(1));
//                    System.out.println("count: " + (count+1) + " / " + friend.get(1) + " is added.");
//                    count++;
//                }
//            }
//
//            if(friend.get(0).equals(user)){
//                boolean directFriendsDuplicate = false;
//                for(i=0; i<directFriends.length; i++){
//                    if(directFriends[i] == null || directFriends[i].equals(friend.get(1))){
//                        directFriendsDuplicate = true;
//                        break;
//                    }
//                }
//                if(!directFriendsDuplicate){
//                    directFriends[count2] = new String(friend.get(1));
//                    count2++;
//                }
//            }else if(friend.get(1).equals(user)){
//                boolean directFriendsDuplicate = false;
//                for(i=0; i<directFriends.length; i++){
//                    if(directFriends[i] == null || directFriends[i].equals(friend.get(0))){
//                        directFriendsDuplicate = true;
//                        break;
//                    }
//                }
//                if(!directFriendsDuplicate){
//                    directFriends[count2] = new String(friend.get(0));
//                    count2++;
//                }
//            }
//        }
//
//        for(String visitor : visitors){
//            boolean isNull = false;
//            boolean visitorDuplicate = false;
//            for(i=0; i<friendArr.length; i++){
//                if(friendArr[i] == null){
//                    break;
//                }else if(friendArr[i].getName().equals(visitor)){
//                    visitorDuplicate = true;
//                    break;
//                }
//            }
//            if(!visitorDuplicate){
//                friendArr[count] = new Friend(visitor);
//                System.out.println("count: " + (count+1) + " / " + visitor + " is added.");
//                count++;
//            }
//        }
//
//        for(i=0; i<count; i++){
//            if(friendArr[i] == null){
//                break;
//            }
//            String r = friendArr[i].getName();
//            for(int j=0; j<friends.size(); j++){
//                String friend1 = friends.get(i).get(0);
//                String friend2 = friends.get(i).get(1);
//                if(r.equals(friend1)){
//                    boolean directFriendsDuplicates = false;
//                    for(int k=0; k<count; k++){
//                        if(friendArr[k] == null || friendArr[k].getName().equals(friend2)){
//                            directFriendsDuplicates = true;
//                            break;
//                        }
//                    }
//                    if(!directFriendsDuplicates){
//                        friendArr[i].addScore(10);
//                    }
//                }else if(r.equals(friend2)){
//                    boolean directFriendsDuplicates = false;
//                    for(int k=0; k<count; k++){
//                        if(friendArr[k] == null || friendArr[k].getName().equals(friend1)){
//                            directFriendsDuplicates = true;
//                            break;
//                        }
//                    }
//                    if(!directFriendsDuplicates){
//                        friendArr[i].addScore(10);
//                    }
//                }
//            }
//            for(int j=0; j<visitors.size(); j++){
//                if(r.equals(visitors.get(j))){
//                    friendArr[i].addScore(1);
//                }
//            }
//        }
//
//        int j;
//        for(i=1; i<count; i++){
//            Friend currentFriend = friendArr[i];
//            j = i-1;
//            while(j >= 0 && currentFriend != null && friendArr[j] != null && currentFriend.getScore() <= friendArr[j].getScore()){
//                friendArr[j+1] = friendArr[j];
//                j -= 1;
//            }
//            friendArr[j+1] = currentFriend;
//        }
//
//        for(i=0; i<count; i++){
//            if(friendArr[i] != null){
//                result.add(friendArr[i].getName());
//            }else{
//                break;
//            }
//        }
//
//        for(i=0; i<count; i++){
//            Friend friend = friendArr[i];
//            if(friend != null && friend.getScore() != 0){
//                System.out.println("name: " + friend.name + ", score: " + friend.score);
//            }else{
//                break;
//            }
//        }
//
//        return result;
    }
}

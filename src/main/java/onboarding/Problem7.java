package onboarding;

import java.util.*;

public class Problem7 {
    static HashMap<String,Integer> f_map=new HashMap<>();
    static ArrayList<String> user_f_list=new ArrayList<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        if (validation("user_length",user.length())&&validation("friends_size",friends.size())&&validation("visitors_size",visitors.size())){
            //닉네임 길이 예외처리&&친구 리스트 배열길이 예외처리
            setUser_F_list(user,friends);
            for (List<String> friend:friends){
                if(validation("friends_e_length",friend.size())){
                    String own = friend.get(0);
                    String fri = friend.get(1);
                    if (validation("user_valid",own)&&validation("user_valid",fri)){
                        for (int i=0;i<user_f_list.size();i++){
                            if (own.equals(user_f_list.get(i))) {
                                if (fri.equals(user)) continue;
                                f_map.put(fri,f_map.getOrDefault(fri,0)+10);
                            }
                            else if (fri.equals(user_f_list.get(i))) {
                                if (own.equals(user)) continue;
                                f_map.put(own,f_map.getOrDefault(own,0)+10);
                            }
                        }
                    }
                }
            }

            for (String visitor:visitors){
                f_map.put(visitor,f_map.getOrDefault(visitor,0)+1);
            }

        }
        return answer;
    }

    public static void setUser_F_list(String user,List<List<String>> f_list){
        for (List<String> friend:f_list){
            String own = friend.get(0);
            String fri = friend.get(1);
            if (own.equals(user)){
                user_f_list.add(fri);
            }else if (fri.equals(user)){
                user_f_list.add(own);
            }
        }
    }

    public static void main(String[] args) {
        String user="mrko";

        List<List<String>> friends=new ArrayList<>();

        List<String> friend1=new ArrayList<>();
        friend1.add("donut");
        friend1.add("andole");

        List<String> friend2=new ArrayList<>();
        friend2.add("donut");
        friend2.add("jun");

        List<String> friend3=new ArrayList<>();
        friend3.add("donut");
        friend3.add("mrko");

        List<String> friend4=new ArrayList<>();
        friend4.add("shakevan");
        friend4.add("andole");

        List<String> friend5=new ArrayList<>();
        friend5.add("shakevan");
        friend5.add("jun");

        List<String> friend6=new ArrayList<>();
        friend6.add("shakevan");
        friend6.add("mrko");

        friends.add(friend1);
        friends.add(friend2);
        friends.add(friend3);
        friends.add(friend4);
        friends.add(friend5);
        friends.add(friend6);

        List<String> visitors=new ArrayList<>();
        visitors.add("bedi");
        visitors.add("bedi");
        visitors.add("donut");
        visitors.add("bedi");
        visitors.add("shakevan");

        solution(user,friends,visitors);
    }

    private static <T>boolean validation(String err_type,T err_param){
        if (err_type.equals("user_length")&&err_param instanceof Integer){
            int user_length = (int) err_param;
            return 0< user_length&&user_length<31;
        }
        else if (err_type.equals("friends_size")&&err_param instanceof Integer){
            int friends_size = (int) err_param;
            return 0<friends_size&&friends_size<10001;
        }
        else if (err_type.equals("visitors_size")&&err_param instanceof Integer){
            int visitors_size = (int) err_param;
            return 0<visitors_size&&visitors_size<10001;
        }
        else if(err_type.equals("friends_e_length")&&err_param instanceof Integer){
            int elements_length = (int) err_param;
            return elements_length==2;
        }
        else if (err_type.equals("user_valid")&&err_param instanceof String){
            String user_id_regex = (String) err_param;
            if (!user_id_regex.matches("^[a-z]*$")) return false;
            return 0<user_id_regex.length()&&user_id_regex.length()<31;
        }
        return false;
    }
}

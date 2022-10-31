package onboarding;

import java.util.*;

public class Problem7 {
    static HashMap<String,Integer> f_map=new HashMap<>();
    static ArrayList<String> user_f_list=new ArrayList<>();
    static List<String> answer = new ArrayList<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        if (validation("user_length",user.length())
                &&
                validation("friends_size",friends.size())){

            setUser_F_list(user,friends);

            for (List<String> friend:friends){
                if(validation("friends_e_length",friend.size())){

                    String own = friend.get(0);
                    String fri = friend.get(1);

                    if (validation("user_valid",own)
                            &&
                            validation("user_valid",fri)){

                        getRelationFriendScore(own,fri,user);
                    }
                }
            }
            if (validation("visitors_size",visitors.size())){
                getVisitorScore(visitors);
            }

            List<Map.Entry<String, Integer>> entryList=new LinkedList<>(f_map.entrySet());

            entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if (o1.getValue()==o2.getValue()){
                        for (int i=0;i<o1.getKey().length();i++){
                            for (int j=0;j<o2.getKey().length();j++){
                                if (o1.getKey().charAt(j)>o2.getKey().charAt(j)) return 1;
                                else return -1;
                            }
                        }
                    }
                    return o2.getValue()-o1.getValue();
                }
            });

            if (!entryList.isEmpty()){
                getAnswer(entryList);
            }
        }
        return answer;
    }

    public static void getRelationFriendScore(String own,String fri,String user){
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

    public static void getVisitorScore(List<String> visitors){
        for (String visitor:visitors){
            if(user_f_list.contains(visitor)) f_map.put(visitor,-100000);
            f_map.put(visitor,f_map.getOrDefault(visitor,0)+1);
        }
    }

    public static void getAnswer(List<Map.Entry<String, Integer>> entryList){
        if (entryList.size()>=5){
            for (int i=0;i<5;i++){
                if (entryList.get(i).getValue()>0){
                    String r_friends = entryList.get(i).getKey();
                    answer.add(r_friends);
                }
            }
        }else {
            for (int i=0;i<entryList.size();i++){
                if (entryList.get(i).getValue()>0){
                    String r_friends = entryList.get(i).getKey();
                    answer.add(r_friends);
                }
            }
        }
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

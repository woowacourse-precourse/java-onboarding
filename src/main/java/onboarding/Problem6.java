package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<UserInfo> userInfoList = getUserInfosFromInput(forms);

        Set<String> result = new HashSet<>();

        userInfoList.forEach(userInfo -> {
            String name = userInfo.getName();
            for (int spellIndex = 0; spellIndex < name.length() - 1; spellIndex++) {
                String duplicatingWord = makeDuplicatingWord(name, spellIndex);
                userInfoList.forEach(target -> {
                    if (!isNameExactlySame(userInfo, target) && hasDuplicatedName(duplicatingWord, target)) {
                        result.add(userInfo.getEmail());
                    }
                });
            }
        });

        List<String> resultList = new ArrayList<>(result);
        Collections.sort(resultList);

        return resultList;
    }

    private static List<UserInfo> getUserInfosFromInput(List<List<String>> forms) {
        List<UserInfo> userInfoList = new ArrayList<>();
        for (List<String> form : forms) {
            userInfoList.add(UserInfo.of(form.get(0), form.get(1)));
        }
        return userInfoList;
    }

    private static boolean hasDuplicatedName(String duplicatingWord, UserInfo target) {
        return target.getName().contains(duplicatingWord);
    }

    private static boolean isNameExactlySame(UserInfo userInfo, UserInfo target) {
        return userInfo.equals(target);
    }

    private static String makeDuplicatingWord(String name, int spellIndex) {
        return String.valueOf(name.charAt(spellIndex)) + name.charAt(spellIndex + 1);
    }

    public static class UserInfo {
        private final String email;
        private final String name;

        public UserInfo(String email, String name) {
            this.email = email;
            this.name = name;
        }

        public static UserInfo of(String email, String name) {
            return new UserInfo(email, name);
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof UserInfo))
                return false;
            UserInfo userInfo = (UserInfo)o;
            return email.equals(userInfo.email) && name.equals(userInfo.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(email, name);
        }
    }
}

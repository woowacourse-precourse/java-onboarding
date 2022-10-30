# 1주차_Problem6

## 🚀 기능 요구 사항

우아한테크코스에서는 교육생(이하 크루) 간 소통 시 닉네임을 사용한다. 간혹 비슷한 닉네임을 정하는 경우가 있는데, 이러할 경우 소통할 때 혼란을 불러일으킬 수 있다.

혼란을 막기 위해 크루들의 닉네임 중 **같은 글자가 연속적으로 포함** 될 경우 해당 닉네임 사용을 제한하려 한다. 이를 위해 같은 글자가 연속적으로 포함되는 닉네임을 신청한 크루들에게 알려주는 시스템을 만들려고 한다.

신청받은 닉네임 중 **같은 글자가 연속적으로 포함** 되는 닉네임을 작성한 지원자의 이메일 목록을 return 하도록 solution 메서드를 완성하라.

### 제한사항

- 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
- 크루는 1명 이상 10,000명 이하이다.
- 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
- 신청할 수 있는 이메일은 `email.com` 도메인으로만 제한한다.
- 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
- result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.

### 실행 결과 예시

| forms | result |
| --- | --- |
| [ ["jm@email.com", "제이엠"],["jason@email.com", "제이슨"], ["woniee@email.com", "워니"], ["mj@email.com", "엠제이"], ["nowm@email.com", "이제엠"] ] | ["jason@email.com", "jm@email.com", "mj@email.com"] |

백엔드 6번 문제에서 이메일의 특징에서 같은 값을 가지면 안되는게 일반적인데 문제에서 제한사항이나 기능 요구 사항에도 언급된 바가 없다. 이메일이 유일하면 식별자로 사용할 수 있을것 같다. 또한 유일한 값이라면 Hash를 이용할 때 더 빠른 속도로 해싱할 수 있다.

교육생(User) 클래스를 만들었다. 필드는 이름과 이메일을 갖고 있고 제한 사항에서 이메일을 오름차순으로 정렬하고 중복은 제거해야 하기 때문에 Comparable 인터페이스를 상속받아 구현하였다.

```java
public class User implements Comparable<User>
{
    private String email;
    private String name;

    public User(String email,String name)
    {
        this.email = email;
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public int compareTo(User o) {
        return email.compareTo(o.email);
    }
}
```

Tokenizer클래스는 문자열을 2-grams을 생성하여 리턴한다. 

```java
public class Tokenizer
{
    private static final int SEQUENCE = 2;
    public static List<String> getTokens(String input)
    {
        List<String> resultList = new ArrayList<>();

        for(int i = 0 ; i <= input.length() - SEQUENCE;i++)
        {
            resultList.add(input.substring(i,i+SEQUENCE));
        }

        return resultList;
    }
}
```

중복 체크를 위한 클래스를 만들었다. token을 subWord로 가지는 List<User>를 매핑해두고

중복이 있는 token들은 Set으로 저장해 두었다. check()를 호출 할 때 마다 중복이된 토큰이면 Set에 추가하고 getUserListWhoHasToken()는 특정 토큰을 가진 사용자를 조회할때 처음온 token이 있으면 새로운 List를 생성하고 map에 추가하고 기존에 존재하면 조회하여 반환하였다.

```java
public class DuplicatedChecker {
    private static final int DUPLICATED=1;
    Map<String, List<User>> tokenToUserListMap;
    Set<String> duplicatedTokens;

    public DuplicatedChecker()
    {
        this.tokenToUserListMap = new HashMap<>();
        this.duplicatedTokens = new HashSet<>();
    }

    public void check(String token)
    {
        List<User> userListWhoHasToken = tokenToUserListMap.get(token);
        if(userListWhoHasToken.size() > DUPLICATED)
        {
            duplicatedTokens.add(token);
        }
    }

    public List<User> getUserListWhoHasToken(String token)
    {
        List<User> userListWhoHasToken;
        if(tokenToUserListMap.containsKey(token))
        {
            userListWhoHasToken = tokenToUserListMap.get(token);
        }
        else
        {
            userListWhoHasToken = new ArrayList<>();
            tokenToUserListMap.put(token,userListWhoHasToken);
        }

        return userListWhoHasToken;
    }

    public Set<User> getDuplicatedUser()
    {

        Set<User> duplicatedUser = new TreeSet<>();
        duplicatedTokens.forEach(token->
        {
            List<User> userListWhoHasToken = tokenToUserListMap.get(token);
            duplicatedUser.addAll(userListWhoHasToken);
        });

        return duplicatedUser;
    }
}
```

UserRepository는 User를 관리하는 저장소이며 DuplicatedChecker를 필드로 가진다. 새로운 User가 등록 될 때 마다 userList에 저장하고 기존 User와 중복 되었는지 찾기 위해서 duplicatedChecker에게

검사를 요청하였다.

```java
public class UserRepository
{
    DuplicatedChecker duplicatedChecker;
    List<User> userList;

    public UserRepository(DuplicatedChecker duplicatedChecker)
    {
        this.userList = new ArrayList<>();
        this.duplicatedChecker = duplicatedChecker;
    }

    public void addAllUser(List<User> userList)
    {
        for(User user : userList)
        {
            addUser(user);
        }
    }

    public void addUser(User user)
    {
        userList.add(user);
        String userName = user.getName();
        List<String> tokenList = Tokenizer.getTokens(userName);

        for(String token : tokenList)
        {
            List<User> userListWhoHasToken = duplicatedChecker.getUserListWhoHasToken(token);
            userListWhoHasToken.add(user);

            duplicatedChecker.check(token);
        }
    }

}
```
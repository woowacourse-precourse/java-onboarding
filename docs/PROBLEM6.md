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
| [ ["jm@email.com", "제이엠"], ["jason@email.com", "제이슨"], ["woniee@email.com", "워니"], ["mj@email.com", "엠제이"], ["nowm@email.com", "이제엠"] ] | ["jason@email.com", "jm@email.com", "mj@email.com"] |

---
## 기능 목록

#### 1. ```List<List<String>>```을 ```HashMap<String, String>```으로 변환하기
- email을 key, name을 value로 설정한다

<br/>

#### 2. 닉네임에서 두 글자의 연속 문자열 구하기 ```getTokens```
```String name``` => ```List<String>```
- ```name```의 길이가 1인 경우 빈 리스트를 반환한다

<br/>

#### 3. 두 크루의 닉네임 비교 후 제한 여부 확인하기 ```isSimilar```
```List<String> names```(```[name1, name2]```) => ```boolean```

1. ```getTokens```를 이용해 ```name1```의 token 배열을 구한다
2. 각 token에 대해 ```name2```의 token 포함 여부를 확인한다
3. ```name2```에 포함된 token이 존재할 경우 ```true```를 반환한다


<br/>

#### 4. 둘로 짝지을 수 있는 모든 크루 조합 구하기 ```combination```
```List<String> emails``` => ```List<List<String>>``` (```[[email1, email2], ...]```)

<br/>

#### 5. 제한된 닉네임의 이메일 추가하기 ```addEmailList```
```List<String> emailPair, Map<String, String> formsMap, List<String> prevList``` => ```List<String>```
- ```isSimilar```가 ```true```인 경우 result에 이메일을 추가한다

<br/>

#### 6. 닉네임 사용 제한된 이메일 목록 구하기 ```solution```




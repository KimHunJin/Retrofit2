package dxmnd.com.retrofit2.java.model;

/**
 * Created by HunJin on 2018-02-24.
 * 클래스 명을 제외한 나머지 이름의 명칭은 rest api와 통일시켜 주세요.
 * 혹은 어노테이션을 사용해도 괜찮습니다. (GSON에서 제공할거에요 아마..)
 */

public class Item {
    private int id;
    private String user;
    private String name;

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }
}

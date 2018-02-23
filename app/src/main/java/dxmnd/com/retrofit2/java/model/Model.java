package dxmnd.com.retrofit2.java.model;

import java.util.List;

/**
 * Created by HunJin on 2018-02-24.
 * 클래스 명을 제외한 나머지 이름의 명칭은 rest api와 통일시켜 주세요.
 * 혹은 어노테이션을 사용해도 괜찮습니다. (GSON에서 제공할거에요 아마..)
 */

public class Model {
    private int count;
    private String next;
    private List<Item> results;

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public List<Item> getResults() {
        return results;
    }
}
package dxmnd.com.retrofit2.java.model;

import java.util.List;

/**
 * Created by HunJin on 2018-02-24.
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
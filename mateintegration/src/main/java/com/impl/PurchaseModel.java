package com.impl;

import com.flexionmobile.codingchallenge.integration.Purchase;


/**
 * Created by Mate on 2017.08.22..
 */


public class PurchaseModel implements Purchase {

    private String id;
    private String itemId;
    private boolean consumed;

    public PurchaseModel() {
    }

    public String getId() {
        return id;
    }

    public boolean getConsumed() {
        return consumed;
    }

    public String getItemId() {
        return itemId;
    }

    @Override
    public String toString() {
        return "PurchaseModel{" +
                "id='" + id + '\'' +
                ", itemId='" + itemId + '\'' +
                ", consumed=" + consumed +
                '}';
    }
}

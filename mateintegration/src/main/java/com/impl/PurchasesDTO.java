package com.impl;

import com.flexionmobile.codingchallenge.integration.Purchase;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mate on 2017.08.22..
 */
public class PurchasesDTO {
    @SerializedName("purchases")
    private List<PurchaseModel> purchases;

    public PurchasesDTO() {
    }

    public List<PurchaseModel> getPurchases() {
        return purchases;
    }

}

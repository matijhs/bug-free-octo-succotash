package com.impl;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Mate on 2017.08.22..
 */

/**
 * Helper class for parsing response with list.
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

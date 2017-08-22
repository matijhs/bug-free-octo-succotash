package com.impl;

import com.flexionmobile.codingchallenge.integration.Integration;
import com.flexionmobile.codingchallenge.integration.Purchase;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.util.List;

/**
 * Created by Mate on 2017.08.22..
 */
public class IntegrationImpl implements Integration {

    private static final String developerId = "matijhs";
    private static final String baseUrl = "http://sandbox.flexionmobile.com/javachallenge/rest/developer";
    private static final String mediaType = "application/json";

    /**
     * Call this method to buy one item. Items can be bought multiple times.
     *
     * @param s ItemId
     * @return A JSON representation of a Purchase if the call is successful.
     */

    public Purchase buy(String s) {
        String url = baseUrl + "/" + developerId + "/buy/" + s;
        RestClient rest = new RestClient();
        ClientResponse response = rest.postCall(url);

        if (response.getStatus() != 200) {
            System.out.println(response.toString());
            return null;
        }

        String entity = response.getEntity(String.class);
        Gson gs = new Gson();

        System.out.println(entity);

        return gs.fromJson(entity, PurchaseModel.class);
    }

    /**
     * Call this method to retrieve all previous purchases. Returns a list of Purchases in JSON format.
     *
     * @return A list of Purchase objects.
     */
    public List<Purchase> getPurchases() {
        String url = baseUrl + "/" + developerId + "/all";
        RestClient rest = new RestClient();
        ClientResponse response = rest.getCall(url);

        if (response.getStatus() != 200) {
            System.out.println(response.toString());
            return null;
        }

        String entity = response.getEntity(String.class);
        Gson gs = new Gson();

        System.out.println(entity);

        // use this helper class to parse the response JSON
        PurchasesDTO dto = gs.fromJson(entity, PurchasesDTO.class);

        // a not so brave cast as we know it will be fine.
        return (List<Purchase>) (List<?>) dto.getPurchases();
    }

    /**
     * Call this method to consume one purchase.
     *
     * @param purchase - The Purchase object to be consumed.
     */
    public void consume(Purchase purchase) {
        String url = baseUrl + "/" + developerId + "/consume/" + purchase.getId();
        RestClient rest = new RestClient();
        ClientResponse response = rest.postCall(url);

        if (response.getStatus() != 200) {
            System.out.println(response.toString());
        }
    }

    private class RestClient {

        public ClientResponse getCall(String url) {
            WebResource webRes = Client.create().resource(url);
            System.out.println("getCall to " + url);
            return webRes.accept(mediaType).get(ClientResponse.class);
        }

        public ClientResponse postCall(String url) {
            WebResource webRes = Client.create().resource(url);
            System.out.println("postCall to " + url);
            return webRes.accept(mediaType).post(ClientResponse.class);
        }
    }
}

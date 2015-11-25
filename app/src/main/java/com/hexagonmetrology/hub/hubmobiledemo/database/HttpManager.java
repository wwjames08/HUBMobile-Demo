package com.hexagonmetrology.hub.hubmobiledemo.database;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;

/**
 * Grabs data from the cloud and manages the HTTP connection
 */
public class HttpManager {

    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    /**
     *
     */
    public interface CloudCallback {
        void received(DataManager dataManager);
    }

/*    public HttpManager(final CloudCallback callback) {

        Request.Builder request = new Request.Builder();
        request.url("https://s3.amazonaws.com/hexmet-sfnow/pulse_event.txt");

        *//**
     * Makes a call to the URL given
     *//*
        client.newCall(request.build()).enqueue(new Callback() {

            *//**
     * Handles the non-response of the website called...
     * @param request
     * @param e
     *//*
            @Override
            public void onFailure(Request request, IOException e) {
                //TODO: Handle failed Http call
            }

            *//**
     * Handles the response of the website called by turning the
     * body into a string and then parsing it with gson to the
     * DataManager class
     * @param response is the data downloaded from the website
     * @throws IOException
     *//*
            @Override
            public void onResponse(Response response) throws IOException {
                String data = response.body().string();
                Timber.d(data); //For debugging: see if data came through
                DataManager dataManager = gson.fromJson(data, DataManager.class);
                if (callback != null)
                    callback.received(dataManager);
            }
        });
    }*/

}

package ca.simba.resumeapp;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by tmast_000 on 8/31/2015.
 */
public class Requests {

    private static Requests sInstance = null;
    private final RequestQueue mRequestQueue;

    private Requests() {
        mRequestQueue = Volley.newRequestQueue(MyApplication.getAppContext());
    }

    public static Requests getInstance() {
        if (sInstance==null) {
            sInstance = new Requests();
        }
        return sInstance;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

}

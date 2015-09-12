package ca.simba.resumeapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;

import com.lacronicus.easydatastorelib.DatastoreBuilder;

import java.io.IOException;
import java.security.GeneralSecurityException;


public class Credentials {

    private static UserLocalStore credentials;

    // Constants
    private static String SHARED_PREFS_NAME = "Credentials";
    public static String USERNAME = "__USERNAME__";
    public static String PASSWORD = "__PASSWORD__";

    public static UserLocalStore get(Context context) {
        if (credentials == null) {
            credentials = new DatastoreBuilder(PreferenceManager.getDefaultSharedPreferences(context))
                    .create(UserLocalStore.class);
        }
        return credentials;
    }

    public static void save(Context context, String username, String password)
    throws Exception {
        // TODO Add encryption
        Credentials.get(context);
        credentials.username().put(username);
        String cred = username + ":" + password;
        credentials.credentials().put(Base64.encodeToString(cred.getBytes(), Base64.DEFAULT));
    }

    public static String getHeader(Context context) {
        Credentials.get(context);
        String cred = credentials.credentials().get();
        Log.e("Auth", "Basic "+ cred);
        return "Basic " + cred;
    }

}

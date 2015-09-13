package ca.simba.resumeapp.util;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;

import com.lacronicus.easydatastorelib.DatastoreBuilder;


public class Credentials {

    private static UserLocalStore credentials;

    public static UserLocalStore get(Context context) {
        if (credentials == null) {
            credentials = new DatastoreBuilder(PreferenceManager.getDefaultSharedPreferences(context))
                    .create(UserLocalStore.class);
        }
        return credentials;
    }

    public static void save(Context context, String username, String password) {
        // TODO Add encryption
        Credentials.get(context);
        credentials.username().put(username);

        String cred = Base64.encodeToString((username + ":" + password).getBytes(), Base64.DEFAULT);
        credentials.credentials().put(cred);
    }

    public static String getHeader(Context context) {
        Credentials.get(context);
        String cred = credentials.credentials().get();
        Log.e("Auth", "Basic "+ cred);
        return "Basic " + cred;
    }

}

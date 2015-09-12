package ca.simba.resumeapp;

import com.lacronicus.easydatastorelib.ObjectEntry;
import com.lacronicus.easydatastorelib.Preference;
import com.lacronicus.easydatastorelib.StringEntry;

import java.util.List;

/**
 * Created by tmast_000 on 9/2/2015.
 */
public interface UserLocalStore {

    @Preference("username")
    StringEntry username();

    @Preference("password")
    StringEntry password();

    @Preference("credentials")
    StringEntry credentials();

    @Preference("key")
    StringEntry key();

    @Preference("resumes")
    ObjectEntry<List<String>> resumes();

}

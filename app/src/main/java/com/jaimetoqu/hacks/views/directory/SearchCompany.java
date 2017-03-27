package com.jaimetoqu.hacks.views.directory;

import com.jaimetoqu.hacks.data.Queries;
import com.jaimetoqu.hacks.models.Company;

import java.util.List;

/**
 * Created by jaime on 2/27/17.
 */

public class SearchCompany {

    private DirectoryCallback callback;

    public SearchCompany(DirectoryCallback callback) {
        this.callback = callback;
    }

    public void validate(String name) {
        if (name.trim().length() > 0) {
            List<Company> companies = new Queries().companiesByName(name);
            callback.searched(companies);

        } else {
            callback.noName();
        }
    }
}

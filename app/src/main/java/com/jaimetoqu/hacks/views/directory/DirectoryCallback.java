package com.jaimetoqu.hacks.views.directory;

import com.jaimetoqu.hacks.models.Company;

import java.util.List;

/**
 * Created by jaime on 2/27/17.
 */

public interface DirectoryCallback {

    void searched(List<Company> companies);

    void noName();
}

package com.jaimetoqu.hacks.views.signupcompany;

/**
 * Created by jaime on 2/28/17.
 */

public interface SignUpCompanyCallback {

    void signedCompany(String name, int bounty, String email, String webSite);
    void noCompany();
}

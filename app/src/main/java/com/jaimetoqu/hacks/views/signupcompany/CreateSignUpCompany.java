package com.jaimetoqu.hacks.views.signupcompany;

import com.jaimetoqu.hacks.models.Company;

/**
 * Created by jaime on 2/28/17.
 */

public class CreateSignUpCompany {

    private SignUpCompanyCallback callback;

    public CreateSignUpCompany(SignUpCompanyCallback callback) {
        this.callback = callback;
    }

    public void valid(String name, String bounty, String email, String webSite) {
        if (name.trim().length() > 0 && bounty.trim().length() > 0 && email.trim().length() > 0 && email.contains("@") && webSite.trim().length() > 0) {
            Company company = new Company();
            company.setName(name);
            company.setEmail(email);
            company.setWebSite(webSite);
            company.setBounty(Integer.parseInt(bounty));
            company.save();
            callback.signedCompany(name, Integer.parseInt(bounty), email, webSite);
        } else {
            callback.noCompany();
        }
    }
}

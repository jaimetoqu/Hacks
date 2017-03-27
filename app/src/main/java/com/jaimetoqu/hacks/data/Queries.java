package com.jaimetoqu.hacks.data;

import android.util.Log;

import com.jaimetoqu.hacks.models.Company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaime on 2/27/17.
 */

public class Queries {

    public List<Company> companiesByName(String name) {
        List<Company> companies = new ArrayList<>();
        String query = "name LIKE " + "'%"+name+"%'";
        List<Company> companyList = Company.find(Company.class, query);
        if (companyList != null && companyList.size() > 0) {
            companies.addAll(companyList);
            Log.d("SIZE", String.valueOf(companyList.size()));
        }
        return companies;
    }


}


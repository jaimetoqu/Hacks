package com.jaimetoqu.hacks.views.companydetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jaimetoqu.hacks.R;
import com.jaimetoqu.hacks.models.Company;

public class CompanyDetailsActivity extends AppCompatActivity {

    private TextView webSite;
    private TextView email;
    private TextView bounty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);

        long id = getIntent().getLongExtra("id", 0);
        Company company = Company.findById(Company.class, id);
        getSupportActionBar().setTitle(company.getName());

        webSite = (TextView) findViewById(R.id.webSiteTv);
        webSite.setText(company.getWebSite());

        email = (TextView) findViewById(R.id.emailTv);
        email.setText(company.getWebSite());

        bounty = (TextView) findViewById(R.id.bountyTv);
        bounty.setText(String.valueOf(company.getBounty()));

    }
}

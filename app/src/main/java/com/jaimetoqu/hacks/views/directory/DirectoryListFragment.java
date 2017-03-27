package com.jaimetoqu.hacks.views.directory;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaimetoqu.hacks.R;
import com.jaimetoqu.hacks.adapters.company.CompanyAdapter;
import com.jaimetoqu.hacks.adapters.company.CompanyClickListener;
import com.jaimetoqu.hacks.models.Company;
import com.jaimetoqu.hacks.views.companydetails.CompanyDetailsActivity;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DirectoryListFragment extends Fragment implements CompanyClickListener {

    private CompanyAdapter adapter;

    public DirectoryListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_directory_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.companiesRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        adapter = new CompanyAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    public void addCompany(List<Company> companies) {
        adapter.addCompany(companies);
    }

    @Override
    public void clickedId(long id) {
        Intent intent = new Intent(getActivity(), CompanyDetailsActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

}

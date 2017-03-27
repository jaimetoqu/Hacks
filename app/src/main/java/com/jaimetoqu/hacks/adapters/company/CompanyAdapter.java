package com.jaimetoqu.hacks.adapters.company;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaimetoqu.hacks.R;
import com.jaimetoqu.hacks.models.Company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaime on 2/27/17.
 */

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.ViewHolder> {

    private List<Company> companies = new ArrayList<>();
    private CompanyClickListener listener;

    public CompanyAdapter(CompanyClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_company, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Company company = companies.get(position);
        holder.companyView.setText(company.getName());
        holder.bountyView.setText("recompensa min: $" + String.valueOf(company.getBounty()));

        holder.companyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Company auxCompany = companies.get(holder.getAdapterPosition());
                listener.clickedId(auxCompany.getId());
            }
        });

        holder.bountyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Company auxCompany = companies.get(holder.getAdapterPosition());
                listener.clickedId(auxCompany.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return companies.size();
    }

    public void addCompany(List<Company> companies) {
        this.companies.clear();
        this.companies.addAll(companies);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView companyView;
        private final TextView bountyView;

        public ViewHolder(View itemView) {
            super(itemView);
            companyView = (TextView) itemView.findViewById(R.id.companyTv);
            bountyView = (TextView) itemView.findViewById(R.id.bountyT);
        }
    }
}

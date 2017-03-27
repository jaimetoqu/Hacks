package com.jaimetoqu.hacks.views.post;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaimetoqu.hacks.R;
import com.jaimetoqu.hacks.adapters.post.PostAdapter;
import com.jaimetoqu.hacks.data.CurrentUser;


public class PostListFragment extends Fragment {

    private PostAdapter adapter;

    public PostListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.postRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        CurrentUser user = new CurrentUser();
        String uid = user.userId();

        adapter = new PostAdapter(uid);
        recyclerView.setAdapter(adapter);
    }

}

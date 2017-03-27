package com.jaimetoqu.hacks.adapters.post;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.jaimetoqu.hacks.R;
import com.jaimetoqu.hacks.data.CurrentUser;
import com.jaimetoqu.hacks.data.Nodes;
import com.jaimetoqu.hacks.models.Post;


/**
 * Created by jaime on 3/26/17.
 */

public class PostAdapter extends FirebaseRecyclerAdapter<Post, PostAdapter.PostHolder> {

    private boolean done = true;

    public PostAdapter(String postId) {
        super(Post.class, R.layout.list_item_post, PostHolder.class, new Nodes().hackerPost(postId));
    }

    @Override
    protected void populateViewHolder(final PostHolder viewHolder, final Post model, int position) {


        viewHolder.setHackerPost(model.getPost());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (done) {
                    String uid = new CurrentUser().userId();
                    new Nodes().hackerPost(uid).child(model.getPostId()).removeValue();
                }
            }
        });
    }

    public static class PostHolder extends RecyclerView.ViewHolder {

        private final TextView hackerPost;

        public PostHolder(View itemView) {
            super(itemView);
            hackerPost = (TextView) itemView.findViewById(R.id.hackerPostTv);

        }

        public void setHackerPost(String text) {
            hackerPost.setText(text);
        }
    }
}

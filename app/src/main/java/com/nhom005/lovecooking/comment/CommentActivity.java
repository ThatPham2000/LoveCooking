package com.nhom005.lovecooking.comment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhom005.lovecooking.R;
import com.nhom005.lovecooking.models.Comment;
import com.nhom005.lovecooking.search.ResultSearchActivity;
import com.nhom005.lovecooking.utils.Constants;
import com.nhom005.lovecooking.utils.FunctionHelper;

import java.util.ArrayList;

public class CommentActivity extends AppCompatActivity {
    ArrayList<Comment> comments = new ArrayList<>();
    RecyclerView lvComment;
    CommentAdapter adapter;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        comments.addAll(Constants.comments);

        ImageView closeBtn = findViewById(R.id.closeBtn);
        ImageView imgAddImageBtn = findViewById(R.id.imgAddImageBtn);
        lvComment = findViewById(R.id.lvComment);
        EditText contentText = findViewById(R.id.contentText);

        adapter = new CommentAdapter(comments, new IComment() {
            @Override
            public void replyComment(int i) {
                index = i;
            }
        });
        lvComment.setAdapter(adapter);

        closeBtn.setOnClickListener(v -> {
            onBackPressed();
        });
        contentText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String content = contentText.getText().toString();
                    addComment(content);
                    handled = true;

                    contentText.setText("");
                    FunctionHelper.hideKeyboard(CommentActivity.this);
                }
                return handled;
            }
        });

    }

    private void addComment(String content) {
        if (index > -1 && comments.get(index).isReply) {
            Comment comment = comments.get(index);
            comment.reply.add(new Comment(Constants.users.get(0), content));
            comment.isReply = false;
            lvComment.scrollToPosition(index);
            adapter.notifyItemChanged(index);
            return;
        }
        comments.add(new Comment(Constants.users.get(0), content));
        lvComment.scrollToPosition(comments.size() - 1);
        adapter.notifyItemInserted(comments.size() - 1);
    }
}
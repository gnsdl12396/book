package com.lectopia.tsop.booklibrarydemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lectopia.tsop.booklibrarydemo.share.ApplicationShare;

public class AddBookFragment extends Fragment {
    private ApplicationShare share;
    private EditText etTitle;
    private EditText etAuthor;
    private EditText etContent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_add_book, container, false);

        share = (ApplicationShare)getActivity().getApplication();

        etTitle = (EditText)rootView.findViewById(R.id.etTitle);
        etAuthor = (EditText)rootView.findViewById(R.id.etAuthor);
        etContent= (EditText)rootView.findViewById(R.id.etContent);

        Button btnAdd = (Button)rootView.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etTitle.getText().toString();
                String author = etAuthor.getText().toString();
                String content = etContent.getText().toString();

                if (title == null || title.isEmpty()
                        || author == null || author.isEmpty()
                        || content == null || content.isEmpty()) {
                    Toast.makeText(getContext(), "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    share.getBookDb().insertRecordParam(title, author, content);
                    etTitle.setText("");
                    etAuthor.setText("");
                    etContent.setText("");
                    Toast.makeText(getContext(), "저장 되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;
    }
}

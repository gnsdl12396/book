package com.lectopia.tsop.booklibrarydemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.lectopia.tsop.booklibrarydemo.adapter.BookListAdapter;
import com.lectopia.tsop.booklibrarydemo.share.ApplicationShare;

public class SearchBookFragment extends Fragment {
    private BookListAdapter adapter;
    private ListView bookListView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_search_book, container, false);

        ApplicationShare share = (ApplicationShare)getActivity().getApplication();

        bookListView = (ListView)rootView.findViewById(R.id.bookListView);
        adapter = new BookListAdapter(getActivity(), share.getBooks());
        bookListView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}

package com.lectopia.tsop.booklibrarydemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lectopia.tsop.booklibrarydemo.R;
import com.lectopia.tsop.booklibrarydemo.model.Book;

import java.util.List;

public class BookListAdapter extends BaseAdapter{
    private Context context;
    private LayoutInflater layoutInflater;
    private List<Book> data;

    public BookListAdapter(Context context, List<Book> data) {
        this.context = context;
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    class ViewHolder {
        TextView tvTitle;
        TextView tvAuthor;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        //1. 리스트의 한 항목에 해당하는 레이아웃을 설정
        View itemLayout = view;
        ViewHolder viewHolder = null;

        if (itemLayout == null) {
            itemLayout = layoutInflater.inflate(R.layout.list_item_book, null);
            viewHolder = new ViewHolder();

            viewHolder.tvTitle = (TextView)itemLayout.findViewById(R.id.tvTitle);
            viewHolder.tvAuthor = (TextView)itemLayout.findViewById(R.id.tvAuthor);
            itemLayout.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)itemLayout.getTag();
        }

        //2.  이름, 학번, 학과 데이터를 참조해서 레이아웃을 갱신
        Book book = this.data.get(position);
        viewHolder.tvTitle.setText(book.getTitle());
        viewHolder.tvAuthor.setText(book.getAuthor());

        return itemLayout;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}

package to.msn.wings.listmyadapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ListItem> data;
    private int resource;

    public MyListAdapter(Context context, ArrayList<ListItem> data, int resource) {
        this.context = context;
        this.data = data;
        this.resource = resource;
    }

        //データ項目の個数を表示
    @Override
    public int getCount() {
        return data.size();
    }
        //指定された項目を取得
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }
        //指定された項目を識別するためのid値を取得
    @Override
    public long getItemId(int position) {
        return data.get(position).getId();
    }
        //リスト項目を表示する為のViewを取得
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Activity activity = (Activity)context;
        ListItem item = (ListItem) getItem(position);
        if(convertView == null){
            convertView = activity.getLayoutInflater().inflate(resource,null);
        }
        ((TextView)convertView.findViewById(R.id.title)).setText(item.getTitle());
        ((TextView)convertView.findViewById(R.id.tag)).setText(item.getTag());
        ((TextView)convertView.findViewById(R.id.detail)).setText(item.getDetail());
        return convertView;
    }
}

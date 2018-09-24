package sample.android.com.customlistviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    String[] names;
    int[] images;
    private LayoutInflater inflater;


    public CustomAdapter(Context context, String[] names, int[] images) {
        this.context = context;
        this.names = names;
        this.images = images;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {

            view = inflater.inflate(R.layout.sample_layout, null);

        }

        ImageView imageView = view.findViewById(R.id.pictureId);
        TextView textView = view.findViewById(R.id.nameId);

        imageView.setImageResource(images[i]);
        textView.setText(names[i]);

        return view;
    }

    public void filter(String[] title, int[] img) {
        names = title;
        images = img;
        notifyDataSetChanged();//changing list if changes notified


    }
}

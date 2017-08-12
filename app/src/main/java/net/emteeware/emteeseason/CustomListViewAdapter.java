package net.emteeware.emteeseason;

/*
  Created by Merlin Thomas on 12.08.2017.
  www.emteeware.net
 */

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomListViewAdapter extends ArrayAdapter<Series> {

    private Context context;

    CustomListViewAdapter(Context context, int resourceId,
                          List<Series> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
        TextView txtDesc;
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        Series seriesItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.txtDesc = (TextView) convertView.findViewById(R.id.desc);
            holder.txtTitle = (TextView) convertView.findViewById(R.id.title);
            holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        assert seriesItem != null;
        holder.txtDesc.setText(seriesItem.getSeasonString());
        holder.txtTitle.setText(seriesItem.getName());
        // holder.imageView.setImageResource(seriesItem.getImageId());

        return convertView;
    }
}
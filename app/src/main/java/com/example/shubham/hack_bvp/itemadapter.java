package com.example.shubham.hack_bvp;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by navendu on 02-02-2017.
 */
public class itemadapter extends ArrayAdapter<item> {


    private static final String LOG_TAG = itemadapter.class.getSimpleName();

    public itemadapter(Activity context, ArrayList<item> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final item currentitem = getItem(position);

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(currentitem.getImageResourceId());




        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.item_name);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentitem.name);
        TextView name1TextView = (TextView) listItemView.findViewById(R.id.item_price);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        name1TextView.setText("$"+currentitem.price+"");

        final EditText name3TextView = (EditText) listItemView.findViewById(R.id.ee);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView

        Button b1 = (Button) listItemView.findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                name3TextView.setText(++currentitem.qty+"");

            }
        });



        Button b2 = (Button) listItemView.findViewById(R.id.b2);


        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                name3TextView.setText(--currentitem.qty+"");

            }
        });




        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }




}

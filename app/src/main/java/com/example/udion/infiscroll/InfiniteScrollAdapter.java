package com.example.udion.infiscroll;

/**
 * Created by udion on 7/10/17.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class InfiniteScrollAdapter<T> extends ArrayAdapter<T>{

    private Activity context;
    private List<T> values;
    private int count;
    private int stepNumber;
    private int startCount;

    /**
     *
     * @param context
     * @param values
     * @param startCount the initial number of views to show
     * @param stepNumber the number of additional views to show with each expansion
     */
    public InfiniteScrollAdapter(Activity context, List<T> values, int startCount, int stepNumber) {
        super(context, R.layout.row_layout, values);
        this.context = context;
        this.values = values;
        this.startCount = Math.min(startCount, values.size()); //don't try to show more views than we have
        this.count = this.startCount;
        this.stepNumber = stepNumber;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.row_layout, null);

            view.setTag(R.id.t1, view.findViewById(R.id.textView1));
            view.setTag(R.id.t2, view.findViewById(R.id.textView2));
            view.setTag(R.id.t3, view.findViewById(R.id.textView3));
            view.setTag(R.id.t4, view.findViewById(R.id.textView4));
            //buttons
            view.setTag(R.id.b1, view.findViewById(R.id.button_add_comment));
            view.setTag(R.id.b2, view.findViewById(R.id.button_more_comment));
        }else{
            view = convertView;
        }
        TextView textView1 = (TextView) view.getTag(R.id.t1);
        TextView textView2 = (TextView) view.getTag(R.id.t2);
        TextView textView3 = (TextView) view.getTag(R.id.t3);
        TextView textView4 = (TextView) view.getTag(R.id.t4);
        final Button btn1 = (Button) view.getTag(R.id.b1);
        final Button btn2 = (Button) view.getTag(R.id.b2);

        textView1.setText(((List<List<String>>)values).get(position).get(0).toString());
        textView2.setText(((List<List<String>>)values).get(position).get(1).toString());
        textView3.setText(((List<List<String>>)values).get(position).get(2).toString());
        textView4.setText(((List<List<String>>)values).get(position).get(3).toString());

        btn1.setTag(((List<List<String>>)values).get(position).get(4).toString());
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO write the proper action
                String bid = (String) btn1.getTag();
                System.out.println("hi inside addComments "+bid);
                Toast.makeText(getContext(), "post id: "+bid, Toast.LENGTH_SHORT).show();
            }
        });
        //TODO write the listener for btn2
        return view;
    }

    /**
     * Show more views, or the bottom
     * @return true if the entire data set is being displayed, false otherwise
     */
    public boolean showMore(){
        if(count == values.size()) {
            return true;
        }else{
            count = Math.min(count + stepNumber, values.size()); //don't go past the end
            notifyDataSetChanged(); //the count size has changed, so notify the super of the change
            return endReached();
        }
    }

    /**
     * @return true if then entire data set is being displayed, false otherwise
     */
    public boolean endReached(){
        return count == values.size();
    }

    /**
     * Sets the ListView back to its initial count number
     */
    public void reset(){
        count = startCount;
        notifyDataSetChanged();
    }
}

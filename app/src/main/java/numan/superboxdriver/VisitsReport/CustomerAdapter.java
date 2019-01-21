package numan.superboxdriver.VisitsReport;

/**
 * Created by Gillani on 10/4/2016.
 */
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;

import numan.superboxdriver.R;

public class CustomerAdapter extends BaseAdapter {

    Context context;
    List<CustomerRowItem> rowItems;
    public CustomerAdapter(Context context, List<CustomerRowItem> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {

        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    /* private view holder class */
    private class ViewHolder {
        TextView ProviderName;
        TextView ProductName;
//        TextView TotalQuantity;
        TextView TotalAmount;
        TextView CreatedOn;
        TextView MobileNumber;
        FrameLayout frameColor;
    }

    @SuppressLint("ResourceAsColor")
    @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View v = convertView;
        ViewHolder holder;
        try {
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.deal_item, null);


                holder = new ViewHolder();
                    holder.ProviderName = (TextView) v
                            .findViewById(R.id.ProviderName);
                holder.ProductName = (TextView) v
                        .findViewById(R.id.ProductName);
//                holder.TotalQuantity = (TextView) v
//                        .findViewById(R.id.TotalQuantity);
                holder.TotalAmount = (TextView) v
                        .findViewById(R.id.TotalAmount);
                holder.CreatedOn = (TextView) v
                        .findViewById(R.id.CreatedOn);
                holder.MobileNumber = (TextView) v
                        .findViewById(R.id.MobileNumber);
                holder.frameColor = (FrameLayout) v
                        .findViewById(R.id.status_bg);

                v.setTag(holder);
            } else
                holder = (ViewHolder) v.getTag();

            holder.ProviderName.setText(rowItems.get(position).getProviderName());
            holder.ProductName.setText(rowItems.get(position).getProductName());
//            holder.TotalQuantity.setText(rowItems.get(position).getTotalQuantity());
                holder.TotalAmount.setText(rowItems.get(position).getTotalAmount());
            holder.CreatedOn.setText(rowItems.get(position).getCreatedOn());
            holder.MobileNumber.setText(rowItems.get(position).getMobileNumber());
            holder.MobileNumber.setSelected(true);
            holder.MobileNumber.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            holder.MobileNumber.setSingleLine(true);
            if(position%2==0)
                holder.frameColor.setBackgroundColor(context.getResources().getColor(R.color.green_400));
            else if(position%3==0)
                holder.frameColor.setBackgroundColor(context.getResources().getColor(R.color.yellow_400));
            else
                holder.frameColor.setBackgroundColor(context.getResources().getColor(R.color.red_400));
        }
        catch (Exception ex)
        {
            Log.e("Custom Main Exception" , ex+"");
        }
            return v;
    }
}


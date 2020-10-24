package list_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jmjproduction.adasupplychain.R;

import UserDefinder.DeliveryChallanReportModel;

/**
 * Created by jmjsa on 07/03/2017.
 */

public class DeliveryChallanListAdapter extends RecyclerView.Adapter<DeliveryChallanViewHolder> {
    private Context mContext;
    DeliveryChallanReportModel[] deliveryChallanReportModelArrayList;

    public DeliveryChallanListAdapter(Context mContext, DeliveryChallanReportModel[] deliveryChallanReportModelArrayList) {
        this.mContext = mContext;
        this.deliveryChallanReportModelArrayList = deliveryChallanReportModelArrayList;
    }

    @Override
    public DeliveryChallanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.deliverychallan_report_productlist_design,parent,false);
        DeliveryChallanViewHolder holder=new DeliveryChallanViewHolder(view);
        holder.txtProductname=(TextView)view.findViewById(R.id.productName);
        holder.txtColorname=(TextView)view.findViewById(R.id.txtColor);
        holder.txtQuantity=(TextView)view.findViewById(R.id.txtQuantity);
        holder.txttotalAmount=(TextView)view.findViewById(R.id.txtTotalAmount);
        holder.txtUnitPrice=(TextView) view.findViewById(R.id.unitPrice);
        return holder;

    }

    @Override
    public void onBindViewHolder(DeliveryChallanViewHolder holder, int position) {
        DeliveryChallanReportModel deliveryChallanReportModel=deliveryChallanReportModelArrayList[position];
            holder.txtProductname.setText(deliveryChallanReportModel.getProductName());
        holder.txtColorname.setText(deliveryChallanReportModel.getColorName());
        holder.txtQuantity.setText(deliveryChallanReportModel.getDeliveredQuantity().toString());

    }

    @Override
    public int getItemCount() {
        return deliveryChallanReportModelArrayList.length;
    }
}

class DeliveryChallanViewHolder extends RecyclerView.ViewHolder{
    TextView txtProductname;
    TextView txtQuantity;
    TextView txtUnitPrice;
    TextView txttotalAmount;
    TextView txtColorname;
    public DeliveryChallanViewHolder(View itemView) {
        super(itemView);
    }
}

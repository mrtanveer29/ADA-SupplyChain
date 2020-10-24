package list_adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jmjproduction.adasupplychain.DeliveryChalanActivity;
import com.jmjproduction.adasupplychain.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import IRepository.IRequisition;
import IRepository.IdeliveryListInfo;
import UserDefinder.ReceivedDeliveryModel;
import UserDefinder.RequisitionDeleteModel;
import UserDefinder.RequisitionList;
import model.APIInitializer;
import model.DeliveryListInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Code Freak Tanveer on 20/02/2017.
 */

public class DeliveryListAdapter extends RecyclerView.Adapter<DeliveryViewHolder> {
    private Activity mContext;
    List<DeliveryListInfo> deliveryListInfoList;
    public DeliveryListAdapter(Activity mContext,DeliveryListInfo[] data) {
        this.mContext = mContext;
        deliveryListInfoList=new ArrayList<DeliveryListInfo>(Arrays.asList(data));
    }

    @Override
    public DeliveryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.delivery_list_design,parent,false);
        DeliveryViewHolder deliveryViewHolder=new DeliveryViewHolder(view);
        deliveryViewHolder.txtDeliveryCode=(TextView)view.findViewById(R.id.txtDeliveryCode);
        deliveryViewHolder.txtDeliveryDate=(TextView)view.findViewById(R.id.textDeliveryDate);
        deliveryViewHolder.txtRequisitionCode=(TextView)view.findViewById(R.id.txtRequisitionCode);
        deliveryViewHolder.txtRequistiondate=(TextView)view.findViewById(R.id.txtRequistionDate);
        deliveryViewHolder.txtTotalAmount=(TextView)view.findViewById(R.id.txtTotalAmount);
        deliveryViewHolder.itemDelivery=(View) view.findViewById(R.id.itemClickForChallan);
        deliveryViewHolder.btnReceived=(Button)view.findViewById(R.id.btnReceived);
        deliveryViewHolder.imgDeliveryStatus=(ImageView) view.findViewById(R.id.txtDeliveryStatus);

        return deliveryViewHolder;
    }

    @Override
    public void onBindViewHolder(DeliveryViewHolder holder, final int position) {

        holder.txtDeliveryCode.setText(deliveryListInfoList.get(position).getDeliveryNo());
        holder.txtDeliveryDate.setText(deliveryListInfoList.get(position).getDeliveryDate());
        holder.txtRequisitionCode.setText(deliveryListInfoList.get(position).getRequisitionCode());
        holder.txtRequistiondate.setText(deliveryListInfoList.get(position).getCreatedDate());
        holder.txtTotalAmount.setText(deliveryListInfoList.get(position).getTotalAmount().toString()+" TK");

        final String delieveryStatus=deliveryListInfoList.get(position).getStatus();
        if(delieveryStatus.equals("Received")){
            holder.btnReceived.setVisibility(View.GONE);
            holder.imgDeliveryStatus.setImageResource(R.drawable.icon_received);
        }

        holder.itemDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                int delivery_master_id=deliveryListInfoList.get(position).getDeliveryMasterId();
                Intent intent=new Intent(mContext, DeliveryChalanActivity.class);
               intent.putExtra("delivery_master_id",delivery_master_id);
               intent.putExtra("delivery_status",delieveryStatus);
                mContext.startActivity(intent);
           }
        });
        holder.btnReceived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(mContext)
                        .setIcon(R.drawable.icon_alert)
                        .setTitle("Confirmation")
                        .setMessage("Are you sure you want to Receive this Delivery?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int deliveryMasterId=deliveryListInfoList.get(position).getDeliveryMasterId();
                                Retrofit retrofit= APIInitializer.initNetwork(mContext);
                                retrofit.create(IdeliveryListInfo.class).ReceivedDelivery(deliveryMasterId,54).enqueue(new Callback<ReceivedDeliveryModel>() {
                                    @Override
                                    public void onResponse(Call<ReceivedDeliveryModel> call, Response<ReceivedDeliveryModel> response) {
                                        deliveryListInfoList.remove(position);
                                        Toast.makeText(mContext, "Delivery is received successfully.", Toast.LENGTH_SHORT).show();
                                        notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onFailure(Call<ReceivedDeliveryModel> call, Throwable t) {

                                    }
                                });
                            }

                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return deliveryListInfoList.size();
    }

}

class DeliveryViewHolder extends RecyclerView.ViewHolder{
    TextView txtDeliveryCode;
    TextView txtDeliveryDate;
    TextView txtRequisitionCode;
    TextView txtRequistiondate;
    TextView txtTotalAmount;
    ImageView imgDeliveryStatus;
    View itemDelivery;
    Button btnReceived;
    public DeliveryViewHolder(View itemView) {
        super(itemView);
    }
}
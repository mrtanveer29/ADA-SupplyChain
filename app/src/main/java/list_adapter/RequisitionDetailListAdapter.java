package list_adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jmjproduction.adasupplychain.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import IRepository.IRequisition;
import UserDefinder.RequisitionDeleteModel;
import UserDefinder.RequisitionList;
import model.APIInitializer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class RequisitionDetailListAdapter extends RecyclerView.Adapter<RequisitionDetailsViewHolder> {
    private Activity mContext;

    List<RequisitionList> requisitionArrayList;

    public RequisitionDetailListAdapter(Activity mContext,RequisitionList[] requisitionLists) {
        this.mContext = mContext;
         requisitionArrayList=new ArrayList<RequisitionList>(Arrays.asList(requisitionLists));
    }

    @Override
    public RequisitionDetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.requisition_list_design_2,parent,false);
        RequisitionDetailsViewHolder requisitionDetailsViewHolder=new RequisitionDetailsViewHolder(view);
        requisitionDetailsViewHolder.txtRequisitionCode=(TextView)view.findViewById(R.id.txtRequisitionCode);
        requisitionDetailsViewHolder.txtPartyName=(TextView)view.findViewById(R.id.txtPartyName);
        requisitionDetailsViewHolder.txtRequsitionDate=(TextView)view.findViewById(R.id.txtRequistionDate);
        requisitionDetailsViewHolder.txtFinanceApproveStatus=(TextView)view.findViewById(R.id.txtFinanceApprove);
        requisitionDetailsViewHolder.txtTotalAmount=(TextView)view.findViewById(R.id.txtTotalAmount);
        requisitionDetailsViewHolder.imgSalesApprovestatus=(ImageView) view.findViewById(R.id.imgSalesApprovestatus);
        requisitionDetailsViewHolder.btnRequistionDelete=(ImageView) view.findViewById(R.id.btnRequistionDelete);
        requisitionDetailsViewHolder.btnedit=(ImageView) view.findViewById(R.id.btnEdit);
        return requisitionDetailsViewHolder;
    }

    @Override
    public void onBindViewHolder(RequisitionDetailsViewHolder holder, final int position) {


        holder.txtRequisitionCode.setText(requisitionArrayList.get(position).getRequisitionCode());
        holder.txtPartyName.setText(requisitionArrayList.get(position).getPartyName());
        holder.txtRequsitionDate.setText(requisitionArrayList.get(position).getRequisitionDate());
        holder.txtFinanceApproveStatus.setText("Finance: "+requisitionArrayList.get(position).getFinanceStatus());
        if(requisitionArrayList.get(position).getFinanceStatus().equals("Approved")){
            holder.txtFinanceApproveStatus.setTextColor(Color.parseColor("#66BB6A"));
        }else{
            holder.txtFinanceApproveStatus.setTextColor(Color.parseColor("#f44336"));
        }
        holder.txtTotalAmount.setText(requisitionArrayList.get(position).getAmount().toString()+" TK");
        String salesApproveStatus=requisitionArrayList.get(position).getStatus();
        if (salesApproveStatus.equals("Approved")){
            holder.imgSalesApprovestatus.setImageResource(R.drawable.icon_approved_sample_2);
            holder.btnRequistionDelete.setVisibility(View.GONE);
            holder.btnedit.setVisibility(View.GONE);
        }else{
            holder.imgSalesApprovestatus.setImageResource(R.drawable.icon_not_approved_sample_2);
            holder.btnRequistionDelete.setVisibility(View.VISIBLE);
            holder.btnedit.setVisibility(View.VISIBLE);
        }
        holder.btnRequistionDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new AlertDialog.Builder(mContext)
                        .setIcon(R.drawable.icon_alert)
                        .setTitle("Confirmation")
                        .setMessage("Are you sure you want to Cancel this Requisition?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int requistionmasterId=requisitionArrayList.get(position).getRequisitionMasterId();
                                Retrofit retrofit= APIInitializer.initNetwork( mContext);
                                retrofit.create(IRequisition.class).DeleteReuisitionFromList(requistionmasterId,54).enqueue(new Callback<RequisitionDeleteModel>() {
                                    @Override
                                    public void onResponse(Call<RequisitionDeleteModel> call, Response<RequisitionDeleteModel> response) {
                                        requisitionArrayList.remove(position);
                                        Toast.makeText(mContext, "Requisition is deleted successfully.", Toast.LENGTH_SHORT).show();
                                        notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onFailure(Call<RequisitionDeleteModel> call, Throwable t) {

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
        return requisitionArrayList.size();
    }
}

class RequisitionDetailsViewHolder extends RecyclerView.ViewHolder{
    TextView txtRequisitionCode;
    TextView txtPartyName;
    TextView txtRequsitionDate;
    TextView txtFinanceApproveStatus;
    TextView txtTotalAmount;
    ImageView imgSalesApprovestatus;
    ImageView btnRequistionDelete;
    ImageView btnedit;

    public RequisitionDetailsViewHolder(View itemView) {
        super(itemView);
    }
}
package list_adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

import IRepository.IPayment;
import IRepository.IRequisition;
import UserDefinder.PaymentListModel;
import UserDefinder.PaymentREquestDeleteModel;
import UserDefinder.RequisitionDeleteModel;
import UserDefinder.RequisitionList;
import model.APIInitializer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by ASUS on 5/8/2017.
 */

public class PaymentListAdapter extends RecyclerView.Adapter<PaymentListViewHolder>{

    private Activity mContext;

    List<PaymentListModel> paymentArraylist;
    public PaymentListAdapter(Activity mContext,PaymentListModel[] paymentListModels) {
        this.mContext = mContext;
        paymentArraylist=new ArrayList<PaymentListModel>(Arrays.asList(paymentListModels));
    }

    @Override
    public PaymentListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.payment_list_design,parent,false);
        PaymentListViewHolder paymentListViewHolder=new PaymentListViewHolder(view);
        paymentListViewHolder.txtPaymentMethod=(TextView)view.findViewById(R.id.txtPaymentMethod);
        paymentListViewHolder.txtPartyName=(TextView)view.findViewById(R.id.txtPartyName);
        paymentListViewHolder.txtPaymentDate=(TextView)view.findViewById(R.id.txtDepositeDate);

        paymentListViewHolder.txtTotalAmount=(TextView)view.findViewById(R.id.txtTotalAmount);
        paymentListViewHolder.imgAccountsApprovestatus=(ImageView) view.findViewById(R.id.imgAccountsApprovestatus);
        paymentListViewHolder.btnPaymentDelete=(ImageView) view.findViewById(R.id.btnRequistionDelete);
        paymentListViewHolder.btnedit=(ImageView) view.findViewById(R.id.btnEdit);
        return paymentListViewHolder;
    }

    @Override
    public void onBindViewHolder(PaymentListViewHolder holder, final int position) {
        holder.txtPaymentMethod.setText(paymentArraylist.get(position).getPaymentMethodName());
        holder.txtPartyName.setText(paymentArraylist.get(position).getPartyName());
        holder.txtPaymentDate.setText(paymentArraylist.get(position).getDepositeDate());
        holder.txtTotalAmount.setText(paymentArraylist.get(position).getAmount().toString()+" TK");
/*        String salesApproveStatus=paymentArraylist.get(position).getStatus();
        if (salesApproveStatus.equals("Approved")){
            holder.imgSalesApprovestatus.setImageResource(R.drawable.icon_approved);
            holder.btnRequistionDelete.setVisibility(View.GONE);
            holder.btnedit.setVisibility(View.GONE);
        }else{
            holder.imgSalesApprovestatus.setImageResource(R.drawable.icon_not_approved);
            holder.btnRequistionDelete.setVisibility(View.VISIBLE);
            holder.btnedit.setVisibility(View.VISIBLE);
        }*/
    holder.btnPaymentDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new AlertDialog.Builder(mContext)
                        .setIcon(R.drawable.icon_alert)
                        .setTitle("Confirmation")
                        .setMessage("Are you sure you want to Cancel this Payment Request?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                final int paymentReqId=paymentArraylist.get(position).getPaymentReqId();
                                final Retrofit retrofit= APIInitializer.initNetwork( mContext);
                                retrofit.create(IPayment.class).PaymentRequestDelete(paymentReqId).enqueue(new Callback<PaymentREquestDeleteModel>() {

                                    @Override
                                    public void onResponse(Call<PaymentREquestDeleteModel> call, Response<PaymentREquestDeleteModel> response) {

                                        paymentArraylist.remove(position);
                                        Toast.makeText(mContext, "Payment request is deleted successfully. "+paymentReqId, Toast.LENGTH_SHORT).show();
                                        notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onFailure(Call<PaymentREquestDeleteModel> call, Throwable t) {

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
        return paymentArraylist.size();
    }
}
class PaymentListViewHolder extends RecyclerView.ViewHolder{
    TextView txtPaymentMethod;
    TextView txtPartyName;
    TextView txtPaymentDate;
    TextView txtTotalAmount;
    ImageView imgAccountsApprovestatus;
    ImageView btnPaymentDelete;
    ImageView btnedit;


    public PaymentListViewHolder(View itemView) {
        super(itemView);
    }
}
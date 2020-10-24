package list_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jmjproduction.adasupplychain.R;

import java.util.ArrayList;

import IRepository.AdapterListener;
import UserDefinder.ProductModelForTemplist;

/**
 * Created by Code Freak Tanveer on 19/02/2017.
 */

public class RequisitionListAdapter extends RecyclerView.Adapter<RequisitionViewHolder> {


    private Context mContext;
    private AdapterListener adapterListener;

    public void setAdapterListener(AdapterListener adapterListener) {
        this.adapterListener = adapterListener;
    }

    private ArrayList<ProductModelForTemplist> arrayListProductList;
    public RequisitionListAdapter(Context mContext, ArrayList<ProductModelForTemplist> data){
        this.mContext=mContext;
        this.arrayListProductList=data;
    }

    @Override
    public RequisitionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.requisition_list_style,parent,false);

        RequisitionViewHolder holder= new RequisitionViewHolder(view);
        holder.productNameTextView=(TextView) view.findViewById(R.id.productName);
        holder.productUnitPriceTextView=(TextView) view.findViewById(R.id.unitPrice);
        holder.productColorTextView=(TextView) view.findViewById(R.id.txtColor);
        holder.quantityTextView=(TextView) view.findViewById(R.id.txtQuantity);
        holder.productPriceTextView=(TextView) view.findViewById(R.id.txtTotalAmount);
        holder.btnDelete=(Button) view.findViewById(R.id.btnDeleteProduct);
        return holder;
    }

    @Override
    public void onBindViewHolder(RequisitionViewHolder holder, final int position) {
            holder.productNameTextView.setText(arrayListProductList.get(position).getProductName());
        holder.productUnitPriceTextView.setText(arrayListProductList.get(position).getPrice().toString());
        holder.quantityTextView.setText(arrayListProductList.get(position).getQuantity().toString());
        holder.productColorTextView.setText(arrayListProductList.get(position).getColorName().toString());
        holder.productPriceTextView.setText(arrayListProductList.get(position).getLine_total().toString());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayListProductList.remove(position);
                notifyDataSetChanged();
                adapterListener.applyValueChanged(arrayListProductList);
                Toast.makeText(mContext, "Deleted Successfully!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayListProductList.size();
    }
    public ArrayList<ProductModelForTemplist> getProductList() {
        return arrayListProductList;
    }

}

class RequisitionViewHolder extends RecyclerView.ViewHolder{
    TextView quantityTextView;
    TextView productNameTextView;
    TextView productColorTextView;
    TextView productPriceTextView;
    TextView productUnitPriceTextView;
    Button btnDelete;

    public RequisitionViewHolder(View itemView) {
        super(itemView);
    }


}

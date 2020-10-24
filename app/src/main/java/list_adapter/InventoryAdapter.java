package list_adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jmjproduction.adasupplychain.InventoryDetailsActivity;
import com.jmjproduction.adasupplychain.R;

import java.util.ArrayList;

import UserDefinder.InventoryListModel;
import model.Inventory;

/**
 * Created by Code Freak Tanveer on 06/03/2017.
 */

public class InventoryAdapter extends RecyclerView.Adapter<InventotyViewHolder> {
    private Context mContext;
    private String activityName;
    private ArrayList<InventoryListModel> inventories;

    public InventoryAdapter(Context mContext,String activityName,ArrayList<InventoryListModel> inventories) {
        this.mContext = mContext;
        this.activityName=activityName;
        this.inventories=inventories;
    }

    @Override
    public InventotyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.inventory_list_style,parent,false);
        InventotyViewHolder holder=new InventotyViewHolder(view);
        holder.inventoryTitleView= (TextView) view.findViewById(R.id.inventoryTitleView);
        holder.inventoryQuantityView= (TextView) view.findViewById(R.id.inventoryQuantityView);
        holder.txtItemRef=(TextView) view.findViewById(R.id.txtItemRef);
        holder.rootView=view.findViewById(R.id.inventorylistRoot);
        return holder;
    }

    @Override
    public void onBindViewHolder(InventotyViewHolder holder, final int position) {
        final InventoryListModel inventory=inventories.get(position);
        String productNameTitle="";
        productNameTitle=inventory.getProductName();
        char firstTitle=productNameTitle.charAt(0);
        Log.e("First Char",firstTitle+"");

        if (activityName.equals("inventory")){
            holder.inventoryTitleView.setText(productNameTitle);
            holder.inventoryQuantityView.setText(inventory.getLineTotalQty().toString()+" "+inventory.getUnitName());
          holder.txtItemRef.setText(productNameTitle.charAt(0)+"");
        }else{
            holder.inventoryTitleView.setText(inventory.getColorName());
            holder.inventoryQuantityView.setText(inventory.getStockQuantity().toString()+" "+inventory.getUnitName());
            holder.txtItemRef.setText(productNameTitle.charAt(0)+"");

        }


        holder.rootView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(activityName.equals("inventory")){
                    Intent detailsIntent=new Intent(mContext, InventoryDetailsActivity.class);
                   detailsIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    detailsIntent.putExtra("product_name",inventory.getProductName());
                    mContext.startActivity(detailsIntent);
                }
            }


        });

    }

    @Override
    public int getItemCount() {
        return inventories.size();
    }
}

class InventotyViewHolder extends RecyclerView.ViewHolder{
    View rootView;
    TextView inventoryTitleView;
    TextView inventoryQuantityView;
    TextView txtItemRef;

    public InventotyViewHolder(View itemView) {
        super(itemView);
    }
}
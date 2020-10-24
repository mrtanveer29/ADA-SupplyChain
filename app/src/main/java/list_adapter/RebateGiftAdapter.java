package list_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jmjproduction.adasupplychain.R;

import org.w3c.dom.Text;

import java.util.List;

import UserDefinder.Gift;
import UserDefinder.Rebate;
import UserDefinder.RebateAndGiftModel;

/**
 * Created by Code Freak Tanveer on 20/02/2017.
 */

public class RebateGiftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private boolean hasRebate=false;
    private boolean hasGift=false;
    private Context mContext;
    List<RebateAndGiftModel.RebateList> rebates;
    List<RebateAndGiftModel.GiftList> gifts;
    int temp_counter=0;

    public RebateGiftAdapter(Context mContext, List<RebateAndGiftModel.RebateList> rebates, List<RebateAndGiftModel.GiftList> gifts) {
        this.mContext = mContext;
        this.gifts=gifts;
        this.rebates=rebates;
        if(rebates.size()!=0){
            hasRebate=true;
        }
        if(gifts.size()!=0){
            hasGift=true;
        }
    }

    @Override
    public int getItemViewType(int position) {
        int viewType=0;
        if(hasRebate ){
            if(position<rebates.size()+1){
                viewType=2;
            }
            if(position==0 || position==rebates.size()+1){
                viewType=1;
            }


            if(hasGift && position>rebates.size()+1){
                viewType =3;
            }
            return viewType;
        }

        if(hasGift){
            if(position>0){
                viewType=3;
            }
            if(position==0){
                viewType=1;
            }


        }
        return viewType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case 1:
                View titleView= LayoutInflater.from(mContext).inflate(R.layout.layout_gift_rebate_title,parent,false);
                TitleViewHolder titleViewHolder= new TitleViewHolder(titleView);
                return  titleViewHolder;
            case 2:
                View rebateView= LayoutInflater.from(mContext).inflate(R.layout.layout_rebate_list,parent,false);
                RebateViewHolder rebateViewHolder= new RebateViewHolder(rebateView);
                return rebateViewHolder;
            case 3:
                View giftView= LayoutInflater.from(mContext).inflate(R.layout.layout_gift_list,parent,false);
                GiftViewHolder holder= new GiftViewHolder(giftView);
                return holder;

        }
       return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)){
            case 1:
                String title = "";
                int size=0;
                TitleViewHolder titleViewHolder= (TitleViewHolder) holder;
                if(position==0 && hasRebate){
                    title="Rebate";
                    size=rebates.size();
                }
                if(position==0 && hasGift){
                    title="Gift";
                    size=gifts.size();
                }
                if(hasGift && hasRebate){
                    if(position==0){
                        title="Rebate";
                        size=rebates.size();
                    }else {
                        title="Gift";
                        size=gifts.size();
                    }

                }
                titleViewHolder.titleText.setText(title);
                titleViewHolder.giftRebatequantity.setText(size+"");
                break;
            case 2:
                RebateAndGiftModel.RebateList rebate=rebates.get(position-1);
                RebateViewHolder rebateViewHolder= (RebateViewHolder) holder;
                rebateViewHolder.rebateForNameText.setText(rebate.getRebateFor()+" ("+rebate.getRebate()+")");
                rebateViewHolder.rebateType.setText(rebate.getRebateType());
                rebateViewHolder.rebateForQuantityText.setText(rebate.getQuantity()+" PC");
                rebateViewHolder.rebateAmount.setText("Rebate Amount "+rebate.getRebateAmount());
                break;
            case 3:
                Log.e("Gift collution",position+" "+temp_counter);
                RebateAndGiftModel.GiftList gift=gifts.get(temp_counter);
                GiftViewHolder viewHolder= (GiftViewHolder) holder;
                viewHolder.giftForNameText.setText(gift.getGiftFor());
                viewHolder.giftProduct.setText(gift.getProductName());
                viewHolder.giftForQuantityText.setText(gift.getQuantity()+" PC");
                viewHolder.giftPrice.setText("Gift Price "+gift.getPrice());
                temp_counter++;
                break;
        }
    }



    @Override
    public int getItemCount() {

        if(hasRebate && hasGift){
            return rebates.size()+gifts.size()+2;
        }
        if(hasRebate){
            return rebates.size()+1;
        }
        if(hasGift){
            return gifts.size()+1;
        }
        return 0;
    }
}
class TitleViewHolder extends RecyclerView.ViewHolder{
    TextView titleText;
    TextView giftRebatequantity;
    public TitleViewHolder(View itemView) {
        super(itemView);
        titleText= (TextView) itemView.findViewById(R.id.titleText);
        giftRebatequantity= (TextView) itemView.findViewById(R.id.giftRebatequantity);
    }
}
class GiftViewHolder extends RecyclerView.ViewHolder{
    TextView giftForNameText;
    TextView giftProduct;
    TextView giftPrice;
    TextView giftForQuantityText;
    public GiftViewHolder(View itemView) {
        super(itemView);
        giftForNameText= (TextView) itemView.findViewById(R.id.giftForNameText);
        giftPrice= (TextView) itemView.findViewById(R.id.giftPrice);
        giftForQuantityText= (TextView) itemView.findViewById(R.id.giftForQuantityText);
        giftProduct= (TextView) itemView.findViewById(R.id.giftProduct);

    }
}
class RebateViewHolder extends RecyclerView.ViewHolder{
    TextView rebateForNameText;
    TextView rebateType;
    TextView rebateAmount;
    TextView rebateForQuantityText;
    public RebateViewHolder(View itemView) {
        super(itemView);
        rebateForNameText= (TextView) itemView.findViewById(R.id.rebateForNameText);
        rebateType= (TextView) itemView.findViewById(R.id.rebateType);
        rebateAmount= (TextView) itemView.findViewById(R.id.rebateAmount);
        rebateForQuantityText= (TextView) itemView.findViewById(R.id.rebateForQuantityText);
    }
}
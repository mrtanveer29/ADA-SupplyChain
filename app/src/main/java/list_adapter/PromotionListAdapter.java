package list_adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.jmjproduction.adasupplychain.R;

import model.Promotion;

/**
 * Created by Code Freak Tanveer on 17/02/2017.
 */

public class PromotionListAdapter extends RecyclerView.Adapter<PromotionViewHolder> {
    private Context mContext;
    private  Promotion[] promotions;
    public PromotionListAdapter(Context mContext, Promotion[] promotions){
        this.mContext=mContext;
        this.promotions=promotions;
    }
    @Override
    public PromotionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.promotion_list_style,parent,false);
        PromotionViewHolder promotionViewHolder=new PromotionViewHolder(view);
        return promotionViewHolder;
    }

    @Override
    public void onBindViewHolder(PromotionViewHolder holder, int position) {
        Promotion promotion=promotions[position];
            holder.promotionHeadingText.setText(promotion.getTitel());
        holder.promotionDetailsText.setText(promotion.getPromotionDescription());
        YoYo.with(Techniques.FlipInX)
                .duration(700).playOn(holder.promotionListContainer);

    }

    @Override
    public int getItemCount() {
        return promotions.length;
    }
}

class PromotionViewHolder extends RecyclerView.ViewHolder {
    TextView promotionHeadingText;
    TextView promotionStartDate;
    TextView promotionEndDate;
    TextView promotionDetailsText;
    View promotionListContainer;

    public PromotionViewHolder(View itemView) {
        super(itemView);
        promotionHeadingText= (TextView) itemView.findViewById(R.id.promotionHeadingText);
        promotionDetailsText= (TextView) itemView.findViewById(R.id.promotionDetailsText);
        promotionListContainer= (View) itemView.findViewById(R.id.promotionListContainer);
    }
}

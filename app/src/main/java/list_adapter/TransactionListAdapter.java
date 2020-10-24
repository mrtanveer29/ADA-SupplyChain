package list_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jmjproduction.adasupplychain.R;

import model.Transaction;

/**
 * Created by Code Freak Tanveer on 10/03/2017.
 */

public class TransactionListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    String current_date;
    private Context mContext;
    private Transaction[] transactions;

    public TransactionListAdapter(Context mContext,Transaction[] transactions) {
        this.mContext = mContext;
        this.transactions=transactions;

        Log.e("size",transactions.length+"");
    }

    @Override
    public int getItemViewType(int position) {
        String datetime=transactions[position].getTransactionDate();
        String [] tmp=datetime.split(" ");
//        if(position==0){
//            current_date=tmp[0];
//        }
        if(tmp[0].equals(current_date)){
            return 0;
        }
        current_date=tmp[0];

        return 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case 0:
                View transactionView=LayoutInflater.from(mContext).inflate(R.layout.account_list_style,parent,false);
                TransactionViewHolder transactionViewHolder=new TransactionViewHolder(transactionView);
                transactionViewHolder.docCode= (TextView) transactionView.findViewById(R.id.docCode);
                transactionViewHolder.transactionType= (TextView) transactionView.findViewById(R.id.transactionType);
                transactionViewHolder.transactionAmount= (TextView) transactionView.findViewById(R.id.transactionAmount);
                transactionViewHolder.paymentStatus= (TextView) transactionView.findViewById(R.id.paymentStatus);
                transactionViewHolder.payment_method_name= (TextView) transactionView.findViewById(R.id.payment_method_name);

                return transactionViewHolder;
            case 1:
                View view=LayoutInflater.from(mContext).inflate(R.layout.date_layout,parent,false);
                DateViewHolde dateViewHolde=new DateViewHolde(view);
                dateViewHolde.dateView= (TextView) view.findViewById(R.id.dateView);
                dateViewHolde.docCode= (TextView) view.findViewById(R.id.docCode);
                dateViewHolde.paymentStatus= (TextView) view.findViewById(R.id.paymentStatus);
                dateViewHolde.transactionType= (TextView) view.findViewById(R.id.transactionType);
                dateViewHolde.transactionAmount= (TextView) view.findViewById(R.id.transactionAmount);
                dateViewHolde.payment_method_name= (TextView) view.findViewById(R.id.payment_method_name);

                return  dateViewHolde;
        }
        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Transaction moneyTransaction=transactions[position];

            switch (holder.getItemViewType()){
            case 0:
                TransactionViewHolder transactionViewHolder= (TransactionViewHolder) holder;

                if(moneyTransaction.getCrAmount()==0.00){
                    transactionViewHolder.transactionType.setText("Debit");
                    transactionViewHolder.transactionAmount.setText(moneyTransaction.getDrAmount()+" Tk");
                }else{
                    transactionViewHolder.transactionType.setText("Credit");
                    transactionViewHolder.transactionAmount.setText(moneyTransaction.getCrAmount()+" Tk");
                }
                transactionViewHolder.docCode.setText(moneyTransaction.getDocumentCode());
                transactionViewHolder.paymentStatus.setText(moneyTransaction.getRemarks());
                transactionViewHolder.payment_method_name.setText(moneyTransaction.getPaymentMethodName());
                break;
            case 1:
                DateViewHolde dateViewHolde= (DateViewHolde) holder;
                String datetime=moneyTransaction.getTransactionDate();

                if(moneyTransaction.getCrAmount()==0.00){
                    dateViewHolde.transactionType.setText("Debit");
                    dateViewHolde.transactionAmount.setText(moneyTransaction.getDrAmount()+" Tk");
                }else{
                    dateViewHolde.transactionType.setText("Credit");
                    dateViewHolde.transactionAmount.setText(moneyTransaction.getCrAmount()+" Tk");
                }
                dateViewHolde.docCode.setText(moneyTransaction.getDocumentCode());
                dateViewHolde.paymentStatus.setText(moneyTransaction.getRemarks());
                dateViewHolde.payment_method_name.setText(moneyTransaction.getPaymentMethodName());
                String [] tmp=datetime.split(" ");
                dateViewHolde.dateView.setText(tmp[0]);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return transactions.length;
    }

    class TransactionViewHolder extends RecyclerView.ViewHolder{
        TextView transactionAmount;
        TextView transactionType;
        TextView docCode;
        TextView paymentStatus;
        TextView payment_method_name;

        public TransactionViewHolder(View itemView) {
            super(itemView);
        }
    }
    class DateViewHolde extends RecyclerView.ViewHolder{
        TextView dateView;
        TextView transactionAmount;
        TextView transactionType;
        TextView docCode;
        TextView paymentStatus;
        TextView payment_method_name;
        public DateViewHolde(View itemView) {
            super(itemView);
        }
    }
}

package UserDefinder;

import java.util.ArrayList;

/**
 * Created by jmjsa on 05/03/2017.
 */

public class GetRebateAndGiftInfoModel {
    ArrayList<ProductModelForTemplist> RequisitionDetailsList;
    boolean IsActivePromo;

    public ArrayList<ProductModelForTemplist> getRequisitionDetailsList() {
        return RequisitionDetailsList;
    }

    public void setRequisitionDetailsList(ArrayList<ProductModelForTemplist> requisitionDetailsList) {
        RequisitionDetailsList = requisitionDetailsList;
    }

    public boolean isActivePromo() {
        return IsActivePromo;
    }

    public void setActivePromo(boolean activePromo) {
        IsActivePromo = activePromo;
    }
}

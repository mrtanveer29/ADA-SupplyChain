package UserDefinder;

/**
 * Created by ASUS on 5/9/2017.
 */
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class PaymentREquestDeleteModel {

    @SerializedName("output")
    @Expose
    private String output;
    @SerializedName("msg")
    @Expose
    private String msg;

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
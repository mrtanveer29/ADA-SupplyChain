package UserDefinder;

/**
 * Created by jmjsa on 19/03/2017.
 */
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class RequisitionDeleteModel {

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
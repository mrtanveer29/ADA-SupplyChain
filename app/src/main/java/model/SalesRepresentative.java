package model;

/**
 * Created by jmjsa on 12/03/2017.
 */

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class SalesRepresentative {

    @SerializedName("employee_name")
    @Expose
    private String employeeName;
    @SerializedName("employee_id")
    @Expose
    private Integer employeeId;
    @SerializedName("party_id")
    @Expose
    private Integer partyId;
    @SerializedName("party_name")
    @Expose
    private String partyName;
    @SerializedName("party_type_id")
    @Expose
    private Integer partyTypeId;
    @SerializedName("party_type_name")
    @Expose
    private String partyTypeName;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getPartyId() {
        return partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public Integer getPartyTypeId() {
        return partyTypeId;
    }

    public void setPartyTypeId(Integer partyTypeId) {
        this.partyTypeId = partyTypeId;
    }

    public String getPartyTypeName() {
        return partyTypeName;
    }

    public void setPartyTypeName(String partyTypeName) {
        this.partyTypeName = partyTypeName;
    }

    @Override
    public String toString() {
        return getEmployeeName().toString();
    }
}
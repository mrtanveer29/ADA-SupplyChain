package UserDefinder;

/**
 * Created by jmjsa on 22/03/2017.
 */

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class LoginModel {

    @SerializedName("output")
    @Expose
    private String output;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("returnvalue")
    @Expose
    private Returnvalue returnvalue;

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

    public Returnvalue getReturnvalue() {
        return returnvalue;
    }

    public void setReturnvalue(Returnvalue returnvalue) {
        this.returnvalue = returnvalue;
    }
    public class Returnvalue {

        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("full_name")
        @Expose
        private String fullName;
        @SerializedName("login_name")
        @Expose
        private String loginName;
        @SerializedName("password")
        @Expose
        private String password;
        @SerializedName("role_id")
        @Expose
        private Integer roleId;
        @SerializedName("company_id")
        @Expose
        private Integer companyId;
        @SerializedName("user_role_name")
        @Expose
        private String userRoleName;
        @SerializedName("party_id")
        @Expose
        private Integer partyId;
        @SerializedName("party_type_id")
        @Expose
        private Integer partyTypeId;

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Integer getRoleId() {
            return roleId;
        }

        public void setRoleId(Integer roleId) {
            this.roleId = roleId;
        }

        public Integer getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Integer companyId) {
            this.companyId = companyId;
        }

        public String getUserRoleName() {
            return userRoleName;
        }

        public void setUserRoleName(String userRoleName) {
            this.userRoleName = userRoleName;
        }

        public Integer getPartyId() {
            return partyId;
        }

        public void setPartyId(Integer partyId) {
            this.partyId = partyId;
        }

        public Integer getPartyTypeId() {
            return partyTypeId;
        }

        public void setPartyTypeId(Integer partyTypeId) {
            this.partyTypeId = partyTypeId;
        }

    }
}





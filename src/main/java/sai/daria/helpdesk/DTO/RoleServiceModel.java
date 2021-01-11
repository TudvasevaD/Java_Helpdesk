package sai.daria.helpdesk.DTO;

public class RoleServiceModel {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String authority;

    public RoleServiceModel(String authority) {
        this.authority = authority;
    }

    public RoleServiceModel() { }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }



}

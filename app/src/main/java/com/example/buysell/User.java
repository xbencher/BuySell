package com.example.buysell;

public  class User {

    private String  pname,pdate,pdesc,pmrp,psell;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public String getPmrp() {
        return pmrp;
    }

    public void setPmrp(String pmrp) {
        this.pmrp = pmrp;
    }

    public String getPsell() {
        return psell;
    }

    public void setPsell(String psell) {
        this.psell = psell;
    }

    public User() {
    }

    public User(String pname, String pdate, String pdesc, String pmrp, String psell) {
        this.pname = pname;
        this.pdate = pdate;
        this.pdesc = pdesc;
        this.pmrp = pmrp;
        this.psell = psell;
    }
}

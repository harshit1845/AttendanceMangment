package com.example.abc;

public class ST {
    String sname;
    String sid;
    String classes;
    String spass;

    public ST(String sname,String sid,String classes,String spass) {
        this.sname = sname;
        this.sid = sid;
        this.classes=classes;
        this.spass=spass;
    }

    public String getSname() {return sname;}
    public String getSid() {return sid;}
    public String getClasses() {return classes;}
    public String getSpass() {return spass;}


}

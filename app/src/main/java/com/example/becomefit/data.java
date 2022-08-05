package com.example.becomefit;

public class data {
    public String name;
    public String imageurl;
    public String type;
    public String des;
    public data(){

    }
    public data(String name,String imageurl, String type, String des){
        this.name=name;
        this.imageurl=imageurl;
        this.type=type;
        this.des=des;

    }

    public String getName() {

        return name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getType() {
        return type;
    }

    public String getDes() {
        return des;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDes(String des) {
        this.des = des;
    }
}

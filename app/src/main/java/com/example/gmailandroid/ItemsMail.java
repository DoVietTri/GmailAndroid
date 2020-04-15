package com.example.gmailandroid;

import java.util.Date;

public class ItemsMail {
    private String name;
    private String desc;
    private boolean isSelected;

    public ItemsMail(String name, String desc) {

        this.name = name;
        this.desc = desc;
        this.isSelected = false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

}

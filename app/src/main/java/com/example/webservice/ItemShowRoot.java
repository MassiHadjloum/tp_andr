package com.example.webservice;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemShowRoot {

    @SerializedName("data")
    private List<ItemShow> itemShowList;

    public ItemShowRoot(List<ItemShow> itemShowList) {
        this.itemShowList = itemShowList;
    }

    public List<ItemShow> getItemShowList() {
        return itemShowList;
    }

    public void setItemShowList(List<ItemShow> itemShowList) {
        this.itemShowList = itemShowList;
    }
}

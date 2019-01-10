package com.example.jol.myapplication;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ItemDataList {
    private ArrayList<ItemData> data;

    public ArrayList<ItemData> getItemList() {
        return data;
    }
    public void setItemList(ArrayList<ItemData> itemList) {
        this.data = itemList;
    }
}

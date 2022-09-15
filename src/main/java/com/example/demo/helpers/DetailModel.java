package com.example.demo.helpers;

import com.example.demo.models.ItemModel;
import lombok.Data;

@Data
public class DetailModel {
    private ItemModel itemModel;
    private String usdPrise;
    private String eurPrice;

}

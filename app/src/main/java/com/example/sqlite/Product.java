package com.example.sqlite;

import android.provider.BaseColumns;

public class Product {

    private Product(){

    }
    public static final class ProductEntry implements BaseColumns {
        public static final String TABLE_NAME = "Price14022021";
        public static final String COLUMN_NAME = "Product_Name";
        public static final String COLUMN_AMOUNT = "SV_Price";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }
}

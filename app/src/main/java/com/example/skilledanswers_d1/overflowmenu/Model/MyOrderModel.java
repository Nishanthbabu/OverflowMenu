package com.example.skilledanswers_d1.overflowmenu.Model;

/**
 * Created by SkilledAnswers-D1 on 09-05-2016.
 */
public class MyOrderModel {
    private String _orderDate=null;
    private String _orderId=null;
    private int _productImage=0;
    private String _productName=null;
    private boolean _delevered=false;
    private boolean _ontheway=false;
    private boolean _cancled=false;
    private String _productDeleveryDesc=null;

    public String get_orderDate() {
        return _orderDate;
    }

    public void set_orderDate(String _orderDate) {
        this._orderDate = _orderDate;
    }

    public String get_orderId() {
        return _orderId;
    }

    public void set_orderId(String _orderId) {
        this._orderId = _orderId;
    }

    public int get_productImage() {
        return _productImage;
    }

    public void set_productImage(int _productImage) {
        this._productImage = _productImage;
    }

    public String get_productName() {
        return _productName;
    }

    public void set_productName(String _productName) {
        this._productName = _productName;
    }

    public boolean is_delevered() {
        return _delevered;
    }

    public void set_delevered(boolean _delevered) {
        this._delevered = _delevered;
    }

    public boolean is_ontheway() {
        return _ontheway;
    }

    public void set_ontheway(boolean _ontheway) {
        this._ontheway = _ontheway;
    }

    public boolean is_cancled() {
        return _cancled;
    }

    public void set_cancled(boolean _cancled) {
        this._cancled = _cancled;
    }

    public String get_productDeleveryDesc() {
        return _productDeleveryDesc;
    }

    public void set_productDeleveryDesc(String _productDeleveryDesc) {
        this._productDeleveryDesc = _productDeleveryDesc;
    }
}

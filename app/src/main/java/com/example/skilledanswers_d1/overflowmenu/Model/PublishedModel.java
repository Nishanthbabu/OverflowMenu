package com.example.skilledanswers_d1.overflowmenu.Model;

/**
 * Created by SkilledAnswers-D1 on 11-05-2016.
 */
public class PublishedModel {

    private int _image=0;
    private String _productName=null;
    private int _ratting=0;
    private String _review=null;

    public int get_image() {
        return _image;
    }

    public void set_image(int _image) {
        this._image = _image;
    }

    public String get_productName() {
        return _productName;
    }

    public void set_productName(String _productName) {
        this._productName = _productName;
    }

    public int get_ratting() {
        return _ratting;
    }

    public void set_ratting(int _ratting) {
        this._ratting = _ratting;
    }

    public String get_review() {
        return _review;
    }

    public void set_review(String _review) {
        this._review = _review;
    }
}

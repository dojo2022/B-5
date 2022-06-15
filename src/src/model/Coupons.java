package model;

import java.io.Serializable;

public class Coupons implements Serializable {
	private int id;	 //ID
	private String coupon_name;	 //クーポン名
	private String coupon_image; //クーポン画像
	private int coupon_point; //消費ポイント
	private String coupon_id; //クーポンID

	public Coupons(int id, String coupon_name, String coupon_image, int coupon_point, String coupon_id) {
		super();
		this.id = id;
		this.coupon_name = coupon_name;
		this.coupon_image = coupon_image;
		this.coupon_point = coupon_point;
		this.coupon_id = coupon_id;
	}

	public Coupons() {
		super();
		this.id = 0;
		this.coupon_name = "";
		this.coupon_image = "";
		this.coupon_point = 0;
		this.coupon_id = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoupon_name() {
		return coupon_name;
	}

	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}

	public String getCoupon_image() {
		return coupon_image;
	}

	public void setCoupon_image(String coupon_image) {
		this.coupon_image = coupon_image;
	}

	public int getCoupon_point() {
		return coupon_point;
	}

	public void setCoupon_point(int coupon_point) {
		this.coupon_point = coupon_point;
	}

	public String getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}


}

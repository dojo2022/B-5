package model;

import java.io.Serializable;

public class CouponItems implements Serializable {
	public int id;
	public String user_id;
	public String coupon_id;
	public String coupon_num;
	public String coupon_name;
	public String coupon_image;
	public String mail;

	//引数があるコンストラクタ
	public CouponItems(int id, String user_id, String coupon_id, String coupon_num) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.coupon_id = coupon_id;
		this.coupon_num = coupon_num;
	}


	public CouponItems(String coupon_name, String coupon_image, String coupon_num) {
		super();
		this.coupon_name = coupon_name;
		this.coupon_image = coupon_image;
		this.coupon_num = coupon_num;
	}
//登録用コンストラクタ 0624清水追加
	public CouponItems(String user_id, String coupon_id) {
		super();
		this.user_id = user_id;
		this.coupon_id = coupon_id;
	}


	//引数がないコンストラクタ
	public CouponItems() {
		super();
		this.id = 0;
		this.user_id = "";
		this.coupon_id = "";
		this.coupon_num = "";
	}

	public CouponItems(String mail) {
		super();
		this.mail = mail;

	}

	//ゲッターセッター
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}
	public String getCoupon_num() {
		return coupon_num;
	}
	public void setCoupon_num(String coupon_num) {
		this.coupon_num = coupon_num;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


}

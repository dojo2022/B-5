package model;

import java.io.Serializable;

public class CouponItems implements Serializable {
	public int id;
	public String user_id;
	public String coupon_id;
	public int coupon_num;

	//引数があるコンストラクタ
	public CouponItems(int id, String user_id, String coupon_id, int coupon_num) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.coupon_id = coupon_id;
		this.coupon_num = coupon_num;
	}
	//引数がないコンストラクタ
	public CouponItems() {
		super();
		this.id = 0;
		this.user_id = "";
		this.coupon_id = "";
		this.coupon_num = 0;
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
	public int getCoupon_num() {
		return coupon_num;
	}
	public void setCoupon_num(int coupon_num) {
		this.coupon_num = coupon_num;
	}


}

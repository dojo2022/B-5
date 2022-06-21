package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Stamps;



public class StampsDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Stamps> select(Stamps param) {
		Connection conn = null;
		List<Stamps> cardList = new ArrayList<Stamps>();

		try
		{
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する<<ここに改造 WHEREの後は、なにで検索したいかどうか>>
			String sql = "SELECT * FROM Stamps ORDER BY id";

			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Stamps card = new Stamps(
						rs.getInt("id"),
						rs.getString("user_id"),
						rs.getString("stamp_id"),
						rs.getString("stamp_image")
						);
				cardList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}



//カレンダーにアイコンだけ表示させたい！
	public List<Stamps> icon(Stamps param) {
		Connection conn = null;
		List<Stamps> StampList = new ArrayList<Stamps>();

		try
		{
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// 実行するSQL文
			String sql = "SELECT id,stamp_id,user_id,stamp_image FROM Stamps LEFT JOIN users ON users.user_id = Stamps.user_id"
					+ "LEFT JOIN Schedules ON Schedules.stamp_id = stamps.stamps_id where mail like ?";

			//一覧を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、変数rsに結果を格納
			ResultSet rs = pStmt.executeQuery();

			// 実行結果を順番に取り出す
			while (rs.next()) {
				Stamps icon = new Stamps(
						rs.getInt("id"),
						rs.getString("user_id"),
						rs.getString("stamp_id"),
						rs.getString("stamp_image")
						);
				//取得した要素を、iconに追加
				StampList.add(icon);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			StampList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			StampList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					StampList = null;
				}
			}
		}

		// 結果を返す
		return StampList;

	}
}


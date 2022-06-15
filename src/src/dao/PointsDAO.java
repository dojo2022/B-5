package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Points;

public class PointsDAO {

	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Points> select(Points param) {
			Connection conn = null;
			List<Points> cardList = new ArrayList<Points>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "select * from Points ORDER BY ID";

				PreparedStatement pStmt = conn.prepareStatement(sql);

//				// SQL文を完成させる
//				if (param.getPoint_value() != null) {
//					pStmt.setInt(1, "%" + param.getPoint_value() + "%");
//				}
//				else {
//					pStmt.setInt(1, "%");
//				}
//				if (param.getUser_id() != null) {
//					pStmt.setString(2, "%" + param.getUser_id() + "%");
//				}
//				else {
//					pStmt.setString(2, "%");
//				}
//				if (param.getId() != null) {
//					pStmt.setInt(3, "%" + param.getId() + "%");
//				}
//				else {
//					pStmt.setInt(3, "%");
//				}

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Points card = new Points(
					rs.getInt("id"),
					rs.getString("user_id"),
					rs.getInt("point_value")
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

		// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Points card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "INSERT INTO Points (id,user_id,point_value)"
						+" values (?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getId() != 0 ) {
					pStmt.setInt(1, card.getId());
				}
				else {
					pStmt.setInt(1, 0);
				}
				if (card.getUser_id() != null && !card.getUser_id().equals("")) {
					pStmt.setString(2, card.getUser_id());
				}
				else {
					pStmt.setString(2, null);
				}
				if (card.getPoint_value() != 0) {
					pStmt.setInt(3, card.getPoint_value());
				}
				else {
					pStmt.setInt(3, 0);
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}


		// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(Points card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "update Points set user_id =?, point_value=? where id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getUser_id() != null && !card.getUser_id().equals("")) {
					pStmt.setString(1, card.getUser_id());
				}
				else {
					pStmt.setString(1, null);
				}
				if (card.getPoint_value() != 0) {
					pStmt.setInt(2, card.getPoint_value());
				}
				else {
					pStmt.setInt(2, 0);
				}
				pStmt.setInt(3, card.getId());

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}


		// 引数idで指定されたレコードを削除し、成功したらtrueを返す
		public boolean delete(String id) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "delete from Points where ID=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, id);

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}

}

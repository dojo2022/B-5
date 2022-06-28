package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Visits;

public class VisitsDAO {


	public boolean insert(Visits card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "insert into visits (user_id) values ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (card.getUser_id() != null && !card.getUser_id().equals("")) {
				pStmt.setString(1, card.getUser_id());
			} else {
				pStmt.setString(1, "");
			}
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
//visitsテーブルに同じ日付があるか確認するため
	public boolean isVisitsOK(String todaysDateString) {
		Connection conn = null;
		boolean VisitsResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*) from visits where visit_date like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, todaysDateString+"%");

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// メアドが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				VisitsResult = true;
			}else {
				VisitsResult = false;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			VisitsResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			VisitsResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					VisitsResult = false;
				}
			}
		}

		// 結果を返す
		return VisitsResult;
	}
}

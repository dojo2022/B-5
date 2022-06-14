package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.BackgroundItems;

public class BackgroundItemsDAO {
	// ログインできるならtrueを返す
		public boolean isLoginOK(BackgroundItems card) {
			Connection conn = null;
			boolean Result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				//SQL文を準備する
				String sql = "insert into background_items (id, user_id, background_id) values(?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//SQL文を完成させる
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
				if (card.getBackground_id() != null && !card.getBackground_id().equals("")) {
					pStmt.setString(3, card.getBackground_id());
				}
				else {
					pStmt.setString(3, null);
				}
				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					Result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				Result = false;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				Result = false;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						Result = false;
					}
				}
			}

			// 結果を返す
			return Result;
		}
}

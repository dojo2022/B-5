package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BackgroundItems;

public class BackgroundItemsDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<BackgroundItems> select(BackgroundItems param) {
		Connection conn = null;
		List<BackgroundItems> cardList = new ArrayList<BackgroundItems>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//SQL文を準備する
			String sql = "select id, user_id, background_id"
					+ "from background_items WHERE id LIKE ? AND user_id LIKE ? AND background_id like ?  ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			if (param.getId() != 0) {
				pStmt.setInt(1, param.getId());
			}
			else {
				pStmt.setInt(1, 0);
			}
			if (param.getUser_id() != null) {
				pStmt.setString(2, "%" + param.getUser_id() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getBackground_id() != null) {
				pStmt.setString(3, "%" + param.getBackground_id() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				BackgroundItems card = new BackgroundItems(
				rs.getInt("id"),
				rs.getString("user_id"),
				rs.getString("background_id")

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
		public boolean insert(BackgroundItems card) {
			Connection conn = null;
			boolean Result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				//SQL文を準備する
				String sql = "insert into background_items (user_id, background_id) values(?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//SQL文を完成させる

				if (card.getUser_id() != null && !card.getUser_id().equals("")) {
					pStmt.setString(1, card.getUser_id());
				}
				else {
					pStmt.setString(1, null);
				}
				if (card.getBackground_id() != null && !card.getBackground_id().equals("")) {
					pStmt.setString(2, card.getBackground_id());
				}
				else {
					pStmt.setString(2, null);
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

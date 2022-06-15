package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Characters;
import model.Kakugens;

public class CharactersDAO {
		// 引数paramで検索項目を指定し、検索結果のリストを返す
		//常にすべてのデータを表示するのであいまい検索
		public List<Characters> select(Characters param) {
			Connection conn = null;
			List<Characters> cardList = new ArrayList<Characters>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する <<ここを改造する！！！>>表が持っているデータを書き並べる　～LIKE?
				String sql = "select id, user_id, character_name, character_status, character_image, character_point, character_id"
						+ "from Characters WHERE id LIKE ? AND kuser_id LIKE ? AND character_name LIKE ? AND character_status LIKE ? "
						+ "AND character_image LIKE ? AND character_point LIKE ? AND character_id LIKE ? ORDER BY id";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる <<ここも改造！！！>>
				//Int型の部分の表記　エラーの改善方法を相談 1/2/6がエラー
				if (param.getId() != 0) {
					pStmt.setInteger(1, "%" + param.getId() + 0);
				}
				else {
					pStmt.setInteger(1, "%");
				}
				if (param.getUser_id() != 0) {
					pStmt.setInteger(2, "%" + param.getUser_id() + "%");
				}
				else {
					pStmt.setInteger(2, "%");
				}
				if (param.getCharacter_name() != null) {
					pStmt.setString(3, "%" + param.getCharacter_name() + "%");
				}
				else {
					pStmt.setString(3, "%");
				}
				if (param.getCharacter_status() != null) {
					pStmt.setString(4, "%" + param.getCharacter_status() + "%");
				}
				else {
					pStmt.setString(4, "%");
				}
				if (param.getCharacter_image() != null) {
					pStmt.setString(5, "%" + param.getCharacter_image() + "%");
				}
				else {
					pStmt.setString(5, "%");
				}
				if (param.getCharacter_point() != 0) {
					pStmt.setInteger(6, "%" + param.getCharacter_point() + "%");
				}
				else {
					pStmt.setInteger(6, "%");
				}
				if (param.getCharacter_id() != null) {
					pStmt.setString(7, "%" + param.getCharacter_id() + "%");
				}
				else {
					pStmt.setString(7, "%");
				}

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする <<ここも改造！！！>>
				while (rs.next()) {
					Kakugens card = new Kakugens(
					rs.getInteger("id"),
					rs.getInteger("user_id"),
					rs.getString("character_name"),
					rs.getString("character_status"),
					rs.getString("character_image"),
					rs.getInteger("character_point"),
					rs.getString("character_id")
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
	}



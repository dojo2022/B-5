package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Characters;

public class CharactersDAO {
		// 引数paramで検索項目を指定し、検索結果のリストを返す
		//常にすべてのデータを表示するのであいまい検索
		public List<Characters> select(Characters param) {
			Connection conn = null;
			List<Characters> charactersList = new ArrayList<Characters>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する <<ここを改造する！！！>>表が持っているデータを書き並べる　～LIKE?
//				String sql = "select * from Characters ORDER BY id";
				String sql = "SELECT * FROM Characters LEFT JOIN Character_items ON  Characters.character_id= Character_items.character_id "
						+ "WHERE character_items.character_id IS NULL ORDER BY Characters.id";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする <<ここも改造！！！>>
				while (rs.next()) {
					Characters characters = new Characters(
					rs.getInt("id"),
					rs.getString("user_id"),
					rs.getString("character_name"),
					rs.getString("character_status"),
					rs.getString("character_image"),
					rs.getInt("character_point"),
					rs.getString("character_id")
					);
					charactersList.add(characters);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				charactersList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				charactersList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						charactersList = null;
					}
				}
			}

			// 結果を返す
			return charactersList;
		}
	}



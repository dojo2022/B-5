package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Backgrounds;

public class BackgroundsDAO {

	// 引数paramで検索項目を指定し、検索結果のリストを返す
	//常にすべてのデータを表示するのであいまい検索
	public List<Backgrounds> select() {
		Connection conn = null;
		List<Backgrounds> cardList = new ArrayList<Backgrounds>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する <<ここを改造する！！！>>表が持っているデータを書き並べる　～LIKE?
			// とりあえず名刺番号、名、会社名のみで検索
			String sql = "select * from Backgroungds ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする <<ここも改造！！！>>
			while (rs.next()) {
				Backgrounds card = new Backgrounds(
				rs.getInt("id"),
				rs.getString("bg_name"),
				rs.getString("bg_image"),
				rs.getInt("bg_point"),
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
}

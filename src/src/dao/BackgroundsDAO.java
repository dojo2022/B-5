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
	public List<Backgrounds> select(Backgrounds param) {
		Connection conn = null;
		List<Backgrounds> bgList = new ArrayList<Backgrounds>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する <<ここを改造する！！！>>表が持っているデータを書き並べる　～LIKE?
			// backgrounds_items似ないものを抽出
			//SELECT * FROM backgrounds
//			  LEFT JOIN background_items
//		         ON  backgrounds.background_id= background_items.background_id
//		 WHERE background_items.background_id IS NULL;
//			String sql = "select * from Backgrounds ORDER BY id";
			String sql = "SELECT * FROM backgrounds"
					+ "  LEFT JOIN background_items"
					+ "         ON  backgrounds.background_id= background_items.background_id"
					+ " WHERE background_items.background_id IS NULL ORDER BY backgrounds.id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする <<ここも改造！！！>>
			while (rs.next()) {
				Backgrounds bg = new Backgrounds(
				rs.getInt("id"),
				rs.getString("bg_name"),
				rs.getString("bg_image"),
				rs.getInt("bg_point"),
				rs.getString("background_id")
				);
				bgList.add(bg);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			bgList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			bgList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					bgList = null;
				}
			}
		}

		// 結果を返す
		return bgList;
	}
}

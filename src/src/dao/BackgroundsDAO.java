package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Backgrounds;
import model.Kakugens;

public class BackgroundsDAO {

	// 引数paramで検索項目を指定し、検索結果のリストを返す
	//常にすべてのデータを表示するのであいまい検索
	public List<Backgrounds> select(Backgrounds param) {
		Connection conn = null;
		List<Backgrounds> cardList = new ArrayList<Backgrounds>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する <<ここを改造する！！！>>表が持っているデータを書き並べる　～LIKE?
			// とりあえず名刺番号、名、会社名のみで検索
			String sql = "select id, bg_name, bg_image, bg_point, background_id"
					+ "from Backgrounds WHERE id LIKE ? AND bg_name LIKE ? AND bg_image LIKE ? AND bg_point LIKE ? "
					+ "AND background_id LIKE ? ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる <<ここも改造！！！>>
			if (param.getId() != 0) {
				pStmt.setInteger(1, "%" + param.getId() + 0);
			}
			else {
				pStmt.setInteger(1, "%");
			}
			if (param.getBg_name() != null) {
				pStmt.setString(2, "%" + param.getBg_name() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getBg_image() != null) {
				pStmt.setString(3, "%" + param.get() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			if (param.getGenre() != null) {
				pStmt.setString(4, "%" + param.getGenre() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}
			if (param.getKakugen_id() != null) {
				pStmt.setString(5, "%" + param.getKakugen_id() + "%");
			}
			else {
				pStmt.setString(5, "%");
			}
			if (param.getKakugen_point() != 0) {
				pStmt.setInteger(6, "%" + param.getKakugen_point() + "%");
			}
			else {
				pStmt.setInteger(6, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする <<ここも改造！！！>>
			while (rs.next()) {
				Kakugens card = new Kakugens(
				rs.getInteger("id"),
				rs.getString("kakugen"),
				rs.getString("genre_name"),
				rs.getString("genre"),
				rs.getString("kakugen_id"),
				rs.getInteger("kakugen_point")
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

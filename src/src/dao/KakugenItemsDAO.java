package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.KakugenItems;

public class KakugenItemsDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<KakugenItems> select(KakugenItems param) {
		Connection conn = null;
		List<KakugenItems> cardList = new ArrayList<KakugenItems>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//SQL文を準備する
			String sql = "select id, user_id, kakugen_id"
					+ "from character_items WHERE id LIKE ? AND user_id LIKE ? AND kakugen_id like ?  ORDER BY id";
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
			if (param.getKakugen_id() != null) {
				pStmt.setString(3, "%" + param.getKakugen_id() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				KakugenItems card = new KakugenItems(
						rs.getInt("id"),
						rs.getString("user_id"),
						rs.getString("kakugen_id")

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
	public boolean insert(KakugenItems card) {
		Connection conn = null;
		boolean Result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//SQL文を準備する 0624清水変更　
			String sql = "insert into kakugen_items (user_id, genre_name1) values(?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			if (card.getUser_id() != null && !card.getUser_id().equals("")) {
				pStmt.setString(1, card.getUser_id());
			}
			else {
				pStmt.setString(1, "");
			}
			if (card.getGenre_name1() != null && !card.getGenre_name1().equals("")) {
				pStmt.setString(2, card.getGenre_name1());
			}
			else {
				pStmt.setString(2, "");
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
	// 所持格言をリスト表示
	public List<KakugenItems> selectMyItem(KakugenItems param) {
		Connection conn = null;
		List<KakugenItems> KakugenItemsList = new ArrayList<KakugenItems>();

		try
		{
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する<<ここに改造 WHEREの後は、なにで検索したいかどうか>>
			String sql = "select genre_name1, kakugen_image, kakugen_active from kakugen_items "
					+ "left join users on users.user_id = kakugen_ITEMS.user_id "
					+ "left join kakugens on kakugens.genre_name = kakugen_ITEMS.genre_name1 "
					+ "where mail like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる<<検索項目だけ書く

			if (param.getMail() != null) {
				pStmt.setString(1, "%" + param.getMail() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				KakugenItems card = new KakugenItems(
						rs.getString("genre_name1"),
						rs.getString("kakugen_image"),
						rs.getString("kakugen_active")
						);
				KakugenItemsList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			KakugenItemsList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			KakugenItemsList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					KakugenItemsList = null;
				}
			}
		}

		// 結果を返す
		return KakugenItemsList;
	}

	// 適用した格言の更新
	public boolean activate(KakugenItems card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");


			String sql = "update Kakugen_items set Kakugen_active = 'false' where Kakugen_active = 'true' and user_id=(select user_id from users where mail like ?);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getKakugen_image() != null) {
				pStmt.setString(1, "%" + card.getKakugen_image() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

			// SQL文を準備する
			sql = "update kakugen_items set kakugen_active='true' where user_id=(select user_id from users where mail like ?)and kakugen_ID like (select background_ID from backgrounds where genre_name like ?);";
			pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる


			if (card.getKakugen_image() != null) {
				pStmt.setString(1, "%" + card.getKakugen_image() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (card.getKakugen_active() != null) {
				pStmt.setString(2, "%" + card.getKakugen_active() + "%");
			}
			else {
				pStmt.setString(2, "%");
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

	//適用した格言の表示
	public List<KakugenItems> selectActive(KakugenItems param) {
		Connection conn = null;
		List<KakugenItems> KakugenItemsList = new ArrayList<KakugenItems>();

		try
		{
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する<<ここに改造 WHEREの後は、なにで検索したいかどうか>>
			String sql = "select kakugen from Kakugen_items "
					+ "left join users on users.user_id = Kakugen_ITEMS.user_id "
					+ "left join Kakugens on Kakugens.genre_name = Kakugen_ITEMS.genre_name1 where mail like ? and Kakugen_active like 'true'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる<<検索項目だけ書く

			if (param.getMail() != null) {
				pStmt.setString(1, "%" + param.getMail() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				KakugenItems card = new KakugenItems(
						rs.getString("kakugen")

						);
				KakugenItemsList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			KakugenItemsList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			KakugenItemsList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					KakugenItemsList = null;
				}
			}
		}

		// 結果を返す
		return KakugenItemsList;
	}

}

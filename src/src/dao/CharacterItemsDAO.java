package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CharacterItems;

public class CharacterItemsDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<CharacterItems> select(CharacterItems param) {
		Connection conn = null;
		List<CharacterItems> cardList = new ArrayList<CharacterItems>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//SQL文を準備する
			String sql = "select id, user_id, character_id"
					+ "from character_items WHERE id LIKE ? AND user_id LIKE ? AND character_id like ?  ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			if (param.getId() != 0) {
				pStmt.setInt(1, param.getId() );
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
			if (param.getCharacter_id() != null) {
				pStmt.setString(3, "%" + param.getCharacter_id() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				CharacterItems card = new CharacterItems(
						rs.getInt("id"),
						rs.getString("user_id"),
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
	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(CharacterItems card) {
		Connection conn = null;
		boolean Result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//SQL文を準備する
			String sql = "insert into character_items (user_id, character_id) values(?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる

			if (card.getUser_id() != null && !card.getUser_id().equals("")) {
				pStmt.setString(1, card.getUser_id());
			}
			else {
				pStmt.setString(1, null);
			}
			if (card.getCharacter_id() != null && !card.getCharacter_id().equals("")) {
				pStmt.setString(2, card.getCharacter_id());
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
	// 所持背景をリスト表示
	public List<CharacterItems> selectMyItem(CharacterItems param) {
		Connection conn = null;
		List<CharacterItems> CharacterItemsList = new ArrayList<CharacterItems>();

		try
		{
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する<<ここに改造 WHEREの後は、なにで検索したいかどうか>>
			String sql = "select character_name, character_image, character_active from character_items "
					+ "left join users on users.user_id = character_ITEMS.user_id "
					+ "left join characters on characters.character_ID = character_ITEMS.character_ID "
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
				CharacterItems card = new CharacterItems(
						rs.getString("character_name"),
						rs.getString("character_image"),
						rs.getString("character_active")
						);
				CharacterItemsList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			CharacterItemsList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			CharacterItemsList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					CharacterItemsList = null;
				}
			}
		}

		// 結果を返す
		return CharacterItemsList;
	}
}

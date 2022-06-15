package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Users;

public class UsersDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Users> select(Users param) {
		Connection conn = null;
		List<Users> cardList = new ArrayList<Users>();

		try
		{
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する<<ここに改造 WHEREの後は、なにで検索したいかどうか>>
			String sql = "select id, user_id, user_name,mail, login_pw  "
					+ "from users WHERE id LIKE ? AND user_id LIKE ? AND user_name LIKE ? AND mail LIKE ? "
					+ "AND login_pw LIKE ? ORDER BY id";
			//			6/1412時作業
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる<<検索項目だけ書く
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
			if (param.getUser_name() != null) {
				pStmt.setString(3, "%" + param.getUser_name() + "%");
			} else {
				pStmt.setString(3, "");
			}
			if (param.getMail() != null) {
				pStmt.setString(4, "%" + param.getMail() + "%");
			} else {
				pStmt.setString(4, "");
			}
			if (param.getLogin_pw() != null) {
				pStmt.setString(5,"%" + param.getLogin_pw() + "%");
			} else {
				pStmt.setString(5, "");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Users card = new Users(
						rs.getInt("id"),
						rs.getString("user_id"),
						rs.getString("user_name"),
						rs.getString("mail"),
						rs.getString("login_pw")
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
	public boolean insert(Users card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "insert into diary (id, user_id, diary_date,diary_title, diary_content"
					+ "from diaries ;) values (?, ?, ?, ? ,? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if(card.getId() != 0) {
				pStmt.setInt(1, card.getId() );
			} else {
				pStmt.setInt(1, 0);
			}
			if (card.getUser_id() != null && !card.getUser_id().equals("")) {
				pStmt.setString(2, card.getUser_id());
			} else {
				pStmt.setString(2, "");
			}
			if (card.getUser_name() != null && !card.getUser_name().equals("")) {
				pStmt.setString(3, card.getUser_name());
			} else {
				pStmt.setString(3, "");
			}
			if (card.getMail() != null && !card.getMail().equals("")) {
				pStmt.setString(4, card.getMail());
			} else {
				pStmt.setString(4, "");
			}
			if (card.getLogin_pw() != null && !card.getLogin_pw().equals("")) {
				pStmt.setString(5, card.getLogin_pw());
			} else {
				pStmt.setString(5, "");
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

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Users card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "update BC set user_id=?, diary_date=?, diary_title=?, diary_content=? where id=? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (card.getUser_id() != null && !card.getUser_id().equals("")) {
				pStmt.setString(1, card.getUser_id() );
			} else {
				pStmt.setString(1, "");
			}
			if (card.getUser_name() != null && !card.getUser_name().equals("")) {
				pStmt.setString(2, card.getUser_name());
			} else {
				pStmt.setString(2, "");
			}
			if (card.getMail() != null && !card.getMail().equals("")) {
				pStmt.setString(3, card.getMail());
			} else {
				pStmt.setString(3, "");
			}
			if (card.getLogin_pw() != null && !card.getLogin_pw().equals("")) {
				pStmt.setString(4, card.getLogin_pw());
			} else {
				pStmt.setString(4, "");

			}
			pStmt.setInt(5, card.getId());
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

	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(String id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "delete from BC where Id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, id);

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

}



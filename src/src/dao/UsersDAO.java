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
			//point_valueをusersに追加 0622
			String sql = "select id, user_id, user_name,mail, login_pw, point_value "
					+ "from users WHERE  user_id LIKE ? AND user_name LIKE ? AND mail LIKE ? "
					+ "AND login_pw LIKE ? ORDER BY id";
			//			6/1412時作業
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる<<検索項目だけ書く

			if (param.getUser_id() != null) {
				pStmt.setString(1, "%" + param.getUser_id() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getUser_name() != null) {
				pStmt.setString(2, "%" + param.getUser_name() + "%");
			} else {
				pStmt.setString(2, "%");
			}
			if (param.getMail() != null) {
				pStmt.setString(3, "%" + param.getMail() + "%");
			} else {
				pStmt.setString(3, "%");
			}
			if (param.getLogin_pw() != null) {
				pStmt.setString(4,"%" + param.getLogin_pw() + "%");
			} else {
				pStmt.setString(4, "%");
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
						rs.getString("login_pw"),
						rs.getInt("point_value")
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
	public List<Users> select(String mail) {
		Connection conn = null;
		List<Users> cardList = new ArrayList<Users>();

		try
		{
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する<<ここに改造 WHEREの後は、なにで検索したいかどうか>>
			String sql = "select id, user_id, user_name,mail, login_pw, point_value "
					+ "from users WHERE mail LIKE ? ORDER BY id";
			//			6/1412時作業
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる<<検索項目だけ書く

			if (mail != null) {
				pStmt.setString(1, mail);
			} else {
				pStmt.setString(1, "%");
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
						rs.getString("login_pw"),
						rs.getInt("point_value")
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
			String sql = "insert into users (user_name,mail, login_pw) values (?, ? ,? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (card.getUser_name() != null && !card.getUser_name().equals("")) {
				pStmt.setString(1, card.getUser_name());
			} else {
				pStmt.setString(1, null);
			}
			if (card.getMail() != null && !card.getMail().equals("")) {
				pStmt.setString(2, card.getMail());
			} else {
				pStmt.setString(2, null);
			}
			if (card.getLogin_pw() != null && !card.getLogin_pw().equals("")) {
				pStmt.setString(3, card.getLogin_pw());
			} else {
				pStmt.setString(3, null);
			}
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
			//user_idの登録
			sql = "UPDATE Users SET  user_id=(SELECT CONCAT('u',id) FROM Users WHERE user_id IS NULL) WHERE user_id IS NULL;";
			pStmt = conn.prepareStatement(sql);
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
			String sql = "update Users set user_name=?, mail=?, login_pw=? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる


			if (card.getUser_name() != null && !card.getUser_name().equals("")) {
				pStmt.setString(1, card.getUser_name());
			} else {
				pStmt.setString(1, "");
			}
			if (card.getMail() != null && !card.getMail().equals("")) {
				pStmt.setString(2, card.getMail());
			} else {
				pStmt.setString(2, "");
			}
			if (card.getLogin_pw() != null && !card.getLogin_pw().equals("")) {
				pStmt.setString(3, card.getLogin_pw());
			} else {
				pStmt.setString(3, "");

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
			String sql = "delete from Users where Id=?";
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

	public boolean isLoginOK(Users Users) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*)  from Users where mail = ? and login_pw = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, Users.getMail());
			pStmt.setString(2, Users.getLogin_pw());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// メアドとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}


	public boolean isMailOK(Users Users) {
		Connection conn = null;
		boolean MailResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SELECT文を準備する
			String sql = "select count(mail)  from Users where mail = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, Users.getMail());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// メアドが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(mail)") == 1) {
				MailResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			MailResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			MailResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					MailResult = false;
				}
			}
		}

		// 結果を返す
		return MailResult;
	}
	//passwordの更新
	public boolean updatePassword(Users card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "update Users set login_pw=? where mail like ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる


			if (card.getLogin_pw() != null && !card.getLogin_pw().equals("")) {
				pStmt.setString(1, card.getLogin_pw());
			} else {
				pStmt.setString(1, "");
			}
			if (card.getMail() != null && !card.getMail().equals("")) {
				pStmt.setString(2, card.getMail());
			} else {
				pStmt.setString(2, "");
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


	//user_nameの更新
	public boolean updateName(Users card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "update Users set user_name=? where mail like ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる


			if (card.getMail() != null && !card.getMail().equals("")) {
				pStmt.setString(1, card.getMail());
			} else {
				pStmt.setString(1, "");
			}
			if (card.getLogin_pw() != null && !card.getLogin_pw().equals("")) {
				pStmt.setString(2, card.getLogin_pw());
			} else {
				pStmt.setString(2, "");
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

	//ポイントを書き換える
	public boolean updatePoint(Users card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する 0627清水変更 id→user?_id
			String sql = "update Users set point_value=? where user_id like ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる


			if (card.getPoint_value() > -1) {
				if (card.getUser_id() != null && !card.getUser_id().equals("")) {
				pStmt.setInt(1, card.getPoint_value());
			} else {
				pStmt.setInt(1, 0);
			}
				pStmt.setString(2, card.getUser_id());
			} else {
				pStmt.setString(2, "");
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

}



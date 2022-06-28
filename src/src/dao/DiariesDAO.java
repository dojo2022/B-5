package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Diaries;

public class DiariesDAO {
	/*	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Diaries> select(Diaries param) {
			Connection conn = null;
			List<Diaries> cardList = new ArrayList<Diaries>();

			try
			{
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する<<ここに改造 WHEREの後は、なにで検索したいかどうか>>
				String sql = "select id, user_id, diary_date,diary_title, diary_content  "
						+ "from diaries WHERE user_id LIKE ? AND diary_date LIKE ? AND diary_title LIKE ? "
						+ "AND diary_content LIKE ? ORDER BY id";
				//			6/1412時作業
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる<<検索項目だけ書く

				if (param.getUser_id() != null) {
					pStmt.setString(1, "%" + param.getUser_id() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}
				if (param.getDiary_date() != null) {
					pStmt.setString(2, "%" + param.getDiary_date() + "%");
				} else {
					pStmt.setString(2, "%");
				}
				if (param.getDiary_title() != null) {
					pStmt.setString(3, "%" + param.getDiary_title() + "%");
				} else {
					pStmt.setString(3, "%");
				}
				if (param.getDiary_content() != null) {
					pStmt.setString(4,"%" + param.getDiary_content() + "%");
				} else {
					pStmt.setString(4, "%");
				}

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Diaries card = new Diaries(
							rs.getString("user_id"),
							rs.getString("diary_date"),
							rs.getString("diary_title"),
							rs.getString("diary_content")
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
	*/
	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Diaries card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "INSERT INTO Diaries (diary_date,diary_title,diary_content,user_id) values (curdate(), ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			
			if (card.getDiary_title() != null && !card.getDiary_title().equals("")) {
				pStmt.setString(1, card.getDiary_title());
			} else {
				pStmt.setString(1, "");
			}
			if (card.getDiary_content() != null && !card.getDiary_content().equals("")) {
				pStmt.setString(2, card.getDiary_content());
			} else {
				pStmt.setString(2, "");
			}
			if (card.getUser_id() != null && !card.getUser_id().equals("")) {
				pStmt.setString(3, card.getUser_id());
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

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Diaries card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "update diaries set diary_date=?, diary_title=?, diary_content=? where user_id like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (card.getDiary_date() != null && !card.getDiary_date().equals("")) {
				pStmt.setString(1, card.getDiary_date());
			} else {
				pStmt.setString(1, null);
			}
			if (card.getDiary_title() != null && !card.getDiary_title().equals("")) {
				pStmt.setString(2, card.getDiary_title());
			} else {
				pStmt.setString(2, null);
			}
			if (card.getDiary_content() != null && !card.getDiary_content().equals("")) {
				pStmt.setString(3, card.getDiary_content());
			} else {
				pStmt.setString(3, null);
			}
			if (card.getUser_id() != null && !card.getUser_id().equals("")) {
				pStmt.setString(4, card.getUser_id());
			} else {
				pStmt.setString(4, null);
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
			String sql = "delete from Diaries where user_id like ?";
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



//ユーザーを区別するための検索
	public List<Diaries> selectMyItem(Diaries para) {
		Connection conn = null;
		List<Diaries> diaryList = new ArrayList<Diaries>();

		try
		{
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する<<ここに改造 WHEREの後は、なにで検索したいかどうか>>
			String sql = "select diary_date, diary_title,diary_content from diaries "
					+ "left join users on users.user_id = diaries.user_id "
					+ "where diary_date like ? and diary_title like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる<<検索項目だけ書く

			if (para.getDiary_date()!= null) {
				pStmt.setString(1, "%" + para.getDiary_date() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (para.getDiary_title() != null) {
				pStmt.setString(2, "%" + para.getDiary_title() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Diaries card = new Diaries(
						rs.getString("diary_date"),
						rs.getString("diary_title"),
						rs.getString("diary_content")
						);
				diaryList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			diaryList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			diaryList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					diaryList = null;
				}
			}
		}

		// 結果を返す
		return diaryList;
	}
	public List<Diaries> selectMyItem(String mail) {
		Connection conn = null;
		List<Diaries> diaryList = new ArrayList<Diaries>();

		try
		{
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する<<ここに改造 WHEREの後は、なにで検索したいかどうか>>
			String sql = "select diary_date, diary_title ,diary_content from diaries "
					+ "left join users on users.user_id = Diaries.user_id "
					+ "where mail like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる<<検索項目だけ書く

			if (mail != null) {
				pStmt.setString(1, mail);
			}
			else {
				pStmt.setString(1, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Diaries card = new Diaries(

						rs.getString("diary_date"),
						rs.getString("diary_title"),
						rs.getString("diary_content")
						);
				diaryList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			diaryList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			diaryList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					diaryList = null;
				}
			}
		}

		// 結果を返す
		return diaryList;
	}
}




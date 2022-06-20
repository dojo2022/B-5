package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Schedules;



public class SchedulesDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Schedules> select(Schedules param) {
		Connection conn = null;
		List<Schedules> cardList = new ArrayList<Schedules>();

		try
		{
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// 実行するSQL文
			String sql = "SELECT * FROM Schedules ORDER BY id";

			//一覧を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、変数rsに結果を格納
			ResultSet rs = pStmt.executeQuery();

			// 実行結果を順番に取り出す
			while (rs.next()) {
				Schedules card = new Schedules(
						rs.getString("id"),
						rs.getString("title"),
						rs.getString("start_time"),
						rs.getString("end_time"),
						rs.getString("stamp_id"),
						rs.getString("schedule_memo"),
						rs.getString("place"),
						rs.getString("user_id")
						);
				//取得した要素を、cardに追加
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
	public boolean insert(Schedules card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "insert into schedules (title,start_time,end_time,stamp_id,schedule_memo,place) values (?, ? ,?, ?, ?, ? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (card.getTitle() != null && !card.getTitle().equals("")) {
				pStmt.setString(1, card.getTitle());
			} else {
				pStmt.setString(1, "");
			}
			if (card.getStart_time() != null && !card.getStart_time().equals("")) {
				pStmt.setString(2, card.getStart_time());
			} else {
				pStmt.setString(2, "");
			}
			if (card.getEnd_time() != null && !card.getEnd_time().equals("")) {
				pStmt.setString(3, card.getEnd_time());
			} else {
				pStmt.setString(3, "");
			}
			if (card.getStamp_id() != null && !card.getStamp_id().equals("")) {
				pStmt.setString(4, card.getStamp_id());
			} else {
				pStmt.setString(4, "");
			}
			if (card.getSchedule_memo() != null && !card.getSchedule_memo().equals("")) {
				pStmt.setString(5, card.getSchedule_memo());
			} else {
				pStmt.setString(5, "");
			}
			if (card.getPlace() != null && !card.getPlace().equals("")) {
				pStmt.setString(6, card.getPlace());
			} else {
				pStmt.setString(6, "");
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
	public boolean update(Schedules card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "update Schedules set title=?, start_time=?, end_time=?, stamp_id=?, schedule_memo=?, place=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる


			if (card.getTitle() != null && !card.getTitle().equals("")) {
				pStmt.setString(1, card.getTitle());
			} else {
				pStmt.setString(1, "");
			}
			if (card.getStart_time() != null && !card.getStart_time().equals("")) {
				pStmt.setString(2, card.getStart_time());
			} else {
				pStmt.setString(2, "");
			}
			if (card.getEnd_time() != null && !card.getEnd_time().equals("")) {
				pStmt.setString(3, card.getEnd_time());
			} else {
				pStmt.setString(3, "");
			}
			if (card.getStamp_id() != null && !card.getStamp_id().equals("")) {
				pStmt.setString(4, card.getStamp_id());
			} else {
				pStmt.setString(4, "");
			}
			if (card.getSchedule_memo() != null && !card.getSchedule_memo().equals("")) {
				pStmt.setString(5, card.getSchedule_memo());
			} else {
				pStmt.setString(5, "");
			}
			if (card.getPlace() != null && !card.getPlace().equals("")) {
				pStmt.setString(6, card.getPlace());
			} else {
				pStmt.setString(6, "");
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
			String sql = "delete from Schedules where Id=?";
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

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TodoLists;

public class TodoListsDAO {

//

	//ユーザーを区別するための検索
			public List<TodoLists> selectMyItem(TodoLists parameter) {
				Connection conn = null;
				List<TodoLists> TodolistList = new ArrayList<TodoLists>();

				try
				{
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

					// SQL文を準備する<<ここに改造 WHEREの後は、なにで検索したいかどうか>>
					String sql = "select todo_deadline,task,importance,todo_memo from todolists "
							+ "left join users on users.user_id = todolists.user_id "
							+ "where todo_deadline like ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる<<検索項目だけ書く

					if (parameter.getTodo_deadline()!= null) {
						pStmt.setString(1, parameter.getTodo_deadline());
					}
					else {
						pStmt.setString(1, "%");
					}


					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						TodoLists card = new TodoLists(
								rs.getString("todo_deadline"),
								rs.getString("task"),
								rs.getString("importance"),
								rs.getString("todo_memo")
								);
						TodolistList.add(card);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					TodolistList = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					TodolistList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							TodolistList = null;
						}
					}
				}

				// 結果を返す
				return TodolistList;
			}


		// TODOリストを表示
		public List<TodoLists> selectMyItem(String mail) {
			Connection conn = null;
			List<TodoLists> TodolistList = new ArrayList<TodoLists>();

			try
			{
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する<<ここに改造 WHEREの後は、なにで検索したいかどうか>>
				String sql = "SELECT todo_deadline,task,importance,todo_memo FROM TodoLists "
						+ "LEFT JOIN users on users.user_id = TodoLists.user_id "
						+ "WHERE mail like ?";
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
					TodoLists card = new TodoLists(
						rs.getString("todo_deadline"),
						rs.getString("task"),
						rs.getString("importance"),
						rs.getString("todo_memo")
							);
					TodolistList.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				TodolistList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				TodolistList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						TodolistList = null;
					}
				}
			}

			// 結果を返す
			return TodolistList;
		}



	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(TodoLists card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "INSERT INTO TodoLists (todo_deadline,task,importance,todo_memo,user_id) values (?,?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getTodo_deadline() != null && !card.getTodo_deadline().equals("")) {
					pStmt.setString(1, card.getTodo_deadline());
				}
				else {
					pStmt.setString(1, null);
				}
				if (card.getTask() != null && !card.getTask().equals("")) {
					pStmt.setString(2, card.getTask());
				}
				else {
					pStmt.setString(2, null);
				}
				if (card.getImportance() != null && !card.getImportance().equals("") ) {
					pStmt.setString(3, card.getImportance());
				}
				else {
					pStmt.setString(3, null);
				}
				if (card.getTodo_memo() != null && !card.getTodo_memo().equals("")) {
					pStmt.setString(4, card.getTodo_memo());
				}
				else {
					pStmt.setString(4, null);
				}
				if (card.getUser_id() != null && !card.getUser_id().equals("")) {
					pStmt.setString(5, card.getUser_id());
				}
				else {
					pStmt.setString(5, null);
				}




				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}


		// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(TodoLists card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "update TodoLists set todo_deadline=?,task=?,importance=?, todo_memo=? where user_id like ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getTodo_deadline() != null && !card.getTodo_deadline().equals("")) {
					pStmt.setString(1, card.getTodo_deadline());
				}
				else {
					pStmt.setString(1, null);
				}
				if (card.getTask() != null && !card.getTask().equals("")) {
					pStmt.setString(2, card.getTask());
				}
				else {
					pStmt.setString(2, null);
				}

				if (card.getImportance() != null && !card.getImportance().equals("")) {
					pStmt.setString(3, card.getImportance());
				}
				else {
					pStmt.setString(3, null);
				}
				if (card.getTodo_memo() != null && !card.getTodo_memo().equals("")) {
					pStmt.setString(4, card.getTodo_memo());
				}
				else {
					pStmt.setString(4, null);
				}
				if (card.getUser_id() != null && !card.getUser_id().equals("")) {
					pStmt.setString(5, card.getUser_id());
				}
				else {
					pStmt.setString(5, null);
				}


				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
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
				String sql = "delete from TodoLists where task like ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, id);

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}

}

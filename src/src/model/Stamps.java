package model;
import java.io.Serializable;

public class Stamps implements Serializable{
	private int id;
	private String user_id;
	private String stamp_id;
	private String stamp_image;


	public Stamps(int id, String user_id, String stamp_id, String stamp_image) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.stamp_id = stamp_id;
		this.stamp_image = stamp_image;

	}


	public Stamps() {
		super();
		this.id = 0;
		this.user_id = "";
		this.stamp_id ="";
		this.stamp_image = "";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getStamp_id() {
		return stamp_id;
	}

	public void setStamp_id(String stamp_id) {
		this.stamp_id = stamp_id;
	}

	public String getStamp_image() {
		return stamp_image;
	}

	public void setStamp_image(String stamp_image) {
		this.stamp_image = stamp_image;
	}
}
///**
// * Servlet implementation class Stamps
// */
//@WebServlet("/Stamps")
//public class Stamps extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Stamps() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}

package common.lec.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.D;

public class CategoryDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public CategoryDAO() {
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("CategoryDAO connection 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	} // end CategoryDAO()

	public void close() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	} // end close()

	public CategoryDTO[] createList(ResultSet resultSet) throws SQLException {
		CategoryDTO[] list = null;
		ArrayList<CategoryDTO> arrayList = new ArrayList<CategoryDTO>();

		while(resultSet.next()) {
			int uid = resultSet.getInt("uid");
			String name = resultSet.getString("name");
			int depth = resultSet.getInt("depth");
			int parent = resultSet.getInt("parent");
			int order = resultSet.getInt("order");

			CategoryDTO dto = new CategoryDTO(uid, name, depth, parent, order);
			arrayList.add(dto);
		}
		int size = arrayList.size();

		if(size == 0) return null;

		list = new CategoryDTO[size];
		arrayList.toArray(list);

		return list;
	} // end createList()

	public CategoryDTO[] selectCategoryRoot() throws SQLException {
		CategoryDTO[] list = null;

		try {
			pstmt = conn.prepareStatement(D.SQL_CATEGORY_BY_DEPTH_1);
			rs = pstmt.executeQuery();
			list = createList(rs);
		} finally {
			close();
		}

		return list;
	} // end selectCategoryRoot()

	public CategoryDTO[] selectCategory(int parent, int depth) throws SQLException {
		CategoryDTO[] list = null;

		try {
			pstmt = conn.prepareStatement(D.SQL_CATEGORY_BY_DEPTH_N_PARENT);
			pstmt.setInt(1, depth);
			pstmt.setInt(2, parent);
			rs = pstmt.executeQuery();
			list = createList(rs);
		} finally {
			close();
		}

		return list;
	} // end selectCategory()

} // end Class

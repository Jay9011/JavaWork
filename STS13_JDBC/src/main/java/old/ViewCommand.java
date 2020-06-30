package old;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO();
		WriteDTO[] arr = null;

		int uid = Integer.parseInt(request.getParameter("uid"));

		try {
			arr = dao.readByUid(uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("viewInfo", arr);
	}

}

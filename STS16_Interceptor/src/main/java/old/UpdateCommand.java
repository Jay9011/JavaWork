package old;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO();

		int uid = Integer.parseInt(request.getParameter("uid"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		int cnt = 0;

		if(subject != null && subject.trim().length() > 0) {
			try {
				cnt = dao.update(uid, subject, content);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("result", cnt);
	}

}

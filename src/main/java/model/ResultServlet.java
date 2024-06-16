package model;

import java.io.File;
import java.io.IOException;
import java.util.List;

import controller.CsvReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResultServlet
 */
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResultServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * doGetメソッド
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String csvFilePath = getServletContext().getRealPath("/") + "data.csv";
		File csvFile = new File(csvFilePath);
		CsvReader csvReader = new CsvReader();
		List<CsvBean> csvDataList = null;

		try {
			csvDataList = csvReader.readCsv(csvFile, CsvBean.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		request.setAttribute("csvDataList", csvDataList);
		request.getRequestDispatcher("/displayCsv.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.ykmimi.ipchecker.servlet;

import java.io.IOException;
import java.net.InetSocketAddress;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ykmimi.ipchecker.util.AddressFormat;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	String ipString = null;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		///// * 设置整体字符编码
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		String domainName = request.getParameter("domainname");

		///// * "realIP"为传导的key, ipString为传导的value
		request.setAttribute("realIP", getAddressResult(domainName));
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);

	}

	@SuppressWarnings("unused")
	public String getAddressResult(String domainName) {
		///// * 通过对地址格式化返回单纯的地址

		try {
			int validityNum = AddressFormat.checkAddressValidity(domainName);
			if (validityNum == 0) {
				return "请输入要查询的域名!💗";
			}
			if (validityNum == 2) {
				return "域名填写错误,http或https与//之间需要':'符号💗";
			}
			if (validityNum == 4) {
				return "域名填写错误,至少得有一个'.'符号💗";
			}
			if(validityNum == 6) {
				return "127.0.0.1";
			}
			///// * 格式化域名
			domainName = AddressFormat.formatAddressAll(domainName);
			///// * 有效性number
			///// * 0表示没有语句.
			///// * 2表示

			InetSocketAddress address = new InetSocketAddress(domainName, 80);

			if (address.getAddress().getHostAddress() != null
					&& !address.getAddress().getHostAddress().equals("127.0.0.1")) {
				
				ipString = "此域名IP为:" + address.getAddress().getHostAddress();
				/////* TODO 将每个正确的IP放入数据库
				return ipString;
			} else {
				ipString = "默认本机IP地址127.0.0.1 请输入您要查询的网站域名进行查询💗";
				return ipString;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			if (e != null) {
				ipString = "无此域名,请核实域名正确性后再填写!💗";
				return ipString;
			}
		} catch (Exception e) {
			e.printStackTrace();
			ipString = "域名填写错误!正确域名格式为http://或https://开头,或直接输入www开始的域名.💗";
			return ipString;
		} finally {
			// nothing
		}
		return "您输入的域名准时外星人发明的!💗";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

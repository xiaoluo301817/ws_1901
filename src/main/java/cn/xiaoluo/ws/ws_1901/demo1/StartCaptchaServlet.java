package cn.xiaoluo.ws.ws_1901.demo1;

import cn.xiaoluo.ws.ws_1901.utils.GeetestConfig;
import cn.xiaoluo.ws.ws_1901.utils.GeetestLib;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * 使用Get的方式返回challenge和capthca_id,此方式以实现前后端完全分离的开发模式
 *
 */
@Controller
@RequestMapping(value = "/gt")
public class StartCaptchaServlet{


	@GetMapping(value = "/startCaptcha1")
	protected void startCaptcha1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key(),
				GeetestConfig.isnewfailback());

		String resStr = "{}";
		
		String userid = "test";
		
		//自定义参数,可选择添加
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("user_id", userid); //网站用户id
		param.put("client_type", "web"); //web:电脑上的浏览器；h5:手机上的浏览器，包括移动应用内完全内置的web_view；native：通过原生SDK植入APP应用的方式
		param.put("ip_address", "127.0.0.1"); //传输用户请求验证时所携带的IP

		//进行验证预处理
		int gtServerStatus = gtSdk.preProcess(param);
		
		//将服务器状态设置到session中
		request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
		//将userid设置到session中
		request.getSession().setAttribute("userid", userid);
		
		resStr = gtSdk.getResponseStr();

		PrintWriter out = response.getWriter();
		out.println(resStr);

	}
}
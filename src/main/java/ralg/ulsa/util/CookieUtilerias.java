package ralg.ulsa.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class CookieUtilerias {

	public static String getCookieValor(HttpServletRequest request, String cookieNombre, String defaultValor) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookieNombre.equals(cookie.getName())) {
					return (cookie.getValue());
				}
			}
		}
		return (defaultValor);
	}

	public static Cookie getCookie(HttpServletRequest request, String cookieNombre) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookieNombre.equals(cookie.getName())) {
					return (cookie);
				}
			}
		}
		return (null);
	}
}

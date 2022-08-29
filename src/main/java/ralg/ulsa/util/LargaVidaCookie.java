package ralg.ulsa.util;

import jakarta.servlet.http.Cookie;

public class LargaVidaCookie extends Cookie {
	public static final int SECONDS_PER_YEAR = 60 * 60 * 24 * 365;

	public LargaVidaCookie(String nombre, String valor) {
		super(nombre, valor);
		setMaxAge(SECONDS_PER_YEAR);
	}
}

package ma.emsi.tp_jpa.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class securityController {
@GetMapping("/notauthorized")
public String error() {
	return "notauthorized";
}

}

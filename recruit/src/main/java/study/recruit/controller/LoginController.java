package study.recruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import study.recruit.model.Response;
import study.recruit.service.LoginService;

@Controller
public class LoginController extends AbstractController {

  private   LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/api/register")
    public String register(String username, String password) {
        Response response = new Response(Response.STATUS_FAIL, Response.MESSAGE_FAIL);
        try {
            response = loginService.register(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponse(Response.STATUS_SERVER_ERROR, Response.MESSAGE_SERVER_ERROR);
        }
        return gson.toJson(response);
    }


}

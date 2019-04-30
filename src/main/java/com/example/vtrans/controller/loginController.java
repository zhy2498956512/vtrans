package com.example.vtrans.controller;

import com.example.vtrans.pojo.Recording;
import com.example.vtrans.pojo.Translate;
import com.example.vtrans.pojo.User;
import com.example.vtrans.service.RecordingService;
import com.example.vtrans.service.UserService;
import com.example.vtrans.util.CommonResponse;
import com.example.vtrans.util.ErrorCode;
import com.example.vtrans.util.MD5Util;
import com.example.vtrans.util.MailboxDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class loginController {

    @Autowired
    private CommonResponse commonResponse;

    @Autowired
    private UserService userService;

    @Autowired
    private RecordingService recordingService;

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    private String code = "";
    @RequestMapping("/sendMail")
    @ResponseBody
    public String sendMail(HttpServletRequest request){
        try {
            String userMail = request.getParameter("userMail");
            String userPass = request.getParameter("userPass");
            if(userService.testingMail(userMail)!=null){
                if(userService.getUser(userMail, MD5Util.string2MD5(userPass))!=null){
                    Double random = Math.random();//随机数
                    String nuberm = random.toString();
                    nuberm =  nuberm.substring(nuberm.length()-6,nuberm.length());
                    code = nuberm;
                    MailboxDemo.setComMailbox(userMail,nuberm);
                    return commonResponse.commonReturn("邮件成功发送");
                }else{
                    return commonResponse.commonErrorReturn(ErrorCode.ValidationFailedError, "邮箱或密码错误");
                }
            }else{
                return commonResponse.commonErrorReturn(ErrorCode.NoUserError, "用户不存在");
            }
        }catch (Exception e){
            e.printStackTrace();
            return commonResponse.commonErrorReturn(500, "系统异常");
        }
    }

    @RequestMapping("/sendLogin")
    @ResponseBody
    public String sendLogin(HttpServletRequest request){
        try {
            String userMail = request.getParameter("userMail");
            String identification = request.getParameter("identification");
            User user = userService.testingMail(userMail);
            if(user!=null){
                if("1".equals(identification)){
                    //验证码登录
                    String userCode = request.getParameter("userCode");
                    if(userCode.equals(code)){
                        request.getSession().setAttribute("User", user);
                        return commonResponse.commonReturn("用户验证成功");
                    }else{
                        return commonResponse.commonErrorReturn(ErrorCode.VerificationCodeError, "验证码错误");
                    }
                }else if("2".equals(identification)){
                    //密码登录
                    String userPass = request.getParameter("userPass");
                    user = userService.getUser(userMail,MD5Util.string2MD5(userPass));
                    if(user!=null){
                        request.getSession().setAttribute("User", user);
                        return commonResponse.commonReturn("用户验证成功");
                    }else{
                        return commonResponse.commonErrorReturn(ErrorCode.ValidationFailedError, "邮箱或密码错误");
                    }
                }else {
                    return commonResponse.commonErrorReturn(500, "系统异常");
                }
            }else{
                return commonResponse.commonErrorReturn(ErrorCode.NoUserError, "用户不存在");
            }
        }catch (Exception e){
            e.printStackTrace();
            return commonResponse.commonErrorReturn(500, "系统异常");
        }
    }

    @RequestMapping("/jumpIndex")
    public String jumpIndex(HttpServletRequest request,Model model){
        /*User user = (User) request.getSession().getAttribute("User");*/
        List<Recording> recordingList = recordingService.getRecordingList(10);
        model.addAttribute("recordingList",recordingList);
        return "index";
    }

    @RequestMapping("/signOut")
    public String signOut(HttpServletRequest request){
        request.getSession().removeAttribute("User");
        return "login";
    }

}

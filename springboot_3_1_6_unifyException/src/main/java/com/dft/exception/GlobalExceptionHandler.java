package com.dft.exception;

import com.dft.dto.ErrorInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Class Name GlobalExceptionHandler
 * @Author dongfuting
 * @Create In 2018年03月16日 18:13
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  public static final String DEFAULT_ERROR_VIEW = "error";

  @ExceptionHandler(value = Exception.class)
  public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    ModelAndView mav = new ModelAndView();
    mav.addObject("exception", e);
    mav.addObject("url", req.getRequestURL());
    mav.setViewName("error");
    return mav;
  }

  @ExceptionHandler(value = MyException.class)
  @ResponseBody
  public ErrorInfo<String> jsonErrorException(HttpServletRequest req, MyException e)
      throws Exception {
    ErrorInfo<String> r = new ErrorInfo<>();
    r.setMessage(e.getMessage());
    r.setCode(ErrorInfo.ERROR);
    r.setData("somg data.");
    r.setUrl(req.getRequestURL().toString());
    return r;
  }
}

package com.dft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.OnTransitionEnd;
import org.springframework.statemachine.annotation.OnTransitionStart;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @Class Name EventConfig
 * @Author dongfuting
 * @Create In 2018年04月11日 15:30
 */
@WithStateMachine
public class EventConfig {
  private Logger logger= LoggerFactory.getLogger(getClass());

  @OnTransition(target = "UNPAID")
  public void create(){
    logger.info("订单创建，待支付");
  }

  @OnTransition(source = "UNPAID",target = "WAITING_FOR_RECEIVE")
  public void pay(){
    logger.info("用户完成支付，待收货");
  }

  @OnTransitionStart(source = "UNPAID",target = "WAITING_FOR_RECEIVE")
  public void payStart(){
    logger.info("用户完成支付，待收货:start");
  }

  @OnTransitionEnd(source = "UNPAID",target = "WAITING_FOR_RECEIVE")
  public void payEnd(){
    logger.info("用户完成支付，待收货:end");
  }

  @OnTransition(source = "WAITING_FOR_RECEIVE",target = "DONE")
  public void recieve(){
    logger.info("用户已收货，交易完成");
  }

}

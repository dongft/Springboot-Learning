package com.dft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;
import sun.rmi.runtime.Log;

/**
 * @Class Name Application
 * @Author dongfuting
 * @Create In 2018年04月11日 14:26
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Autowired
  private StateMachine<States, Events> stateMachine;

  @Override
  public void run(String... args) throws Exception {
    stateMachine.start();
    stateMachine.sendEvent(Events.PAY);
    stateMachine.sendEvent(Events.RECEIVE);
  }
}

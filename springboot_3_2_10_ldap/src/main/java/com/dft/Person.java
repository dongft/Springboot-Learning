package com.dft;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import lombok.Data;

/**
 * @Class Name Person
 * @Author dongfuting
 * @Create In 2018年03月21日 10:20
 */
@Data
@Entry(base = "ou=people,dc=dftspace,dc=com", objectClasses = "inetOrgPerson")
public class Person {
  @Id
  private Name id;

  @DnAttribute(value = "uid", index = 3)
  private String uid;

  @Attribute(name = "cn")
  private String commonName;

  @Attribute(name = "sn")
  private String userName;

  private String userPassword;
}

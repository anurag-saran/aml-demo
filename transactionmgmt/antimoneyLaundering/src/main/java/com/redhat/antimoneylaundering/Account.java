package com.redhat.antimoneylaundering;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class Account implements java.io.Serializable
{

   static final long serialVersionUID = 1L;

   @org.kie.api.definition.type.Label("accountNo")
   private java.lang.String accountNo;
   @org.kie.api.definition.type.Label("firstName")
   private java.lang.String firstName;
   @org.kie.api.definition.type.Label("lastName")
   private java.lang.String lastName;
   @org.kie.api.definition.type.Label("street")
   private java.lang.String street;
   @org.kie.api.definition.type.Label("city")
   private java.lang.String city;
   @org.kie.api.definition.type.Label("state")
   private java.lang.String state;
   @org.kie.api.definition.type.Label("zipCode")
   private java.lang.String zipCode;
   @org.kie.api.definition.type.Label("occupation")
   private java.lang.String occupation;
   @org.kie.api.definition.type.Label("age")
   private String age;
   @org.kie.api.definition.type.Label("sex")
   private java.lang.String sex;
   @org.kie.api.definition.type.Label("marritialStatus")
   private java.lang.String marritialStatus;
   @org.kie.api.definition.type.Label("accountType")
   private java.lang.String accountType;

   public Account()
   {
   }

   public java.lang.String getAccountNo()
   {
      return this.accountNo;
   }

   public void setAccountNo(java.lang.String accountNo)
   {
      this.accountNo = accountNo;
   }

   public java.lang.String getFirstName()
   {
      return this.firstName;
   }

   public void setFirstName(java.lang.String firstName)
   {
      this.firstName = firstName;
   }

   public java.lang.String getLastName()
   {
      return this.lastName;
   }

   public void setLastName(java.lang.String lastName)
   {
      this.lastName = lastName;
   }

   public java.lang.String getStreet()
   {
      return this.street;
   }

   public void setStreet(java.lang.String street)
   {
      this.street = street;
   }

   public java.lang.String getCity()
   {
      return this.city;
   }

   public void setCity(java.lang.String city)
   {
      this.city = city;
   }

   public java.lang.String getState()
   {
      return this.state;
   }

   public void setState(java.lang.String state)
   {
      this.state = state;
   }

   public java.lang.String getZipCode()
   {
      return this.zipCode;
   }

   public void setZipCode(java.lang.String zipCode)
   {
      this.zipCode = zipCode;
   }

   public java.lang.String getOccupation()
   {
      return this.occupation;
   }

   public void setOccupation(java.lang.String occupation)
   {
      this.occupation = occupation;
   }

   public java.lang.String getSex()
   {
      return this.sex;
   }

   public void setSex(java.lang.String sex)
   {
      this.sex = sex;
   }

   public java.lang.String getMarritialStatus()
   {
      return this.marritialStatus;
   }

   public void setMarritialStatus(java.lang.String marritialStatus)
   {
      this.marritialStatus = marritialStatus;
   }

   public java.lang.String getAccountType()
   {
      return this.accountType;
   }

   public void setAccountType(java.lang.String accountType)
   {
      this.accountType = accountType;
   }

   public java.lang.String getAge()
   {
      return this.age;
   }

   public void setAge(java.lang.String age)
   {
      this.age = age;
   }

   public Account(java.lang.String accountNo, java.lang.String firstName,
         java.lang.String lastName, java.lang.String street,
         java.lang.String city, java.lang.String state,
         java.lang.String zipCode, java.lang.String occupation,
         java.lang.String age, java.lang.String sex,
         java.lang.String marritialStatus, java.lang.String accountType)
   {
      this.accountNo = accountNo;
      this.firstName = firstName;
      this.lastName = lastName;
      this.street = street;
      this.city = city;
      this.state = state;
      this.zipCode = zipCode;
      this.occupation = occupation;
      this.age = age;
      this.sex = sex;
      this.marritialStatus = marritialStatus;
      this.accountType = accountType;
   }

}
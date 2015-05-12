package com.fanqie.dc.domain;

import com.fanqie.core.Domain;
import com.fanqie.dc.enumeration.InnActiveType;

/**
 * DESC : 活跃客栈
 * @author : 番茄木-ZLin
 * @data : 2015/5/12
 * @version: v1.0.0
 */
public class InnActive extends Domain {
   //客栈id
    private int innId;
    //客栈名称
    private String innName;
    //客栈联系电话
    private String mobile;
    //订单数
    private int orderNum;
    //入住数
    private int checkInNum;
    //退房数
    private int checkOutNum;
   //短信数
   private int msgNum;
  //操作数
  private int operateNum;

 public int getInnId() {
  return innId;
 }

 public void setInnId(int innId) {
  this.innId = innId;
 }

 public String getInnName() {
  return innName;
 }

 public void setInnName(String innName) {
  this.innName = innName;
 }

 public String getMobile() {
  return mobile;
 }

 public void setMobile(String mobile) {
  this.mobile = mobile;
 }

 public int getOrderNum() {
  return orderNum;
 }

 public void setOrderNum(int orderNum) {
  this.orderNum = orderNum;
 }

 public int getCheckInNum() {
  return checkInNum;
 }

 public void setCheckInNum(int checkInNum) {
  this.checkInNum = checkInNum;
 }

 public int getCheckOutNum() {
  return checkOutNum;
 }

 public void setCheckOutNum(int checkOutNum) {
  this.checkOutNum = checkOutNum;
 }

 public int getMsgNum() {
  return msgNum;
 }

 public void setMsgNum(int msgNum) {
  this.msgNum = msgNum;
 }

 public int getOperateNum() {
  return operateNum;
 }

 public void setOperateNum(int operateNum) {
  this.operateNum = operateNum;
 }
}

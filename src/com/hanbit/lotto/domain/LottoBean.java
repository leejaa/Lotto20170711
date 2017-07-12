package com.hanbit.lotto.domain;

import java.io.Serializable;

public class LottoBean implements Serializable{
	private static final long serialVersionUID = 1L;
private int money;
private int number;
public int getMoney() {
	return money;
}
public void setMoney(int money) {
	this.money = money;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public String toString(){
	return String.valueOf(number)+"\n";
}

}

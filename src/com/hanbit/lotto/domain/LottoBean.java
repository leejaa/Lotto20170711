package com.hanbit.lotto.domain;

public class LottoBean {
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

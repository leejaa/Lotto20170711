package com.hanbit.lotto.controller;

import javax.swing.JOptionPane;

import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;
import com.hanbit.lotto.serviceImpl.LottoServiceImpl;

public class LottoController {
	public static void main(String[] args) {
		
		LottoService service=new LottoServiceImpl();
		LottoBean bean=new LottoBean();
		bean.setMoney(Integer.parseInt(JOptionPane.showInputDialog("얼마를 구입하실 겁니까??")));
		service.setLottos(bean);
		
		String ShowLotto="";
		for(int[] a:service.getLottos()){
			for(int aa:a){
				ShowLotto+=String.valueOf(aa)+"/";
			}
			ShowLotto+="\n";
		}
		JOptionPane.showMessageDialog(null, ShowLotto);
	}
}

package com.hanbit.lotto.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;
import com.hanbit.lotto.serviceImpl.LottoServiceImpl;

public class LottoController {
	public static void main(String[] args) {
		LottoService service=new LottoServiceImpl();
		LottoBean bean=new LottoBean();
		StringBuffer buff=new StringBuffer();
		
		while(true){
			switch(JOptionPane.showInputDialog("0.exit 1.buy lotto")){
			
			case "0":return;
			case "1":
				bean.setMoney(Integer.parseInt(JOptionPane.showInputDialog("얼마를 구입하실 겁니까??")));
				service.setLottos(bean);
				
				for(int[] a:service.getLottos()){
					for(int aa:a){
						buff.append(aa+"\t");
						}
						buff.append("/");
					}
				int lottoSerialNo=(int)(Math.random()*99999+10000);
				File output=new File("C:\\Users\\1027\\JavaProjects\\lottos\\"+lottoSerialNo+".txt");
				BufferedWriter bw=null;
				String[] lottoPrint=buff.toString().split("/");
				try {
					bw=new BufferedWriter(new FileWriter(output));
					for(String s:lottoPrint){
						s+=System.getProperty("line.separator");
						bw.write(s);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						bw.flush();
						bw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				break;
			}
		}
	}
}

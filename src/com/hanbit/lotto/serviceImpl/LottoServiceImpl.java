package com.hanbit.lotto.serviceImpl;

import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;

public class LottoServiceImpl implements LottoService{
	int[][] lottos;
	int[] lotto;//돈과 상관없이 생성되는 한줄(숫자 6개) 로또
	private int count;
	
	public LottoServiceImpl() {
		count=0;
		lotto=new int[6];
	}

	@Override
	public void setLottos(LottoBean bean) {
		//로또만들기
		int number=0;
		setCount(bean);//몇줄짜리인지 먼저 정한다
		lottos=new int[count][6];
		for(int i=0;i<count;i++){
			for(int j=0;j<6;j++){
				number=(int)(Math.random()*45)+1;
				j=isDuplication(j, number)?j-1:j;
				
				System.out.println("랜덤숫자는 "+number);
			lotto[j]=number;
			}
			sort(lotto);//로또 정렬
			lottos[i]=lotto;
			lotto=new int[6];//한줄 로또 다시 초기화
		}
	}

	@Override
	public int[][] getLottos() {
		// 만든 로또 가져오기
		return lottos;
	}
	@Override
	public boolean isDuplication(int count, int num) {
		// 중복된 번호인지 체크(중복이면 true 리턴)
		boolean r=false;
		for(int i=0;i<count;i++){
			if(lotto[i]==num){
				return true;
			}
		}
		return r;
	}

	@Override
	public void sort(int[] arr) {
		int temp=0;
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		lotto=arr;
	}

	@Override
	public int getCount() {
		//해당 로또수 만큼 출력
		return count;
	}

	@Override
	public void setCount(LottoBean bean) {
		// 몇줄을 출력할 것인지 로또 수 계산(최대 5줄)
		int money=bean.getMoney();
		System.out.println("넘어온 돈은 "+money);
		int lottoCount=money/1000;
		lottoCount=lottoCount>5?5:lottoCount;
		System.out.println("총 카운트 값은 "+lottoCount);
		count=lottoCount;
	}
}

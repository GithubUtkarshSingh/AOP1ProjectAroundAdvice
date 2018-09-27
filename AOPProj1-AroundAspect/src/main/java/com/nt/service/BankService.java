package com.nt.service;

public class BankService {
	
	public  float calcSimpleIntrAmount(float pAmt,float rate,float time){
		System.out.println("BankService:: calcSimpleIntrAmount(-,-,-)");
		return (pAmt*rate*time)/100.0f;
	}
	
	public   float calcCompoundIntrAmount(float pAmt,float rate,float time){
		System.out.println("BankService:: calcCompoundIntrAmount(-,-,-)");
		return (float) ((pAmt*(Math.pow((1+rate/100.0f), time)))-pAmt);
	}


}

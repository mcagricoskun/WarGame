package com.coskun.codeAcademy;

public class CodeAcademy {
    public static void main(String[] args) {
         class ATM{
             int totalMoney = 0;
             int numATMs= 0;


            ATM(int totalMoney, int numATMs){
                this.totalMoney = totalMoney;
                this.numATMs = numATMs;
             }

//            public static void changeMoney(){
//                this.totalMoney = 13;
//            }

             public void changeMoney(){
                 this.totalMoney = 13;
             }
        }

//        new atm

        ATM newATM = new ATM(50, 5);

        System.out.println(newATM.totalMoney);

        newATM.changeMoney();

        System.out.println(newATM.totalMoney);



    }
}

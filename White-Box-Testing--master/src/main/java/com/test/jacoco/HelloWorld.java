package com.test.jacoco;

import javax.imageio.event.IIOReadWarningListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class HelloWorld {
    public HelloWorld() {

    }

    public String Method1() {
        return "Hello World";
    }

    public int Method2(int a, int b) {
        return a + b;
    }

    public int Method3(int a, int b, int c){
    	if((a>5&&b<0)||c>0) {
    		System.out.println("Condition 1");
    	}
    	else if(a<5 && c<-2 ) {
    		System.out.println("Condition 2");
    	}
    	else {
    		System.out.println("Condition 3");
    	}
    	return 0;
    }

    public int Method4(int a, int b, int c, int d, float e) {
    	if(a == 0) {
    		return 0;
    	}
    	int x = 0;
    	if((a == b) || ((c == d) && (bug(a)))) {
    		 x = 1; 
    	}
    	e = 1/x;
    	return 0;
    }

    public boolean bug(int a) {
    	if(a == 5) return true;
    	return false;
    }


    
    public boolean isTriangle(int a, int b, int c) {
    	/**
    	 * TODO: You need to complete this method to determine whether  a
    	 * triangle is formed or not when given the input edge a, b and c.
    	 */
    	if(a<=0 || b<=0 || c<=0) return false;
		if(a+b <= c) return false;
		if(b+c <= a) return false;
		if(a+c <=b) return false;
    	return true;
    }

    public boolean isBirthday(int year, int month, int day) throws ParseException {
		/**
		 * TODO: You need to complete this method to determine whether a
		 * legitimate date of birth between 1990/01/01 and 2019/10/01 is
		 * formed or not when given the input year, month and day.
		 */
		Boolean flag = true;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day);

		try{
			format.setLenient(false);
			format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			flag = false;
		}

		if(!flag){
			return false;
		}

		String format2 = "yyyy-MM-dd";
		Date startTime = new SimpleDateFormat(format2).parse("1990-01-01");
		Date endTime = new SimpleDateFormat(format2).parse("2019-10-01");
		Date nowdate = new SimpleDateFormat(format2).parse(date);

		if(nowdate.after(startTime) && nowdate.before(endTime)) {
			return true;
		}else {
			return false;
		}
	}

    public Double miniCalculator(double a, double b, char op) {
    	/**
    	 * TODO: You need to complete this method to form a small calculator which 
    	 * can calculate the formula: "a op b", the op here can be four basic  
    	 * operation: "+","-","*","/". 
    	 */
    	double result = 0.0;
    	if( op == '+') result = a+b;
    	else if (op == '-') result = a-b;
    	else if (op == '*') result = a*b;
    	else result = a/b;
    	return result;
    }
    
}

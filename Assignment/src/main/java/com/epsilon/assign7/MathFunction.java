package com.epsilon.assign7;

public class MathFunction {
	
	public static float sine1(float x){
        float sin=0.0f;
        long fact;
        for(int i=1; i<=10; i++){
            fact=1;
            for(int j=1; j<=2*i-1; j++){
                fact=fact*j;
            }
            if(i%2==1){
                sin=sin+(float)(Math.pow(x,2*i-1)/fact);
            }else{
                sin=sin-(float)(Math.pow(x,2*i-1)/fact);
            }
        }
        return sin;
    }

	public static void main(String[] args) {
		System.out.println("Sin(1.57079632679) is "+Math.sin(1.57079632679f)+" "+sine1(1.57079632679f));

	}

}

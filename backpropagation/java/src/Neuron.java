import java.util.Random;

public class Neuron{
	static final Random r=new Random();
	
	public float biais;
	public final float inputs[];
	public final float weights[];
	
	public final int size;
	
	public Neuron(int size){
		this.size=size;
		this.inputs=new float[size];
		this.weights=new float[size];
		
		biais=r.nextFloat();
		for(int i=0;i<size;i++){
			weights[i]=r.nextFloat();
		}
	}
	
	public Neuron setInput(int input){
		for(int i=0;i<size;i++){
			inputs[size-(i+1)]=(input&(1<<i))>>i;
		}
		return this;
	}
	
	public Neuron setInput(float inputs[]){
		for(int i=0;i<size;i++){
			this.inputs[i]=inputs[i];
		}
		return this;
	}
	
	public float getOutput(){
		float z=dot(inputs,weights)+biais;
		return sigmoid(z);
	}
	
	public static float sigmoid(float z){
		return (float)(1/(1+Math.exp(-z)));
	}

	public static float sigmoidP(float z){
		return sigmoid(z)*(1-sigmoid(z));
	}
	
	public static int[] toBits(int n){
		int size=Integer.toBinaryString(n).length();
		int[] bits=new int[size];
		for(int i=0;i<size;i++){
			bits[size-(i+1)]=(n&(1<<i))>>i;
		}
		return bits;
	}

	public static float dot(float[] x,float[] w){
		if(x.length!=w.length)
			return 0;

		float dot=0;
		for(int i=0;i<x.length;i++){
			dot+=x[i]*w[i];
		}
		return dot;
	}
}

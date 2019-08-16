import java.util.*;

public class Main{
	
	static int[][] q={
		{1,0,0},{1,0,0},{1,0,0},{1,0,0},{1,0,0},{0,1,0},{0,1,0},{0,1,0},
		{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0},
		{1,0,0},{1,0,0},{1,0,0},{1,0,0},{0,0,1},{1,0,0},{1,0,0},{1,0,0},
		{0,0,1},{0,1,0},{0,1,0},{0,1,0},{0,0,1},{0,1,0},{0,1,0},{0,1,0},
		{1,0,0},{1,0,0},{1,0,0},{1,0,0},{0,0,1},{1,0,0},{1,0,0},{1,0,0},
		{0,0,1},{0,0,1},{0,1,0},{0,1,0},{0,0,1},{0,0,1},{0,1,0},{0,1,0},
		{1,0,0},{1,0,0},{1,0,0},{1,0,0},{0,0,1},{1,0,0},{1,0,0},{1,0,0},
		{0,0,1},{0,0,1},{0,1,0},{0,1,0},{0,0,1},{0,0,1},{0,1,0},{0,1,0},
	};


	static int maxI(int[] state){
		int idx=0;
		float max=0;
		for(int i=0;i<state.length;i++){
			if(max<state[i]){
				idx=i;
				max=state[i];
			}
		}

		return idx;
	}

	static int maxF(float[] state){
		int idx=0;
		float max=0;
		for(int i=0;i<state.length;i++){
			if(max<state[i]){
				idx=i;
				max=state[i];
			}
		}

		return idx;
	}
	
	public static void main2(String[] args){
		Network n=new Network(6,4,3);
		for(int epoch=0;epoch<100;epoch++){
			for(int i=0;i<q.length;i++){
				n.train(i,q[i]);
			}
		}
		
		for(int i=0;i<Q.q.length;i++){
			float mf=maxF(n.setInput(i).getOutputs());
			float mi=maxI(q[i]);
			//System.out.print(i);
			System.out.print(" "+mf);
			System.out.print(" "+mi);
			if(mf!=mi){
				System.out.println(" not");
			}
			else
				System.out.println();
				
		}
	}
	
	public static void main(String[] args){
		Network nn=new Network(2,2,2);
		
		Neuron[] neurons=nn.hidL.neurons;
		
		neurons[0].biais=0.35f;
		neurons[0].inputs[0]=0.05f;
		neurons[0].inputs[1]=0.10f;
		neurons[0].weights[0]=0.15f;
		neurons[0].weights[1]=0.20f;
		
		neurons[1].biais=0.35f;
		neurons[1].inputs[0]=0.05f;
		neurons[1].inputs[1]=0.10f;
		neurons[1].weights[0]=0.25f;
		neurons[1].weights[1]=0.30f;
		
		float[] out={
			neurons[0].getOutput(),
			neurons[1].getOutput()
		};
		
		neurons=nn.outL.neurons;
		
		neurons[0].biais=0.60f;
		neurons[0].inputs[0]=out[0];
		neurons[0].inputs[1]=out[1];
		neurons[0].weights[0]=0.40f;
		neurons[0].weights[1]=0.45f;
		
		neurons[1].biais=0.60f;
		neurons[1].inputs[0]=out[0];
		neurons[1].inputs[1]=out[1];
		neurons[1].weights[0]=0.50f;
		neurons[1].weights[1]=0.55f;
		
	
		nn.train(new float[]{0.01f,0.99f});
		
		
		System.out.println(Arrays.toString(nn.hidL.neurons[0].weights));
		System.out.println(Arrays.toString(nn.hidL.neurons[1].weights));
		
	}
}

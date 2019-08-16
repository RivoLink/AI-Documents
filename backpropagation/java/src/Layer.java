public class Layer{
	
	public final int nCount;
	public final Neuron[] neurons;
	
	public Layer(int iLen,int nCount){
		this.nCount=nCount;
		
		neurons=new Neuron[nCount];
		for(int i=0;i<nCount;i++){
			neurons[i]=new Neuron(iLen);
		}
	}
	
	public Layer setInputs(int input){
		for(int i=0;i<nCount;i++){
			neurons[i].setInput(input);
		}
		return this;
	}
	
	public Layer setInputs(float[] inputs){
		for(int i=0;i<nCount;i++){
			neurons[i].setInput(inputs);
		}
		return this;
	}
	
	public float[] getOutputs(){
		float[] outputs=new float[nCount];
		for(int i=0;i<nCount;i++){
			outputs[i]=neurons[i].getOutput();
		}
		return outputs;
	}
	
}

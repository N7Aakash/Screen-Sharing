import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.awt.Dimension;



public class Helper implements java.io.Serializable{
	public byte[] byteImage;
	public Dimension dim;
	// public OutputStream clientOut;

	public Helper(byte[] byteImage , Dimension dim){
		this.byteImage = byteImage;
		// this.clientOut = clientOut;
		this.dim = dim;
	}

	// public void serializeObject(){
	// 	ObjectOutputStream stream = new ObjectOutputStream(clientOut);
	// }

}
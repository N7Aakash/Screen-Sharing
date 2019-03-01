import java.net.*;
import java.io.*;
import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.Dimension;

 

public class ClientCode{
	public static void main(String args[]) throws UnknownHostException,IOException
	{
		int count = 0;
		try{
		int character;
		
		while(true){
		
		Socket s = new Socket("127.0.0.1", 8767);

		// InputStream clientIn = s.getInputStream();
		OutputStream clientOut = s.getOutputStream();
		
		Robot r = new Robot();
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(dim);
		BufferedImage image = r.createScreenCapture(rect);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image,"jpeg",baos);
		byte[] byteImage = baos.toByteArray();
		System.out.println(count++);
		Helper help = new Helper(byteImage,dim);

		ObjectOutputStream stream = new ObjectOutputStream(clientOut);
		stream.writeObject(help);
		stream.close();
		// while((character = clientIn.read())!=-1)
		// 	System.out.print((char)character);

		}

		}catch(IOException a){
			System.out.println("issue : "  + a );
		}catch(Exception e){
			System.out.println(e);
		}

		
	}
}



// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// System.out.println("enter anything");
		// String input = br.readLine();
		// input = input + "\n";
		// byte buff[] = input.getBytes();
		// clientOut.write(buff);
		// while((character = clientIn.read())!=-1)
		// 	System.out.print((char)character);





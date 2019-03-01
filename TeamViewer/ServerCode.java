import java.net.*;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import javax.imageio.ImageIO;


import java.io.*;
class ServerCode{
	public static void main(String args[]) throws IOException{
		try{
		ServerSocket socket = new ServerSocket(8767);
		

		
		
		JFrameExample ex = null;
		int flag = 0;
		int count = 1;
		while(true){
			Socket inSocket = socket.accept();
			InputStream inServer = inSocket.getInputStream();
			ObjectInputStream stream = new ObjectInputStream(inServer);	

			Helper help = (Helper)stream.readObject();
			// System.out.println(count++);

			byte[] byteImage = help.byteImage;
			Dimension dim = help.dim;
			ByteArrayInputStream bais = new ByteArrayInputStream(byteImage);
			BufferedImage image = ImageIO.read(bais);

			
			if(flag==0){
				// java.awt.EventQueue.invokeLater(new Runnable(){
	         //    public void run() {
	         //        ex = new JFrameExample(image,dim);
	         //    }
	        	// });
				ex = new JFrameExample(image,dim).;
				ex.updateFrame(image);
		}
				
			// if(flag == 0){
			// ex.createFrame();
			// flag = 1;
			// }
			if(flag == 1){
				// System.out.println("hi");
				ex.updateFrame(image);
				// System.out.println("I am here!");
			}

			flag = 1;

			// inSocket.close();

			stream.close();
			inServer.close();
		}

		

		}
		catch(ClassNotFoundException c){
			System.out.println(c);
		}
		catch(IOException e){
			System.out.println(e);
		}
		catch(Exception p){
			System.out.println(p);
		}
	}
}



// BufferedReader in = new BufferedReader(new InputStreamReader(inSocket.getInputStream()));
// 		PrintWriter out = new PrintWriter(inSocket.getOutputStream(),true);
// 		String str = in.readLine();
// 		out.println("Server got this :" + str);
// 		System.out.println("Client Sent : " + str);

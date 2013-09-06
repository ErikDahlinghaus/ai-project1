package connectn;

import java.io.*;

public class Logger {
	
	BufferedWriter bw;
	
	Logger(String fn){
		File file = new File(fn);

		// if file doesnt exists, then create it
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		FileWriter fw = null;
		try {
			fw = new FileWriter(file.getAbsoluteFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bw = new BufferedWriter(fw);
	}
	
	public void log(String mes) throws IOException{		 

		this.bw.write(mes+"\n");
		this.bw.flush();
	}
	
	public void log(String mes, Object... args) throws IOException{
		
		String message = String.format(mes, args);
		this.log(message);
	}

}

package member;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyOutPutStream extends ObjectOutputStream{
	
	public MyOutPutStream(OutputStream out) throws IOException{
		super(out);
	}

	@Override
	protected void writeStreamHeader() throws IOException{
		
	}
	
}



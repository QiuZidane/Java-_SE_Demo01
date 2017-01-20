package network.votedemo;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class VoteMsgBinCoder implements VoteMsgCoder{
	
	public static final int MIN_WIRE_LENGTH=4;
	public static final int MAX_WIRE_LENGTH=16;
	public static final int MAGIC=0x5400;
	public static final int MAGIC_MASK=0xfc00;
//	public static final int MIN_WIRE_LENGTH=4;
//	public static final int MIN_WIRE_LENGTH=4;
//	public static final int MIN_WIRE_LENGTH=4;

	@Override
	public byte[] toWire(VoteMsg msg) throws IOException {

		
		
		return null;
	}

	@Override
	public VoteMsg fromWire(byte[] input) throws IOException {

		ByteArrayInputStream bStream = new ByteArrayInputStream(input);
		
		return null;
	}
	
	

}

/**
 * 
 */
package com.tutorials.java8.core.fileSystem;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Siddhant sahu
 *
 */
public class LimitedOutputStream extends FilterOutputStream {

	private final int maxByte;
	private long byteCount;

	public LimitedOutputStream(OutputStream out, int maxByte) {
		super(out);
		this.maxByte = maxByte;
	}

	private void ensureCapacity(int len) throws IOException {
		long currentLen = this.byteCount + len;
		if (currentLen > maxByte) {
			throw new IOException(
					"File size " + this.byteCount + " is greated then " + this.maxByte);
		}
		// this.byteCount=currentLen;
	}

	@Override
	public void write(int b) throws IOException {
		ensureCapacity(1);
		super.write(b);
	}

	@Override
	public void write(byte[] b) throws IOException {
		ensureCapacity(b.length);
		super.write(b);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		ensureCapacity(len);
		super.write(b, off, len);
	}

}

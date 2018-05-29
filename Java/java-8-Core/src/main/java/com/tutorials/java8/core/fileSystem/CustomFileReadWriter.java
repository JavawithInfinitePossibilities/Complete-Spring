/**
 * 
 */
package com.tutorials.java8.core.fileSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author Siddhant sahu
 *
 */
public class CustomFileReadWriter {

	public void getSmallFileCluster(String path) {
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			StringBuilder builder = new StringBuilder();
			String container;
			BufferedWriter writer;
			int counter = 1;
			while ((container = reader.readLine()) != null) {
				builder.append(container);
				if (builder.toString().getBytes(StandardCharsets.UTF_8).length > (1024 * 10)) {
					customWriter(builder, counter++);
				}
			}
			if (builder != null && !builder.toString().isEmpty()) {
				Writer(builder, counter++);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void Writer(StringBuilder builder, int counter) throws IOException {
		BufferedWriter writer;
		writer = new BufferedWriter(new FileWriter("Test_" + counter + ".txt"));
		writer.write(builder.toString());
		writer.flush();
		writer.close();
	}

	private void customWriter(StringBuilder builder, int counter) throws IOException {
		int maxByte = 1024 * 10;
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new LimitedOutputStream(
				new FileOutputStream("Test_" + counter + ".txt"), maxByte)));
		writer.write(builder.toString());
		writer.flush();
		writer.close();
	}
}

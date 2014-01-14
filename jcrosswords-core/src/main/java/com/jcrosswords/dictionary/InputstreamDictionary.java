package com.jcrosswords.dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Ted Vinke
 */
public class InputstreamDictionary extends AbstractDictionary {

	private static final long serialVersionUID = -4518555504314990691L;

	public InputstreamDictionary(InputStream inputStream) {
		if (inputStream == null) {
			throw new NullPointerException("Input stream for dictionary is null.");
		}
		try {
			loadStream(inputStream);
		} catch (IOException e) {
			throw new IllegalStateException("Unable to load input stream.", e);
		}
	}

	private void loadStream(InputStream inputStream) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		try {
			while ((line = in.readLine()) != null) {
				String[] split = line.split(";");
				if (split.length > 1) {
					add(split[0], split[1]);
				} else {
					add(split[0], "?");
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

}

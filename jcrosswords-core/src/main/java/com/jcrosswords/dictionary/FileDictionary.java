package com.jcrosswords.dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class FileDictionary extends AbstractDictionary {

	private static final long serialVersionUID = 3321564575890738182L;

	public FileDictionary(String filename) {
		boolean exists = (new File(filename)).exists();
		if (!exists) {
			throw new IllegalStateException("File does not exist for file name: " + filename);
		}

		try {
			loadFile(filename);
		} catch (IOException e) {
			throw new IllegalStateException("Unable to load file for file name: " + filename, e);
		}

	}

	private void loadFile(String filename) throws IOException {

		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		try {
			String c;
			String w;
			while ((w = br.readLine()) != null) {
				if ((c = br.readLine()) != null) {
					add(w, c);
				}
			}
		} finally {
			if (fr != null) {
				fr.close();
			}
		}
	}

}

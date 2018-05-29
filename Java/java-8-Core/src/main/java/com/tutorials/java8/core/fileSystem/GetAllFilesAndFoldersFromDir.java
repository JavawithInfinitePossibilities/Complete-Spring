/**
 * 
 */
package com.tutorials.java8.core.fileSystem;

import java.io.File;

/**
 * @author Siddhant sahu
 *
 */
public class GetAllFilesAndFoldersFromDir {

	public void getAllFilesAndFolderFromDir(String dir) {
		File path = new File(dir);
		String[] subDirs = path.list((File file, String name) -> {
			return new File(file, name).isDirectory();
		});
		if (subDirs != null) {
			for (String subDir : subDirs) {
				File subDirFiles = new File(dir + File.separator + subDir);
				String[] files = subDirFiles.list((File file, String name) -> {
					return name.endsWith(".txt");
				});
				for (String file : files) {
					System.out.println(dir + File.separator + subDir + File.separator + file);
				}
			}
		}
	}
}

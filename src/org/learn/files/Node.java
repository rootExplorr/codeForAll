package org.learn.files;

import java.nio.file.attribute.FileTime;
import java.util.Date;

public class Node {
	String name;
	int type;//0 or 1 depending whther it is a directory or a file
	long size; // 
	FileTime date;
}
package org.learn.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FileHandling {
	public static List<Node> displayFile(String directory) throws IOException {
				
		File directoryPath = new File(directory);
		System.out.println("Total space occupied :: " + (directoryPath.getTotalSpace()/(1024*1024)) + " MB");
		File[] list = directoryPath.listFiles();
		
		List<Node> returnList = new ArrayList();
		
		for(int i=0; i<list.length; i++) {
			Node node = new Node();
			node.name = list[i].getName();
			node.type = (list[i].isDirectory() ? 1:0); //Path class
			node.size = Files.size(list[i].toPath())/(1024*1024);//MB
			BasicFileAttributes attr = Files.readAttributes(list[i].toPath(), BasicFileAttributes.class);
			node.date = attr.creationTime();
			returnList.add(node);
		}
		return returnList;
	}
	//list all the files
	//print total space occupied by the folder
	public static void main(String[] args) throws IOException {
		List<Node> list = displayFile("E:\\G060_A1_PS12_AirportConnections");
		
		System.out.println("Contents of a directory :: ");
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i).date + " " +list.get(i).name);
			System.out.println();
		}
	}
}
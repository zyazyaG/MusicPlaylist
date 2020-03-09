package cisc3130;

import java.io.*;
import java.util.Set;
import java.util.HashSet;

public class MusicPlaylist {
	public static void main (String [] args) throws IOException{
		MyQueue list=new MyQueue();
		File file=new File("/Users/azizagulyamova/eclipse-workspace/MusicPlaylist/src/cisc3130/myfol");
		File[] names=file.listFiles();
		String [] nm=new String[names.length];
		TrackList list1=new TrackList();
		
		
		for (int i=0;i<names.length;i++)
			nm[i]=names[i].getAbsolutePath();

		for (int i=0;i<names.length;i++) {
			list.readData(nm[i], list);
			
		}
		System.out.println(list.first);
		list.sortList();
		list.duplicates();
		
		
		list.displayL();
		int n=list.getSize();
		System.out.println(n);
		
		
	}
public static String conv(String fileN) {
	String temp="";
	temp="\""+fileN+"\"";
	return temp;
	}

}

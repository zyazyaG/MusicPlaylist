package cisc3130;

import java.util.Set;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.io.*;

class Track {
	public String track;
	public Track next;
	public Track prev;
	PrintWriter output;	
	
	//no argument constructor
	public Track() {
	}
	
	
	//constructor method	
	public Track (String track){
	this.track=track;
	}
	
	//method to print out the node
	public void displayTrack(PrintWriter output) throws IOException{
		
		output.printf("%-20.20s\n", track);
	}

}//close Artist class


class TrackList {
	protected Track first;
    
	
	//constructor
	public TrackList() {
		first=null;
	}
	
	//true if list is empty
	public boolean isEmpty() {
		return (first==null);
	}
	
	//method to insert node into list
	public void insertFirst (String track) {
		Track newTrack=new Track(track);
		newTrack.next=first;
		first=newTrack;
	}
	
	public void insert(String track) {
		Track newTrack=new Track (track);
		Track last=first;
		newTrack.next=null;
		
		if (first==null) {
			newTrack.prev=null;
			first=newTrack;
			return;
		}
		while (last.next!=null) {
			last=last.next;
		}
		
		last.next=newTrack;
		newTrack.prev=last;
	}
	public Track remove() {
		Track temp=first;
		first=first.next;
		return temp;
	}
	//method to print out the list
	public void displayList()throws IOException{
		PrintWriter output=new PrintWriter(new File("/Users/azizagulyamova/eclipse-workspace/MusicPlaylist/src/cisc3130/dataend.txt"));
		output.println("list of songs");
		Track current=first;
		while (current!=null) {
			current.displayTrack(output);
			current=current.next;
		}
		output.close();		
	}
	
	public int size () {
		Track temp=first;
		int count=0;
		while (temp!=null) {
			count++;
			temp=temp.next;
		}
		return count;
	}
	public void sort() {
		Track current=first;
		Track nextTrack=null;
		String temp="";
		
		while(current!=null) {
			nextTrack=current.next;
			while (nextTrack!=null) {
				if ((current.track.compareToIgnoreCase(nextTrack.track))>0) {
					temp=current.track;
					current.track=nextTrack.track;
					nextTrack.track=temp;
				}
				
				nextTrack=nextTrack.next;
			}
			current=current.next;
		}
	}
	
	
}//close TrackList class


class MyQueue extends TrackList{
	
	private TrackList list;
	
	public MyQueue() {
		list=new TrackList();
		
	}
	
	public void push (String track) {
		list.insertFirst(track);
	}
	
	public Track remove() {
		return list.remove();
	}
	
	
	public Track peekFront() {
		return list.first;
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int getSize() {
		return list.size();
	}
	public void duplic() {
		Set s=new HashSet<Track>();
		s.addAll((Collection) list);
		list.first=null;
		
		
		
	}
	public void sortList() {
		list.sort();
	}
	
	public void readData(String fileName, MyQueue queue) throws IOException{
		Scanner input=new Scanner(new File(fileName));
		if (input.hasNext()) {
		  String empt=input.nextLine();//store first two lines of file
		  System.out.println(empt);
		  String empt2=input.nextLine();
		}
		int n=0;
		
		while (input.hasNextLine()) {//read in data to array and trim it
			if (input.hasNext()) {
				String []temp=input.nextLine().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");//temporary array to store line
                String line=temp[1].replaceAll("\'", "");
                queue.push(line);
                n++;
			}
		}
		
	}
	
	public void displayL() throws IOException{
		list.displayList();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	

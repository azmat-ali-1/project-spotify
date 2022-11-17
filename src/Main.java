import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        album album1 = new album("azmat","inferno");
        album1.addSong("Alon",5.3);
        album1.addSong("Alon2",4.3);
        album1.addSong("Alon3",8.3);

        LinkedList<song> myPlayList = new LinkedList<>();
        album1.addToPlayList("Alon",myPlayList);
        album1.addToPlayList("ABCD",myPlayList);
        album1.addToPlayList("Alon2",myPlayList);

        //System.out.println( album1.addToPlayList("Alon2",myPlayList));
        //System.out.println( album1.addToPlayList("Alon8",myPlayList));
        printList(myPlayList);
        play(myPlayList);
    }
    public  static  void play(LinkedList<song> playList){
        Scanner sc = new Scanner(System.in);
        ListIterator<song> itr = playList.listIterator();
        if(!itr.hasNext()){
            System.out.println("play List is Empty");
            return;
        }
        System.out.println("You are now listening "+ itr.next());
        showMenu();
        boolean forward  = true;
        while(true){
            int option = sc.nextInt();
            switch (option){
                case 0:
                    System.out.println("thank you for listening");
                    return;
                case 1 :
                    showMenu();
                    break;
                case 2:
                    printList(playList);
                    break;
                case 3:
                    if(!forward){
                        if(itr.hasNext()){
                        itr.next();
                        }
                        else{
                            System.out.println("No next song");
                        }
                    }
                    if(!itr.hasNext()){
                        System.out.println("You have reached the end of playlist");
                    }
                    else{
                        System.out.println("You are listening to "+itr.next());
                    }
                    forward =true;
                    break;
                case 4:
                    if(forward){
                        if(itr.hasPrevious()){
                            itr.previous();
                        }
                        else{
                            System.out.println("No previous song");
                        }
                    }
                    if(!itr.hasPrevious()){
                        System.out.println("You have reached the start of playlist");
                    }
                    else{
                        System.out.println("You are listening to "+itr.previous());
                    }
                    forward =false;
                    break;
            }
        }
    }
    public static void printList(LinkedList<song> playList){
        ListIterator<song> itr  = playList.listIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        return;
    }
    public static void showMenu(){
        System.out.println("0. Exit");
        System.out.println("1. Print Menu");
        System.out.println("2. Show the list of all song in the playlist");
        System.out.println("3. play next song");
        System.out.println("4. play previous song");
        System.out.println("5. repeat the song");
        System.out.println("6. Delete the Song");
    }
}
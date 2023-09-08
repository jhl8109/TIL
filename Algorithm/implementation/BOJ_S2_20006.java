import java.util.*;
import java.io.*;

class Room {
    int limit;
    ArrayList<Player> players;
    
    Room(int limit, ArrayList<Player> players) {
        this.limit = limit;
        this.players = players;
    }
}

class Player implements Comparable<Player>{
    int level;
    String nickname;

    Player(int level, String nickname) {
        this.level = level;
        this.nickname = nickname;
    }
    @Override
    public int compareTo(Player o) {
        return this.nickname.compareTo(o.nickname);
    }
}

class BOJ_S2_20006{
    public static int p,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        ArrayList<Room> rooms = new ArrayList<>();

        int level = 0;
        String nickname = "";
        for(int i=0; i<p; i++) {
            st = new StringTokenizer(br.readLine());
            level = Integer.parseInt(st.nextToken());
            nickname = st.nextToken();
            Player player = new Player(level,nickname);

            boolean check = false;
            for(int j=0; j<rooms.size(); j++) {
                if(rooms.get(j).players.size() < m && player.level <= rooms.get(j).limit+10 && player.level >= rooms.get(j).limit-10) {
                    check = true;
                    rooms.get(j).players.add(player);
                    break;
                }
            }
            if(!check) {
                ArrayList<Player> tmp = new ArrayList<>();
                tmp.add(player);
                rooms.add(new Room(level,tmp));
            } 
        }

        for(Room room : rooms) {
            Collections.sort(room.players);
            if(room.players.size() == m) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }
            for(Player player : room.players) {
                System.out.println(player.level + " " + player.nickname);
            }
        }
    }
}
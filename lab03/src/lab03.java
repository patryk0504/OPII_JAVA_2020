public class lab03 {
    public static void main(String[] args) {
        try {
            if (args.length != 4)
                throw new NumberFormatException();
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            int steps = Integer.parseInt(args[2]);
            int preset = Integer.parseInt(args[3]);
            Game gameOne = new Game (x,y);
            //start symulacji
            gameOne.gameStart(steps,preset);
        }catch (NumberFormatException e){
            System.out.println("Bledne argumenty programu");
        }
    }
}

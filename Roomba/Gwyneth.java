public class Gwyneth {

   public static void main(String args[])
   {
      Room zenRoom = new Room(4.5,6.0,3);
      Furniture meditationChamber = new Furniture(2,2,1.2,1.2);
      Furniture studyChair = new Furniture(3.1,4,0.7,0.7);
      Furniture incenseTable = new Furniture(1,4,1.0,0.8);
      zenRoom.addThing(meditationChamber);
      zenRoom.addThing(studyChair);
      zenRoom.addThing(incenseTable);
      Roomba supervac = new Roomba(1,1,0.25);
      zenRoom.addRoomba(supervac);

      if(zenRoom.allValid())
      {
         System.out.println("The room is ready");
      }
      else
      {
         System.out.println("The room has a problem!");
      }
      if(zenRoom.canCleanAll())
      {
         System.out.println("Let's clean!");
      }
      else
      {
         System.out.println("Whoah! What's that narrow space?");
      }

      for(int i = 0; i < args.length; i += 2)
      {
         double x = Double.parseDouble(args[i]);
         double y = Double.parseDouble(args[i+1]);
         RoombaMove rm = new RoombaMove(x,y);
         System.out.println("Do move "+i);
         if(!zenRoom.doMove(rm))
         {
             System.out.println("Failed to clean on move "+i);
         }
      }
   }
}
public class Room {

   private double length;
   private double width;

   private Furniture[] things;
   private int howMany;

   private Roomba vac;

   public Room(double w,double l,int stuff)
   {
      length = l;
      width = w;
      things = new Furniture[stuff];
      howMany = 0;
   }

   public void addThing(Furniture f)
   {
      things[howMany++] = f;
   }

   public void addRoomba(Roomba r)
   {
      vac = r;
   }

   public boolean valid()
   {
      for(int i = 0;i < howMany;++i)
      {
         for(int c = 0;c < 4;++c)
         {
            double x = things[i].getXpos(c);
            if(x < 0 || x > width)
            {
               return false;
            }
            double y = things[i].getYpos(c);
            if(y < 0 || y > length)
            {
               return false;
            }
         }
      
         for(int j = i+1;j < howMany;++j)
         {
            if(things[i].overlaps(things[j]))
            {
               return false;
            }
         }
      }
      return true;
   }

   public boolean validVac()
   {
      for(int i = 0;i < howMany;++i)
      {
         if(vac.inCollision(things[i]))
         {
            return false;
         }
      }
      return true;
   }

   public boolean allValid()
   {
      return valid() && validVac();
   }

   public boolean canCleanAll()
   {
      for(int i = 0;i < howMany;++i)
      {
         if(!vac.fits(things[i].getXpos(0)) ||
            !vac.fits(things[i].getYpos(0)) ||
            !vac.fits(width - things[i].getXpos(3)) ||
            !vac.fits(length - things[i].getYpos(1)))
         {
            return false;
         }

         for(int j = i+1;j < howMany;++j)
         {
            if(things[i].beside(things[j]))
            {
               if(!vac.fits(things[i].distanceTo(things[j])))
               {
                  return false;
               }
            }
         }
      }
      return true;
   }

   public boolean doMove(RoombaMove rm)
   {
      for(int i = 0; i < howMany;++i)
      {
         if(vac.collisionOnMove(rm,things[i]))
         {
            return false;
         }
      }
      vac.doMove(rm);
      return true;
   }
}
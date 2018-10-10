public class Furniture {

   private double xPos;
   private double yPos;
   private double length;
   private double width;

   public Furniture(double x,double y,double l,double w)
   {
      xPos = x;
      yPos = y;
      length = l;
      width = w;
   }

   public double getXpos(int c)
   {
      if(c==0 || c == 4) {return xPos;}
      return xPos+width;
   }

   public double getYpos(int c)
   {
      if(c==0 || c==1) {return yPos;}
      return yPos+length;
   }

   public boolean overlaps(Furniture f)
   {
      if(xPos+width <= f.xPos || 
           f.xPos+f.width <= xPos)
      {
         return false;
      }
      if(yPos+length <= f.yPos ||
           f.yPos+f.length <= yPos)
      {
         return false;
      }
      return true;
   }

   public boolean beside(Furniture f)
   {
      if(xPos + width <= f.xPos || f.xPos +f.width <= xPos)
      {
          if(yPos + length > f.yPos && f.yPos +f.length > yPos)
          {
              return true;
          }
      }
      if(yPos + length <= f.yPos || f.yPos +f.length <= yPos)
      {
          if(xPos + width > f.xPos && f.xPos +f.width > xPos)
          {
              return true;
          }
      }
      return false;
   }

   public double distanceTo(Furniture f)
   {
      if(xPos + width <= f.xPos || f.xPos +f.width <= xPos)
      {
          return Math.max(f.yPos + f.length - yPos,yPos + length - f.yPos);
      }
      return Math.max(f.xPos + f.width - xPos,xPos +width - f.xPos);
   }
}

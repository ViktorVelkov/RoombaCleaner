public class Roomba {

  private double xPos;
  private double yPos;
  private double radius;

  public Roomba(double x,double y,double r)
  {
     xPos = x;
     yPos = y;
     radius = r;
  }

  public void moveTo(int x,int y)
  {
     xPos = x;
     yPos = y;
  }

  public String toString()
  {
     String s = "Roomba radius "+radius+" at ("+xPos+","+yPos+")";
     return s;
  }

  public boolean inCollision(double x,double y,Furniture f)
  {
// Check whether this Roomba would, at (x,y), collide with f
     if(x + radius <= f.getXpos(0) || x - radius >= f.getXpos(3))
     {
        return false;
     }
     if(y + radius <= f.getYpos(0) || y - radius >= f.getYpos(1))
     {
        return false;
     }
     if((x - f.getXpos(0))*(x - f.getXpos(3)) < 0 ||
         (y - f.getYpos(0))*(y - f.getYpos(1)) < 0)
     {
        return true;
     }
     for(int i = 0;i < 4;++i)
     {
        if((x - f.getXpos(i))*(x - f.getXpos(i)) + 
            (y - f.getYpos(i))*(y - f.getYpos(i)) < radius*radius)
        {
            return true;
        }
     }
     return false;
  }

  public boolean collisionOnMove(RoombaMove r,Furniture f)
  {
     return inCollision(xPos+r.getX(),yPos+r.getY(),f);
  }

  public boolean inCollision(Furniture f)
  {
     return inCollision(xPos,yPos,f);
  }

  public boolean fits(double d)
  {
     return ((d==0) || (2*radius <= d));
  }

  public void doMove(RoombaMove rm)
  {
     xPos += rm.getX();
     yPos += rm.getY();
  }
}